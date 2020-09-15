package com.safecharge.response;

import com.safecharge.model.MerchantDetails;

/**
 * Copyright (C) 2007-2020 SafeCharge International Group Limited.
 * <p>
 * Response received from the SafeCharge's servers to the {@link com.safecharge.request.OpenOrderRequest}.
 * </p>
 * @author Nikola Dichev
 * @see com.safecharge.request.OpenOrderRequest
 * @since 2/15/2017
 */
public class OpenOrderResponse extends SafechargeResponse implements SafechargeOrderResponse {

    /**
     * Merchant Order ID to be used as input parameter in update method and payment methods. The parameter passed to define which merchant order to update.
     */
    private String orderId;

    /**
     * ID of the user in merchant system.
     */
    private String userTokenId;

    MerchantDetails merchantDetails;

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

    public MerchantDetails getMerchantDetails() {
        return merchantDetails;
    }

    public void setMerchantDetails(MerchantDetails merchantDetails) {
        this.merchantDetails = merchantDetails;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OpenOrderResponse{");
        sb.append("orderId='").append(orderId).append('\'');
        sb.append(", userTokenId='").append(userTokenId).append('\'');
        sb.append(", merchantDetails='").append(merchantDetails).append('\'');
        sb.append(", ").append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
