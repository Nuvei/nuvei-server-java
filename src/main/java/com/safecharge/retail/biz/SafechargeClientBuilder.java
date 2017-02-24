package com.safecharge.retail.biz;

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

import com.safecharge.retail.model.Proxy;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
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
    private static final String[] SERVER_SUPPORTED_SSL_PROTOCOLS = new String[] { "TLSv1.1", "TLSv1.2" };

    private int timeToLive;
    private TimeUnit timeToLiveTimeUnit;
    private RequestConfig requestConfig = null;
    private DefaultProxyRoutePlanner routePlanner = null;
    private HttpClientConnectionManager connectionManager = null;
    private LayeredConnectionSocketFactory sslSocketFactory = null;

    public SafechargeClientBuilder setProxy(Proxy proxy) {

        if (proxy != null) {
            HttpHost proxyHost = new HttpHost(proxy.getHost(), proxy.getPort(), proxy.getProtocol());
            this.routePlanner = new DefaultProxyRoutePlanner(proxyHost);
        }

        return this;
    }

    /* Custom */

    public SafechargeClientBuilder setRequestConfig(RequestConfig requestConfig) {
        this.requestConfig = requestConfig;
        return this;
    }

    public SafechargeClientBuilder setConnectionManager(HttpClientConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
        return this;
    }

    public SafechargeClientBuilder setConnectionTTL(int timeToLive, TimeUnit timeToLiveTimeUnit) {
        this.timeToLive = timeToLive;
        this.timeToLiveTimeUnit = timeToLiveTimeUnit;
        return this;
    }

    public SafechargeClientBuilder setSSLSocketFactory(LayeredConnectionSocketFactory sslSocketFactory) {
        this.sslSocketFactory = sslSocketFactory;
        return this;
    }

    /**/

    /* Default methods */

    public SafechargeClientBuilder setDefaultRequestConfig() {
        this.requestConfig = RequestConfig.custom()
                                          .setSocketTimeout(DEFAULT_TIMEOUT_MILLISECONDS)
                                          .setConnectTimeout(DEFAULT_TIMEOUT_MILLISECONDS)
                                          .setConnectionRequestTimeout(DEFAULT_TIMEOUT_MILLISECONDS)
                                          .setCookieSpec(CookieSpecs.IGNORE_COOKIES)
                                          .build();
        return this;
    }

    public SafechargeClientBuilder setDefaultConnectionManager() {
        this.connectionManager = new PoolingHttpClientConnectionManager(CONNECTION_TIME_TO_LIVE_MINUTES, TimeUnit.MINUTES);
        ((PoolingHttpClientConnectionManager) this.connectionManager).setMaxTotal(DEFAULT_MAX_TOTAL_CONNECTIONS);
        ((PoolingHttpClientConnectionManager) this.connectionManager).setDefaultMaxPerRoute(DEFAULT_MAX_CONNECTIONS_PER_ROUTE);
        return this;
    }

    public SafechargeClientBuilder setDefaultConnectionTTL() {
        this.timeToLive = CONNECTION_TIME_TO_LIVE_MINUTES;
        this.timeToLiveTimeUnit = TimeUnit.MINUTES;
        return this;
    }

    public SafechargeClientBuilder setDefaultSSLSocketFactory() {
        SSLContext sslContext = SSLContexts.createDefault();
        String[] javaSupportedProtocols = sslContext.getSupportedSSLParameters()
                                                    .getProtocols();

        List<String> supportedProtocols = new ArrayList<String>();
        for (String SERVER_SUPPORTED_SSL_PROTOCOL : SERVER_SUPPORTED_SSL_PROTOCOLS) {
            for (String javaSupportedProtocol : javaSupportedProtocols) {
                if (SERVER_SUPPORTED_SSL_PROTOCOL.equals(javaSupportedProtocol)) {
                    supportedProtocols.add(SERVER_SUPPORTED_SSL_PROTOCOL);
                }
            }
        }

        if (!supportedProtocols.isEmpty()) {
            sslSocketFactory =
                    new SSLConnectionSocketFactory(sslContext, supportedProtocols.toArray(new String[] {}), null, new DefaultHostnameVerifier());
        } else {
            throw new UnsupportedOperationException("Your Java version doesn't support any of the server supported SSL protocols: " + Arrays.toString(
                    SERVER_SUPPORTED_SSL_PROTOCOLS));
        }
        return this;
    }

    /**/
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
