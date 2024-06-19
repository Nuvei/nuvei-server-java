package com.safecharge.model;

public class RiskInfo {

    private boolean existingCustomer;

    private int currentNumberOfTransactions;

    private String customerSince;

    public boolean isExistingCustomer() {
        return existingCustomer;
    }

    public void setExistingCustomer(boolean existingCustomer) {
        this.existingCustomer = existingCustomer;
    }

    public int getCurrentNumberOfTransactions() {
        return currentNumberOfTransactions;
    }

    public void setCurrentNumberOfTransactions(int currentNumberOfTransactions) {
        this.currentNumberOfTransactions = currentNumberOfTransactions;
    }

    public String getCustomerSince() {
        return customerSince;
    }

    public void setCustomerSince(String customerSince) {
        this.customerSince = customerSince;
    }
}
