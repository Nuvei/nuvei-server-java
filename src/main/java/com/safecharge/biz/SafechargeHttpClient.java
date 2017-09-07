package com.safecharge.biz;

import org.apache.http.client.HttpClient;

import com.safecharge.model.Proxy;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Wrapper class for {@link HttpClient} with specific Safecharge's properties
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/16/2017
 */
public class SafechargeHttpClient {

    /**
     * Creates a pre-configured {@link HttpClient} instance.
     *
     * @return @link HttpClient} with specific Safecharge's default properties
     */
    public static HttpClient createDefault() {
        return new SafechargeClientBuilder().setDefaultConnectionManager()
                .setDefaultConnectionTTL()
                .setDefaultRequestConfig()
                .setDefaultSSLSocketFactory()
                .build();
    }

    /**
     * Creates a pre-configured {@link HttpClient} instance which connects to SafeCharge's API via {@link Proxy}.
     *
     * @param proxy A {@link Proxy} object to get the connection info from
     * @return {@link HttpClient} with specific Safecharge's default properties and the proxy properties defined by the {@code proxy}
     */
    public static HttpClient createDefault(Proxy proxy) {
        return new SafechargeClientBuilder().setProxy(proxy)
                .setDefaultConnectionManager()
                .setDefaultConnectionTTL()
                .setDefaultRequestConfig()
                .setDefaultSSLSocketFactory()
                .build();
    }

    /**
     * Provides custom {@link HttpClient} configuration.
     *
     * @return {@link SafechargeClientBuilder} instance
     */
    public static SafechargeClientBuilder custom() {
        return new SafechargeClientBuilder();
    }

}
