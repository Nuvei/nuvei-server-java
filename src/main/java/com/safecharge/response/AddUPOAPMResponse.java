package com.safecharge.response;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/22/2017
 */
public class AddUPOAPMResponse extends SafechargeResponse {

    private Long userPaymentOptionId;

    public Long getUserPaymentOptionId() {
        return userPaymentOptionId;
    }

    public void setUserPaymentOptionId(Long userPaymentOptionId) {
        this.userPaymentOptionId = userPaymentOptionId;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("AddUPOAPMResponse{");
        sb.append("userPaymentOptionId=")
          .append(userPaymentOptionId);
        sb.append(", ")
          .append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
