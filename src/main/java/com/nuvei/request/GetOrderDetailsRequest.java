/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.nuvei.request.builder.NuveiBuilder;
import com.nuvei.util.Constants;
import com.nuvei.util.ValidChecksum;
import com.nuvei.util.ValidationUtils;

/**
 * <p>
 * Request to get specific order details.
 * <p>
 * Enables receiving specific order details of an existing order.
 * Note that order details can be viewed at any point in time.
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @see OpenOrderRequest
 * @see UpdateOrderRequest
 * @since 2/15/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class GetOrderDetailsRequest extends NuveiRequest implements NuveiOrderRequest {

    /**
     * MerchantOrderID to be used as input parameter in update method and payment methods.
     */
    @Size(max = 45, message = "orderId has to be maximum 45 symbols")
    @NotNull(message = "orderId parameter is mandatory!")
    private String orderId;

    public static Builder builder() {
        return new Builder();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    @NotNull(message = "sessionToken parameter is mandatory!")
    public String getSessionToken() {
        return super.getSessionToken();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetOrderDetailsRequest{");
        sb.append("orderId='")
                .append(orderId)
                .append('\'');
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends NuveiBuilder<Builder> {

        String orderId;

        /**
         * Adds order id to the request,
         *
         * @param orderId the order ID to get the info for
         * @return this object
         */
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
            GetOrderDetailsRequest request = new GetOrderDetailsRequest();
            request.setOrderId(orderId);
            return ValidationUtils.validate(super.build(request));
        }
    }
}
