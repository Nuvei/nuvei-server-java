/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import com.safecharge.response.ThreeDResponse;

public class CardResponse {

    private ApiExternalToken externalToken;
    private String externalTokenProvider;
    private String ccCardNumber;
    private String bin;
    private String last4Digits;
    private String ccExpMonth;
    private String ccExpYear;
    private String acquirerId;
    private String cvv2Reply;
    private String avsCode;
    private String ccTempToken;
    private String isVerified;
    private String isPrepaid;
    private String cardType;
    private String cardBrand;
    private String issuerCountry;
    private ThreeDResponse threeD;

    public ApiExternalToken getExternalToken() {
        return externalToken;
    }

    public void setExternalToken(ApiExternalToken externalToken) {
        this.externalToken = externalToken;
    }

    public String getExternalTokenProvider() {
        return externalTokenProvider;
    }

    public void setExternalTokenProvider(String externalTokenProvider) {
        this.externalTokenProvider = externalTokenProvider;
    }

    public String getCcCardNumber() {
        return ccCardNumber;
    }

    public void setCcCardNumber(String ccCardNumber) {
        this.ccCardNumber = ccCardNumber;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getLast4Digits() {
        return last4Digits;
    }

    public void setLast4Digits(String last4Digits) {
        this.last4Digits = last4Digits;
    }

    public String getCcExpMonth() {
        return ccExpMonth;
    }

    public void setCcExpMonth(String ccExpMonth) {
        this.ccExpMonth = ccExpMonth;
    }

    public String getCcExpYear() {
        return ccExpYear;
    }

    public void setCcExpYear(String ccExpYear) {
        this.ccExpYear = ccExpYear;
    }

    public String getAcquirerId() {
        return acquirerId;
    }

    public void setAcquirerId(String acquirerId) {
        this.acquirerId = acquirerId;
    }

    public String getCvv2Reply() {
        return cvv2Reply;
    }

    public void setCvv2Reply(String cvv2Reply) {
        this.cvv2Reply = cvv2Reply;
    }

    public String getAvsCode() {
        return avsCode;
    }

    public void setAvsCode(String avsCode) {
        this.avsCode = avsCode;
    }

    public String getCcTempToken() {
        return ccTempToken;
    }

    public void setCcTempToken(String ccTempToken) {
        this.ccTempToken = ccTempToken;
    }

    public String getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(String isVerified) {
        this.isVerified = isVerified;
    }

    public String getIsPrepaid() {
        return isPrepaid;
    }

    public void setIsPrepaid(String isPrepaid) {
        this.isPrepaid = isPrepaid;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

    public String getIssuerCountry() {
        return issuerCountry;
    }

    public void setIssuerCountry(String issuerCountry) {
        this.issuerCountry = issuerCountry;
    }

    public ThreeDResponse getThreeD() {
        return threeD;
    }

    public void setThreeD(ThreeDResponse threeD) {
        this.threeD = threeD;
    }
}
