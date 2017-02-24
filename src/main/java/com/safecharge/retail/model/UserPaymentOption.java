package com.safecharge.retail.model;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/14/2017
 */
//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class UserPaymentOption {

    //    @NotNull
    //    @Size(min=3, max=45)
    private String userPaymentOptionId;

    //    @Size(max=4)
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
