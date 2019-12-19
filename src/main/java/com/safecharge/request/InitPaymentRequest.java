package com.safecharge.request;

import com.safecharge.model.DeviceDetails;
import com.safecharge.model.InitPaymentPaymentOption;
import com.safecharge.model.UrlDetails;
import com.safecharge.model.UserAddress;
import com.safecharge.request.builder.SafechargeBaseBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Copyright (C) 2007-2019 SafeCharge International Group Limited.
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

    private String sourceApplication;

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

    public String getSourceApplication() {
        return sourceApplication;
    }

    public void setSourceApplication(String sourceApplication) {
        this.sourceApplication = sourceApplication;
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
                .append(", sourceApplication=").append(sourceApplication);

        return sb.toString();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends SafechargeBaseBuilder<Builder> {

        private String userTokenId;
        private String clientUniqueId;
        private String currency;
        private String amount;
        private DeviceDetails deviceDetails;
        private InitPaymentPaymentOption paymentOption;
        private UrlDetails urlDetails;
        private String customData;
        private UserAddress billingAddress;
        private String sourceApplication;

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

        public Builder addSourceApplication(String sourceApplication) {
            this.sourceApplication = sourceApplication;
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
            request.setSourceApplication(sourceApplication);
            request.setUrlDetails(urlDetails);
            request.setUserTokenId(userTokenId);
            request.setClientUniqueId(clientUniqueId);

            return ValidationUtils.validate(super.build(request));
        }
    }
}
