package com.safecharge.response;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * This is the unified response for the Settle, Void and Refund transaction requests.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/20/2017
 */
public class SafechargeTransactionResponse extends SafechargeResponse {

    /**
     * The transaction ID of the transaction for future actions.
     */
    private String transactionId;

    /**
     * The transaction ID of the transaction in the event that an external service is used.
     */
    private String externalTransactionId;

    /**
     * The UPO ID used for the transaction.
     */
    private Long userPaymentOptionId;

    /**
     * If an error occurred on the APM side, an error code is returned in this parameter.
     */
    private Integer paymentMethodErrorCode;

    /**
     * If an error occurred on the APM side, an error reason is returned in this parameter.
     */
    private String paymentMethodErrorReason;

    /**
     * If an error occurred in the Gateway, then an error code is returned in this parameter.
     */
    private Integer gwErrorCode;

    /**
     * If an error occurred in the gateway, then an error reason is returned in this parameter.
     * (E.g. failure in checksum validation, timeout from processing engine, etc.)
     */
    private String gwErrorReason;

    /**
     * Error code if error occurred on the bank’s side.
     * When a transaction is successful, this field is 0.
     * When a transaction is not successful, the parameter is the code of the generic error.
     */
    private Integer gwExtendedErrorCode;

    /**
     * The gateway transaction status. Possible values:
     * <ul>
     * <li>APPROVED
     * <li>DECLINED
     * <li>ERROR
     * </ul>
     */
    private String transactionStatus;

    /**
     * The authorization code of the related auth transaction, to be compared to the original one.
     */
    private String authCode;

    /**
     * The 3D secure request data for the card issuer/bank.
     */
    private String paRequest;

    /**
     * The URL used by the merchant to redirect consumers to the payment method for authentication and authorization of the transaction.
     */
    private String redirectUrl;

    /**
     * The Electronic Commerce Indicator (ECI) is returned from banks and indicates whether the attempted transaction
     * passed as full 3D or failed.
     */
    private String eci;

    /**
     * If the attempt for 3D transaction failed - this parameter is returned by the banks to indicate the reason why
     * the transaction was not passed as full 3D.
     */
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
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
        return sb.toString();
    }
}
