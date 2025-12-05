/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.request;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.nuvei.request.builder.NuveiBuilder;
import com.nuvei.util.Constants;
import com.nuvei.util.ValidChecksum;
import com.nuvei.util.ValidationUtils;

/**
 * <p>
 * Request to cancel existing subscription.
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @see CreateSubscriptionRequest
 * @since 6/5/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.CANCEL_CASHIER_SUBSCRIPTION)
public class CancelSubscriptionRequest
        extends NuveiRequest {

    /**
     * The ID of the user’s active subscription in the Nuvei's system.
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

    public static class Builder extends NuveiBuilder<Builder> {

        private String subscriptionId;
        private String userTokenId;

        /**
         * Adds subscription Id to the request.
         *
         * @param subscriptionId the ID of the user’s active subscription in the Nuvei's system.
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
         * @return {@link NuveiRequest} object build from the params set by this builder
         * @throws ConstraintViolationException if the validation of the params fails
         */
        @Override
        public NuveiBaseRequest build() throws ConstraintViolationException {
            CancelSubscriptionRequest cancelSubscriptionRequest = new CancelSubscriptionRequest();
            cancelSubscriptionRequest.setSubscriptionId(subscriptionId);
            cancelSubscriptionRequest.setUserTokenId(userTokenId);
            return ValidationUtils.validate(super.build(cancelSubscriptionRequest));
        }
    }
}
