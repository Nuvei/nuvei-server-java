package com.safecharge.response;

import com.safecharge.model.FraudDetails;
import com.safecharge.model.MerchantDetails;
import com.safecharge.model.PaymentOptionResponse;

public abstract class Authorize3dAndPaymentResponse extends SafechargeResponse {

    private String orderId;

    private String userTokenId;

    private PaymentOptionResponse paymentOption;

    private String transactionStatus;

    private MerchantDetails merchantDetails;

    private Integer gwErrorCode;

    private String gwErrorReason;

    private Integer gwExtendedErrorCode;

    private Integer paymentMethodErrorCode;

    private String paymentMethodErrorReason;

    private String transactionType;

    private String transactionId;

    private String externalTransactionId;

    private String authCode;

    private String customData;

    private FraudDetails fraudDetails;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    public PaymentOptionResponse getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(PaymentOptionResponse paymentOption) {
        this.paymentOption = paymentOption;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public MerchantDetails getMerchantDetails() {
        return merchantDetails;
    }

    public void setMerchantDetails(MerchantDetails merchantDetails) {
        this.merchantDetails = merchantDetails;
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

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

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

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }

    public FraudDetails getFraudDetails() {
        return fraudDetails;
    }

    public void setFraudDetails(FraudDetails fraudDetails) {
        this.fraudDetails = fraudDetails;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", orderId=").append(orderId).append('\'')
                .append(", userToken=").append(userTokenId).append('\'')
                .append(", paymentOption=").append(paymentOption).append('\'')
                .append(", transactionStatus=").append(transactionStatus).append('\'')
                .append(", merchantDetails=").append(merchantDetails).append('\'')
                .append(", gwErrorCode=").append(gwErrorCode).append('\'')
                .append(", gwErrorReason=").append(gwErrorReason)
                .append(", gwExtendedErrorCode=").append(gwExtendedErrorCode).append('\'')
                .append(", paymentMethodErrorCode=").append(paymentMethodErrorCode).append('\'')
                .append(", paymentMethodErrorReason=").append(paymentMethodErrorReason).append('\'')
                .append(", transactionType=").append(transactionType).append('\'')
                .append(", transactionId=").append(transactionId).append('\'')
                .append(", externalTransactionId=").append(externalTransactionId).append('\'')
                .append(", authCode=").append(authCode).append('\'')
                .append(", customData=").append(customData).append('\'')
                .append(", fraudDetails=").append(fraudDetails);

        return sb.toString();
    }
}
