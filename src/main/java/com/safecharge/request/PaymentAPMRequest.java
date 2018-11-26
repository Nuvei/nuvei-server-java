package com.safecharge.request;

import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.safecharge.model.SubMethodDetails;
import com.safecharge.model.UserPaymentOption;
import com.safecharge.request.builder.SafechargeOrderBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Request to perform a payment using an alternative payment method(APM).
 * <p>
 * PaymentAPM transaction is implemented in four main stages:
 * <ol>
 * <li>Ensuring that SafeCharge is integrated to the desired APM.
 * <li>The {@code paymentAPM} request.
 * <li>The required merchant actions (for APM’s who use redirect).
 * Following a positive response from the paymentAPM request, per output parameter {@code transactionStatus} returned value,
 * the merchant is redirected to the APM’s payment page (using {@code redirectUrl}) to login and confirm the billing information.
 * <li>The APM required actions (for APM’s who use redirect). Once the credentials are typed and the payment is confirmed,
 * the APM redirects (with some additional information) back to SafeCharge’s gateway using a {@code returnUrl} from previous APM-SafeCharge
 * communications at 1st stage. Afterwards, the SafeCharge gateway redirects to a {@code successURL} or to a {@code failureURL}.
 * </ol>
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see Payment3DRequest
 * @see PaymentCCRequest
 * @since 2/15/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class PaymentAPMRequest
        extends SafechargeOrderDetailsRequest implements SafechargeOrderRequest {

    /**
     * MerchantOrderID to be used as input parameter in update method and payment methods. The parameter passed to define which merchant order to update.
     */
    @Size(max = 45, message = "orderId size must be up to 45 characters long!")
    private String orderId;

    /**
     * Identification of the payment method. For example: PayPal, Skrill, PaysafeCard etc.
     */
    @NotNull(message = "paymentMethod parameter is mandatory!")
    private String paymentMethod;

    /**
     * Account details of the APM. Specific data for each APM.
     */
    private Map<String, String> userAccountDetails;

    /**
     * User payment option can to be provided as an alternative for providing card data/card token/Apple Pay token.
     * Only one of them can be in use for a certain transaction. If both are not provided or both are provided it will cause an error.
     */
    @Valid
    private UserPaymentOption userPaymentOption;

    @Valid
    private SubMethodDetails subMethodDetails;

    private String customData;

    public static Builder builder() {
        return new Builder();
    }

    public String getOrderId() {
        return orderId;
    }

    @Override
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Map<String, String> getUserAccountDetails() {
        return userAccountDetails;
    }

    public void setUserAccountDetails(Map<String, String> userAccountDetails) {
        this.userAccountDetails = userAccountDetails;
    }

    public UserPaymentOption getUserPaymentOption() {
        return userPaymentOption;
    }

    public void setUserPaymentOption(UserPaymentOption userPaymentOption) {
        this.userPaymentOption = userPaymentOption;
    }

    public SubMethodDetails getSubMethodDetails() {
        return subMethodDetails;
    }

    public void setSubMethodDetails(SubMethodDetails subMethodDetails) {
        this.subMethodDetails = subMethodDetails;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentAPMRequest{");
        sb.append("orderId='").append(orderId).append('\'');
        sb.append(", paymentMethod='").append(paymentMethod).append('\'');
        sb.append(", userAccountDetails=").append(userAccountDetails);
        sb.append(", userPaymentOption=").append(userPaymentOption);
        sb.append(", subMethodDetails=").append(subMethodDetails);
        sb.append(", customData=").append(customData);
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeOrderBuilder<Builder> {

        private String orderId;
        private String paymentMethod;
        private Map<String, String> userAccountDetails;
        private UserPaymentOption userPaymentOption;
        private SubMethodDetails subMethodDetails;
        private String customData;

        /**
         * Adds order ID to the request.
         *
         * @param orderId the ID of the order to add to the request, it is used as indication that the payment is done for this order
         * @return this object
         */
        public Builder addOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        /**
         * Adds the payment method name to the request.
         *
         * @param paymentMethod SafeCharge’s unique name of the payment method. For a list of possible payment methods check
         *                      <a href="https://www.safecharge.com/docs/api/?java#apm-unique-safecharge-names">APM Unique SafeCharge Names.</a>
         * @return this object
         */
        public Builder addPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        /**
         * Adds user account details to the request. Those details are related to the user's APM account and not the SafeCharge's account.
         *
         * @param userAccountDetails SafeCharge’s account identifiers of the payment method's details. For more information, see
         *                           <a href="https://www.safecharge.com/docs/api/?java#apm-account-identifiers">APM Account Identifiers.</a>
         * @return this object
         */
        public Builder addUserAccountDetails(Map<String, String> userAccountDetails) {
            this.userAccountDetails = userAccountDetails;
            return this;
        }

        /**
         * Adds User Payment Option (UPO) ID to the request.
         * <p>
         * This is the ID of previously used payment option (PO) stored in the SafeCharge's system.
         *
         * @param userPaymentOptionId The id of a previously used PO(that the user has agreed to store in SafeCharge's system)
         * @param cvv                 Card Verification Value number. If the UPO requires CVV for every transaction, it must be provided
         * @return this object
         */
        public Builder addUserPaymentOption(String userPaymentOptionId, String cvv) {
            UserPaymentOption userPaymentOption = new UserPaymentOption();
            userPaymentOption.setUserPaymentOptionId(userPaymentOptionId);
            userPaymentOption.setCVV(cvv);
            return addUserPaymentOption(userPaymentOption);
        }

        /**
         * Adds {@link UserPaymentOption} to the request.
         *
         * @param userPaymentOption object holding the User Payment Option information
         * @return this object
         */
        public Builder addUserPaymentOption(UserPaymentOption userPaymentOption) {
            this.userPaymentOption = userPaymentOption;
            return this;
        }

        /**
         * Adds {@link SubMethodDetails} to the request.
         * @param subMethodDetails
         * @return
         */
        public Builder addSubMethodDetails(SubMethodDetails subMethodDetails) {
            this.subMethodDetails = subMethodDetails;
            return this;
        }

        public Builder addCustomData(String customData) {
            this.customData = customData;
            return this;
        }

        /**
         * Builds the request.
         *
         * @return {@link SafechargeRequest} object build from the params set by this builder
         */
        @Override
        public SafechargeBaseRequest build() {
            PaymentAPMRequest paymentAPMRequest = new PaymentAPMRequest();
            paymentAPMRequest.setOrderId(orderId);
            paymentAPMRequest.setPaymentMethod(paymentMethod);
            paymentAPMRequest.setUserAccountDetails(userAccountDetails);
            paymentAPMRequest.setUserPaymentOption(userPaymentOption);
            paymentAPMRequest.setSubMethodDetails(subMethodDetails);
            paymentAPMRequest.setCustomData(customData);
            return ValidationUtils.validate(super.build(paymentAPMRequest));
        }
    }
}
