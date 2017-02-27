package com.safecharge.retail.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/14/2017
 */
public class UserPaymentOption {

    @NotNull @Size(min = 3,
                   max = 45) private String userPaymentOptionId;

    @Size(max = 4) private String CVV;

    public String getUserPaymentOptionId() {
        return userPaymentOptionId;
    }

    public void setUserPaymentOptionId(String userPaymentOptionId) {
        this.userPaymentOptionId = userPaymentOptionId;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String cVV) {
        CVV = cVV;
    }

}
