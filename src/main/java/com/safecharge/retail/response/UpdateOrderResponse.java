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

    /**
     * Sets the Merchant Order ID to be used as input parameter in update method and payment methods. The parameter passed to define which merchant order to update.
     *
     * @param orderId
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return ID of the user in merchant system.
     */
    public String getUserTokenId() {
        return userTokenId;
    }

    /**
     * Sets the ID of the user in merchant system.
     *
     * @param userTokenId
     */
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
