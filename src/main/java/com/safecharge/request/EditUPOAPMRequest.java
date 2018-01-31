package com.safecharge.request;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.safecharge.model.UserDetails;
import com.safecharge.model.UserDetailsCashier;
import com.safecharge.request.basic.EditUPOBasicRequest;
import com.safecharge.util.AddressUtils;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * Copyright (C) 2007-2018 SafeCharge International Group Limited.
 * <p>
 * Request to add APM User Payment Option to a User.
 * <p>
 * The goal of this request is to add an APM UPO account for specific users according to their User Token ID.
 * Once an APM UPO is added to a consumer’s UPO list, the APM is displayed in the user’s available payment options on the payment page.
 *
 * @author <a mailto:bozhidarsh@safecharge.com>Bozhidar Shumanov</a>
 * @see AddUPOCreditCardByTempTokenRequest
 * @see AddUPOCreditCardRequest
 * @see com.safecharge.response.AddUPOAPMResponse
 * @since 1/29/2018
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.EDIT_CASHIER_APM)
public class EditUPOAPMRequest extends EditUPOBasicRequest {

    /**
     * A list of name-value pairs that contain the parameters of the user payment option.
     */
    @NotNull(message = "apmData parameter is mandatory!")
    @Size(min = 1, message = "apmData must have at least one entry")
    private Map<String, String> apmData;

    /**
     * Billing address related to a user payment option. Since order can contain only one payment option billing address is part of the order parameters.
     */
    private UserDetailsCashier billingAddress;

    public static Builder builder() {
        return new Builder();
    }

    public Map<String, String> getApmData() {
        return apmData;
    }

    public void setApmData(Map<String, String> apmData) {
        this.apmData = apmData;
    }

    public UserDetailsCashier getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(UserDetailsCashier billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EditUPOAPM{");
        sb.append("billingAddress=")
                .append(billingAddress);
        sb.append(", apmData=")
                .append(apmData);
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder  extends EditUPOBasicRequest.Builder<EditUPOAPMRequest.Builder> {

        UserDetailsCashier billingAddress;
        private Map<String, String> apmData;

        /**
         * Adds map from APM specific data to the request. E.g. username -> user1111, password -> p4ssw0rd
         *
         * @param apmData map of APM specific key-value data
         * @return this object
         */
        public EditUPOAPMRequest.Builder addApmData(Map<String, String> apmData) {
            this.apmData = apmData;
            return this;
        }

        /**
         * Adds one key-value pair of APM specific data to the request.
         *
         * @param key   {@link String} key. E.g. "username"
         * @param value {@link String} value to assign to the {@code key}. E.g. "user1111"
         * @return this object
         */
        public EditUPOAPMRequest.Builder addApmDataEntry(String key, String value) {

            if (apmData == null) {
                apmData = new HashMap<>();
            }
            apmData.put(key, value);
            return this;
        }

        /**
         * Adds billing address data to the request.
         *
         * @param billingAddress {@link UserDetails} object to get the billing details from
         * @return this object
         */
        public EditUPOAPMRequest.Builder addBillingAddress(UserDetailsCashier billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        /**
         * Adds billing address data to the request.
         *
         * @param firstName   The first name of the recipient
         * @param lastName    The last name of the recipient
         * @param address     The address of the recipient
         * @param phone       The phone number of the recipient
         * @param zip         The postal code of the recipient
         * @param city        The city of the recipient
         * @param countryCode The country of the recipient(two-letter ISO country code)
         * @param state       The state of the recipient(two-letter ISO state code)
         * @param email       The email of the recipient
         * @param birthdate The date of birth of the recipient
         * @param locale The date of birth of the recipient
         * @return this object
         */
        public EditUPOAPMRequest.Builder addBillingAddress(String address, String city, String countryCode, String email, String firstName,
                                         String lastName, String phone, String state, String zip, String birthdate,
                                         String county, String locale) {

            UserDetailsCashier billingAddress = AddressUtils.createUserDetailsCashierFromParams(address, city, countryCode, email, firstName,
                    lastName, phone, state, zip, birthdate, county, locale);
            return addBillingAddress(billingAddress);
        }

        /**
         * Builds the request.
         *
         * @return {@link SafechargeRequest} object build from the params set by this builder
         * @throws ConstraintViolationException if the validation of the params fails
         */
        @Override
        public SafechargeBaseRequest build() throws ConstraintViolationException {

            EditUPOAPMRequest editUPOAPMRequest = new EditUPOAPMRequest();
            editUPOAPMRequest.setApmData(apmData);
            editUPOAPMRequest.setBillingAddress(billingAddress);

            return ValidationUtils.validate(super.build(editUPOAPMRequest));
        }
    }
}
