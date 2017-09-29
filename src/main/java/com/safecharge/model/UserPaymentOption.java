package com.safecharge.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Holder for User Payment Option(UPO) data.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/14/2017
 */
public class UserPaymentOption {

    @NotNull(message = "userPaymentOptionId may not be null!")
    @Size(min = 3, max = 45, message = "userPaymentOptionId size must at least 3 symbols and maximum 45 characters long!")
    private String userPaymentOptionId;

    @Size(max = 4, message = "cvv size must be up to 4 characters long!")
    private String CVV;

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
