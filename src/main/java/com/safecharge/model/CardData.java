/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import javax.validation.constraints.Size;

import com.safecharge.util.APIConstants;

/**
 * <p>
 * Holder for credit/debit/prepaid card data.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/14/2017
 */
public class CardData {

    @Size(max = APIConstants.CREDIT_CARD_MAX_LENGTH, message = "cardNumber size must be up to 20 characters long!")
    private String cardNumber;

    @Size(max = APIConstants.CARD_HOLDER_MAX_LENGTH, message = "cardHolderName size must be up to 70 characters long!")
    private String cardHolderName;

    @Size(max = 2, message = "expirationMonth size must be up to 2 characters long!")
    private String expirationMonth;

    @Size(min = 2, max = 4, message = "expirationYear size must be from 2 to 4 characters long!")
    private String expirationYear;

    @Size(max = 45, message = "ccTempToken size must be up to 45 characters long!")
    private String ccTempToken;

    @Size(min = 3, max = 4, message = "cvv size must be 3 or 4 characters long!")
    private String CVV;

    private String brand;

    @Size(max = 4, message = "last4Digits size must be up to 4 digits long!")
    private String last4Digits;

    public CardData() {
    }

    public CardData(String cardNumber, String cardHolderName, String expirationMonth, String expirationYear, String ccTempToken, String CVV) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.ccTempToken = ccTempToken;
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

    public String getCcTempToken() {
        return ccTempToken;
    }

    public void setCcTempToken(String ccTempToken) {
        this.ccTempToken = ccTempToken;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLast4Digits() {
        return last4Digits;
    }

    public void setLast4Digits(String last4Digits) {
        this.last4Digits = last4Digits;
    }
}
