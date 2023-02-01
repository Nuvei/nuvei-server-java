/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import javax.validation.constraints.Size;

public class StoredCredentials {

    public StoredCredentials() {
        super();
    }

    public StoredCredentials(String storedCredentialsMode) {
        super();
        this.storedCredentialsMode = storedCredentialsMode;
    }

    @Size(max = 1)
    private String storedCredentialsMode;

    public String getStoredCredentialsMode() {
        return storedCredentialsMode;
    }

    public void setStoredCredentialsMode(String storedCredentialsMode) {
        this.storedCredentialsMode = storedCredentialsMode;
    }

}
