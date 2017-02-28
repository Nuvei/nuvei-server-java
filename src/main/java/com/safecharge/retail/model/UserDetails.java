package com.safecharge.retail.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.safecharge.retail.util.APIConstants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/14/2017
 */
public class UserDetails {

    @Size(max = APIConstants.FIRST_NAME_MAX_LENGTH,
          message = "firstName size must be up to 30 characters long!") private String firstName;

    @Size(max = APIConstants.LAST_NAME_MAX_LENGTH,
          message = "lastName size must be up to 40 characters long!") private String lastName;

    @Pattern(regexp = APIConstants.EMAIL_REGEX,
             message = "the entered value is not a valid email") private String email;

    @Size(max = APIConstants.PHONE_MAX_LENGTH,
          message = "phone size must be up to 18 characters long!") private String phone;

    @Size(max = APIConstants.ADDRESS_MAX_LENGTH,
          message = "address size must be up to 60 characters long!") private String address;

    @Size(max = APIConstants.CITY_MAX_LENGTH,
          message = "city size must be up to 30 characters long!") private String city;

    @Size(max = 2,
          message = "country size must be up to 2 characters long!") private String country;

    @Size(max = 2,
          message = "state size must be up to 2 characters long!") private String state;

    @Size(max = APIConstants.ZIP_MAX_LENGTH,
          message = "zip size must be up to 10 characters long!") private String zip;

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

}
