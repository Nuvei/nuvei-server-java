/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.request;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.safecharge.model.*;
import com.safecharge.request.builder.SafechargeBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * <p>
 * Request for initiation of payment process for transactions.
 * </p>
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class InitPaymentRequest extends SafechargeRequest {

    @Size(max = 255, message = "userTokenId size must be up to 255 characters long!")
    private String userTokenId;

    @Size(max = 255, message = "clientUniqueId size must be up to 255 characters long!")
    private String clientUniqueId;

    /**
     * The three character ISO currency code.
     */
    @NotNull(message = "currency parameter is mandatory!")
    private String currency;

    /**
     * The transaction amount.
     */
    @NotNull(message = "amount parameter is mandatory!")
    private String amount;

    private DeviceDetails deviceDetails;

    private InitPaymentPaymentOption paymentOption;

    private UrlDetails urlDetails;

    @Size(max = 255, message = "customData size must be up to 255 characters long!")
    private String customData;

    private UserAddress billingAddress;

    @Size(max = 1)
    private String aftOverride;

    private RecipientDetails recipientDetails;

    private DecryptedMessage decryptedMessage;

    private ApplePayPaymentDataHolder applePayPaymentDataHolder;

    @Size(max = 255)
    private String userId;

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    public String getClientUniqueId() {
        return clientUniqueId;
    }

    public void setClientUniqueId(String clientUniqueId) {
        this.clientUniqueId = clientUniqueId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public DeviceDetails getDeviceDetails() {
        return deviceDetails;
    }

    public void setDeviceDetails(DeviceDetails deviceDetails) {
        this.deviceDetails = deviceDetails;
    }

    public InitPaymentPaymentOption getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(InitPaymentPaymentOption paymentOption) {
        this.paymentOption = paymentOption;
    }

    public UrlDetails getUrlDetails() {
        return urlDetails;
    }

    public void setUrlDetails(UrlDetails urlDetails) {
        this.urlDetails = urlDetails;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }

    public UserAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(UserAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAftOverride() {
        return aftOverride;
    }

    public void setAftOverride(String aftOverride) {
        this.aftOverride = aftOverride;
    }

    public RecipientDetails getRecipientDetails() {
        return recipientDetails;
    }

    public void setRecipientDetails(RecipientDetails recipientDetails) {
        this.recipientDetails = recipientDetails;
    }

    public DecryptedMessage getDecryptedMessage() {
        return decryptedMessage;
    }

    public void setDecryptedMessage(DecryptedMessage decryptedMessage) {
        this.decryptedMessage = decryptedMessage;
    }

    public ApplePayPaymentDataHolder getApplePayPaymentDataHolder() {
        return applePayPaymentDataHolder;
    }

    public void setApplePayPaymentDataHolder(ApplePayPaymentDataHolder applePayPaymentDataHolder) {
        this.applePayPaymentDataHolder = applePayPaymentDataHolder;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", userTokenId=").append(userTokenId)
                .append(", clientUniqueId=").append(clientUniqueId)
                .append(", currency=").append(currency)
                .append(", amount=").append(amount)
                .append(", DeviceDetails=").append(deviceDetails)
                .append(", PaymentOption=").append(paymentOption)
                .append(", urlDetails=").append(urlDetails)
                .append(", customData=").append(customData)
                .append(", billingAddress=").append(billingAddress)
                .append(", aftOverride=").append(aftOverride)
                .append(", recipientDetails=").append(recipientDetails)
                .append(", decryptedMessage=").append(decryptedMessage)
                .append(", applePayPaymentDataHolder=").append(applePayPaymentDataHolder)
                .append(", userId=").append(userId);

        return sb.toString();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends SafechargeBuilder<Builder> {

        private String userTokenId;
        private String clientUniqueId;
        private String currency;
        private String amount;
        private DeviceDetails deviceDetails;
        private InitPaymentPaymentOption paymentOption;
        private UrlDetails urlDetails;
        private String customData;
        private UserAddress billingAddress;
        private String userId;
        private String aftOverride;
        private RecipientDetails recipientDetails;
        private DecryptedMessage decryptedMessage;
        private ApplePayPaymentDataHolder applePayPaymentDataHolder;

        public Builder addUserTokenId(String userTokenId) {
            this.userTokenId = userTokenId;
            return this;
        }

        public Builder addClientUniqueId(String clientUniqueId) {
            this.clientUniqueId = clientUniqueId;
            return this;
        }

        public Builder addCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder addAmount(String amount) {
            this.amount = amount;
            return this;
        }

        public Builder addDeviceDetails(DeviceDetails deviceDetails) {
            this.deviceDetails = deviceDetails;
            return this;
        }

        public Builder addInitPaymentPaymentOption(InitPaymentPaymentOption paymentOption) {
            this.paymentOption = paymentOption;
            return this;
        }

        public Builder addUrlDetails(UrlDetails urlDetails) {
            this.urlDetails = urlDetails;
            return this;
        }

        public Builder addCustomData(String customData) {
            this.customData = customData;
            return this;
        }

        public Builder addBillingAddress(UserAddress billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        public Builder addUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder addAftOverride(String aftOverride) {
            this.aftOverride = aftOverride;
            return this;
        }

        public Builder addRecipientDetails(RecipientDetails recipientDetails) {
            this.recipientDetails = recipientDetails;
            return this;
        }

        public Builder addDecryptedMessage(DecryptedMessage decryptedMessage) {
            this.decryptedMessage = decryptedMessage;
            return this;
        }

        public Builder addApplePayPaymentDataHolder(ApplePayPaymentDataHolder applePayPaymentDataHolder) {
            this.applePayPaymentDataHolder = applePayPaymentDataHolder;
            return this;
        }

        @Override
        public InitPaymentRequest build() throws ConstraintViolationException {
            InitPaymentRequest request = new InitPaymentRequest();
            request.setAmount(amount);
            request.setBillingAddress(billingAddress);
            request.setCurrency(currency);
            request.setCustomData(customData);
            request.setDeviceDetails(deviceDetails);
            request.setPaymentOption(paymentOption);
            request.setUrlDetails(urlDetails);
            request.setUserTokenId(userTokenId);
            request.setClientUniqueId(clientUniqueId);
            request.setUserId(userId);
            request.setAftOverride(aftOverride);
            request.setRecipientDetails(recipientDetails);
            request.setDecryptedMessage(decryptedMessage);
            request.setApplePayPaymentDataHolder(applePayPaymentDataHolder);

            return ValidationUtils.validate(super.build(request));
        }
    }
}
