package com.safecharge.util;

import com.safecharge.model.CashierUserDetails;
import com.safecharge.model.UserAddress;
import com.safecharge.model.UserDetails;

/**
 * Copyright (C) 2007-2020 SafeCharge International Group Limited.
 *
 * @author <a mailto:antona@safecharge.com>Anton Antonov</a>
 * @since 19.09.2017 г.
 */
public class AddressUtils {

    private AddressUtils() {
    }

    public static UserAddress createUserAddressFromParams(String firstName, String lastName, String email, String phone, String address, String city,
                                                          String country, String state, String zip, String cell) {

        UserAddress userAddress = new UserAddress();
        userAddress.setFirstName(firstName);
        userAddress.setLastName(lastName);
        userAddress.setEmail(email);
        userAddress.setPhone(phone);
        userAddress.setAddress(address);
        userAddress.setCity(city);
        userAddress.setCountry(country);
        userAddress.setState(state);
        userAddress.setZip(zip);
        userAddress.setCell(cell);

        return userAddress;
    }

    public static UserDetails createUserDetailsFromParams(String firstName, String lastName, String address, String phone, String zip, String city,
                                                          String countryCode, String state, String email, String locale, String dateOfBirth) {

        UserDetails billingAddress = new UserDetails();
        billingAddress.setFirstName(firstName);
        billingAddress.setLastName(lastName);
        billingAddress.setAddress(address);
        billingAddress.setPhone(phone);
        billingAddress.setZip(zip);
        billingAddress.setCity(city);
        billingAddress.setCountryCode(countryCode);
        billingAddress.setState(state);
        billingAddress.setEmail(email);
        billingAddress.setLocale(locale);
        billingAddress.setDateOfBirth(dateOfBirth);

        return billingAddress;
    }

    public static CashierUserDetails createCashierUserDetailsFromParams(String address, String city, String country, String email, String firstName,
                                                                        String lastName, String phone, String state, String zip, String dateOfBirth) {

        CashierUserDetails userDetails = new CashierUserDetails();
        userDetails.setAddress(address);
        userDetails.setCity(city);
        userDetails.setCountry(country);
        userDetails.setEmail(email);
        userDetails.setFirstName(firstName);
        userDetails.setLastName(lastName);
        userDetails.setPhone(phone);
        userDetails.setState(state);
        userDetails.setZip(zip);
        userDetails.setDateOfBirth(dateOfBirth);

        return userDetails;
    }
}
