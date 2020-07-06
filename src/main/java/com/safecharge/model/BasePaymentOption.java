package com.safecharge.model;

import javax.validation.constraints.Size;

public class BasePaymentOption {

    @Size(max = 45)
    private String userPaymentOptionId;

    public String getUserPaymentOptionId() {
        return userPaymentOptionId;
    }

    public void setUserPaymentOptionId(String userPaymentOptionId) {
        this.userPaymentOptionId = userPaymentOptionId;
    }
}
