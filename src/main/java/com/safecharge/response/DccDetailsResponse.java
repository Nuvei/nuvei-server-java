/*
 * Copyright (c) 2007-2020 SafeCharge International Group Limited.
 */

package com.safecharge.response;

public class DccDetailsResponse extends SafechargeResponse {

    private String rateValueWitMarkUp;

    private String markUpValue;

    private String amount;

    private String currency;

    private String originalAmount;

    private String originalCurrency;

    private String dccFullSupport;

    public String getRateValueWitMarkUp() {
        return rateValueWitMarkUp;
    }

    public void setRateValueWitMarkUp(String rateValueWitMarkUp) {
        this.rateValueWitMarkUp = rateValueWitMarkUp;
    }

    public String getMarkUpValue() {
        return markUpValue;
    }

    public void setMarkUpValue(String markUpValue) {
        this.markUpValue = markUpValue;
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

    public String getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(String originalAmount) {
        this.originalAmount = originalAmount;
    }

    public String getOriginalCurrency() {
        return originalCurrency;
    }

    public void setOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
    }

    public String getDccFullSupport() {
        return dccFullSupport;
    }

    public void setDccFullSupport(String dccFullSupport) {
        this.dccFullSupport = dccFullSupport;
    }
}
