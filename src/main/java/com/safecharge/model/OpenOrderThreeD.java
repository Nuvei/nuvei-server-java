/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import javax.validation.Valid;

public class OpenOrderThreeD {

    private String isDynamic3D;

    private String dynamic3DMode;

    private String convertNonEnrolled;

    @Valid
    private OpenOrderThreeDV2AdditionalParams v2AdditionalParams;

    @Valid
    private Account account;

    @Valid
    private Acquirer acquirer;

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

    public OpenOrderThreeDV2AdditionalParams getV2AdditionalParams() {
        return v2AdditionalParams;
    }

    public void setV2AdditionalParams(OpenOrderThreeDV2AdditionalParams v2AdditionalParams) {
        this.v2AdditionalParams = v2AdditionalParams;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Acquirer getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(Acquirer acquirer) {
        this.acquirer = acquirer;
    }
}
