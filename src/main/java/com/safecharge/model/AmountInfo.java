/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

public class AmountInfo {

    private String requestedAmount;
    private String requestedCurrency;
    private String processedAmount;
    private String processedCurrency;
    
    public String getRequestedAmount() {
        return requestedAmount;
    }
    public void setRequestedAmount(String requestedAmount) {
        this.requestedAmount = requestedAmount;
    }
    public String getRequestedCurrency() {
        return requestedCurrency;
    }
    public void setRequestedCurrency(String requestedCurrency) {
        this.requestedCurrency = requestedCurrency;
    }
    public String getProcessedAmount() {
        return processedAmount;
    }
    public void setProcessedAmount(String processedAmount) {
        this.processedAmount = processedAmount;
    }
    public String getProcessedCurrency() {
        return processedCurrency;
    }
    public void setProcessedCurrency(String processedCurrency) {
        this.processedCurrency = processedCurrency;
    }
    
    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("AmountInfo [requestedAmount=");
        sBuilder.append(requestedAmount);
        sBuilder.append(", requestedCurrency=");
        sBuilder.append(requestedCurrency);
        sBuilder.append(", processedAmount=");
        sBuilder.append(processedAmount);
        sBuilder.append(", processedCurrency=");
        sBuilder.append(processedCurrency);
        sBuilder.append("]");
        return sBuilder.toString();
    }
}
