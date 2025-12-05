package com.nuvei.model;

import com.nuvei.util.AtLeastOneFieldPresent;

import javax.validation.Valid;
import javax.validation.constraints.Size;


@AtLeastOneFieldPresent(fields = {"card", "userPaymentOptionId"}, message = "Either \"card\" or \"userPaymentOptionId\" must be defined")
public class RefundPaymentOption {
    @Valid
    private CardData card;

    @Size(max = 45)
    private String userPaymentOptionId;

    public CardData getCard() {
        return card;
    }

    public void setCard(CardData card) {
        this.card = card;
    }

    public String getUserPaymentOptionId() {
        return userPaymentOptionId;
    }

    public void setUserPaymentOptionId(String userPaymentOptionId) {
        this.userPaymentOptionId = userPaymentOptionId;
    }

}
