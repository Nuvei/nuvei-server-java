

/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

public abstract class CommonUserDetailsInfo {

    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String zip;
    private String city;
    private String country;
    private String state;
    private String email;
    private String locale;
    private String county;
    private String identification;
    private String identificationType;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /**
     *  This method is no longer acceptable to get the country code.
     *  <p> Use {@link #getCountry()} instead.
     */
    @Deprecated
    public String getCountryCode() {
        return getCountry();
    }

    /**
     *  This method is no longer acceptable to set the country code.
     *  <p> Use {@link #setCountry(String)} instead.
     */
    public void setCountryCode(String countryCode) {
        setCountry(countryCode);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getIdentification() {
        return identification;
    }

    public CommonUserDetailsInfo setIdentification(String identification) {
        this.identification = identification;
        return this;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public CommonUserDetailsInfo setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("firstName='")
                .append(firstName)
                .append('\'');
        sb.append(", lastName='")
                .append(lastName)
                .append('\'');
        sb.append(", address='")
                .append(address)
                .append('\'');
        sb.append(", phone='")
                .append(phone)
                .append('\'');
        sb.append(", zip='")
                .append(zip)
                .append('\'');
        sb.append(", city='")
                .append(city)
                .append('\'');
        sb.append(", country='")
                .append(country)
                .append('\'');
        sb.append(", state='")
                .append(state)
                .append('\'');
        sb.append(", email='")
                .append(email)
                .append('\'');
        sb.append(", locale='")
                .append(locale)
                .append('\'');
        sb.append(", county='")
                .append(county)
                .append('\'');
        sb.append(", identification='")
                .append(identification)
                .append('\'');
        sb.append(", identificationType='")
                .append(identificationType)
                .append('\'');
        sb.append('}');

        return sb.toString();
    }
}
