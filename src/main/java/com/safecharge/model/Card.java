/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import javax.validation.constraints.Size;

public class Card extends CardData {

    private ExternalToken externalToken;

    private StoredCredentials storedCredentials;

    @Size(max = 2, message = "acquirerId size must be up to 2 characters long!")
    private String acquirerId;

    private ThreeD threeD;

    public ExternalToken getExternalToken() {
        return externalToken;
    }

    public void setExternalToken(ExternalToken externalToken) {
        this.externalToken = externalToken;
    }

    public StoredCredentials getStoredCredentials() {
        return storedCredentials;
    }

    public void setStoredCredentials(StoredCredentials storedCredentials) {
        this.storedCredentials = storedCredentials;
    }

    public String getAcquirerId() {
        return acquirerId;
    }

    public void setAcquirerId(String acquirerId) {
        this.acquirerId = acquirerId;
    }

    public ThreeD getThreeD() {
        return threeD;
    }

    public void setThreeD(ThreeD threeD) {
        this.threeD = threeD;
    }
}
