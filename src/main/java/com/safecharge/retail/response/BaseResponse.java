package com.safecharge.retail.response;

import com.safecharge.retail.util.Constants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/14/2017
 */
public abstract class BaseResponse implements SafechargeResponse {

    private static final long serialVersionUID = 4104056768008786142L;

    private Long internalRequestId;
    private Constants.APIResponseStatus status;
    private int errCode = Constants.ERR_CODE_NO_ERROR;

    private String reason = "";

    private String merchantId;

    private String merchantSiteId;

    private String version;

    private String clientRequestId;

    private String sessionToken;

    private String clientUniqueId;

    private Constants.ErrorType errorType = null;

    private Constants.APIType apiType;

    public BaseResponse() {
    }

    public Long getInternalRequestId() {
        return internalRequestId;
    }

    public void setInternalRequestId(Long internalRequestId) {
        this.internalRequestId = internalRequestId;
    }

    public Constants.APIResponseStatus getStatus() {
        return status;
    }

    public void setStatus(Constants.APIResponseStatus status) {
        this.status = status;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getClientRequestId() {
        return clientRequestId;
    }

    public void setClientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getClientUniqueId() {
        return clientUniqueId;
    }

    public void setClientUniqueId(String clientUniqueId) {
        this.clientUniqueId = clientUniqueId;
    }

    public Constants.ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(Constants.ErrorType errorType) {
        this.errorType = errorType;
    }

    public Constants.APIType getApiType() {
        return apiType;
    }

    public void setApiType(Constants.APIType apiType) {
        this.apiType = apiType;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        BaseResponse that = (BaseResponse) o;

        if (errCode != that.errCode)
            return false;
        if (internalRequestId != null ? !internalRequestId.equals(that.internalRequestId) : that.internalRequestId != null)
            return false;
        if (status != that.status)
            return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null)
            return false;
        if (merchantId != null ? !merchantId.equals(that.merchantId) : that.merchantId != null)
            return false;
        if (merchantSiteId != null ? !merchantSiteId.equals(that.merchantSiteId) : that.merchantSiteId != null)
            return false;
        if (version != null ? !version.equals(that.version) : that.version != null)
            return false;
        if (clientRequestId != null ? !clientRequestId.equals(that.clientRequestId) : that.clientRequestId != null)
            return false;
        if (sessionToken != null ? !sessionToken.equals(that.sessionToken) : that.sessionToken != null)
            return false;
        if (clientUniqueId != null ? !clientUniqueId.equals(that.clientUniqueId) : that.clientUniqueId != null)
            return false;
        if (errorType != that.errorType)
            return false;
        return apiType == that.apiType;
    }

    @Override public int hashCode() {
        int result = internalRequestId != null ? internalRequestId.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + errCode;
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (merchantId != null ? merchantId.hashCode() : 0);
        result = 31 * result + (merchantSiteId != null ? merchantSiteId.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (clientRequestId != null ? clientRequestId.hashCode() : 0);
        result = 31 * result + (sessionToken != null ? sessionToken.hashCode() : 0);
        result = 31 * result + (clientUniqueId != null ? clientUniqueId.hashCode() : 0);
        result = 31 * result + (errorType != null ? errorType.hashCode() : 0);
        result = 31 * result + (apiType != null ? apiType.hashCode() : 0);
        return result;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("BaseResponse{");
        sb.append("internalRequestId=")
          .append(internalRequestId);
        sb.append(", status=")
          .append(status);
        sb.append(", errCode=")
          .append(errCode);
        sb.append(", reason='")
          .append(reason)
          .append('\'');
        sb.append(", merchantId='")
          .append(merchantId)
          .append('\'');
        sb.append(", merchantSiteId='")
          .append(merchantSiteId)
          .append('\'');
        sb.append(", version='")
          .append(version)
          .append('\'');
        sb.append(", clientRequestId='")
          .append(clientRequestId)
          .append('\'');
        sb.append(", sessionToken='")
          .append(sessionToken)
          .append('\'');
        sb.append(", clientUniqueId='")
          .append(clientUniqueId)
          .append('\'');
        sb.append(", errorType=")
          .append(errorType);
        sb.append(", apiType=")
          .append(apiType);
        sb.append('}');
        return sb.toString();
    }
}
