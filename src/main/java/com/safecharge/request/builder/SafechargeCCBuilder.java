package com.safecharge.request.builder;

import com.safecharge.model.CardData;
import com.safecharge.model.ExternalMpi;
import com.safecharge.model.ExternalTokenProvider;
import com.safecharge.model.UserPaymentOption;
import com.safecharge.request.SafechargeCCRequest;
import com.safecharge.util.CardUtils;
import com.safecharge.util.Constants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * A base builder for a credit/debit card specific requests.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see SafechargeBuilder
 * @see SafechargeOrderBuilder
 * @see SafechargeTransactionBuilder
 * @since 4/4/2017
 */
public abstract class SafechargeCCBuilder<T extends SafechargeCCBuilder<T>> extends SafechargeOrderBuilder<T> {

    private CardData cardData;
    private Constants.TransactionType transactionType;
    private UserPaymentOption userPaymentOption;
    private String orderId;
    private int isRebilling;
    private String isPartialApproval;
    private ExternalMpi externalMpi;
    private ExternalTokenProvider externalTokenProvider;
    private String customSiteName;
    private String productId;
    private String customData;
    private String relatedTransactionId;

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
     * Adds transaction type to the request.
     *
     * @param transactionType the type of the transaction. Possible types: {@link com.safecharge.util.Constants.TransactionType}
     * @return this object
     */
    public T addTransactionType(Constants.TransactionType transactionType) {
        this.transactionType = transactionType;
        return (T) this;
    }

    /**
     * Adds user payment option (UPO) to the request. It is the payment option that will be used for the transaction.
     *
     * @param cvv                 the CVV code of the related credit/debit card. Note that CVV is not stored by Safecharge
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
     * Adds user payment option (UPO) to the request. It is the payment option that will be used for the transaction.
     * If CVV is required it should be set in the passed {@code userPaymentOption}.
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
     *
     * @param externalMpi
     * @return
     */
    public T addExternalMpi(ExternalMpi externalMpi) {
        this.externalMpi = externalMpi;
        return (T) this;
    }

    /**
     *
     * @param externalTokenProvider
     * @return
     */
    public T addExternalTokenProvider(ExternalTokenProvider externalTokenProvider) {
        this.externalTokenProvider = externalTokenProvider;
        return (T) this;
    }

    /**
     * The method is used to ad to the builder custom site name which will overwrite the one of the merchant site.
     * @param customSiteName
     * @return
     */
    public T addCustomSiteName(String customSiteName) {
        this.customSiteName = customSiteName;
        return (T) this;
    }

    /**
     * Adds product id to request builder.
     * @param productId
     * @return
     */
    public T addProductId(String productId) {
        this.productId = productId;
        return (T) this;
    }

    /**
     * Adds custom data to request builder.
     * @param customData
     * @return
     */
    public T addCustomData(String customData) {
        this.customData = customData;
        return (T) this;
    }

    /**
     * Adds relatedTransactionId data to request builder.
     * @param relatedTransactionId
     * @return
     */
    public T addRelatedTransactionId(String relatedTransactionId) {
        this.relatedTransactionId = relatedTransactionId;
        return (T) this;
    }

    /**
     * Adds the common credit/debit data, collected by this builder.
     *
     * @param request an already created request of type T
     * @param <S>     type parameter
     * @return the passed {@code request} filled with the data from this builder
     */
    public <S extends SafechargeCCRequest> S build(S request) {

        super.build(request);

        request.setUserPaymentOption(userPaymentOption);
        request.setTransactionType(transactionType);
        request.setCardData(cardData);
        request.setOrderId(orderId);
        request.setIsRebilling(isRebilling);
        request.setExternalMpi(externalMpi);
        request.setIsPartialApproval(isPartialApproval);
        request.setExternalTokenProvider(externalTokenProvider);
        request.setCustomSiteName(customSiteName);
        request.setProductId(productId);
        request.setCustomData(customData);
        request.setRelatedTransactionId(relatedTransactionId);

        return request;
    }
}