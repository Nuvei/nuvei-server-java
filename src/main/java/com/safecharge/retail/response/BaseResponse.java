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

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder();
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
        return sb.toString();
    }
}
