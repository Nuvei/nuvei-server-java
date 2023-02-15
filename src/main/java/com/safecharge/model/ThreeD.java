/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import javax.validation.constraints.Size;

public class ThreeD {

    @Size(max = 1, message = "isDynamic3D must be one character long!")
    private String isDynamic3D;

    private String dynamic3DMode;

    private String convertNonEnrolled;

    private ExternalMpi externalMpi;

    private String paResponse;

    @Size(max = 1, message = "methodCompletionInd must be one character long!")
    private String methodCompletionInd;

    @Size(max = 256, message = "notificationURL must be up to 256 characters long!")
    private String notificationURL;

    @Size(max = 2048, message = "merchantURL must be up to 2048 characters long!")
    private String merchantURL;

    @Size(max = 2, message = "platformType must be up to 2 characters long!")
    private String platformType;

    @Size(max = 8, message = "version must be up to 8 characters long!")
    private String version;

    private BrowserDetails browserDetails;

    private Sdk sdk;

    private Acquirer acquirer;

    private Account account;

    private V2AdditionalParams v2AdditionalParams;

    @Size(max = 25)
    private String mpiChallengePreference;

    @Size(max = 25)
    private String mpiExemptionRequestReason;

    private String externalRiskScore;

    public String getIsDynamic3D() {
        return isDynamic3D;
    }

    public void setIsDynamic3D(String isDynamic3D) {
        this.isDynamic3D = isDynamic3D;
    }

    public String getDynamic3DMode() {
        return dynamic3DMode;
    }

    public void setDynamic3DMode(String dynamic3DMode) {
        this.dynamic3DMode = dynamic3DMode;
    }

    public String getConvertNonEnrolled() {
        return convertNonEnrolled;
    }

    public void setConvertNonEnrolled(String convertNonEnrolled) {
        this.convertNonEnrolled = convertNonEnrolled;
    }

    public ExternalMpi getExternalMpi() {
        return externalMpi;
    }

    public void setExternalMpi(ExternalMpi externalMpi) {
        this.externalMpi = externalMpi;
    }

    public String getPaResponse() {
        return paResponse;
    }

    public void setPaResponse(String paResponse) {
        this.paResponse = paResponse;
    }

    public String getMethodCompletionInd() {
        return methodCompletionInd;
    }

    public void setMethodCompletionInd(String methodCompletionInd) {
        this.methodCompletionInd = methodCompletionInd;
    }

    public String getNotificationURL() {
        return notificationURL;
    }

    public void setNotificationURL(String notificationURL) {
        this.notificationURL = notificationURL;
    }

    public String getMerchantURL() {
        return merchantURL;
    }

    public void setMerchantURL(String merchantURL) {
        this.merchantURL = merchantURL;
    }

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public BrowserDetails getBrowserDetails() {
        return browserDetails;
    }

    public void setBrowserDetails(BrowserDetails browserDetails) {
        this.browserDetails = browserDetails;
    }

    public Sdk getSdk() {
        return sdk;
    }

    public void setSdk(Sdk sdk) {
        this.sdk = sdk;
    }

    public Acquirer getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(Acquirer acquirer) {
        this.acquirer = acquirer;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public V2AdditionalParams getV2AdditionalParams() {
        return v2AdditionalParams;
    }

    public void setV2AdditionalParams(V2AdditionalParams v2AdditionalParams) {
        this.v2AdditionalParams = v2AdditionalParams;
    }

    public String getMpiChallengePreference() {
        return mpiChallengePreference;
    }

    public void setMpiChallengePreference(String mpiChallengePreference) {
        this.mpiChallengePreference = mpiChallengePreference;
    }

    public String getMpiExemptionRequestReason() {
        return mpiExemptionRequestReason;
    }

    public void setMpiExemptionRequestReason(String mpiExemptionRequestReason) {
        this.mpiExemptionRequestReason = mpiExemptionRequestReason;
    }

    public String getExternalRiskScore() {
        return externalRiskScore;
    }

    public void setExternalRiskScore(String externalRiskScore) {
        this.externalRiskScore = externalRiskScore;
    }
}
