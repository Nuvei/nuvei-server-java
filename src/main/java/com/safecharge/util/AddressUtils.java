/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.util;

import com.safecharge.model.RestApiUserDetails;
import com.safecharge.model.UserAddress;
import com.safecharge.model.UserDetails;
import com.safecharge.model.UserDetailsCashier;

/**
 *
 * @author <a mailto:antona@safecharge.com>Anton Antonov</a>
 * @since 19.09.2017 г.
 */
public class AddressUtils {

    private AddressUtils() {
    }

    /**
     * Static factory method to create new {@link UserAddress} object based on the passed params.
     *
     * @param firstName The first name of the recipient
     * @param lastName  The last name of the recipient
     * @param email     The email of the recipient
     * @param phone     The phone number of the recipient
     * @param address   The address of the recipient
     * @param city      The city of the recipient
     * @param country   The country of the recipient(two-letter ISO country code)
     * @param state     The state of the recipient(two-letter ISO state code)
     * @param zip       The postal code of the recipient
     * @param cell      The cell number of the recipient
     * @return new {@link UserAddress} object created from the passed params
     */
    public static UserAddress createUserAddressFromParams(String firstName, String lastName, String email, String phone, String address, String city,
                                                          String country, String state, String zip, String cell, String county) {
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
        userAddress.setCounty(county);

        return userAddress;
    }

    /**
     * Static factory method to create new {@link UserAddress} object based on the passed params.
     *
     * @param firstName The first name of the recipient
     * @param lastName  The last name of the recipient
     * @param email     The email of the recipient
     * @param phone     The phone number of the recipient
     * @param address   The address of the recipient
     * @param city      The city of the recipient
     * @param country   The country of the recipient(two-letter ISO country code)
     * @param state     The state of the recipient(two-letter ISO state code)
     * @param zip       The postal code of the recipient
     * @param cell      The cell number of the recipient
     * @param addressLine2 The address line 2 of the recipient's address
     * @param addressLine3 The address line 3 of the recipient's address
     * @param shipAddressLine2 The shipping address line 2 of the recipient's address
     * @param shipAddressLine3 The shipping address line 3 of the recipient's address
     * @return new {@link UserAddress} object created from the passed params
     */
    public static UserAddress createUserAddressFromParams(String firstName, String lastName, String email, String phone, String address, String city,
                                                          String country, String state, String zip, String cell, String county, String addressLine2, String addressLine3,
                                                          String shipAddressLine2, String shipAddressLine3) {

        UserAddress userAddress = createUserAddressFromParams(firstName, lastName, email, phone, address, city, country, state, zip, cell, county);
        userAddress.setAddressLine2(addressLine2);
        userAddress.setAddressLine3(addressLine3);
        userAddress.setShipAddressLine2(shipAddressLine2);
        userAddress.setShipAddressLine3(shipAddressLine3);

        return userAddress;
    }

    /**
     * Static factory method to create new {@link UserDetails} object based on the passed params.
     *
     * @param firstName   The first name of the recipient
     * @param lastName    The last name of the recipient
     * @param address     The address of the recipient
     * @param phone       The phone number of the recipient
     * @param zip         The postal code of the recipient
     * @param city        The city of the recipient
     * @param countryCode The country of the recipient(two-letter ISO country code)
     * @param state       The state of the recipient(two-letter ISO state code)
     * @param email       The email of the recipient
     * @param locale      The recipient’s locale and default language, for example en_UK.
     * @param dateOfBirth The date of birth of the recipient
     * @return new {@link UserDetails} object created from the passed params
     */
    public static UserDetails createUserDetailsFromParams(String firstName, String lastName, String address, String phone, String zip, String city,
                                                          String countryCode, String state, String email, String locale, String dateOfBirth, String county) {

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
        billingAddress.setBirthdate(dateOfBirth);
        billingAddress.setCounty(county);

        return billingAddress;
    }

    /**
     * Static factory method to create new {@link RestApiUserDetails} object based on the passed params.
     *
     * @param address     The address of the user
     * @param city        The city of the user
     * @param country     The city of the user(two-letter ISO country code)
     * @param email       The email of the user
     * @param firstName   The first name of the user
     * @param lastName    The last name of the user
     * @param phone       The phone number of the user
     * @param state       The state of the user(two-letter ISO state code)
     * @param zip         The postal code of the user
     * @param dateOfBirth The date of birth of the user
     * @return new {@link RestApiUserDetails} object created from the passed params
     */
    public static RestApiUserDetails createRestApiUserDetailsFromParams(String address, String city, String country, String email, String firstName,
                                                                        String lastName, String phone, String state, String zip, String dateOfBirth,
                                                                        String county) {

        RestApiUserDetails userDetails = new RestApiUserDetails();
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
        userDetails.setCounty(county);

        return userDetails;
    }

    /**
     * Static factory method to create new {@link UserDetailsCashier} object based on the passed params.
     *
     * @param address     The address of the user
     * @param city        The city of the user
     * @param countryCode     The city of the user(two-letter ISO country code)
     * @param email       The email of the user
     * @param firstName   The first name of the user
     * @param lastName    The last name of the user
     * @param phone       The phone number of the user
     * @param state       The state of the user(two-letter ISO state code)
     * @param zip         The postal code of the user
     * @param birthdate The date of birth of the user
     * @return new {@link UserDetailsCashier} object created from the passed params
     */
    public static UserDetailsCashier createUserDetailsCashierFromParams(String address, String city, String countryCode, String email, String firstName,
                                                                        String lastName, String phone, String state, String zip, String birthdate,
                                                                        String county, String locale) {

        UserDetailsCashier userDetails = new UserDetailsCashier();
        userDetails.setAddress(address);
        userDetails.setCity(city);
        userDetails.setCountryCode(countryCode);
        userDetails.setEmail(email);
        userDetails.setFirstName(firstName);
        userDetails.setLastName(lastName);
        userDetails.setPhone(phone);
        userDetails.setState(state);
        userDetails.setZip(zip);
        userDetails.setBirthdate(birthdate);
        userDetails.setCounty(county);
        userDetails.setLocale(locale);

        return userDetails;
    }
}
