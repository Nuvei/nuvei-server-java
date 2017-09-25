package com.safecharge.request;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.safecharge.model.UserAddress;
import com.safecharge.request.builder.SafechargeBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/9/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class AddUPOCreditCardByTempTokenRequest
        extends SafechargeRequest {

    /**
     * The unique identifier generated for each customer.
     */
    @NotNull(message = "userTokenId parameter is mandatory!")
    @Size(min = 1,
            max = 45)
    private String userTokenId;

    /**
     * The temporary hash of the credit card.
     */
    @NotNull(message = "ccTempToken parameter is mandatory!")
    @Size(min = 1,
            max = 45)
    private String ccTempToken;

    /**
     *
     */
    @Valid
    private UserAddress billingAddress;

    public static Builder builder() {
        return new Builder();
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    public String getCcTempToken() {
        return ccTempToken;
    }

    public void setCcTempToken(String ccTempToken) {
        this.ccTempToken = ccTempToken;
    }

    public UserAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(UserAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AddUPOCreditCardByTempTokenRequest{");
        sb.append("userTokenId='")
                .append(userTokenId)
                .append('\'');
        sb.append(", ccTempToken='")
                .append(ccTempToken)
                .append('\'');
        sb.append(", billingAddress=")
                .append(billingAddress);
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeBuilder<Builder> {

        private String userTokenId;
        private String ccTempToken;
        private UserAddress billingAddress;

        public Builder addUserTokenId(String userTokenId) {
            this.userTokenId = userTokenId;
            return this;
        }

        public Builder addCCTempToken(String ccTempToken) {
            this.ccTempToken = ccTempToken;
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

        @Override
        public SafechargeRequest build() throws ConstraintViolationException {
            AddUPOCreditCardByTempTokenRequest addUPOCreditCardByTempTokenRequest = new AddUPOCreditCardByTempTokenRequest();
            addUPOCreditCardByTempTokenRequest.setUserTokenId(userTokenId);
            addUPOCreditCardByTempTokenRequest.setCcTempToken(ccTempToken);
            addUPOCreditCardByTempTokenRequest.setBillingAddress(billingAddress);
            return ValidationUtils.validate(super.build(addUPOCreditCardByTempTokenRequest));
        }
    }
}