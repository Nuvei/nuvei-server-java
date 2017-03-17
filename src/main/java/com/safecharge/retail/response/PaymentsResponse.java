package com.safecharge.retail.response;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/10/2017
 */
public abstract class PaymentsResponse extends SafechargeResponse {

    /**
     * Тhe Merchant Order ID to be used as input parameter in update method and payment methods. The parameter passed to define which merchant order to update.
     */
    protected String orderId;

    /**
     * Тhe gateway/APM gateway transaction status.
     */
    protected String transactionStatus;

    /**
     * Тhe error code if error occurred at the cashier side.
     */
    protected String paymentMethodErrorCode;

    /**
     * Тhe error reason if error occurred at the cashier side.
     */
    protected String paymentMethodErrorReason;

    /**
     * The error code if error occurred at the gateway/APM gateway side.
     */
    protected Integer gwErrorCode;

    /**
     * The error reason if error occurred at the gateway/APM gateway side.
     */
    protected String gwErrorReason;

    /**
     * The error code if error occurred at the bank side.
     */
    protected Integer gwExtendedErrorCode;

    /**
     * The Id of newly generated userPaymentOption, in case of new userPaymentOption is generated, or userPaymentOptionId that has been used for transaction processing and it had been sent into the request.
     */
    protected Long userPaymentOptionId;

    /**
     * Тhe Bank transaction ID.
     */
    protected String externalTransactionId;

    /**
     * Gateway Transaction ID.
     */
    protected String transactionId;

    /**
     * The Auth code.
     */
    protected String authCode;

    /**
     * The ID of the user in merchant system.
     */
    protected String userTokenId;

    /**
     * @return the Merchant Order ID to be used as input parameter in update method and payment methods. The parameter passed to define which merchant order to update.
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Sets Merchant Order ID to be used as input parameter in update method and payment methods. The parameter passed to define which merchant order to update.
     *
     * @param orderId
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the gateway/APM gateway transaction status.
     */
    public String getTransactionStatus() {
        return transactionStatus;
    }

    /**
     * Sets the gateway/APM gateway transaction status.
     *
     * @param transactionStatus
     */
    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    /**
     * @return the error code if error occurred at the cashier side.
     */
    public String getPaymentMethodErrorCode() {
        return paymentMethodErrorCode;
    }

    /**
     * Sets error code if error occurred at the cashier side.
     *
     * @param paymentMethodErrorCode
     */
    public void setPaymentMethodErrorCode(String paymentMethodErrorCode) {
        this.paymentMethodErrorCode = paymentMethodErrorCode;
    }

    /**
     * @return the error reason if error occurred at the cashier side.
     */
    public String getPaymentMethodErrorReason() {
        return paymentMethodErrorReason;
    }

    /**
     * Sets the error reason if error occurred at the cashier side.
     *
     * @param paymentMethodErrorReason
     */
    public void setPaymentMethodErrorReason(String paymentMethodErrorReason) {
        this.paymentMethodErrorReason = paymentMethodErrorReason;
    }

    /**
     * @return the error reason if error occurred at the gateway/APM gateway side.
     */
    public String getGwErrorReason() {
        return gwErrorReason;
    }

    /**
     * Sets the error reason if error occurred at the gateway/APM gateway side.
     *
     * @param gwErrorReason
     */
    public void setGwErrorReason(String gwErrorReason) {
        this.gwErrorReason = gwErrorReason;
    }

    /**
     * @return the Id of newly generated userPaymentOption, in case of new userPaymentOption is generated, or userPaymentOptionId that has been used for transaction processing and it had been sent into the request.
     */
    public Long getUserPaymentOptionId() {
        return userPaymentOptionId;
    }

    /**
     * Sets the Id of newly generated userPaymentOption, in case of new userPaymentOption is generated, or userPaymentOptionId that has been used for transaction processing and it had been sent into the request.
     *
     * @param userPaymentOptionId
     */
    public void setUserPaymentOptionId(Long userPaymentOptionId) {
        this.userPaymentOptionId = userPaymentOptionId;
    }

    /**
     * @return the Bank transaction ID.
     */
    public String getExternalTransactionId() {
        return externalTransactionId;
    }

    /**
     * Sets the Bank transaction ID.
     *
     * @param externalTransactionId
     */
    public void setExternalTransactionId(String externalTransactionId) {
        this.externalTransactionId = externalTransactionId;
    }

    /**
     * @return Gateway Transaction ID.
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets Gateway Transaction ID.
     *
     * @param transactionId
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * @return error code if error occurred at the gateway/APM gateway side.
     */
    public Integer getGwErrorCode() {
        return gwErrorCode;
    }

    /**
     * Sets the error code if error occurred at the gateway/APM gateway side.
     *
     * @param gwErrorCode
     */
    public void setGwErrorCode(Integer gwErrorCode) {
        this.gwErrorCode = gwErrorCode;
    }

    /**
     * @return error code if error occurred at the bank side.
     */
    public Integer getGwExtendedErrorCode() {
        return gwExtendedErrorCode;
    }

    /**
     * Sets the error code if error occurred at the bank side.
     *
     * @param gwExtendedErrorCode
     */
    public void setGwExtendedErrorCode(Integer gwExtendedErrorCode) {
        this.gwExtendedErrorCode = gwExtendedErrorCode;
    }

    /**
     * @return the ID of the user in merchant system.
     */
    public String getUserTokenId() {
        return userTokenId;
    }

    /**
     * Sets the ID of the user in merchant system.
     *
     * @param userTokenId
     */
    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    /**
     * @return the Auth code.
     */
    public String getAuthCode() {
        return authCode;
    }

    /**
     * Sets the Auth code.
     *
     * @param authCode
     */
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("orderId='")
          .append(orderId)
          .append('\'');
        sb.append(", transactionStatus='")
          .append(transactionStatus)
          .append('\'');
        sb.append(", paymentMethodErrorCode='")
          .append(paymentMethodErrorCode)
          .append('\'');
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
        sb.append(", userPaymentOptionId=")
          .append(userPaymentOptionId);
        sb.append(", externalTransactionId='")
          .append(externalTransactionId)
          .append('\'');
        sb.append(", transactionId='")
          .append(transactionId)
          .append('\'');
        sb.append(", authCode='")
          .append(authCode)
          .append('\'');
        sb.append(", userTokenId='")
          .append(userTokenId)
          .append('\'');
        sb.append(", ")
          .append(super.toString());
        return sb.toString();
    }
}
