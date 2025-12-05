/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.model;

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
