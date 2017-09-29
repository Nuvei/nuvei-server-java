package com.safecharge.request;

import javax.validation.constraints.NotNull;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Abstract class to be used as a base for all of the requests to SafeCharge's servers.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/14/2017
 */
//@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING.GET_CASHIER_USER_INFO)
public abstract class SafechargeRequest {

    /**
     * Merchant's unique request ID
     */
    private String internalRequestId;

    /**
     * ID of the API request in merchant system.
     */
    private String clientRequestId;

    /**
     * Merchant ID provided by SafeCharge.
     */
    @NotNull(message = "merchantId parameter is mandatory!")
    private String merchantId;

    /**
     * Merchant Site ID provided by SafeCharge.
     */
    @NotNull(message = "merchantSiteId parameter is mandatory!")
    private String merchantSiteId;

    /**
     * The local time when the method call is performed in the format: YYYYMMDDHHmmss.
     */
    @NotNull(message = "timeStamp parameter is mandatory!")
    private String timeStamp;

    /**
     * Hash of the values of the request parameters UTF-8 encoded and concatenated in this order HASH(merchantId + merchantSiteId + clientRequestId + amount + currency + timestamp + merchantSecretKey)
     * Where HASH is the type of used hash algorithm, MD5 or SHA256, depends on merchantSite setting.
     */
    @NotNull(message = "checksum parameter is mandatory!")
    private String checksum;

    /**
     * The session identifier returned, to be used as input parameter in all methods. UUID = Universal unique ID.
     */
    private String sessionToken;

    private String serverHost;

    public String getInternalRequestId() {
        return internalRequestId;
    }

    public void setInternalRequestId(String internalRequestId) {
        this.internalRequestId = internalRequestId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantSiteId() {
        return merchantSiteId;
    }

    public void setMerchantSiteId(String merchantSiteId) {
        this.merchantSiteId = merchantSiteId;
    }

    public String getClientRequestId() {
        return clientRequestId;
    }

    public void setClientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getServerHost() {
        return serverHost;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("serverHost='")
                .append(serverHost)
                .append('\'');
        sb.append("internalRequestId='")
                .append(internalRequestId)
                .append('\'');
        sb.append(", clientRequestId='")
                .append(clientRequestId)
                .append('\'');
        sb.append(", merchantId='")
                .append(merchantId)
                .append('\'');
        sb.append(", merchantSiteId='")
                .append(merchantSiteId)
                .append('\'');
        sb.append(", timeStamp='")
                .append(timeStamp)
                .append('\'');
        sb.append(", checksum='")
                .append(checksum)
                .append('\'');
        sb.append(", sessionToken='")
                .append(sessionToken)
                .append('\'');
        return sb.toString();
    }
}
