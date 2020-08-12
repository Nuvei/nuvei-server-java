package com.safecharge.response;


import com.safecharge.request.CardDetailsRequest;

/**
 * Copyright (C) 2007-2020 SafeCharge International Group Limited.
 * <p>
 * Response received from the SafeCharge's servers to the {@link CardDetailsRequest}
 * </p>
 *
 * @see CardDetailsRequest
 * @since 7/27/2020
 */
public class CardDetailsResponse extends SafechargeResponse {

    private String brand;
    private String cardType;
    private String cardProduct;
    private String program;
    private String visaDirectSupport;
    private String issuerCountry;
    private String currency;
    private boolean dccAllowed;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardProduct() {
        return cardProduct;
    }

    public void setCardProduct(String cardProduct) {
        this.cardProduct = cardProduct;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getVisaDirectSupport() {
        return visaDirectSupport;
    }

    public void setVisaDirectSupport(String visaDirectSupport) {
        this.visaDirectSupport = visaDirectSupport;
    }

    public String getIssuerCountry() {
        return issuerCountry;
    }

    public void setIssuerCountry(String issuerCountry) {
        this.issuerCountry = issuerCountry;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isDccAllowed() {
        return dccAllowed;
    }

    public void setDccAllowed(boolean dccAllowed) {
        this.dccAllowed = dccAllowed;
    }
}
