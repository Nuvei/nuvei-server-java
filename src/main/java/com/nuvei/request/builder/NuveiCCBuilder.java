/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.request.builder;

import com.nuvei.model.CardData;
import com.nuvei.model.ExternalMpi;
import com.nuvei.model.ExternalSchemeDetails;
import com.nuvei.model.ExternalTokenProvider;
import com.nuvei.model.StoredCredentials;
import com.nuvei.model.UserPaymentOption;
import com.nuvei.request.NuveiCCRequest;
import com.nuvei.util.CardUtils;

/**
 * <p>
 * A base builder for a credit/debit card specific requests.
 * </p>
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @see NuveiBuilder
 * @see NuveiOrderBuilder
 * @see NuveiTransactionBuilder
 * @since 4/4/2017
 */
public abstract class NuveiCCBuilder<T extends NuveiCCBuilder<T>> extends NuveiPaymentBuilder<T> {

    private CardData cardData;
    private UserPaymentOption userPaymentOption;
    private String orderId;
    private int isRebilling;
    private String isPartialApproval;
    private ExternalMpi externalMpi;
    private ExternalTokenProvider externalTokenProvider;
    private StoredCredentials storedCredentials;
    private ExternalSchemeDetails externalSchemeDetails;

    /**
     * Adds an order to the request.
     *
     * @param orderId the id of the order
     * @return this object
     */
    public T addOrderId(String orderId) {
        this.orderId = orderId;
        return (T) this;
    }

    /**
     * Adds user payment option (UPO) to the request. It is the payment option that will be used for the transaction.
     *
     * @param cvv                 the CVV code of the related credit/debit card. Note that CVV is not stored by Nuvei
     * @param userPaymentOptionId the id of the UPO to add to the request
     * @return this object
     */
    public T addUserPaymentOption(String cvv, String userPaymentOptionId) {
        UserPaymentOption userPaymentOption = new UserPaymentOption();
        userPaymentOption.setCVV(cvv);
        userPaymentOption.setUserPaymentOptionId(userPaymentOptionId);
        return addUserPaymentOption(userPaymentOption);
    }

    /**
     * <p>
     * Adds user payment option (UPO) to the request. It is the payment option that will be used for the transaction.
     * If CVV is required it should be set in the passed {@code userPaymentOption}.
     * </p>
     *
     * @param userPaymentOption the UPO to add to the request
     * @return this object
     */
    public T addUserPaymentOption(UserPaymentOption userPaymentOption) {
        this.userPaymentOption = userPaymentOption;
        return (T) this;
    }

    /**
     * Adds card data to the request.
     *
     * @param cardNumber      the number printed on the card
     * @param cardHolderName  the name of the card's holder as printed on the card
     * @param expirationMonth the card's expiration month as printed on the card
     * @param expirationYear  the card's expiration year as printed on the card
     * @param cardToken       this token can be provided instead of the above parameters
     * @param cvv             the CVV code printed on the back of the card
     * @return this object
     */
    public T addCardData(String cardNumber, String cardHolderName, String expirationMonth, String expirationYear, String cardToken, String cvv) {
        CardData cardData = CardUtils.createCardDataFromParams(cardNumber, cardHolderName, expirationMonth, expirationYear, cardToken, cvv);
        return addCardData(cardData);
    }

    /**
     * Adds card data to the request.
     *
     * @param cardData {@link CardData} object to set to the request
     * @return this object
     */
    public T addCardData(CardData cardData) {
        this.cardData = cardData;
        return (T) this;
    }

    /**
     * Flag indicating if it is a rebilling(subscription) request.
     *
     * @param isRebilling indicates whether this is a regular transaction (0) or a recurring/re-billing transaction (1).
     *                    Re-billing can only be performed using a UPO id, and NOT by using card data or a card token
     * @return this object
     */
    public T addIsRebilling(int isRebilling) {
        this.isRebilling = isRebilling;
        return (T) this;
    }

    /**
     * Flag indicating if it is partial approval or not.
     * 0 - is not partial approval
     * 1 - is partial approval
     *
     * @return this object
     */
    public T addIsPartialApproval(String isPartialApproval) {
        this.isPartialApproval = isPartialApproval;
        return (T) this;
    }

    /**
     * @param externalMpi
     * @return this object
     */
    public T addExternalMpi(ExternalMpi externalMpi) {
        this.externalMpi = externalMpi;
        return (T) this;
    }

    /**
     * @param externalTokenProvider
     * @return this object
     */
    public T addExternalTokenProvider(ExternalTokenProvider externalTokenProvider) {
        this.externalTokenProvider = externalTokenProvider;
        return (T) this;
    }

    /**
     * @param storedCredentials
     * @return this object
     */
    public T addStoredCredentials(StoredCredentials storedCredentials) {
        this.storedCredentials = storedCredentials;
        return (T) this;
    }

    public T addExternalSchemeDetails(ExternalSchemeDetails externalSchemeDetails) {
        this.externalSchemeDetails = externalSchemeDetails;
        return (T) this;
    }

    /**
     * Adds the common credit/debit data, collected by this builder.
     *
     * @param request an already created request of type T
     * @param <S>     type parameter
     * @return the passed {@code request} filled with the data from this builder
     */
    public <S extends NuveiCCRequest> S build(S request) {

        super.build(request);

        request.setUserPaymentOption(userPaymentOption);

        request.setCardData(cardData);
        request.setOrderId(orderId);
        request.setIsRebilling(isRebilling);
        request.setExternalMpi(externalMpi);
        request.setIsPartialApproval(isPartialApproval);
        request.setExternalTokenProvider(externalTokenProvider);
        request.setStoredCredentials(storedCredentials);
        request.setExternalSchemeDetails(externalSchemeDetails);

        return request;
    }
}