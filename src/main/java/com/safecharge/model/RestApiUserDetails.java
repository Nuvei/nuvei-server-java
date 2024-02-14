/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.safecharge.util.APIConstants;

/**
 * <p>
 * Holder for Checkout Page's User data.
 * </p>
 * @since 2/14/2017
 */
public class RestApiUserDetails {

    @Size(max = APIConstants.FIRST_NAME_MAX_LENGTH,
            message = "firstName size must be up to 30 characters long!")
    private String firstName;

    @Size(max = APIConstants.LAST_NAME_MAX_LENGTH,
            message = "lastName size must be up to 40 characters long!")
    private String lastName;

    @Size(max = APIConstants.EMAIL_MAX_LENGTH, message = "email size must be up to 100 characters long!")
    private String email;

    @Size(max = APIConstants.PHONE_MAX_LENGTH,
            message = "phone size must be up to 18 characters long!")
    private String phone;

    @Size(max = APIConstants.ADDRESS_MAX_LENGTH,
            message = "address size must be up to 60 characters long!")
    private String address;

    @Size(max = APIConstants.CITY_MAX_LENGTH,
            message = "city size must be up to 30 characters long!")
    private String city;

    @Size(max = 2,
            message = "country size must be up to 2 characters long!")
    private String country;

    @Size(max = 5,
            message = "state size must be up to 5 characters long!")
    private String state;

    @Size(max = APIConstants.ZIP_MAX_LENGTH,
            message = "zip size must be up to 10 characters long!")
    private String zip;

    @Pattern(regexp = APIConstants.DATE_OF_BIRTH_REGEX,
            message = "dateOfBirth must be in format yyyy-MM-dd!")
    private String dateOfBirth;

    @Size(max = APIConstants.COUNTY_MAX_LENGTH,
            message = "county size must be up to 255 characters long!")
    private String county;

    @Size(max = APIConstants.SSN_IDENTIFICATION_MAX_LENGTH,
            message = "identification size must be up to 15 characters long!")
    private String identification;

    @Size(max = APIConstants.APM_IDENTIFICATION_TYPE_MAX_LENGTH,
            message = "identification type size must be up to 100 characters long!")
    private String identificationType;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getIdentification() {
        return identification;
    }

    public RestApiUserDetails setIdentification(String identification) {
        this.identification = identification;
        return this;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public RestApiUserDetails setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RestApiUserDetails{");
        sb.append("firstName='")
                .append(firstName)
                .append('\'');
        sb.append(", lastName='")
                .append(lastName)
                .append('\'');
        sb.append(", email='")
                .append(email)
                .append('\'');
        sb.append(", phone='")
                .append(phone)
                .append('\'');
        sb.append(", address='")
                .append(address)
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
        sb.append(", zip='")
                .append(zip)
                .append('\'');
        sb.append(", dateOfBirth='")
                .append(dateOfBirth)
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
