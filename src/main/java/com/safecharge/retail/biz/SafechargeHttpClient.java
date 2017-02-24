package com.safecharge.retail.biz;

import org.apache.http.client.HttpClient;

import com.safecharge.retail.model.Proxy;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/16/2017
 */
public class SafechargeHttpClient {

    public static HttpClient createDefault() {
        return new SafechargeClientBuilder().setDefaultConnectionManager()
                                            .setDefaultConnectionTTL()
                                            .setDefaultRequestConfig()
                                            .setDefaultSSLSocketFactory()
                                            .build();
    }

    public static HttpClient createDefault(Proxy proxy) {
        return new SafechargeClientBuilder().setProxy(proxy)
                                            .setDefaultConnectionManager()
                                            .setDefaultConnectionTTL()
                                            .setDefaultRequestConfig()
                                            .setDefaultSSLSocketFactory()
                                            .build();
    }

    public static SafechargeClientBuilder custom() {
        return new SafechargeClientBuilder();
    }

}
