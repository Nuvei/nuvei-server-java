/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import javax.validation.constraints.Size;

public class Sdk {

    @Size(max = 2, message = "appSdkInterface must be up to 2 characters long!")
    private String appSdkInterface;

    @Size(max = 2, message = "appSdkUIType must be up to 2 characters long!")
    private String appSdkUIType;

    @Size(max = 36, message = "appId must be up to 36 characters long!")
    private String appId;

    @Size(max = 64000, message = "encData must be up to 64000 characters long!")
    private String encData;

    @Size(max = 256, message = "ephemPubKey must be up to 256 characters long!")
    private String ephemPubKey;

    @Size(max = 2, message = "maxTimeout must be up to 2 characters long!")
    private String maxTimeout;

    @Size(max = 32, message = "referenceNumber must be up to 2 characters long!")
    private String referenceNumber;

    @Size(max = 36, message = "transId must be up to 36 characters long!")
    private String transId;

    public String getAppSdkInterface() {
        return appSdkInterface;
    }

    public void setAppSdkInterface(String appSdkInterface) {
        this.appSdkInterface = appSdkInterface;
    }

    public String getAppSdkUIType() {
        return appSdkUIType;
    }

    public void setAppSdkUIType(String appSdkUIType) {
        this.appSdkUIType = appSdkUIType;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getEncData() {
        return encData;
    }

    public void setEncData(String encData) {
        this.encData = encData;
    }

    public String getEphemPubKey() {
        return ephemPubKey;
    }

    public void setEphemPubKey(String ephemPubKey) {
        this.ephemPubKey = ephemPubKey;
    }

    public String getMaxTimeout() {
        return maxTimeout;
    }

    public void setMaxTimeout(String maxTimeout) {
        this.maxTimeout = maxTimeout;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }
}
