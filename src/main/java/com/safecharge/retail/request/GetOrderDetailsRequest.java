package com.safecharge.retail.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.safecharge.retail.request.builder.SafechargeBuilder;
import com.safecharge.retail.util.ValidationUtil;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/15/2017
 */
public class GetOrderDetailsRequest extends BaseSafechargeRequest implements SafechargeOrderRequest {

    /**
     * MerchantOrderID to be used as input parameter in update method and payment methods. The parameter passed to define which merchant order to update.
     */
    @Size(max = 45,
          message = "orderId has to be maximum 45 symbols") @NotNull(message = "orderId parameter is mandatory!") private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override @NotNull(message = "sessionToken parameter is mandatory!") public String getSessionToken() {
        return super.getSessionToken();
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("GetOrderDetailsRequest{");
        sb.append("orderId='")
          .append(orderId)
          .append('\'');
        sb.append(", ");
        sb.append(sb.append(super.toString()));
        sb.append('}');
        return sb.toString();
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
            return ValidationUtil.validate(request);
        }
    }
}
