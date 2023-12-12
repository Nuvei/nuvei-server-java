/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.response;

import com.safecharge.model.PaymentOptionResponse;

public class InitPaymentResponse extends SafechargeResponse {

    private String orderId;

    private String userTokenId;

    private String transactionId;

    private String transactionType;

    private String transactionStatus;

    private Integer gwErrorCode;

    private String gwErrorReason;

    private Integer gwExtendedErrorCode;

    private PaymentOptionResponse paymentOption;

    private String customData;

    private String resultStatus;

    private String resultCode;

    private String resultDescription;

    private String mcc;

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

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
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

    public PaymentOptionResponse getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(PaymentOptionResponse paymentOption) {
        this.paymentOption = paymentOption;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("InitPaymentResponse{");
        sb.append(super.toString());
        sb.append(", orderId= ").append(orderId)
                .append(", userTokenId=").append(userTokenId).append('\'')
                .append(", transactionId=").append(transactionId).append('\'')
                .append(", transactionType=").append(transactionType).append('\'')
                .append(", transactionStatus=").append(transactionStatus).append('\'')
                .append(", gwErrorCode=").append(gwErrorCode).append('\'')
                .append(", gwErrorReason=").append(gwErrorReason).append('\'')
                .append(", paymentOption=").append(paymentOption).append('\'')
                .append(", gwErrorCode=").append(gwErrorCode).append('\'')
                .append(", resultStatus=").append(resultStatus).append('\'')
                .append(", resultCode=").append(resultCode).append('\'')
                .append(", resultDescription=").append(resultDescription)
                .append(", mcc=").append(mcc);
        return sb.toString();
    }
}
