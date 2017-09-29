package com.safecharge.model;

import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Holder for User's personal details and a "generic" address. Note that a User can have different billing/shipping
 * address per order stored in {@link UserAddress} object.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/21/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.USER_DETAILS)
public class UserDetails {

    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String zip;
    private String city;
    private String countryCode;
    private String state;
    private String email;
    private String locale;
    private String dateOfBirth;

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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDetails{");
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
        sb.append(", countryCode='")
                .append(countryCode)
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
        sb.append(", dateOfBirth='")
                .append(dateOfBirth)
                .append('\'');
        sb.append('}');
        return sb.toString();
    }
}
