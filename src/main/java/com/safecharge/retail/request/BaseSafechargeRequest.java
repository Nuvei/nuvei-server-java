package com.safecharge.retail.request;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/14/2017
 */
public abstract class BaseSafechargeRequest implements SafechargeRequest {

    private Long internalRequestId;

    private String clientRequestId;

    private String merchantId;

    private String merchantSiteId;

    private String timeStamp;

    private String checksum;

    protected String sessionToken;

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

    public Long getInternalRequestId() {
        return internalRequestId;
    }

    @Override public void setInternalRequestId(Long internalRequestId) {
        this.internalRequestId = internalRequestId;
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

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        BaseSafechargeRequest that = (BaseSafechargeRequest) o;

        if (internalRequestId != null ? !internalRequestId.equals(that.internalRequestId) : that.internalRequestId != null)
            return false;
        if (clientRequestId != null ? !clientRequestId.equals(that.clientRequestId) : that.clientRequestId != null)
            return false;
        if (merchantId != null ? !merchantId.equals(that.merchantId) : that.merchantId != null)
            return false;
        if (merchantSiteId != null ? !merchantSiteId.equals(that.merchantSiteId) : that.merchantSiteId != null)
            return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null)
            return false;
        if (checksum != null ? !checksum.equals(that.checksum) : that.checksum != null)
            return false;
        return sessionToken != null ? sessionToken.equals(that.sessionToken) : that.sessionToken == null;
    }

    @Override public int hashCode() {
        int result = internalRequestId != null ? internalRequestId.hashCode() : 0;
        result = 31 * result + (clientRequestId != null ? clientRequestId.hashCode() : 0);
        result = 31 * result + (merchantId != null ? merchantId.hashCode() : 0);
        result = 31 * result + (merchantSiteId != null ? merchantSiteId.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        result = 31 * result + (checksum != null ? checksum.hashCode() : 0);
        result = 31 * result + (sessionToken != null ? sessionToken.hashCode() : 0);
        return result;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("BaseRequest{");
        sb.append("internalRequestId=")
          .append(internalRequestId);
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
        sb.append('}');
        return sb.toString();
    }
}
