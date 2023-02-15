/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import javax.validation.constraints.Size;
import java.util.Map;

public class PaymentOption {

    private Card card;

    private Map<String, String> alternativePaymentMethod;

    @Size(max = 45, message = "userPaymentOptionId must be up to 45 characters long!")
    private String userPaymentOptionId;

    private SubMethod submethod;

    private String savePm;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Map<String, String> getAlternativePaymentMethod() {
        return alternativePaymentMethod;
    }

    public void setAlternativePaymentMethod(Map<String, String> alternativePaymentMethod) {
        this.alternativePaymentMethod = alternativePaymentMethod;
    }

    public String getUserPaymentOptionId() {
        return userPaymentOptionId;
    }

    public void setUserPaymentOptionId(String userPaymentOptionId) {
        this.userPaymentOptionId = userPaymentOptionId;
    }

    public SubMethod getSubmethod() {
        return submethod;
    }

    public void setSubmethod(SubMethod submethod) {
        this.submethod = submethod;
    }

    public String getSavePm() {
        return savePm;
    }

    public void setSavePm(String savePm) {
        this.savePm = savePm;
    }
}
