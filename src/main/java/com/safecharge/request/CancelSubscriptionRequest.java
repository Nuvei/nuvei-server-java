package com.safecharge.request;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.safecharge.request.builder.SafechargeBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Request to cancel existing subscription.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see CreateSubscriptionRequest
 * @since 6/5/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.CANCEL_CASHIER_SUBSCRIPTION)
public class CancelSubscriptionRequest
        extends SafechargeRequest {

    /**
     * The ID of the user’s active subscription in the SafeCharge’s system.
     */
    @NotNull(message = "subscriptionId mustn't be null")
    @Size(max = 20, message = "subscriptionId value size must be up to 20 characters")
    private String subscriptionId;

    /**
     * The ID of the user token to add to the request.
     */
    @NotNull(message = "userTokenId mustn't be null")
    @Size(max = 255, message = "userTokenId value size must be up to 255 characters")
    private String userTokenId;

    public static Builder builder() {
        return new Builder();
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CancelSubscriptionRequest{");
        sb.append("subscriptionId='")
                .append(subscriptionId)
                .append('\'');
        sb.append(", userTokenId='")
                .append(userTokenId)
                .append('\'');
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeBuilder<CancelSubscriptionRequest.Builder> {

        private String subscriptionId;
        private String userTokenId;

        /**
         * Adds subscription Id to the request.
         *
         * @param subscriptionId the ID of the user’s active subscription in the SafeCharge’s system.
         * @return this object
         */
        public CancelSubscriptionRequest.Builder addSubscriptionId(String subscriptionId) {
            this.subscriptionId = subscriptionId;
            return this;
        }

        /**
         * Adds user token id to the request.
         *
         * @param userTokenId the ID of the user token to add to the request
         * @return this object
         */
        public CancelSubscriptionRequest.Builder addUserTokenId(String userTokenId) {
            this.userTokenId = userTokenId;
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
            CancelSubscriptionRequest cancelSubscriptionRequest = new CancelSubscriptionRequest();
            cancelSubscriptionRequest.setSubscriptionId(subscriptionId);
            cancelSubscriptionRequest.setUserTokenId(userTokenId);
            return ValidationUtils.validate(super.build(cancelSubscriptionRequest));
        }
    }
}
