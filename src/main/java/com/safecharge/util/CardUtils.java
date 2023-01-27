/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.util;

import com.safecharge.model.CardData;

/**
 *
 * @author <a mailto:antona@safecharge.com>Anton Antonov</a>
 * @since 25.09.2017 г.
 */
public class CardUtils {

    private CardUtils() {
    }

    /**
     * Static factory method to create new {@link CardData} object based on the passed params.
     *
     * @param cardNumber      the number printed on the card
     * @param cardHolderName  the name of the card's holder as printed on the card
     * @param expirationMonth the card's expiration month as printed on the card
     * @param expirationYear  the card's expiration year as printed on the card
     * @param cardToken       this token can be provided instead of the above parameters
     * @param cvv             the CVV code printed on the back of the card
     * @return new {@link CardData} object created from the passed params
     */
    public static CardData createCardDataFromParams(String cardNumber, String cardHolderName, String expirationMonth,
                                                    String expirationYear, String cardToken, String cvv) {

        CardData cardData = new CardData();
        cardData.setCardNumber(cardNumber);
        cardData.setCardHolderName(cardHolderName);
        cardData.setExpirationMonth(expirationMonth);
        cardData.setExpirationYear(expirationYear);
        cardData.setCcTempToken(cardToken);
        cardData.setCVV(cvv);

        return cardData;
    }

}
