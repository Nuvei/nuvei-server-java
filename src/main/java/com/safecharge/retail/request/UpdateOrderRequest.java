package com.safecharge.retail.request;

import javax.validation.constraints.Size;

import com.safecharge.retail.request.builder.SafechargeOrderBuilder;
import com.safecharge.retail.util.ValidationUtil;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */

public class UpdateOrderRequest extends BaseSafechargeOrderDetailsRequest implements SafechargeOrderRequest {

    @Size(max = 45,
          message = "orderId size must be up to 45 characters long!")
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    @Override public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("UpdateOrderRequest{");
        sb.append("orderId='")
          .append(orderId)
          .append('\'');
        sb.append(", ");
        sb.append(sb.append(super.toString()));
        sb.append('}');
        return sb.toString();
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
            return ValidationUtil.validate(updateOrderRequest);
        }
    }
}
