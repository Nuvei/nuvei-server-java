package com.safecharge.retail.request;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.safecharge.retail.model.CardData;
import com.safecharge.retail.model.UserAddress;
import com.safecharge.retail.request.builder.SafechargeOrderBuilder;
import com.safecharge.retail.util.APIConstants;
import com.safecharge.retail.util.Constants;
import com.safecharge.retail.util.ValidChecksum;
import com.safecharge.retail.util.ValidationUtil;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/15/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class CardTokenizationRequest extends SafechargeRequest {

    @Valid private CardData cardData;

    @Valid private UserAddress billingAddress;

    @Size(max = 255,
          message = "userTokenId size must be up to 255 characters long!") private String userTokenId;

    @Pattern(regexp = APIConstants.IP_ADDRESS_REGEX,
             message = "the entered value is not a valid ipAddress") private String ipAddress;

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

    @Override public String toString() {
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
        sb.append(", ")
          .append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeOrderBuilder<Builder> {

        private CardData cardData;
        private UserAddress billingAddress;
        private String userTokenId;
        private String ipAddress;

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

        public Builder addCardData(CardData cardData) {
            this.cardData = cardData;
            return this;
        }

        public Builder addBillingAddress(String firstName, String lastName, String email, String phone, String address, String city, String country,
                String state, String zip, String cell) {

            UserAddress billingAddress = new UserAddress();
            billingAddress.setFirstName(firstName);
            billingAddress.setLastName(lastName);
            billingAddress.setEmail(email);
            billingAddress.setPhone(phone);
            billingAddress.setAddress(address);
            billingAddress.setCity(city);
            billingAddress.setCountry(country);
            billingAddress.setState(state);
            billingAddress.setZip(zip);
            billingAddress.setCell(cell);

            return addBillingAddress(billingAddress);
        }

        public Builder addBillingAddress(UserAddress billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        public Builder addUserTokenId(String userTokenId) {
            this.userTokenId = userTokenId;
            return this;
        }

        public Builder addIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        @Override public SafechargeRequest build() {
            CardTokenizationRequest cardTokenizationRequest = new CardTokenizationRequest();
            cardTokenizationRequest.setUserTokenId(userTokenId);
            cardTokenizationRequest.setIpAddress(ipAddress);
            cardTokenizationRequest.setCardData(cardData);
            cardTokenizationRequest.setBillingAddress(billingAddress);
            return ValidationUtil.validate(super.build(cardTokenizationRequest));

        }
    }
}
