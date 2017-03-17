package com.safecharge.retail.response;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/10/2017
 */
public class AddUPOCreditCardByTempTokenResponse extends SafechargeResponse {

    private String userPaymentOptionId;

    public String getUserPaymentOptionId() {
        return userPaymentOptionId;
    }

    public void setUserPaymentOptionId(String userPaymentOptionId) {
        this.userPaymentOptionId = userPaymentOptionId;
    }

    @Override public String toString() {
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
