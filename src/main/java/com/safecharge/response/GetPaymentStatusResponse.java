/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.response;

import com.safecharge.model.AmountInfo;
import com.safecharge.model.PaymentDetailsPaymentOption;

public class GetPaymentStatusResponse extends SafechargeResponse {

    private String customData;

    private Integer gwExtendedErrorCode;

    private Integer gwErrorCode;

    private String gwErrorReason;

    private Integer paymentMethodErrorCode;

    private String paymentMethodErrorReason;

    private String authCode;

    private String transactionType;

    private String transactionStatus;

    private String userTokenId;

    private String transactionId;

    private PaymentDetailsPaymentOption paymentOption;

    private AmountInfo partialApproval;

    private String currency;

    private String amount;

    private String issuerDeclineCode;

    private String issuerDeclineReason;

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }

    public Integer getGwExtendedErrorCode() {
        return gwExtendedErrorCode;
    }

    public void setGwExtendedErrorCode(Integer gwExtendedErrorCode) {
        this.gwExtendedErrorCode = gwExtendedErrorCode;
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

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
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

    public PaymentDetailsPaymentOption getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(PaymentDetailsPaymentOption paymentOption) {
        this.paymentOption = paymentOption;
    }

    public AmountInfo getPartialApproval() {
        return partialApproval;
    }

    public void setPartialApproval(AmountInfo partialApproval) {
        this.partialApproval = partialApproval;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getIssuerDeclineCode() {
        return issuerDeclineCode;
    }

    public void setIssuerDeclineCode(String issuerDeclineCode) {
        this.issuerDeclineCode = issuerDeclineCode;
    }

    public String getIssuerDeclineReason() {
        return issuerDeclineReason;
    }

    public void setIssuerDeclineReason(String issuerDeclineReason) {
        this.issuerDeclineReason = issuerDeclineReason;
    }
}
