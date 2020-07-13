package com.safecharge.biz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;

import com.safecharge.model.Proxy;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Builder for a {@link HttpClient} for communicating with the Safecharge's servers
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/16/2017
 */
public class SafechargeClientBuilder {

    public static final int DEFAULT_MAX_TOTAL_CONNECTIONS = 100;
    public static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 10;
    public static final int CONNECTION_TIME_TO_LIVE_MINUTES = 15;
    private static final int DEFAULT_TIMEOUT_SECONDS = 30;
    private static final int DEFAULT_TIMEOUT_MILLISECONDS = DEFAULT_TIMEOUT_SECONDS * 1000;
    private static final String[] SERVER_SUPPORTED_SSL_PROTOCOLS = new String[]{"TLSv1.1", "TLSv1.2"};

    private int timeToLive;
    private TimeUnit timeToLiveTimeUnit;
    private RequestConfig requestConfig = null;
    private DefaultProxyRoutePlanner routePlanner = null;
    private HttpClientConnectionManager connectionManager = null;
    private LayeredConnectionSocketFactory sslSocketFactory = null;

    /**
     * Adds proxy to the {@link HttpClient} created by this builder
     *
     * @param proxy A {@link Proxy} object to get the connection info from
     * @return this object
     */
    public SafechargeClientBuilder setProxy(Proxy proxy) {

        if (proxy != null) {
            HttpHost proxyHost = new HttpHost(proxy.getHost(), proxy.getPort(), proxy.getProtocol());
            this.routePlanner = new DefaultProxyRoutePlanner(proxyHost);
        }

        return this;
    }

    /* Custom */

    /**
     * Sets a {@link RequestConfig} object to set connection properties like TTL, timeout, etc.
     *
     * @param requestConfig A {@link RequestConfig} object to get the connection properties from
     * @return this object
     */
    public SafechargeClientBuilder setRequestConfig(RequestConfig requestConfig) {
        this.requestConfig = requestConfig;
        return this;
    }

    /**
     * Sets a {@link HttpClientConnectionManager} object to set connection properties like
     * number of the connections, max number of connections, number of connections per route, etc.
     *
     * @param connectionManager A {@link HttpClientConnectionManager} object to get the connection properties from
     * @return this object
     */
    public SafechargeClientBuilder setConnectionManager(HttpClientConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
        return this;
    }

    /**
     * Sets the connection TTL. For setting additional connection properties use {@link #setRequestConfig(RequestConfig)}
     * and {@link #setConnectionManager(HttpClientConnectionManager)}
     *
     * @param timeToLive         integer representing the TTL in the time unit defined by the {@code timeToLiveTimeUnit}
     * @param timeToLiveTimeUnit A {@link TimeUnit} object
     * @return this object
     */
    public SafechargeClientBuilder setConnectionTTL(int timeToLive, TimeUnit timeToLiveTimeUnit) {
        this.timeToLive = timeToLive;
        this.timeToLiveTimeUnit = timeToLiveTimeUnit;
        return this;
    }

    /**
     * Sets a {@link LayeredConnectionSocketFactory} object to set connection properties,
     * such as supported SSL Protocols, hostname verifier, etc(needed to create a https connection).
     *
     * @param sslSocketFactory A {@link LayeredConnectionSocketFactory} object to get the connection properties from
     * @return this object
     */
    public SafechargeClientBuilder setSSLSocketFactory(LayeredConnectionSocketFactory sslSocketFactory) {
        this.sslSocketFactory = sslSocketFactory;
        return this;
    }

    /**/

    /* Default methods */

    /**
     * Sets a Safecharge's default {@link RequestConfig} object to set connection properties like TTL, timeout, etc.
     *
     * @return this object
     */
    public SafechargeClientBuilder setDefaultRequestConfig() {
        this.requestConfig = RequestConfig.custom()
                .setSocketTimeout(DEFAULT_TIMEOUT_MILLISECONDS)
                .setConnectTimeout(DEFAULT_TIMEOUT_MILLISECONDS)
                .setConnectionRequestTimeout(DEFAULT_TIMEOUT_MILLISECONDS)
                .setCookieSpec(CookieSpecs.IGNORE_COOKIES)
                .setStaleConnectionCheckEnabled(true)
                .build();
        return this;
    }

    /**
     * Sets a Safecharge's default {@link HttpClientConnectionManager} object to set connection properties like
     * number of the connections, max number of connections, number of connections per route, etc.
     *
     * @return this object
     */
    public SafechargeClientBuilder setDefaultConnectionManager() {
        this.connectionManager = new PoolingHttpClientConnectionManager(CONNECTION_TIME_TO_LIVE_MINUTES, TimeUnit.MINUTES);
        ((PoolingHttpClientConnectionManager) this.connectionManager).setMaxTotal(DEFAULT_MAX_TOTAL_CONNECTIONS);
        ((PoolingHttpClientConnectionManager) this.connectionManager).setDefaultMaxPerRoute(DEFAULT_MAX_CONNECTIONS_PER_ROUTE);
        return this;
    }

    /**
     * Sets default connection TTL ({@value CONNECTION_TIME_TO_LIVE_MINUTES} in {@link TimeUnit#MINUTES}).
     *
     * @return this object
     */
    public SafechargeClientBuilder setDefaultConnectionTTL() {
        this.timeToLive = CONNECTION_TIME_TO_LIVE_MINUTES;
        this.timeToLiveTimeUnit = TimeUnit.MINUTES;
        return this;
    }

    /**
     * Sets a Safecharge's default  {@link LayeredConnectionSocketFactory} object to set connection properties,
     * such as supported SSL Protocols, hostname verifier, etc(needed to create a https connection).
     *
     * @return this object
     */
    public SafechargeClientBuilder setDefaultSSLSocketFactory() {
        SSLContext sslContext = SSLContexts.createDefault();
        String[] javaSupportedProtocols = sslContext.getSupportedSSLParameters()
                .getProtocols();

        List<String> supportedProtocols = new ArrayList<>();
        for (String SERVER_SUPPORTED_SSL_PROTOCOL : SERVER_SUPPORTED_SSL_PROTOCOLS) {
            for (String javaSupportedProtocol : javaSupportedProtocols) {
                if (SERVER_SUPPORTED_SSL_PROTOCOL.equals(javaSupportedProtocol)) {
                    supportedProtocols.add(SERVER_SUPPORTED_SSL_PROTOCOL);
                }
            }
        }

        if (!supportedProtocols.isEmpty()) {
            sslSocketFactory =
                    new SSLConnectionSocketFactory(sslContext, supportedProtocols.toArray(new String[]{}), null, new DefaultHostnameVerifier());
        } else {
            throw new UnsupportedOperationException("Your Java version doesn't support any of the server supported SSL protocols: " + Arrays.toString(
                    SERVER_SUPPORTED_SSL_PROTOCOLS));
        }
        return this;
    }

    /**/

    /**
     * Creates the {@link HttpClient} with the properties set by the builder's methods.
     *
     * @return new {@link HttpClient}
     */
    public HttpClient build() {
        return HttpClients.custom()
                .setRoutePlanner(routePlanner)
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager)
                .setConnectionTimeToLive(timeToLive, timeToLiveTimeUnit)
                .setSSLSocketFactory(sslSocketFactory)
                .build();
    }

}
