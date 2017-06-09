package com.safecharge.request;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.safecharge.model.CardData;
import com.safecharge.model.CashierUserDetails;
import com.safecharge.model.DeviceDetails;
import com.safecharge.model.DynamicDescriptor;
import com.safecharge.model.MerchantDetails;
import com.safecharge.model.URLDetails;
import com.safecharge.model.UserPaymentOption;
import com.safecharge.request.builder.SafechargeBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtil;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 6/5/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.GET_CASHIER_SUBSCRIPTIONS) public class CreateSubscriptionRequest
        extends SafechargeRequest {

    @NotNull(message = "subscriptionPlanId mustn't be null") @Size(max = 20) private String subscriptionPlanId;

    @NotNull(message = "userTokenId mustn't be null") @Size(max = 255,
                                                            message = "userTokenId value size must be up to 255 characters") private String
            userTokenId;

    @Valid private DynamicDescriptor dynamicDescriptor;

    @Valid private CashierUserDetails userDetails;

    @Valid private DeviceDetails deviceDetails;

    @Valid private MerchantDetails merchantDetails;

    @Valid private URLDetails urlDetails;

    @Valid private CardData cardData;

    @Valid private UserPaymentOption userPaymentOption;

    public static Builder builder() {
        return new Builder();
    }

    public String getSubscriptionPlanId() {
        return subscriptionPlanId;
    }

    public void setSubscriptionPlanId(String subscriptionPlanId) {
        this.subscriptionPlanId = subscriptionPlanId;
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    public DynamicDescriptor getDynamicDescriptor() {
        return dynamicDescriptor;
    }

    public void setDynamicDescriptor(DynamicDescriptor dynamicDescriptor) {
        this.dynamicDescriptor = dynamicDescriptor;
    }

    public CashierUserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(CashierUserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public DeviceDetails getDeviceDetails() {
        return deviceDetails;
    }

    public void setDeviceDetails(DeviceDetails deviceDetails) {
        this.deviceDetails = deviceDetails;
    }

    public MerchantDetails getMerchantDetails() {
        return merchantDetails;
    }

    public void setMerchantDetails(MerchantDetails merchantDetails) {
        this.merchantDetails = merchantDetails;
    }

    public URLDetails getUrlDetails() {
        return urlDetails;
    }

    public void setUrlDetails(URLDetails urlDetails) {
        this.urlDetails = urlDetails;
    }

    public CardData getCardData() {
        return cardData;
    }

    public void setCardData(CardData cardData) {
        this.cardData = cardData;
    }

    public UserPaymentOption getUserPaymentOption() {
        return userPaymentOption;
    }

    public void setUserPaymentOption(UserPaymentOption userPaymentOption) {
        this.userPaymentOption = userPaymentOption;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("CreateSubscriptionRequest{");
        sb.append("subscriptionPlanId='")
          .append(subscriptionPlanId)
          .append('\'');
        sb.append(", userTokenId='")
          .append(userTokenId)
          .append('\'');
        sb.append(", dynamicDescriptor=")
          .append(dynamicDescriptor);
        sb.append(", userDetails=")
          .append(userDetails);
        sb.append(", deviceDetails=")
          .append(deviceDetails);
        sb.append(", merchantDetails=")
          .append(merchantDetails);
        sb.append(", urlDetails=")
          .append(urlDetails);
        sb.append(", cardData=")
          .append(cardData);
        sb.append(", userPaymentOption=")
          .append(userPaymentOption);
        sb.append(", ")
          .append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeBuilder<CreateSubscriptionRequest.Builder> {

        private String subscriptionPlanId;
        private String userTokenId;
        private DynamicDescriptor dynamicDescriptor;
        private CashierUserDetails userDetails;
        private DeviceDetails deviceDetails;
        private MerchantDetails merchantDetails;
        private URLDetails urlDetails;
        private CardData cardData;
        private UserPaymentOption userPaymentOption;

        public CreateSubscriptionRequest.Builder addSubscriptionPlanId(String subscriptionPlanId) {
            this.subscriptionPlanId = subscriptionPlanId;
            return this;
        }

        public CreateSubscriptionRequest.Builder addUserTokenId(String userTokenId) {
            this.userTokenId = userTokenId;
            return this;
        }

        public CreateSubscriptionRequest.Builder addDynamicDescriptor(DynamicDescriptor dynamicDescriptor) {

            this.dynamicDescriptor = dynamicDescriptor;
            return this;
        }

        public CreateSubscriptionRequest.Builder addUserDetails(CashierUserDetails userDetails) {

            this.userDetails = userDetails;
            return this;
        }

        public CreateSubscriptionRequest.Builder addDeviceDetails(DeviceDetails deviceDetails) {

            this.deviceDetails = deviceDetails;
            return this;
        }

        public CreateSubscriptionRequest.Builder addMerchantDetails(MerchantDetails merchantDetails) {

            this.merchantDetails = merchantDetails;
            return this;
        }

        public CreateSubscriptionRequest.Builder addURLDetails(URLDetails urlDetails) {
            this.urlDetails = urlDetails;
            return this;
        }

        public CreateSubscriptionRequest.Builder addCardData(CardData cardData) {
            this.cardData = cardData;
            return this;
        }

        public CreateSubscriptionRequest.Builder addUserPaymentOption(UserPaymentOption userPaymentOption) {
            this.userPaymentOption = userPaymentOption;
            return this;
        }

        public CreateSubscriptionRequest.Builder addDynamicDescriptor(String merchantName, String merchantPhone) {

            DynamicDescriptor dynamicDescriptor = new DynamicDescriptor();
            dynamicDescriptor.setMerchantName(merchantName);
            dynamicDescriptor.setMerchantPhone(merchantPhone);

            return addDynamicDescriptor(dynamicDescriptor);
        }

        public CreateSubscriptionRequest.Builder addUserDetails(String address, String city, String country, String email, String firstName,
                String lastName, String phone, String state, String zip) {

            CashierUserDetails userDetails = new CashierUserDetails();
            userDetails.setAddress(address);
            userDetails.setCity(city);
            userDetails.setCountry(country);
            userDetails.setEmail(email);
            userDetails.setFirstName(firstName);
            userDetails.setLastName(lastName);
            userDetails.setPhone(phone);
            userDetails.setState(state);
            userDetails.setZip(zip);

            return addUserDetails(userDetails);
        }

        public CreateSubscriptionRequest.Builder addDeviceDetails(String deviceType, String deviceName, String deviceOS, String browser,
                String ipAddress) {

            DeviceDetails deviceDetails = new DeviceDetails();
            deviceDetails.setDeviceType(deviceType);
            deviceDetails.setDeviceName(deviceName);
            deviceDetails.setDeviceOS(deviceOS);
            deviceDetails.setBrowser(browser);
            deviceDetails.setIpAddress(ipAddress);

            return addDeviceDetails(deviceDetails);
        }

        public CreateSubscriptionRequest.Builder addMerchantDetails(String customField1, String customField2, String customField3,
                String customField4, String customField5, String customField6, String customField7, String customField8, String customField9,
                String customField10) {

            MerchantDetails merchantDetails = new MerchantDetails();
            merchantDetails.setCustomField1(customField1);
            merchantDetails.setCustomField2(customField2);
            merchantDetails.setCustomField3(customField3);
            merchantDetails.setCustomField4(customField4);
            merchantDetails.setCustomField5(customField5);
            merchantDetails.setCustomField6(customField6);
            merchantDetails.setCustomField7(customField7);
            merchantDetails.setCustomField8(customField8);
            merchantDetails.setCustomField9(customField9);
            merchantDetails.setCustomField10(customField10);

            return addMerchantDetails(merchantDetails);
        }

        public CreateSubscriptionRequest.Builder addURLDetails(String failureUrl, String pendingUrl, String successUrl, String notificationUrl) {

            URLDetails urlDetails = new URLDetails();
            urlDetails.setFailureUrl(failureUrl);
            urlDetails.setPendingUrl(pendingUrl);
            urlDetails.setSuccessUrl(successUrl);
            urlDetails.setNotificationUrl(notificationUrl);

            return addURLDetails(urlDetails);
        }

        public CreateSubscriptionRequest.Builder addCardData(String cardNumber, String cardHolderName, String expirationMonth, String expirationYear,
                String cardToken, String cvv) {
            CardData cardData = new CardData();
            cardData.setCardNumber(cardNumber);
            cardData.setCardHolderName(cardHolderName);
            cardData.setExpirationMonth(expirationMonth);
            cardData.setExpirationYear(expirationYear);
            cardData.setCcTempToken(cardToken);
            cardData.setCVV(cvv);
            return addCardData(cardData);
        }

        public CreateSubscriptionRequest.Builder addUserPaymentOption(String cvv, String userPaymentOptionId) {
            UserPaymentOption userPaymentOption = new UserPaymentOption();
            userPaymentOption.setCVV(cvv);
            userPaymentOption.setUserPaymentOptionId(userPaymentOptionId);
            return addUserPaymentOption(userPaymentOption);
        }

        @Override public SafechargeRequest build() throws ConstraintViolationException {
            CreateSubscriptionRequest createSubscriptionRequest = new CreateSubscriptionRequest();
            createSubscriptionRequest.setSubscriptionPlanId(subscriptionPlanId);
            createSubscriptionRequest.setUserTokenId(userTokenId);
            createSubscriptionRequest.setDynamicDescriptor(dynamicDescriptor);
            createSubscriptionRequest.setUserDetails(userDetails);
            createSubscriptionRequest.setDeviceDetails(deviceDetails);
            createSubscriptionRequest.setMerchantDetails(merchantDetails);
            createSubscriptionRequest.setUrlDetails(urlDetails);
            createSubscriptionRequest.setCardData(cardData);
            createSubscriptionRequest.setUserPaymentOption(userPaymentOption);
            return ValidationUtil.validate(super.build(createSubscriptionRequest));
        }
    }
}
