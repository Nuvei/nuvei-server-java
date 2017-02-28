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
public class PaymentAPMRequest extends BaseSafechargeOrderDetailsRequest implements SafechargeOrderRequest {

    @NotNull(message = "orderId parameter is mandatory!") @Size(max = 45,
                                                                message = "orderId size must be up to 45 characters long!") private String orderId;

    @NotNull(message = "paymentMethod parameter is mandatory!") private String paymentMethod;

    private Map<String, String> userAccountDetails;

    @Valid private UserPaymentOption userPaymentOption;

    @Valid private URLDetails urlDetails;

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

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentAPMRequest{");
        sb.append("orderId='")
          .append(orderId)
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
        sb.append(", ");
        sb.append(sb.append(super.toString()));
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeOrderBuilder<Builder> {

        private String orderId;
        private String paymentMethod;
        private Map<String, String> userAccountDetails;
        private UserPaymentOption userPaymentOption;
        private URLDetails urlDetails;

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

        @Override public SafechargeRequest build() {
            PaymentAPMRequest paymentAPMRequest = super.build(new PaymentAPMRequest());
            paymentAPMRequest.setOrderId(orderId);
            paymentAPMRequest.setPaymentMethod(paymentMethod);
            paymentAPMRequest.setUserAccountDetails(userAccountDetails);
            paymentAPMRequest.setUserPaymentOption(userPaymentOption);
            paymentAPMRequest.setUrlDetails(urlDetails);
            return ValidationUtil.validate(paymentAPMRequest);
        }
    }
}
