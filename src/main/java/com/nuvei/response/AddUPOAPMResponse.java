/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.response;

/**
 * <p>
 * Response received from the Nuvei's servers to the {@link com.nuvei.request.AddUPOAPMRequest}.
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @see com.nuvei.request.AddUPOAPMRequest
 * @since 3/22/2017
 */
public class AddUPOAPMResponse extends NuveiResponse {

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
