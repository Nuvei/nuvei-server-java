package com.safecharge.retail.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/14/2017
 */
//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class CardData {

    //    @Size(max=ApiConstants.CREDIT_CARD_MAX_LENGTH)
    private String cardNumber;

    //    @Size(max=ApiConstants.CARD_HOLDER_MAX_LENGTH)
    private String cardHolderName;

    //    @Size(max=2)
    private String expirationMonth;

    //    @Size(max=4)
    private String expirationYear;

    //    @Size(max=45)
    private String cardToken;

    //    @Size(max=4)
    private String CVV;

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
