package com.safecharge.retail.response;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/15/2017
 */
public class PaymentCCResponse extends BaseResponse implements PaymentsResponse {

    private static final long serialVersionUID = 354345234523425L;

    private String orderId;
    private String transactionStatus;
    private String paymentMethodErrorCode;
    private String paymentMethodErrorReason;
    private Integer gwErrorCode;
    private String gwErrorReason;
    private Integer gwExtendedErrorCode;
    private Long userPaymentOptionId;
    private String externalTransactionId;
    private String transactionId;
    private String authCode;
    private String userTokenId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getPaymentMethodErrorCode() {
        return paymentMethodErrorCode;
    }

    public void setPaymentMethodErrorCode(String paymentMethodErrorCode) {
        this.paymentMethodErrorCode = paymentMethodErrorCode;
    }

    public String getPaymentMethodErrorReason() {
        return paymentMethodErrorReason;
    }

    public void setPaymentMethodErrorReason(String paymentMethodErrorReason) {
        this.paymentMethodErrorReason = paymentMethodErrorReason;
    }

    public String getGwErrorReason() {
        return gwErrorReason;
    }

    public void setGwErrorReason(String gwErrorReason) {
        this.gwErrorReason = gwErrorReason;
    }

    public Long getUserPaymentOptionId() {
        return userPaymentOptionId;
    }

    public void setUserPaymentOptionId(Long userPaymentOptionId) {
        this.userPaymentOptionId = userPaymentOptionId;
    }

    public String getExternalTransactionId() {
        return externalTransactionId;
    }

    public void setExternalTransactionId(String externalTransactionId) {
        this.externalTransactionId = externalTransactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getGwErrorCode() {
        return gwErrorCode;
    }

    public void setGwErrorCode(Integer gwErrorCode) {
        this.gwErrorCode = gwErrorCode;
    }

    public Integer getGwExtendedErrorCode() {
        return gwExtendedErrorCode;
    }

    public void setGwExtendedErrorCode(Integer gwExtendedErrorCode) {
        this.gwExtendedErrorCode = gwExtendedErrorCode;
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentCCResponse{");
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
        sb.append(", ");
        sb.append(sb.append(super.toString()));
        sb.append('}');
        return sb.toString();
    }
}