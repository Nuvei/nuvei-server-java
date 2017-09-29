package com.safecharge.response;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Response received from the SafeCharge's servers to the {@link com.safecharge.request.AddUPOCreditCardByTempTokenRequest}.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see com.safecharge.request.AddUPOCreditCardByTempTokenRequest
 * @since 3/10/2017
 */
public class AddUPOCreditCardByTempTokenResponse extends SafechargeResponse {

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
