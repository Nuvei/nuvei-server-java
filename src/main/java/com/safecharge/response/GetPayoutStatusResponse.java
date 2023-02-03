/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.response;

import com.safecharge.model.PaymentOption;

public class GetPayoutStatusResponse extends SafechargeResponse {

    private String transactionStatus;

    private String amount;

    private String currency;

    private String userPaymentOptionId;

    private PaymentOption paymentOption;

    private String paymentMethodErrorCode;

    private String paymentMethodErrorReason;

    private String gwExtendedErrorCode;

    private String gwErrorCode;

    private String gwErrorReason;

    private String userTokenId;

    private String transactionId;

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getUserPaymentOptionId() {
        return userPaymentOptionId;
    }

    public void setUserPaymentOptionId(String userPaymentOptionId) {
        this.userPaymentOptionId = userPaymentOptionId;
    }

    public PaymentOption getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(PaymentOption paymentOption) {
        this.paymentOption = paymentOption;
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

    public String getGwExtendedErrorCode() {
        return gwExtendedErrorCode;
    }

    public void setGwExtendedErrorCode(String gwExtendedErrorCode) {
        this.gwExtendedErrorCode = gwExtendedErrorCode;
    }

    public String getGwErrorCode() {
        return gwErrorCode;
    }

    public void setGwErrorCode(String gwErrorCode) {
        this.gwErrorCode = gwErrorCode;
    }

    public String getGwErrorReason() {
        return gwErrorReason;
    }

    public void setGwErrorReason(String gwErrorReason) {
        this.gwErrorReason = gwErrorReason;
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

    @Override
    public String toString() {
        return "GetPayoutStatusResponse{" +
                "transactionStatus='" + transactionStatus + '\'' +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                ", userPaymentOptionId='" + userPaymentOptionId + '\'' +
                ", paymentOption=" + paymentOption +
                ", paymentMethodErrorCode='" + paymentMethodErrorCode + '\'' +
                ", paymentMethodErrorReason='" + paymentMethodErrorReason + '\'' +
                ", gwExtendedErrorCode='" + gwExtendedErrorCode + '\'' +
                ", gwErrorCode='" + gwErrorCode + '\'' +
                ", gwErrorReason='" + gwErrorReason + '\'' +
                ", userTokenId='" + userTokenId + '\'' +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }
}
