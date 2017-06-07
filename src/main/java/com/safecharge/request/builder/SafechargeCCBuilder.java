package com.safecharge.request.builder;

import com.safecharge.model.CardData;
import com.safecharge.model.UserPaymentOption;
import com.safecharge.request.SafechargeCCRequest;
import com.safecharge.util.Constants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 4/4/2017
 */
public abstract class SafechargeCCBuilder<T extends SafechargeCCBuilder<T>> extends SafechargeOrderBuilder<T> {

    private CardData cardData;
    private Constants.TransactionType transactionType;
    private UserPaymentOption userPaymentOption;
    private String orderId;
    private int isRebilling;

    public T addOrderId(String orderId) {
        this.orderId = orderId;
        return (T) this;
    }

    public T addTransactionType(Constants.TransactionType transactionType) {
        this.transactionType = transactionType;
        return (T) this;
    }

    public T addUserPaymentOption(String cvv, String userPaymentOptionId) {
        UserPaymentOption userPaymentOption = new UserPaymentOption();
        userPaymentOption.setCVV(cvv);
        userPaymentOption.setUserPaymentOptionId(userPaymentOptionId);
        return addUserPaymentOption(userPaymentOption);
    }

    public T addUserPaymentOption(UserPaymentOption userPaymentOption) {
        this.userPaymentOption = userPaymentOption;
        return (T) this;
    }

    public T addCardData(CardData cardData) {
        this.cardData = cardData;
        return (T) this;
    }

    public T addCardData(String cardNumber, String cardHolderName, String expirationMonth, String expirationYear, String cardToken, String cvv) {
        CardData cardData = new CardData();
        cardData.setCardNumber(cardNumber);
        cardData.setCardHolderName(cardHolderName);
        cardData.setExpirationMonth(expirationMonth);
        cardData.setExpirationYear(expirationYear);
        cardData.setCcTempToken(cardToken);
        cardData.setCVV(cvv);
        return addCardData(cardData);
    }

    public T addIsRebilling(int isRebilling) {
        this.isRebilling = isRebilling;
        return (T) this;
    }

    public <T extends SafechargeCCRequest> T build(T request) {
        super.build(request);
        request.setUserPaymentOption(userPaymentOption);
        request.setTransactionType(transactionType);
        request.setCardData(cardData);
        request.setOrderId(orderId);
        request.setIsRebilling(isRebilling);
        return request;
    }
}
