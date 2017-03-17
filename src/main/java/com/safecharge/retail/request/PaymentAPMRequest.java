package com.safecharge.retail.request;

import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.safecharge.retail.model.URLDetails;
import com.safecharge.retail.model.UserPaymentOption;
import com.safecharge.retail.request.builder.SafechargeOrderBuilder;
import com.safecharge.retail.util.ValidationUtil;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/15/2017
 */
public class PaymentAPMRequest extends SafechargeOrderDetailsRequest implements SafechargeOrderRequest {

    /**
     * MerchantOrderID to be used as input parameter in update method and payment methods. The parameter passed to define which merchant order to update.
     */
    @NotNull(message = "orderId parameter is mandatory!") @Size(max = 45,
                                                                message = "orderId size must be up to 45 characters long!") private String orderId;

    /**
     * Identification of the payment method. For example: PayPal, Skrill, PaysafeCard etc.
     */
    @NotNull(message = "paymentMethod parameter is mandatory!") private String paymentMethod;

    /**
     * Account details of the APM. Specific data for each APM.
     */
    private Map<String, String> userAccountDetails;

    /**
     * User payment option can to be provided as an alternative for providing card data/card token/Apple Pay token. Only one of them can be in use for a certain transaction. If both not provided or both provided it will cause an error.
     */
    @Valid private UserPaymentOption userPaymentOption;

    /**
     * Although DMN response can be configured per merchant site, it will allow to dynamically return the DMN to the provided address per request.
     */
    @Valid private URLDetails urlDetails;

    /**
     * The country the transaction is to be completed in.
     */
    @NotNull(message = "country parameter is mandatory!") @Size(max = 2,
                                                                min = 2,
                                                                message = "country must be exactly 2 characters long") private String country;

    public static Builder builder() {
        return new Builder();
    }

    public String getOrderId() {
        return orderId;
    }

    @Override public void setOrderId(String orderId) {
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

    public URLDetails getUrlDetails() {
        return urlDetails;
    }

    public void setUrlDetails(URLDetails urlDetails) {
        this.urlDetails = urlDetails;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentAPMRequest{");
        sb.append("orderId='")
          .append(orderId)
          .append('\'');
        sb.append(", country='")
          .append(country)
          .append('\'');
        sb.append(", paymentMethod='")
          .append(paymentMethod)
          .append('\'');
        sb.append(", userAccountDetails=")
          .append(userAccountDetails);
        sb.append(", userPaymentOption=")
          .append(userPaymentOption);
        sb.append(", urlDetails=")
          .append(urlDetails);
        sb.append(", ")
          .append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeOrderBuilder<Builder> {

        private String orderId;
        private String paymentMethod;
        private Map<String, String> userAccountDetails;
        private UserPaymentOption userPaymentOption;
        private URLDetails urlDetails;
        private String country;

        public Builder addOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder addPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder addUserAccountDetails(Map<String, String> userAccountDetails) {
            this.userAccountDetails = userAccountDetails;
            return this;
        }

        public Builder addUserPaymentOption(String userPaymentOptionId, String cvv) {
            UserPaymentOption userPaymentOption = new UserPaymentOption();
            userPaymentOption.setUserPaymentOptionId(userPaymentOptionId);
            userPaymentOption.setCVV(cvv);
            return addUserPaymentOption(userPaymentOption);
        }

        public Builder addUserPaymentOption(UserPaymentOption userPaymentOption) {
            this.userPaymentOption = userPaymentOption;
            return this;
        }

        public Builder addURLDetails(String failureURL, String pendingURL, String successURL) {
            URLDetails urlDetails = new URLDetails();
            urlDetails.setFailureUrl(failureURL);
            urlDetails.setPendingUrl(pendingURL);
            urlDetails.setSuccessUrl(successURL);
            return addURLDetails(urlDetails);
        }

        public Builder addURLDetails(URLDetails urlDetails) {
            this.urlDetails = urlDetails;
            return this;
        }

        public Builder addCountry(String country) {
            this.country = country;
            return this;
        }

        @Override public SafechargeRequest build() {
            PaymentAPMRequest paymentAPMRequest = super.build(new PaymentAPMRequest());
            paymentAPMRequest.setOrderId(orderId);
            paymentAPMRequest.setPaymentMethod(paymentMethod);
            paymentAPMRequest.setUserAccountDetails(userAccountDetails);
            paymentAPMRequest.setUserPaymentOption(userPaymentOption);
            paymentAPMRequest.setUrlDetails(urlDetails);
            paymentAPMRequest.setCountry(country);
            return ValidationUtil.validate(paymentAPMRequest);
        }
    }
}
