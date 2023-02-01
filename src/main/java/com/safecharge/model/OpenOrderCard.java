/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

/**
 * <p>
 * Holder for Checkout Page's OpenOrder PaymentOption card data.
 * </p>
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/10/2017
 */
public class OpenOrderCard {

    private String acquirerId;
    private StoredCredentials storedCredentials;
    private OpenOrderThreeD threeD;

    public String getAcquirerId() {
        return acquirerId;
    }

    public void setAcquirerId(String acquirerId) {
        this.acquirerId = acquirerId;
    }

    public StoredCredentials getStoredCredentials() {
        return storedCredentials;
    }

    public void setStoredCredentials(StoredCredentials storedCredentials) {
        this.storedCredentials = storedCredentials;
    }

    public OpenOrderThreeD getThreeD() {
        return threeD;
    }

    public void setThreeD(OpenOrderThreeD threeD) {
        this.threeD = threeD;
    }
}
