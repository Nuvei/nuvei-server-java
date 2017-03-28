package com.safecharge.retail.model;

import javax.validation.constraints.Size;

import com.safecharge.retail.util.APIConstants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/14/2017
 */
public class CardData {

    @Size(max = APIConstants.CREDIT_CARD_MAX_LENGTH,
          message = "cardNumber size must be up to 20 characters long!") private String cardNumber;

    @Size(max = APIConstants.CARD_HOLDER_MAX_LENGTH,
          message = "cardHolderName size must be up to 70 characters long!") private String cardHolderName;

    @Size(max = 2,
          message = "expirationMonth size must be up to 2 characters long!") private String expirationMonth;

    @Size(max = 4,
          message = "expirationYear size must be up to 4 characters long!") private String expirationYear;

    @Size(max = 45,
          message = "userTokenId size must be up to 45 characters long!") private String cardToken;

    @Size(max = 4,
          message = "cvv size must be up to 4 characters long!") private String CVV;

    public CardData() {
    }

    public CardData(String cardNumber, String cardHolderName, String expirationMonth, String expirationYear, String cardToken, String CVV) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.cardToken = cardToken;
        this.CVV = CVV;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String cVV) {
        CVV = cVV;
    }

    public String getCardToken() {
        return cardToken;
    }

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }
}
