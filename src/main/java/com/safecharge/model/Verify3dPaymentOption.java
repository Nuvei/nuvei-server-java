/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import javax.validation.Valid;

public class Verify3dPaymentOption extends BasePaymentOption {

    @Valid
    private Verify3dCard card;

    public Verify3dCard getCard() {
        return card;
    }

    public void setCard(Verify3dCard card) {
        this.card = card;
    }
}
