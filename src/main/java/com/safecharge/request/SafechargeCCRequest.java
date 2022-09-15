package com.safecharge.request;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.safecharge.model.CardData;
import com.safecharge.model.ExternalMpi;
import com.safecharge.model.ExternalSchemeDetails;
import com.safecharge.model.ExternalTokenProvider;
import com.safecharge.model.StoredCredentials;
import com.safecharge.model.UserPaymentOption;

/**
 * Copyright (C) 2007-2020 SafeCharge International Group Limited.
 * <p>
 * Abstract class to be used as a base for credit card payment requests.
 * </p>
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 4/10/2017
 */
public abstract class SafechargeCCRequest extends SafechargePaymentRequest implements SafechargeOrderRequest {

    /**
     * MerchantOrderID to be used as input parameter in update method and payment methods. The parameter passed to define which merchant order to update.
     */
    @Size(max = 45)
    private String orderId;

    /**
     * Card data must be passed as parameter in the payment methods and not before that in the payment flow (openOrder, updateOrder)
     * since it's not allowed to be saved in the Checkout Page DB.
     * <p>
     * cardNumber <br />
     * cardHolderName <br />
     * expirationMonth <br />
     * expirationYear <br />
     * cvv <br />
     * </p>
     * OR
     * <p>
     * cardToken <br />
     * cvv
     * </p>
     */
    @Valid
    private CardData cardData;

    /**
     * User payment option can to be provided as an alternative for providing card data/card token/Apple Pay token.
     * Only one of them can be in use for a certain transaction. If both not provided or both provided it will cause an error.
     * <p>
     * SafeCharge decide per client in gateway and per site in Checkout Page, weather CVV is mandatory to be provided with a UPO.
     * Sending CVV will gain a getter interchange. if neded it will be sent by the merchant in cardData class, cvv parameter.
     * </p>
     */
    @Valid
    private UserPaymentOption userPaymentOption;

    /**
     * Param indicating whether this is a regular transaction (0) or a recurring/re-billing transaction (1).
     * <p>
     * Re-bill can only be performed using a user payment option (UPO) ID, and not with card data or card token.
     * The re-bill transaction is based on a previous successful transaction performed using the same UPO ID.
     * This allows the merchant to manage the subscription on its side and send only re-bill transactions.
     * </p>
     */
    @Max(value = 1)
    @Min(value = 0)
    private int isRebilling;

    @Size(max = 1)
    private String isPartialApproval;

    @Valid
    private ExternalMpi externalMpi;

    @Valid
    private ExternalTokenProvider externalTokenProvider;

    @Valid
    private StoredCredentials storedCredentials;

    @Valid
    private ExternalSchemeDetails externalSchemeDetails;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public CardData getCardData() {
        return cardData;
    }

    public void setCardData(CardData cardData) {
        this.cardData = cardData;
    }

    public UserPaymentOption getUserPaymentOption() {
        return userPaymentOption;
    }

    public void setUserPaymentOption(UserPaymentOption userPaymentOption) {
        this.userPaymentOption = userPaymentOption;
    }

    public int getIsRebilling() {
        return isRebilling;
    }

    public void setIsRebilling(int isRebilling) {
        this.isRebilling = isRebilling;
    }

    public String getIsPartialApproval() {
        return isPartialApproval;
    }

    public void setIsPartialApproval(String isPartialApproval) {
        this.isPartialApproval = isPartialApproval;
    }

    public ExternalMpi getExternalMpi() {
        return externalMpi;
    }

    public void setExternalMpi(ExternalMpi externalMpi) {
        this.externalMpi = externalMpi;
    }

    public ExternalTokenProvider getExternalTokenProvider() {
        return externalTokenProvider;
    }

    public void setExternalTokenProvider(ExternalTokenProvider externalTokenProvider) {
        this.externalTokenProvider = externalTokenProvider;
    }

    public StoredCredentials getStoredCredentials() {
        return storedCredentials;
    }

    public void setStoredCredentials(StoredCredentials storedCredentials) {
        this.storedCredentials = storedCredentials;
    }

    public ExternalSchemeDetails getExternalSchemeDetails() {
        return externalSchemeDetails;
    }

    public void setExternalSchemeDetails(ExternalSchemeDetails externalSchemeDetails) {
        this.externalSchemeDetails = externalSchemeDetails;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SafechargeCCRequest{");
        sb.append(super.toString());
        sb.append("orderId='").append(orderId).append('\'');
        sb.append(", cardData=").append(cardData);
        sb.append(", userPaymentOption=").append(userPaymentOption);
        sb.append(", isRebilling=").append(isRebilling);
        sb.append(", isPartialApproval='").append(isPartialApproval).append('\'');
        sb.append(", externalMpi=").append(externalMpi);
        sb.append(", externalTokenProvider=").append(externalTokenProvider);
        sb.append(", storedCredentials='").append(storedCredentials).append('\'');
        sb.append(", externalSchemeDetails='").append(externalSchemeDetails).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
