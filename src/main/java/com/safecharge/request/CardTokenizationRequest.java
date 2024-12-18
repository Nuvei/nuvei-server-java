/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.safecharge.model.CardData;
import com.safecharge.model.UserAddress;
import com.safecharge.request.builder.SafechargeBaseOrderBuilder;
import com.safecharge.util.APIConstants;
import com.safecharge.util.AddressUtils;
import com.safecharge.util.CardUtils;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * <p>
 * Request to obtain a temporary card token.
 * </p>
 * High-level PCI certified merchants can work with this API request fully server to server, as well as perform credit card payments using the {@link PaymentCCRequest}.
 * <p>
 * This method is intended for low-level PCI certified merchants implementing card tokenization.
 * For security and PCI reasons, please note that low-level PCI certified merchants that cannot enter card data on their side
 * and use a native mobile application are not required to use the credit card tokenization client SDK.
 * However, they are able to use this {@link CardTokenizationRequest} directly.
 * </p>
 * Low-level PCI certified merchants that cannot enter card data on their side and use an online website are required to use
 * the credit card tokenization client SDK, according to the instructions <a href="https://www.safecharge.com/docs/api/?java#cardTokenization">here</a>
 * which performs credit card tokenization for them.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see <a href="https://www.safecharge.com/docs/api/?java#cardTokenization">Credit Card tokenization</a>
 * @see AddUPOCreditCardByTempTokenRequest
 * @since 2/15/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class CardTokenizationRequest extends SafechargeBaseRequest {

    /**
     * Valid card details to generate the token for.
     */
    @Valid
    @NotNull
    private CardData cardData;

    /**
     * Valid card holder's address. It will be used as billing address for orders made with the generated card token.
     */
    @Valid
    private UserAddress billingAddress;

    /**
     * The ID of the user token to add to the request.
     */
    @Size(max = 255, message = "userTokenId size must be up to 255 characters long!")
    private String userTokenId;

    /**
     * TODO: Check if this is required param ?!?
     */
    private String ipAddress;

    @Valid
    private Constants.VerifiedPaymentMethod isVerified;

    public static Builder builder() {
        return new Builder();
    }

    public CardData getCardData() {
        return cardData;
    }

    public void setCardData(CardData cardData) {
        this.cardData = cardData;
    }

    public UserAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(UserAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    public Constants.VerifiedPaymentMethod getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Constants.VerifiedPaymentMethod isVerified) {
        this.isVerified = isVerified;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CardTokenizationRequest{");
        sb.append("cardData=")
                .append(cardData);
        sb.append(", billingAddress=")
                .append(billingAddress);
        sb.append(", userTokenId='")
                .append(userTokenId)
                .append('\'');
        sb.append(", ipAddress='")
                .append(ipAddress)
                .append('\'');
        sb.append(", ");
        sb.append(", isVerified='")
                .append(isVerified)
                .append('\'');
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeBaseOrderBuilder<Builder> {

        private CardData cardData;
        private UserAddress billingAddress;
        private String userTokenId;
        private String ipAddress;
        private Constants.VerifiedPaymentMethod isVerified;

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
        public Builder addCardData(String cardNumber, String cardHolderName, String expirationMonth, String expirationYear, String cardToken, String cvv) {

            CardData cardData = CardUtils.createCardDataFromParams(cardNumber, cardHolderName, expirationMonth, expirationYear, cardToken, cvv);

            return addCardData(cardData);
        }

        /**
         * Adds card data to the request.
         *
         * @param cardData {@link CardData} object to set to the request
         * @return this object
         */
        public Builder addCardData(CardData cardData) {
            this.cardData = cardData;
            return this;
        }

        /**
         * Adds billing info to the request.
         *
         * @param firstName The first name of the recipient
         * @param lastName  The last name of the recipient
         * @param email     The email of the recipient
         * @param phone     The phone number of the recipient
         * @param address   The address of the recipient
         * @param city      The city of the recipient
         * @param country   The country of the recipient(two-letter ISO country code)
         * @param state     The state of the recipient(two-letter ISO state code)
         * @param zip       The postal code of the recipient
         * @param cell      The cell number of the recipient
         * @param county    The county of the recipient
         * @return this object
         */
        public Builder addBillingAddress(String firstName, String lastName, String email, String phone, String address, String city, String country,
                                         String state, String zip, String cell, String county) {

            UserAddress billingAddress = AddressUtils.createUserAddressFromParams(firstName, lastName, email, phone, address,
                    city, country, state, zip, cell, county);

            return addBillingAddress(billingAddress);
        }

        /**
         * Adds billing info to the request.
         *
         * @param firstName The first name of the recipient
         * @param lastName  The last name of the recipient
         * @param email     The email of the recipient
         * @param phone     The phone number of the recipient
         * @param address   The address of the recipient
         * @param city      The city of the recipient
         * @param country   The country of the recipient(two-letter ISO country code)
         * @param state     The state of the recipient(two-letter ISO state code)
         * @param zip       The postal code of the recipient
         * @param cell      The cell number of the recipient
         * @param county    The county of the recipient
         * @param addressLine2 The address line 2 of the recipient's address
         * @param addressLine3 The address line 3 of the recipient's address
         * @param shipAddressLine2 The shipping address line 2 of the recipient's address
         * @param shipAddressLine3 The shipping address line 3 of the recipient's address
         * @return this object
         */
        public Builder addBillingAddress(String firstName, String lastName, String email, String phone, String address, String city, String country,
                                         String state, String zip, String cell, String county, String addressLine2, String addressLine3, String shipAddressLine2,
                                         String shipAddressLine3) {

            UserAddress billingAddress = AddressUtils.createUserAddressFromParams(firstName, lastName, email, phone, address,
                    city, country, state, zip, cell, county, addressLine2, addressLine3, shipAddressLine2, shipAddressLine3);

            return addBillingAddress(billingAddress);
        }

        /**
         * Adds billing info to the request.
         *
         * @param billingAddress {@link UserAddress} object to add to the request as billing details
         * @return this object
         */
        public Builder addBillingAddress(UserAddress billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        /**
         * Adds user token id to the request.
         *
         * @param userTokenId The user token as {@link String}
         * @return this object
         */
        public Builder addUserTokenId(String userTokenId) {
            this.userTokenId = userTokenId;
            return this;
        }

        /**
         * Adds user IP address to the request.
         *
         * @param ipAddress the IP address as {@link String} to add to the request
         * @return this object
         */
        public Builder addIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        public Builder addIsVerified(Constants.VerifiedPaymentMethod isVerified) {
            this.isVerified = isVerified;
            return this;
        }

        /**
         * Builds the request.
         *
         * @return this object
         */
        @Override
        public SafechargeBaseRequest build() {
            CardTokenizationRequest cardTokenizationRequest = new CardTokenizationRequest();
            cardTokenizationRequest.setUserTokenId(userTokenId);
            cardTokenizationRequest.setIpAddress(ipAddress);
            cardTokenizationRequest.setCardData(cardData);
            cardTokenizationRequest.setBillingAddress(billingAddress);
            cardTokenizationRequest.setIsVerified(isVerified);
            return ValidationUtils.validate(super.build(cardTokenizationRequest));

        }
    }
}
