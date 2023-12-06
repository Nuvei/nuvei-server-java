/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.request.basic;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.safecharge.request.SafechargeRequest;

public class CashierUserRequest extends SafechargeRequest {

    @NotNull
    @Size(max = 255)
    protected String userTokenId;

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private String city;
    private String zip;
    private String country;
    private String state;
    private String locale;
    private String dateOfBirth;
    private String county;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
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
    @Deprecated
    public void setCountryCode(String country) {
        setCountry(country);
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

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }
}