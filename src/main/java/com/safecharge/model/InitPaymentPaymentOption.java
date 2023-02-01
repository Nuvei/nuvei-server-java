/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

public class InitPaymentPaymentOption extends BasePaymentOption {

    private InitPaymentCard card;

    public InitPaymentCard getCard() {
        return card;
    }

    public void setCard(InitPaymentCard card) {
        this.card = card;
    }
}
