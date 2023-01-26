/*
 * Copyright (c) 2007-2021 SafeCharge International Group Limited.
 */

package com.safecharge.request;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.safecharge.model.DeviceDetails;
import com.safecharge.model.UserDetails;
import com.safecharge.request.builder.SafechargeBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class AccountCaptureRequest extends SafechargeRequest {

    @NotNull
    @Size(max = 255)
    private String userTokenId;

    @NotNull
    @Size(max = 50)
    private String paymentMethod;

    @NotNull
    @Size(max = 3)
    private String currencyCode;

    @NotNull
    @Size(max = 2)
    private String countryCode;

    @NotNull
    @Size(max = 2)
    private String languageCode;

    @Size(max = 12)
    private String amount;

    @Size(max = 1000)
    private String notificationUrl;

    private DeviceDetails deviceDetails;

    private UserDetails userDetails;

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
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

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public String getNotificationUrl() {
        return notificationUrl;
    }

    public void setNotificationUrl(String notificationUrl) {
        this.notificationUrl = notificationUrl;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends SafechargeBuilder<Builder> {

        private String userTokenId;
        private String paymentMethod;
        private String currencyCode;
        private String countryCode;
        private String languageCode;
        private String amount;
        private String notificationUrl;
        private DeviceDetails deviceDetails;
        private UserDetails userDetails;

        public Builder addUserTokenId(String userTokenId) {
            this.userTokenId = userTokenId;
            return this;
        }

        public Builder addPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder addCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }

        public Builder addCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Builder addLanguageCode(String languageCode) {
            this.languageCode = languageCode;
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

        public Builder addUserDetails(UserDetails userDetails) {
            this.userDetails = userDetails;
            return this;
        }

        public Builder addNotificationUrl(String notificationUrl) {
            this.notificationUrl = notificationUrl;
            return this;
        }


        @Override
        public AccountCaptureRequest build() throws ConstraintViolationException {
            AccountCaptureRequest request = new AccountCaptureRequest();
            request.setUserTokenId(userTokenId);
            request.setPaymentMethod(paymentMethod);
            request.setCurrencyCode(currencyCode);
            request.setCountryCode(countryCode);
            request.setLanguageCode(languageCode);
            request.setAmount(amount);
            request.setNotificationUrl(notificationUrl);
            request.setDeviceDetails(deviceDetails);
            request.setUserDetails(userDetails);

            return ValidationUtils.validate(super.build(request));
        }
    }
}
