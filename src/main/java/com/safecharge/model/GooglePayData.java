package com.safecharge.model;

public class GooglePayData {

    private String description;
    private String type;
    private TokenizationData tokenizationData;
    private PaymentInfo info;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TokenizationData getTokenizationData() {
        return tokenizationData;
    }

    public void setTokenizationData(TokenizationData tokenizationData) {
        this.tokenizationData = tokenizationData;
    }

    public PaymentInfo getInfo() {
        return info;
    }

    public void setInfo(PaymentInfo info) {
        this.info = info;
    }
}
