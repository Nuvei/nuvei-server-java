/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.response;

/**
 * <p>
 * Response received from the SafeCharge's servers to the {@link com.safecharge.request.AddUPOAPMRequest}.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see com.safecharge.request.AddUPOAPMRequest
 * @since 3/22/2017
 */
public class AddUPOAPMResponse extends SafechargeResponse {

    /**
     * The id of the created User Payment Option(UPO), if the request is successful.
     */
    private Long userPaymentOptionId;

    public Long getUserPaymentOptionId() {
        return userPaymentOptionId;
    }

    public void setUserPaymentOptionId(Long userPaymentOptionId) {
        this.userPaymentOptionId = userPaymentOptionId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AddUPOAPMResponse{");
        sb.append("userPaymentOptionId=")
                .append(userPaymentOptionId);
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
