/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.response;

import com.safecharge.model.AmountInfo;
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

    private AmountInfo partialApproval;

    private String issuerDeclineCode;

    private String issuerDeclineReason;

    private String externalSchemeTransactionId;

    private String additionalTransactionBankId;

    private String openInExternalBrowser;

    private String merchantAdviceCode;

    private String isAFT;

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

    public AmountInfo getPartialApproval() {
        return partialApproval;
    }

    public void setPartialApproval(AmountInfo partialApproval) {
        this.partialApproval = partialApproval;
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

    public String getExternalSchemeTransactionId() {
        return externalSchemeTransactionId;
    }

    public void setExternalSchemeTransactionId(String externalSchemeTransactionId) {
        this.externalSchemeTransactionId = externalSchemeTransactionId;
    }

    public String getAdditionalTransactionBankId() {
        return additionalTransactionBankId;
    }

    public void setAdditionalTransactionBankId(String additionalTransactionBankId) {
        this.additionalTransactionBankId = additionalTransactionBankId;
    }

    public String getOpenInExternalBrowser() {
        return openInExternalBrowser;
    }

    public void setOpenInExternalBrowser(String openInExternalBrowser) {
        this.openInExternalBrowser = openInExternalBrowser;
    }

    public String getMerchantAdviceCode() {
        return merchantAdviceCode;
    }

    public void setMerchantAdviceCode(String merchantAdviceCode) {
        this.merchantAdviceCode = merchantAdviceCode;
    }

    public String getIsAFT() {
        return isAFT;
    }

    public void setIsAFT(String isAFT) {
        this.isAFT = isAFT;
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
                .append(", fraudDetails=").append(fraudDetails)
                .append(", issuerDeclineCode=").append(issuerDeclineCode)
                .append(", issuerDeclineReason=").append(issuerDeclineReason)
                .append(", externalSchemeTransactionId=").append(externalSchemeTransactionId)
                .append(", additionalTransactionBankId=").append(additionalTransactionBankId)
                .append(", partialApproval=").append(partialApproval)
                .append(", openInExternalBrowser=").append(openInExternalBrowser)
                .append(", merchantAdviceCode=").append(merchantAdviceCode)
                .append(", openInExternalBrowser=").append(openInExternalBrowser)
                .append(", isAFT=").append(isAFT);

        return sb.toString();
    }
}
