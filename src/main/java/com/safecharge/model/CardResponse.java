package com.safecharge.model;

import com.safecharge.response.ThreeDResponse;

public class CardResponse {

    private ApiExternalToken externalToken;
    private String ccCardNumber;
    private String bin;
    private String lastFourDigits;
    private String ccExpMonth;
    private String ccExpYear;
    private String acquirerId;
    private String cvv2Reply;
    private String avsCode;
    private String ccTempToken;
    private String isVerified;
    private ThreeDResponse threeD;

    public ApiExternalToken getExternalToken() {
        return externalToken;
    }

    public void setExternalToken(ApiExternalToken externalToken) {
        this.externalToken = externalToken;
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

    public String getLastFourDigits() {
        return lastFourDigits;
    }

    public void setLastFourDigits(String lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
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

    public ThreeDResponse getThreeD() {
        return threeD;
    }

    public void setThreeD(ThreeDResponse threeD) {
        this.threeD = threeD;
    }
}
