package com.safecharge.model;

import javax.validation.constraints.Size;
import java.util.Map;

public class PaymentOption {

    private Card card;

    private Map<String, String> alternativePaymentMethod;

    @Size(max = 45, message = "userPaymentOptionId must be up to 45 characters long!")
    private String userPaymentOptionId;

    private SubMethod submethod;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
