/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.request;

import com.safecharge.request.builder.SafechargeBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * <p>
 * Request to obtain available subscription plans for the merchant.
 * Creating and updating subscription plans is possible using CPanel, SafeCharge’s back-office tool.
 * <p>
 * For more information, please contact SafeCharge’s Integration Team at <a mailto:integration@safecharge.com />integration@safecharge.com</a>
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see CreateSubscriptionRequest
 * @see GetSubscriptionsListRequest
 * @see CancelSubscriptionRequest
 * @since 6/5/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.GET_CASHIER_SUBSCRIPTIONS)
public class GetSubscriptionPlansRequest
        extends SafechargeRequest {

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetSubscriptionPlansRequest{");
        sb.append(super.toString())
                .append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeBuilder<GetSubscriptionPlansRequest.Builder> {

        /**
         * Builds the request.
         *
         * @return {@link SafechargeRequest} object build from the params set by this builder
         */
        @Override
        public SafechargeBaseRequest build() {
            return ValidationUtils.validate(super.build(new GetSubscriptionPlansRequest()));
        }
    }

}
