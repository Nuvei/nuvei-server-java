package com.safecharge.retail.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.safecharge.retail.model.CardData;
import com.safecharge.retail.model.UserPaymentOption;
import com.safecharge.retail.request.builder.SafechargeOrderBuilder;
import com.safecharge.retail.util.Constants;
import com.safecharge.retail.util.ValidationUtil;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/15/2017
 */
public class PaymentCCRequest extends BaseSafechargeOrderDetailsRequest implements SafechargeOrderRequest {

    @NotNull(message = "orderId parameter is mandatory!") @Size(max = 45) private String orderId;

    @NotNull(message = "transactionType parameter is mandatory!") private Constants.TransactionType transactionType;

    @Valid private CardData cardData;

    @Valid private UserPaymentOption userPaymentOption;

    public String getOrderId() {
        return orderId;
    }

    @Override public void setOrderId(String orderId) {
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
        final StringBuilder sb = new StringBuilder("PaymentCCRequest{");
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
        sb.append(sb.append(super.toString()));
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeOrderBuilder<Builder> {

        private CardData cardData;
        private Constants.TransactionType transactionType;
        private UserPaymentOption userPaymentOption;
        private String orderId;

        public Builder() {
            super();
        }

        public Builder addOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder addTransactionType(Constants.TransactionType transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public Builder addUserPaymentOption(String cvv, String userPaymentOptionId) {
            UserPaymentOption userPaymentOption = new UserPaymentOption();
            userPaymentOption.setCVV(cvv);
            userPaymentOption.setUserPaymentOptionId(userPaymentOptionId);
            return addUserPaymentOption(userPaymentOption);
        }

        public Builder addUserPaymentOption(UserPaymentOption userPaymentOption) {
            this.userPaymentOption = userPaymentOption;
            return this;
        }

        public Builder addCardData(CardData cardData) {
            this.cardData = cardData;
            return this;
        }

        public Builder addCardData(String cardNumber, String cardHolderName, String expirationMonth, String expirationYear, String cardToken,
                String cvv) {
            CardData cardData = new CardData();
            cardData.setCardNumber(cardNumber);
            cardData.setCardHolderName(cardHolderName);
            cardData.setExpirationMonth(expirationMonth);
            cardData.setExpirationYear(expirationYear);
            cardData.setCardToken(cardToken);
            cardData.setCVV(cvv);
            return addCardData(cardData);
        }

        @Override public SafechargeRequest build() {
            PaymentCCRequest request = super.build(new PaymentCCRequest());
            request.setUserPaymentOption(userPaymentOption);
            request.setTransactionType(transactionType);
            request.setCardData(cardData);
            request.setOrderId(orderId);
            return ValidationUtil.validate(request);
        }
    }
}
