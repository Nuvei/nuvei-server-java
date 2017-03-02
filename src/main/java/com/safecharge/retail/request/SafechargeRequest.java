package com.safecharge.retail.request;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */
public interface SafechargeRequest {

    /**
     * Merchant ID provided by SafeCharge.
     *
     * @return merchantId
     */
    String getMerchantId();

    /**
     * Merchant ID provided by SafeCharge.
     *
     * @param merchantId
     */
    void setMerchantId(String merchantId);

    /**
     * @return Merchant Site ID provided by SafeCharge.
     */
    String getMerchantSiteId();

    /**
     * Sets Merchant Site ID provided by SafeCharge.
     *
     * @param merchantSiteId
     */
    void setMerchantSiteId(String merchantSiteId);

    /**
     * @return The local time when the method call is performed in the format: YYYYMMDDHHmmss.
     */
    String getTimeStamp();

    /**
     * The local time when the method call is performed in the format: YYYYMMDDHHmmss.
     *
     * @param timestamp
     */
    void setTimeStamp(String timestamp);

    /**
     * @return ID of the API request in merchant system.
     */
    String getClientRequestId();

    /**
     * ID of the API request in merchant system.
     *
     * @param clientRequestId
     */
    void setClientRequestId(String clientRequestId);

    /**
     * "Hash of the values of the request parameters UTF-8 encoded and concatenated in this order HASH(merchantId + merchantSiteId + clientRequestId + amount + currency + timestamp + merchantSecretKey)
     * Where HASH is the type of used hash algorithm, MD5 or SHA256, depends on merchantSite setting."
     *
     * @param checksum
     */
    void setChecksum(String checksum);

    /**
     * The session identifier returned, to be used as input parameter in all methods. UUID = Universal unique ID.
     *
     * @param sessionToken
     */
    void setSessionToken(String sessionToken);

}