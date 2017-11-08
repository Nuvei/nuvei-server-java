package com.safecharge.request;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Size;

import com.safecharge.request.builder.SafechargeBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Request to retrieve the available payment option for a specific merchant.
 * <p>
 * Allows the merchant view the names, IDs and other information regarding the enabled payment methods and APMs,
 * which may be filtered based on country, currency and language.
 * It may be used by the merchant mostly in order to display the available payment methods in its payment page.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 4/6/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class GetMerchantPaymentMethodsRequest
        extends SafechargeRequest {

    /**
     * The three letter ISO currency code that the transaction is to be completed in.
     */
    @Size(min = 3, max = 3, message = "currencyCode size must be 3 characters long!")
    private String currencyCode;
    /**
     * The two-letter ISO country code the transaction is to be completed in.
     */
    @Size(min = 2, max = 2, message = "countryCode size must be 2 characters long!")
    private String countryCode;

    /**
     * The language the transaction is to be completed in.
     */
    @Size(min = 2, max = 3, message = "languageCode size must be 2 or 3 characters long!")
    private String languageCode;

    public static Builder builder() {
        return new Builder();
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetMerchantPaymentMethodsRequest{");
        sb.append("currencyCode='")
                .append(currencyCode)
                .append('\'');
        sb.append(", countryCode='")
                .append(countryCode)
                .append('\'');
        sb.append(", languageCode='")
                .append(languageCode)
                .append('\'');
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeBuilder<Builder> {

        private String currencyCode;
        private String countryCode;
        private String languageCode;

        /**
         * Adds currency code to the request.
         *
         * @param currencyCode The two-letter ISO country code the transaction is to be completed in
         * @return this object
         */
        public Builder addCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }

        /**
         * Adds country code to the request.
         *
         * @param countryCode The two-letter ISO country code the transaction is to be completed in.
         * @return this object
         */
        public Builder addCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        /**
         * Adds language code to the request.
         *
         * @param languageCode The language the transaction is to be completed in.
         * @return this object
         */
        public Builder addLanguageCode(String languageCode) {
            this.languageCode = languageCode;
            return this;
        }

        /**
         * Builds the request.
         *
         * @return {@link SafechargeRequest} object build from the params set by this builder
         * @throws ConstraintViolationException if the validation of the params fails
         */
        @Override
        public SafechargeBaseRequest build() throws ConstraintViolationException {
            GetMerchantPaymentMethodsRequest getMerchantPaymentMethodsRequest = new GetMerchantPaymentMethodsRequest();
            super.build(getMerchantPaymentMethodsRequest);
            getMerchantPaymentMethodsRequest.setCountryCode(countryCode);
            getMerchantPaymentMethodsRequest.setCurrencyCode(currencyCode);
            getMerchantPaymentMethodsRequest.setLanguageCode(languageCode);
            return ValidationUtils.validate(getMerchantPaymentMethodsRequest);
        }
    }

}
