/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.request;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.nuvei.request.builder.NuveiBuilder;
import com.nuvei.util.APIConstants;
import com.nuvei.util.Constants;
import com.nuvei.util.ValidChecksum;
import com.nuvei.util.ValidationUtils;


/**
 * <p>
 * A request used to retrieve card details such as card brand and type. It will also return amount info.
 * </p>
 * see <a href="https://www.nuvei.com/docs/API/main/indexMain_v1_0.html?json#getCardDetails">getCardDetails</a>
 *
 * @since 7/27/2020
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class CardDetailsRequest extends NuveiRequest {

    @Size(max = 45)
    private String clientUniqueId;

    @NotNull
    @Size(min = 6, max = APIConstants.CREDIT_CARD_MAX_LENGTH)
    private String cardNumber;

    public String getClientUniqueId() {
        return clientUniqueId;
    }

    public void setClientUniqueId(String clientUniqueId) {
        this.clientUniqueId = clientUniqueId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "GetCardDetailsRequest{" +
                "clientUniqueId='" + clientUniqueId + '\'' +
                ", cardNumber='" + cardNumber + '\'' + super.toString() +
                '}';
    }

    public static class Builder extends NuveiBuilder<Builder> {

        private String clientUniqueId;
        private String cardNumber;

        public Builder addClientUniqueId(String clientUniqueId) {
            this.clientUniqueId = clientUniqueId;
            return this;
        }

        public Builder addCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public CardDetailsRequest build() throws ConstraintViolationException {
            CardDetailsRequest request = new CardDetailsRequest();
            request.setClientUniqueId(clientUniqueId);
            request.setCardNumber(cardNumber);

            return ValidationUtils.validate(super.build(request));
        }
    }
}
