package com.safecharge.util;

import com.safecharge.model.CardData;

/**
 * Copyright (C) 2007-2020 SafeCharge International Group Limited.
 *
 * @author <a mailto:antona@safecharge.com>Anton Antonov</a>
 * @since 25.09.2017 г.
 */
public class CardUtils {

    private CardUtils() {
    }

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
