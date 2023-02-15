/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

public class PartialApprovalDetails {

    private String isPartialApproval;

    private AmountInfo amountInfo;

    public String getIsPartialApproval() {
        return isPartialApproval;
    }

    public void setIsPartialApproval(String isPartialApproval) {
        this.isPartialApproval = isPartialApproval;
    }

    public AmountInfo getAmountInfo() {
        return amountInfo;
    }

    public void setAmountInfo(AmountInfo amountInfo) {
        this.amountInfo = amountInfo;
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("PartialApprovalDetails [isPartialApproval=");
        sBuilder.append(isPartialApproval);
        sBuilder.append(", amountInfo=");
        sBuilder.append(amountInfo);
        sBuilder.append("]");
        return sBuilder.toString();
    }
}
