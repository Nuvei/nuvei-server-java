package com.safecharge.retail.response;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/15/2017
 */
public class CardTokenizationResponse extends PaymentCCResponse {

    private String cardToken;

    public CardTokenizationResponse() {
        throw new NotImplementedException();
    }

    /**
     * @return the credit/debit card token.
     */
    public String getCardToken() {
        return cardToken;
    }

    /**
     * Sets the credit/debit card token.
     *
     * @param cardToken
     */
    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("CardTokenizationResponse{");
        sb.append("cardToken='")
          .append(cardToken)
          .append('\'');
        sb.append(", ");
        sb.append(sb.append(super.toString()));
        sb.append('}');
        return sb.toString();
    }
}
