/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.request;

import javax.validation.constraints.Size;

import com.nuvei.request.builder.NuveiOrderBuilder;
import com.nuvei.util.Constants;
import com.nuvei.util.ValidChecksum;
import com.nuvei.util.ValidationUtils;

/**
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @see GetOrderDetailsRequest
 * @see OpenOrderRequest
 * @since 2/17/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class UpdateOrderRequest extends NuveiOrderDetailsRequest implements NuveiOrderRequest {

    @Size(max = 45, message = "orderId size must be up to 45 characters long!")
    private String orderId;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UpdateOrderRequest{");
        sb.append("orderId='")
                .append(orderId)
                .append('\'');
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends NuveiOrderBuilder<Builder> {

        private String orderId;

        public Builder addOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        /**
         * Builds the request.
         *
         * @return {@link NuveiRequest} object build from the params set by this builder
         */
        @Override
        public NuveiBaseRequest build() {
            UpdateOrderRequest updateOrderRequest = new UpdateOrderRequest();
            updateOrderRequest.setOrderId(orderId);
            return ValidationUtils.validate(super.build(updateOrderRequest));
        }
    }
}
