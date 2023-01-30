/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

public class PaymentMethodDetails {

    private String authMethod;
    private String pan;
    private String expirationMonth;
    private String expirationYear;
    private String cryptogram;
    private String eciIndicator;
    private AssuranceDetails assuranceDetails;

    public PaymentMethodDetails() {
    }

    public String getAuthMethod() {
        return authMethod;
    }

    public void setAuthMethod(String authMethod) {
        this.authMethod = authMethod;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getCryptogram() {
        return cryptogram;
    }

    public void setCryptogram(String cryptogram) {
        this.cryptogram = cryptogram;
    }

    public String getEciIndicator() {
        return eciIndicator;
    }

    public void setEciIndicator(String eciIndicator) {
        this.eciIndicator = eciIndicator;
    }

    public AssuranceDetails getAssuranceDetails() {
        return assuranceDetails;
    }

    public void setAssuranceDetails(AssuranceDetails assuranceDetails) {
        this.assuranceDetails = assuranceDetails;
    }
}
