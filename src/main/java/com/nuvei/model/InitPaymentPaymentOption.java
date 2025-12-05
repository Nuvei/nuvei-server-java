/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.model;

public class InitPaymentPaymentOption extends BasePaymentOption {

    private InitPaymentCard card;

    public InitPaymentCard getCard() {
        return card;
    }

    public void setCard(InitPaymentCard card) {
        this.card = card;
    }
}
