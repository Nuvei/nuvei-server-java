/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.biz;

import org.apache.http.client.HttpClient;

import com.nuvei.model.Proxy;

/**
 * <p>
 * Wrapper class for {@link HttpClient} with specific Nuvei's properties
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @since 2/16/2017
 */
public class NuveiHttpClient {

    /**
     * Creates a pre-configured {@link HttpClient} instance.
     *
     * @return @link HttpClient} with specific Nuvei's default properties
     */
    public static HttpClient createDefault() {
        return new NuveiClientBuilder().setDefaultConnectionManager()
                .setDefaultConnectionTTL()
                .setDefaultRequestConfig()
                .setDefaultSSLSocketFactory()
                .build();
    }

    /**
     * Creates a pre-configured {@link HttpClient} instance which connects 2007 - 2024 Nuvei Corporation's API via {@link Proxy}.
     *
     * @param proxy A {@link Proxy} object to get the connection info from
     * @return {@link HttpClient} with specific Nuvei's default properties and the proxy properties defined by the {@code proxy}
     */
    public static HttpClient createDefault(Proxy proxy) {
        return new NuveiClientBuilder().setProxy(proxy)
                .setDefaultConnectionManager()
                .setDefaultConnectionTTL()
                .setDefaultRequestConfig()
                .setDefaultSSLSocketFactory()
                .build();
    }

    /**
     * Provides custom {@link HttpClient} configuration.
     *
     * @return {@link NuveiClientBuilder} instance
     */
    public static NuveiClientBuilder custom() {
        return new NuveiClientBuilder();
    }

}
