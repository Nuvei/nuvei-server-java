package com.safecharge.request;

import com.safecharge.request.builder.SafechargeOrderBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Request to create an order in the SafeCharge's system.
 * <p>
 * This request represents the state of the order when it is created, it can be changed at later time.
 * Note that no payment request is send, it is used mainly to store the order details at the time of creation.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see GetOrderDetailsRequest
 * @see UpdateOrderRequest
 * @since 2/15/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class OpenOrderRequest extends SafechargeOrderDetailsRequest {

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OpenOrderRequest{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeOrderBuilder<Builder> {

        /**
         * Builds the request.
         *
         * @return {@link SafechargeRequest} object build from the params set by this builder
         */
        @Override
        public SafechargeRequest build() {
            SafechargeOrderDetailsRequest openOrderRequest = new OpenOrderRequest();
            return ValidationUtils.validate(super.build(openOrderRequest));
        }
    }
}
