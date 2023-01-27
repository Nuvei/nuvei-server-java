/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

/**
 * <p>
 * Local payment info specific for some clients. Part of {@link Addendums}.
 *
 * @author <a mailto:bozhidarsh@safecharge.com>Bozhidar Shumanov</a>
 * @see Addendums
 * @since 8/8/2018
 */
public class AddendumsAirlinesPassengerDetails {

    private String passangerId;

    private String passportNumber;
    private String customerCode;
    private String frequentFlyerCode;
    private String title;
    private String firstName;
    private String lastName;
    private String middleName;
    private String dateOfBirth;
    private String phoneNumber;
    private String passengerName;

    public String getPassangerId() {
        return passangerId;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public String getFrequentFlyerCode() {
        return frequentFlyerCode;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPassangerId(String passangerId) {
        this.passangerId = passangerId;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public void setFrequentFlyerCode(String frequentFlyerCode) {
        this.frequentFlyerCode = frequentFlyerCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
}