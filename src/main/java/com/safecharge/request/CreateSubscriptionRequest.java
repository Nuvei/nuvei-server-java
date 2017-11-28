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
import com.safecharge.model.UrlDetails;
import com.safecharge.model.UserAddress;
import com.safecharge.model.UserPaymentOption;
import com.safecharge.request.builder.SafechargeBuilder;
import com.safecharge.util.AddressUtils;
import com.safecharge.util.CardUtils;
import com.safecharge.util.Constants;
import com.safecharge.util.DeviceUtils;
import com.safecharge.util.MerchantUtils;
import com.safecharge.util.UrlUtils;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Request to create a recurring payment.
 * <p>
 * This request is used for creating a subscription for consumers that wish to conduct future recurring transactions,
 * based on previous successful transactions.
 * <p>
 * The details of the subscription are stored in a previously created subscription plan. So no parameters related to the subscription
 * (e.g. initial amount, recurring amount, subscription duration, etc) are passed except the ID of the subscription plan.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see GetSubscriptionsListRequest
 * @see GetSubscriptionPlansRequest
 * @see CancelSubscriptionRequest
 * @since 6/5/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.GET_CASHIER_SUBSCRIPTIONS)
public class CreateSubscriptionRequest
        extends SafechargeRequest {

    /**
     * The ID of previously created subscription plan  to add to the request.
     */
    @NotNull(message = "subscriptionPlanId mustn't be null")
    @Size(max = 20, message = "subscriptionId value size must be up to 20 characters")
    private String subscriptionPlanId;

    /**
     * The ID of the user token to add to the request.
     */
    @NotNull(message = "userTokenId mustn't be null")
    @Size(max = 255, message = "userTokenId value size must be up to 255 characters")
    private String userTokenId;

    @Valid
    private DynamicDescriptor dynamicDescriptor;

    @Valid
    private CashierUserDetails userDetails;

    @Valid
    private DeviceDetails deviceDetails;

    @Valid
    private MerchantDetails merchantDetails;

    @Valid
    private UrlDetails urlDetails;

    @Valid
    private CardData cardData;

    @Valid
    private UserPaymentOption userPaymentOption;

    @Valid
    private UserAddress billingAddress;

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

    public UrlDetails getUrlDetails() {
        return urlDetails;
    }

    public void setUrlDetails(UrlDetails urlDetails) {
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

    public UserAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(UserAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public String toString() {
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
        sb.append(", billingAddress=")
                .append(billingAddress);
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
        private UrlDetails urlDetails;
        private CardData cardData;
        private UserPaymentOption userPaymentOption;
        private UserAddress billingAddress;

        /**
         * Adds subscription plan ID to the request.
         * <p>
         * The details of the subscription can be found in it(e.g. initial amount, recurring amount, subscription duration, etc).
         *
         * @param subscriptionPlanId the id of the subscription plan to use in the request
         * @return this object
         */
        public CreateSubscriptionRequest.Builder addSubscriptionPlanId(String subscriptionPlanId) {
            this.subscriptionPlanId = subscriptionPlanId;
            return this;
        }

        /**
         * Adds user token id to the request.
         *
         * @param userTokenId The user token as {@link String}
         * @return this object
         */
        public CreateSubscriptionRequest.Builder addUserTokenId(String userTokenId) {
            this.userTokenId = userTokenId;
            return this;
        }

        /**
         * Adds Merchant's dynamic data to the request.
         *
         * @param dynamicDescriptor {@link DynamicDescriptor} object to add to the request
         * @return this object
         */
        public CreateSubscriptionRequest.Builder addDynamicDescriptor(DynamicDescriptor dynamicDescriptor) {

            this.dynamicDescriptor = dynamicDescriptor;
            return this;
        }

        /**
         * Adds user details to the request.
         *
         * @param userDetails the {@link CashierUserDetails} to add to the request
         * @return this object
         */
        public CreateSubscriptionRequest.Builder addUserDetails(CashierUserDetails userDetails) {

            this.userDetails = userDetails;
            return this;
        }

        /**
         * Adds device details to the request.
         *
         * @param deviceDetails the {@link DeviceDetails} to add to the request
         * @return this object
         */
        public CreateSubscriptionRequest.Builder addDeviceDetails(DeviceDetails deviceDetails) {

            this.deviceDetails = deviceDetails;
            return this;
        }

        /**
         * Adds Merchant's specific custom data to the request.
         *
         * @param merchantDetails {@link MerchantDetails} object to add to the request
         * @return this object
         */
        public CreateSubscriptionRequest.Builder addMerchantDetails(MerchantDetails merchantDetails) {

            this.merchantDetails = merchantDetails;
            return this;
        }

        /**
         * Adds URLs to redirect to in case of success/failure and URL to send notification(DMN) to.
         *
         * @param urlDetails {@link UrlDetails} object to add to the request
         * @return this object
         */
        public CreateSubscriptionRequest.Builder addURLDetails(UrlDetails urlDetails) {
            this.urlDetails = urlDetails;
            return this;
        }

        /**
         * Adds card data to the request.
         *
         * @param cardData {@link CardData} object to set to the request
         * @return this object
         */
        public CreateSubscriptionRequest.Builder addCardData(CardData cardData) {
            this.cardData = cardData;
            return this;
        }

        /**
         * Adds user payment option (UPO) to the request. It is the payment option that will be used for the transaction.
         * If CVV is required it should be set in the passed {@code userPaymentOption}.
         *
         * @param userPaymentOption the UPO to add to the request
         * @return this object
         */
        public CreateSubscriptionRequest.Builder addUserPaymentOption(UserPaymentOption userPaymentOption) {
            this.userPaymentOption = userPaymentOption;
            return this;
        }

        /**
         * Adds Merchant's dynamic data to the request.
         *
         * @param merchantName  Merchant's name
         * @param merchantPhone Merchant's phone number
         * @return this object
         */
        public CreateSubscriptionRequest.Builder addDynamicDescriptor(String merchantName, String merchantPhone) {

            //TODO: decide how to remove this duplicate code - constructor vs static factory
            DynamicDescriptor dynamicDescriptor = new DynamicDescriptor();
            dynamicDescriptor.setMerchantName(merchantName);
            dynamicDescriptor.setMerchantPhone(merchantPhone);

            return addDynamicDescriptor(dynamicDescriptor);
        }

        /**
         * Adds user details to the request.
         *
         * @param address     The address of the user
         * @param city        The city of the user
         * @param country     The city of the user(two-letter ISO country code)
         * @param email       The email of the user
         * @param firstName   The first name of the user
         * @param lastName    The last name of the user
         * @param phone       The phone number of the user
         * @param state       The state of the user(two-letter ISO state code)
         * @param zip         The postal code of the user
         * @param dateOfBirth The date of birth of the user
         * @return this object
         */
        public CreateSubscriptionRequest.Builder addUserDetails(String address, String city, String country, String email, String firstName,
                                                                String lastName, String phone, String state, String zip, String dateOfBirth,
                                                                String county) {

            CashierUserDetails userDetails = AddressUtils.createCashierUserDetailsFromParams(address, city, country, email,
                    firstName, lastName, phone, state, zip, dateOfBirth, county);

            return addUserDetails(userDetails);
        }

        /**
         * Adds device details to the request.
         *
         * @param deviceType the type of the device making the request
         * @param deviceName the type of the device making the request
         * @param deviceOS   the device operating system
         * @param browser    the browser that the device used making the request
         * @param ipAddress  the IP address of the device making the request
         * @return this object
         */
        public CreateSubscriptionRequest.Builder addDeviceDetails(String deviceType, String deviceName, String deviceOS, String browser,
                                                                  String ipAddress) {

            DeviceDetails deviceDetails = DeviceUtils.createDeviceDetailsFromParams(deviceType, deviceName, deviceOS, browser, ipAddress);

            return addDeviceDetails(deviceDetails);
        }

        /**
         * Adds Merchant's specific custom data to the request.
         *
         * @param customField1  {@link String} to store in {@code customField1}
         * @param customField2  {@link String} to store in {@code customField2}
         * @param customField3  {@link String} to store in {@code customField3}
         * @param customField4  {@link String} to store in {@code customField4}
         * @param customField5  {@link String} to store in {@code customField5}
         * @param customField6  {@link String} to store in {@code customField6}
         * @param customField7  {@link String} to store in {@code customField7}
         * @param customField8  {@link String} to store in {@code customField8}
         * @param customField9  {@link String} to store in {@code customField9}
         * @param customField10 {@link String} to store in {@code customField10}
         * @param customField11 {@link String} to store in {@code customField11}
         * @param customField12 {@link String} to store in {@code customField12}
         * @param customField13 {@link String} to store in {@code customField13}
         * @param customField14 {@link String} to store in {@code customField14}
         * @param customField15 {@link String} to store in {@code customField15}
         * @return this object
         */
        public CreateSubscriptionRequest.Builder addMerchantDetails(String customField1, String customField2, String customField3,
                                                                    String customField4, String customField5, String customField6,
                                                                    String customField7, String customField8, String customField9,
                                                                    String customField10, String customField11, String customField12,
                                                                    String customField13, String customField14, String customField15) {

            MerchantDetails merchantDetails = MerchantUtils.createMerchantDetailsFromParams(customField1, customField2, customField3,
                    customField4, customField5, customField6, customField7, customField8, customField9, customField10, customField11, 
                    customField12, customField13, customField14, customField15);

            return addMerchantDetails(merchantDetails);
        }


        /**
         * Adds URLs to redirect to in case of success/failure and URL to send notification(DMN) to.
         *
         * @param failureUrl      URL to redirect to in case of failed transaction
         * @param pendingUrl      URL to redirect to in case of pending transaction
         * @param successUrl      URL to redirect to in case of successful transaction
         * @param notificationUrl URL to send notification(DMN) to
         * @return this object
         */
        public CreateSubscriptionRequest.Builder addURLDetails(String failureUrl, String pendingUrl, String successUrl, String notificationUrl) {

            UrlDetails urlDetails = UrlUtils.createUrlDetails(failureUrl, pendingUrl, successUrl, notificationUrl);

            return addURLDetails(urlDetails);
        }

        /**
         * Adds card data to the request.
         *
         * @param cardNumber      the number printed on the card
         * @param cardHolderName  the name of the card's holder as printed on the card
         * @param expirationMonth the card's expiration month as printed on the card
         * @param expirationYear  the card's expiration year as printed on the card
         * @param cardToken       this token can be provided instead of the above parameters
         * @param cvv             the CVV code printed on the back of the card
         * @return this object
         */
        public CreateSubscriptionRequest.Builder addCardData(String cardNumber, String cardHolderName, String expirationMonth,
                                                             String expirationYear, String cardToken, String cvv) {

            CardData cardData = CardUtils.createCardDataFromParams(cardNumber, cardHolderName, expirationMonth, expirationYear,
                    cardToken, cvv);

            return addCardData(cardData);
        }

        /**
         * Adds user payment option (UPO) to the request. It is the payment option that will be used for the transaction.
         *
         * @param cvv                 the CVV code of the related credit/debit card. Note that CVV is not stored by Safecharge
         * @param userPaymentOptionId the id of the UPO to add to the request
         * @return this object
         */
        public CreateSubscriptionRequest.Builder addUserPaymentOption(String cvv, String userPaymentOptionId) {

            //TODO: decide how to remove this duplicate code - constructor vs static factory
            UserPaymentOption userPaymentOption = new UserPaymentOption();
            userPaymentOption.setCVV(cvv);
            userPaymentOption.setUserPaymentOptionId(userPaymentOptionId);

            return addUserPaymentOption(userPaymentOption);
        }

        /**
         * Adds billing info to the request.
         *
         * @param firstName The first name of the recipient
         * @param lastName  The last name of the recipient
         * @param email     The email of the recipient
         * @param phone     The phone number of the recipient
         * @param address   The address of the recipient
         * @param city      The city of the recipient
         * @param country   The country of the recipient(two-letter ISO country code)
         * @param state     The state of the recipient(two-letter ISO state code)
         * @param zip       The postal code of the recipient
         * @param cell      The cell number of the recipient
         * @return this object
         */
        public Builder addBillingAddress(String firstName, String lastName, String email, String phone, String address, String city, String country,
                                         String state, String zip, String cell, String county) {

            UserAddress billingAddress = AddressUtils.createUserAddressFromParams(firstName, lastName, email, phone, address, city, country,
                    state, zip, cell, county);

            return addBillingAddress(billingAddress);
        }

        /**
         * Adds billing info to the request.
         *
         * @param billingAddress {@link UserAddress} object to add to the request as billing details
         * @return this object
         */
        public Builder addBillingAddress(UserAddress billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        /**
         * Builds the request.
         *
         * @return {@link SafechargeRequest} object build from the params set by this builder
         * @throws ConstraintViolationException if the validation of the params fails
         */
        @Override
        public SafechargeRequest build() throws ConstraintViolationException {
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
            createSubscriptionRequest.setBillingAddress(billingAddress);
            return ValidationUtils.validate(super.build(createSubscriptionRequest));
        }
    }
}
