package com.safecharge.model;

public class DecryptedMessage {
    private String status;
    private String errorMessage;
    private String paymentMethod;
    private PaymentMethodDetails paymentMethodDetails;
    private String messageId;
    private String messageExpiration;
    private String gatewayMerchantId;

    public DecryptedMessage() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethodDetails getPaymentMethodDetails() {
        return paymentMethodDetails;
    }

    public void setPaymentMethodDetails(PaymentMethodDetails paymentMethodDetails) {
        this.paymentMethodDetails = paymentMethodDetails;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageExpiration() {
        return messageExpiration;
    }

    public void setMessageExpiration(String messageExpiration) {
        this.messageExpiration = messageExpiration;
    }

    public String getGatewayMerchantId() {
        return gatewayMerchantId;
    }

    public void setGatewayMerchantId(String gatewayMerchantId) {
        this.gatewayMerchantId = gatewayMerchantId;
    }
}
