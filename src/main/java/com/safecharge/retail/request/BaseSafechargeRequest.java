package com.safecharge.retail.request;

import javax.validation.constraints.NotNull;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/14/2017
 */
public abstract class BaseSafechargeRequest implements SafechargeRequest {

    private String clientRequestId;

    @NotNull(message = "merchantId parameter is mandatory!") private String merchantId;

    @NotNull(message = "merchantSiteId parameter is mandatory!") private String merchantSiteId;

    @NotNull(message = "timeStamp parameter is mandatory!") private String timeStamp;

    @NotNull(message = "checksum parameter is mandatory!") private String checksum;

    private String sessionToken;

    @Override public String getMerchantId() {
        return merchantId;
    }

    @Override public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @Override public String getMerchantSiteId() {
        return merchantSiteId;
    }

    @Override public void setMerchantSiteId(String merchantSiteId) {
        this.merchantSiteId = merchantSiteId;
    }

    @Override public String getClientRequestId() {
        return clientRequestId;
    }

    @Override public void setClientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
    }

    @Override public String getTimeStamp() {
        return timeStamp;
    }

    @Override public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getChecksum() {
        return checksum;
    }

    @Override public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    @Override public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("clientRequestId='")
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
