/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.response;

/**
 * <p>
 * Response received from the Nuvei's servers to the {@link com.nuvei.request.AddUPOCreditCardByTempTokenRequest}.
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @see com.nuvei.request.AddUPOCreditCardByTempTokenRequest
 * @since 3/10/2017
 */
public class AddUPOCreditCardByTempTokenResponse extends NuveiResponse {

    /**
     * The id of the created User Payment Option(UPO), if the request is successful.
     */
    private String userPaymentOptionId;

    public String getUserPaymentOptionId() {
        return userPaymentOptionId;
    }

    public void setUserPaymentOptionId(String userPaymentOptionId) {
        this.userPaymentOptionId = userPaymentOptionId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AddUPOCreditCardByTempTokenResponse{");
        sb.append("userPaymentOptionId='")
                .append(userPaymentOptionId)
                .append('\'');
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
