package com.safecharge.model;

public class PaymentInfo {

    private String cardNetwork;
    private String cardDetails;
    private BillingAddress billingAddress;
    private AssuranceDetails assuranceDetails;

    public String getCardNetwork() {
        return cardNetwork;
    }

    public void setCardNetwork(String cardNetwork) {
        this.cardNetwork = cardNetwork;
    }

    public String getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(String cardDetails) {
        this.cardDetails = cardDetails;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public AssuranceDetails getAssuranceDetails() {
        return assuranceDetails;
    }

    public void setAssuranceDetails(AssuranceDetails assuranceDetails) {
        this.assuranceDetails = assuranceDetails;
    }
}
