/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import javax.validation.constraints.Size;

/**
 * <p>
 * Holder for Recipient Details
 * </p>
 * @since 11/23/2022
 */
public class RecipientDetails {
    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String lastName;

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
}
