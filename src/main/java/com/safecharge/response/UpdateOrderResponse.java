/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.response;

/**
 * <p>
 * Response received from the SafeCharge's servers to the {@link com.safecharge.request.UpdateOrderRequest}.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see com.safecharge.request.UpdateOrderRequest
 * @since 2/15/2017
 */
public class UpdateOrderResponse extends SafechargeResponse implements SafechargeOrderResponse {

    /**
     * Merchant Order ID to be used as input parameter in update method and payment methods.
     * The parameter passed to define which merchant order to update.
     */
    private String orderId;
    /**
     * ID of the user in merchant system.
     */
    private String userTokenId;

    @Override
    public String getOrderId() {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UpdateOrderResponse{");
        sb.append("orderId='")
                .append(orderId)
                .append('\'');
        sb.append(", userTokenId='")
                .append(userTokenId)
                .append('\'');
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
