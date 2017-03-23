package com.safecharge.retail.response;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * This is the unified response for the Settle, Void and Refund transaction requests.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/20/2017
 */
public class SafechargeTransactionResponse extends SafechargeResponse {

    private String transactionId;
    private String externalTransactionId;
    private Long userPaymentOptionId;

    // updated error parameters
    private Integer paymentMethodErrorCode;
    private String paymentMethodErrorReason;
    private Integer gwErrorCode;
    private String gwErrorReason;
    private Integer gwExtendedErrorCode;

    private String transactionStatus;

    private String authCode;

    private String paRequest;
    private String redirectUrl;
    private String eci;
    private String threeDReason;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getExternalTransactionId() {
        return externalTransactionId;
    }

    public void setExternalTransactionId(String externalTransactionId) {
        this.externalTransactionId = externalTransactionId;
    }

    public Long getUserPaymentOptionId() {
        return userPaymentOptionId;
    }

    public void setUserPaymentOptionId(Long userPaymentOptionId) {
        this.userPaymentOptionId = userPaymentOptionId;
    }

    public Integer getPaymentMethodErrorCode() {
        return paymentMethodErrorCode;
    }

    public void setPaymentMethodErrorCode(Integer paymentMethodErrorCode) {
        this.paymentMethodErrorCode = paymentMethodErrorCode;
    }

    public String getPaymentMethodErrorReason() {
        return paymentMethodErrorReason;
    }

    public void setPaymentMethodErrorReason(String paymentMethodErrorReason) {
        this.paymentMethodErrorReason = paymentMethodErrorReason;
    }

    public Integer getGwErrorCode() {
        return gwErrorCode;
    }

    public void setGwErrorCode(Integer gwErrorCode) {
        this.gwErrorCode = gwErrorCode;
    }

    public String getGwErrorReason() {
        return gwErrorReason;
    }

    public void setGwErrorReason(String gwErrorReason) {
        this.gwErrorReason = gwErrorReason;
    }

    public Integer getGwExtendedErrorCode() {
        return gwExtendedErrorCode;
    }

    public void setGwExtendedErrorCode(Integer gwExtendedErrorCode) {
        this.gwExtendedErrorCode = gwExtendedErrorCode;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getPaRequest() {
        return paRequest;
    }

    public void setPaRequest(String paRequest) {
        this.paRequest = paRequest;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getEci() {
        return eci;
    }

    public void setEci(String eci) {
        this.eci = eci;
    }

    public String getThreeDReason() {
        return threeDReason;
    }

    public void setThreeDReason(String threeDReason) {
        this.threeDReason = threeDReason;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("SafechargeTransactionResponse{");
        sb.append("transactionId='")
          .append(transactionId)
          .append('\'');
        sb.append(", externalTransactionId='")
          .append(externalTransactionId)
          .append('\'');
        sb.append(", userPaymentOptionId=")
          .append(userPaymentOptionId);
        sb.append(", paymentMethodErrorCode=")
          .append(paymentMethodErrorCode);
        sb.append(", paymentMethodErrorReason='")
          .append(paymentMethodErrorReason)
          .append('\'');
        sb.append(", gwErrorCode=")
          .append(gwErrorCode);
        sb.append(", gwErrorReason='")
          .append(gwErrorReason)
          .append('\'');
        sb.append(", gwExtendedErrorCode=")
          .append(gwExtendedErrorCode);
        sb.append(", transactionStatus='")
          .append(transactionStatus)
          .append('\'');
        sb.append(", authCode='")
          .append(authCode)
          .append('\'');
        sb.append(", paRequest='")
          .append(paRequest)
          .append('\'');
        sb.append(", redirectUrl='")
          .append(redirectUrl)
          .append('\'');
        sb.append(", eci='")
          .append(eci)
          .append('\'');
        sb.append(", threeDReason='")
          .append(threeDReason)
          .append('\'');
        sb.append(", ")
          .append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
