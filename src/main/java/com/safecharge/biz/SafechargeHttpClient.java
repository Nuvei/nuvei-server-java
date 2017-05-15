package com.safecharge.biz;

import org.apache.http.client.HttpClient;

import com.safecharge.model.Proxy;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/16/2017
 */
public class SafechargeHttpClient {

    /**
     * Creates a pre-configured {@link HttpClient} instance.
     *
     * @return
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
     * @param proxy
     * @return
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
     * @return
     */
    public static SafechargeClientBuilder custom() {
        return new SafechargeClientBuilder();
    }

}
