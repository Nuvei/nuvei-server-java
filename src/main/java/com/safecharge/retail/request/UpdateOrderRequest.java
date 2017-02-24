package com.safecharge.retail.request;

import com.safecharge.retail.request.builder.SafechargeOrderBuilder;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */

public class UpdateOrderRequest extends BaseSafechargeOrderDetailsRequest implements SafechargeOrderRequest {

    //    @Size(max=45)
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    @Override public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public static class Builder extends SafechargeOrderBuilder<Builder> {

        private String orderId;

        public Builder addOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        @Override public SafechargeRequest build() {
            UpdateOrderRequest updateOrderRequest = super.build(new UpdateOrderRequest());
            updateOrderRequest.setOrderId(orderId);
            return updateOrderRequest;
        }
    }
}
