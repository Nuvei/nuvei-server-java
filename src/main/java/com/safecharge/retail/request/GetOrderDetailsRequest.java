package com.safecharge.retail.request;

import com.safecharge.retail.request.builder.SafechargeBuilder;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/15/2017
 */
public class GetOrderDetailsRequest extends BaseSafechargeRequest implements SafechargeOrderRequest {
    // @Size(max=45)
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public static class Builder extends SafechargeBuilder<Builder> {

        String orderId;

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        @Override public SafechargeRequest build() {
            GetOrderDetailsRequest request = super.build(new GetOrderDetailsRequest());
            request.setOrderId(orderId);
            return request;
        }
    }
}
