package com.safecharge.request;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.safecharge.model.CardData;
import com.safecharge.model.UserPaymentOption;
import com.safecharge.util.Constants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 4/10/2017
 */
public abstract class SafechargeCCRequest extends SafechargeOrderDetailsRequest implements SafechargeOrderRequest {

    /**
     * MerchantOrderID to be used as input parameter in update method and payment methods. The parameter passed to define which merchant order to update.
     */
    @Size(max = 45) private String orderId;

    /**
     * Transaction Type of the request. Possible values: Auth / Sale.
     */
    private Constants.TransactionType transactionType;

    /**
     * Card data must be passed as parameter in the payment methods and not before that in the payment flow (openOrder, updateOrder) since it's not allowed to be saved in the cashier/checkout DB.
     * <p>
     * cardNumber <br />
     * cardHolderName <br />
     * expirationMonth <br />
     * expirationYear <br />
     * cvv <br />
     * <p>
     * OR
     * <p>
     * cardToken <br />
     * cvv
     *
     * @return cardData
     */
    @Valid private CardData cardData;

    /**
     * User payment option can to be provided as an alternative for providing card data/card token/Apple Pay token. Only one of them can be in use for a certain transaction. If both not provided or both provided it will cause an error.
     * <p>
     * SafeCharge decide per client in gateway and per site in cashier, weather CVV is mandatory to be provided with a UPO. Sending CVV will gain a getter interchange. if neded it will be sent by the merchant in cardData class, cvv parameter.
     *
     * @return
     */
    @Valid private UserPaymentOption userPaymentOption;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Constants.TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Constants.TransactionType transactionType) {
        this.transactionType = transactionType;
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

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("orderId='")
          .append(orderId)
          .append('\'');
        sb.append(", transactionType=")
          .append(transactionType);
        sb.append(", cardData=")
          .append(cardData);
        sb.append(", userPaymentOption=")
          .append(userPaymentOption);
        sb.append(", ");
        sb.append(super.toString());
        return sb.toString();
    }
}
