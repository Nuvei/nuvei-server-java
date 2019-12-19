package com.safecharge.response;

import com.safecharge.model.ExternalToken;

public class CardResponse {

    private ExternalToken externalToken;
    private String ccCardNumber;
    private String bin;
    private String lastFourDigits;
    private String ccExpMonth;
    private String ccExpYear;
    private String acquirerId;
    private String cvv2Replay;
    private String avsCode;
    private String ccTempToken;
    private String isVerified;
    private ThreeDResponse threeDResponse;

    public ExternalToken getExternalToken() {
        return externalToken;
    }

    public void setExternalToken(ExternalToken externalToken) {
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

    public String getCvv2Replay() {
        return cvv2Replay;
    }

    public void setCvv2Replay(String cvv2Replay) {
        this.cvv2Replay = cvv2Replay;
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

    public ThreeDResponse getThreeDResponse() {
        return threeDResponse;
    }

    public void setThreeDResponse(ThreeDResponse threeDResponse) {
        this.threeDResponse = threeDResponse;
    }
}
