package com.safecharge.retail.response;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/15/2017
 */
public class UpdateOrderResponse extends BaseResponse implements SafechargeOrderResponse {

    private String orderId;
    private String userTokenId;

    @Override public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("UpdateOrderResponse{");
        sb.append("orderId='")
          .append(orderId)
          .append('\'');
        sb.append(", userTokenId='")
          .append(userTokenId)
          .append('\'');
        sb.append(", ");
        sb.append(sb.append(super.toString()));
        sb.append('}');
        return sb.toString();
    }
}
