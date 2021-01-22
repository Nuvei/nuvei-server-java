package com.safecharge.model;

import java.util.List;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Holder for a Checkout Page's Payment method(PM) data.
 * Along with PM's specific info it contains a list of allowed countries and currencies ISO codes for use with the PM.
 * </p>
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 4/7/2017
 */
public class PaymentMethod {

    private String paymentMethod;

    private String isDirect;

    private List<String> countries;

    private List<String> currencies;

    private String logoURL;

    private List<LocalizationMessage> paymentMethodDisplayName;

    private List<Field> fields;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getIsDirect() {
        return isDirect;
    }

    public void setIsDirect(String isDirect) {
        this.isDirect = isDirect;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<String> currencies) {
        this.currencies = currencies;
    }

    public String getLogoURL() {
        return logoURL;
    }

    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }

    public List<LocalizationMessage> getPaymentMethodDisplayName() {
        return paymentMethodDisplayName;
    }

    public void setPaymentMethodDisplayName(List<LocalizationMessage> paymentMethodDisplayName) {
        this.paymentMethodDisplayName = paymentMethodDisplayName;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentMethod{");
        sb.append("paymentMethod='")
                .append(paymentMethod)
                .append('\'');
        sb.append(", isDirect='")
                .append(isDirect)
                .append('\'');
        sb.append(", countries=")
                .append(countries);
        sb.append(", currencies=")
                .append(currencies);
        sb.append(", logoURL='")
                .append(logoURL)
                .append('\'');
        sb.append(", paymentMethodDisplayName=")
                .append(paymentMethodDisplayName);
        sb.append(", fields=")
                .append(fields);
        sb.append('}');
        return sb.toString();
    }
}
