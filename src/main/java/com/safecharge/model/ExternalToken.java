/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import javax.validation.constraints.Size;

public class ExternalToken {

    @Size(max = 45)
    private String externalTokenProvider;

    @Size(max = 5000)
    private String mobileToken;

    @Size(max = 2)
    private String eciProvider;

    @Size(max = 100)
    private String cryptogram;

    public String getEciProvider() {
        return eciProvider;
    }

    public void setEciProvider(String eciProvider) {
        this.eciProvider = eciProvider;
    }

    public String getCryptogram() {
        return cryptogram;
    }

    public void setCryptogram(String cryptogram) {
        this.cryptogram = cryptogram;
    }

    public String getExternalTokenProvider() {
        return externalTokenProvider;
    }

    public void setExternalTokenProvider(String externalTokenProvider) {
        this.externalTokenProvider = externalTokenProvider;
    }

    public String getMobileToken() {
        return mobileToken;
    }

    public void setMobileToken(String mobileToken) {
        this.mobileToken = mobileToken;
    }
}
