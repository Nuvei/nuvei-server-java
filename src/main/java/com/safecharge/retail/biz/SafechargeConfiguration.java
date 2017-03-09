package com.safecharge.retail.biz;

import org.apache.http.client.HttpClient;

import com.safecharge.retail.exception.SafechargeConfigurationException;
import com.safecharge.retail.model.MerchantInfo;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/8/2017
 */
public class SafechargeConfiguration {

    private static MerchantInfo merchantInfo;
    private static String serverHost;
    private static HttpClient httpClient;

    private SafechargeConfiguration() {
    }

    /**
     * This method initializes the configuration needed to access SafeCharge's services.
     *
     * @param merchantInfo
     * @param serverHost
     * @param httpClient
     */
    public static void init(MerchantInfo merchantInfo, String serverHost, HttpClient httpClient) {
        SafechargeConfiguration.merchantInfo = merchantInfo;
        SafechargeConfiguration.serverHost = serverHost;
        SafechargeConfiguration.httpClient = httpClient;
    }

    /**
     * @return the {@link MerchantInfo} instance in the configuration
     * @throws SafechargeConfigurationException if {@link MerchantInfo} property is null
     */
    public static MerchantInfo getMerchantInfo() {
        if (!isConfigured()) {
            throw new SafechargeConfigurationException("MerchantInfo is not configured. SafechargeConfiguration may not be initialized.");
        }
        return merchantInfo;
    }

    /**
     * @return the API Server Host from the configuration
     * @throws SafechargeConfigurationException if API Server Host property is null
     */
    public static String getServerHost() {
        if (!isConfigured()) {
            throw new SafechargeConfigurationException(
                    "Safecharge server host URL is not configured. SafechargeConfiguration may not be initialized.");
        }
        return serverHost;
    }

    /**
     * @return the {@link HttpClient} instance in the configuration
     * @throws SafechargeConfigurationException if {@link HttpClient} property is null
     */
    public static HttpClient getHttpClient() {
        if (!isConfigured()) {
            throw new SafechargeConfigurationException("HttpClient is not configured. SafechargeConfiguration may not be initialized.");
        }
        return httpClient;
    }

    private static boolean isConfigured() {
        return !(merchantInfo == null || serverHost == null || httpClient == null);
    }
}
