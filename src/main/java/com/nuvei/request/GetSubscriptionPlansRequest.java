/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.request;

import com.nuvei.request.builder.NuveiBuilder;
import com.nuvei.util.Constants;
import com.nuvei.util.ValidChecksum;
import com.nuvei.util.ValidationUtils;

/**
 * <p>
 * Request to obtain available subscription plans for the merchant.
 * Creating and updating subscription plans is possible using CPanel, Nuvei's back-office tool.
 * <p>
 * For more information, please contact Nuvei's Integration Team at <a mailto:integration@nuvei.com />integration@nuvei.com</a>
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @see CreateSubscriptionRequest
 * @see GetSubscriptionsListRequest
 * @see CancelSubscriptionRequest
 * @since 6/5/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.GET_CASHIER_SUBSCRIPTIONS)
public class GetSubscriptionPlansRequest
        extends NuveiRequest {

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

    public static class Builder extends NuveiBuilder<Builder> {

        /**
         * Builds the request.
         *
         * @return {@link NuveiRequest} object build from the params set by this builder
         */
        @Override
        public NuveiBaseRequest build() {
            return ValidationUtils.validate(super.build(new GetSubscriptionPlansRequest()));
        }
    }

}
