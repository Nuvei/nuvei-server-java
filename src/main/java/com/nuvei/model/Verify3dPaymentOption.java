/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.model;

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
