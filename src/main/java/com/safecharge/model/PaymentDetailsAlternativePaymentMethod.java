/*
 * Copyright (c) 2007-2021 SafeCharge International Group Limited.
 */

package com.safecharge.model;

public class PaymentDetailsAlternativePaymentMethod {

    private String externalAccountID;

    private String externalAccountDescription;

    private String externalTransactionId;

    private String APMReferenceID;

    private String orderTransactionId;

    private String amountWithoutFee;

    private String apmPayerInfo;

    private String paymentMethod;

    public String getExternalAccountID() {
        return externalAccountID;
    }

    public void setExternalAccountID(String externalAccountID) {
        this.externalAccountID = externalAccountID;
    }

    public String getExternalAccountDescription() {
        return externalAccountDescription;
    }

    public void setExternalAccountDescription(String externalAccountDescription) {
        this.externalAccountDescription = externalAccountDescription;
    }

    public String getExternalTransactionId() {
        return externalTransactionId;
    }

    public void setExternalTransactionId(String externalTransactionId) {
        this.externalTransactionId = externalTransactionId;
    }

    public String getAPMReferenceID() {
        return APMReferenceID;
    }

    public void setAPMReferenceID(String APMReferenceID) {
        this.APMReferenceID = APMReferenceID;
    }

    public String getOrderTransactionId() {
        return orderTransactionId;
    }

    public void setOrderTransactionId(String orderTransactionId) {
        this.orderTransactionId = orderTransactionId;
    }

    public String getAmountWithoutFee() {
        return amountWithoutFee;
    }

    public void setAmountWithoutFee(String amountWithoutFee) {
        this.amountWithoutFee = amountWithoutFee;
    }

    public String getApmPayerInfo() {
        return apmPayerInfo;
    }

    public void setApmPayerInfo(String apmPayerInfo) {
        this.apmPayerInfo = apmPayerInfo;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
