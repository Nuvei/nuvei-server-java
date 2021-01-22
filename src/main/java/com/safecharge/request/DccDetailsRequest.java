/*
 * Copyright (c) 2007-2020 SafeCharge International Group Limited.
 */

package com.safecharge.request;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.safecharge.request.builder.SafechargeBuilder;
import com.safecharge.util.APIConstants;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class DccDetailsRequest extends  SafechargeRequest{

    @Size(max = 45)
    private String clientUniqueId;

    @Size(min = 6, max= APIConstants.CREDIT_CARD_MAX_LENGTH, message = "cardNumber size must be up to 20 characters long!")
    private String cardNumber;

    private String apm;

    @NotNull
    private String originalAmount;

    @NotNull
    @Size(min = 3, max = 3, message = "Invalid currency ISO for 'originalCurrency'. Provided currency ISO must be exactly 3 characters long!")
    private String originalCurrency;

    @Size(min = 3, max = 3, message = "Invalid currency ISO for 'currency'. Provided currency ISO must be exactly 3 characters long!")
    private String currency;

    @Size(min = 2, max = 2, message = "Invalid country ISO. Provided country ISO must be exactly 2 characters long!")
    private String country;

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

    public String getApm() {
        return apm;
    }

    public void setApm(String apm) {
        this.apm = apm;
    }

    public String getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(String originalAmount) {
        this.originalAmount = originalAmount;
    }

    public String getOriginalCurrency() {
        return originalCurrency;
    }

    public void setOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "GetDccDetailsRequest{" +
                "clientUniqueId='" + clientUniqueId + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", apm='" + apm + '\'' +
                ", originalAmount='" + originalAmount + '\'' +
                ", originalCurrency='" + originalCurrency + '\'' +
                ", currency='" + currency + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public static class Builder extends SafechargeBuilder<Builder> {

        private String clientUniqueId;
        private String cardNumber;
        private String apm;
        private String originalAmount;
        private String originalCurrency;
        private String currency;
        private String country;

        public Builder addClientUniqueId(String clientUniqueId) {
            this.clientUniqueId = clientUniqueId;
            return this;
        }

        public Builder addCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public Builder addApm(String apm) {
            this.apm = apm;
            return this;
        }

        public Builder addOriginalAmount(String originalAmount) {
            this.originalAmount = originalAmount;
            return this;
        }

        public Builder addOriginalCurrency(String originalCurrency) {
            this.originalCurrency = originalCurrency;
            return this;
        }

        public Builder addCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder addCountry(String country) {
            this.country = country;
            return this;
        }

        @Override
        public DccDetailsRequest build() throws ConstraintViolationException {
            DccDetailsRequest request = new DccDetailsRequest();
            request.setClientUniqueId(clientUniqueId);
            request.setCardNumber(cardNumber);
            request.setApm(apm);
            request.setOriginalAmount(originalAmount);
            request.setOriginalCurrency(originalCurrency);
            request.setCurrency(currency);
            request.setCountry(country);

            return ValidationUtils.validate(super.build(request));
        }
    }
}
