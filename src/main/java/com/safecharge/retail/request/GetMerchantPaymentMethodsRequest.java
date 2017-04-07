package com.safecharge.retail.request;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Size;

import com.safecharge.retail.request.builder.SafechargeBuilder;
import com.safecharge.retail.util.Constants;
import com.safecharge.retail.util.ValidChecksum;
import com.safecharge.retail.util.ValidationUtil;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 4/6/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING) public class GetMerchantPaymentMethodsRequest
        extends SafechargeRequest {

    @Size(max = 3,
          message = "currencyCode size must be up to 3 characters long!") private String currencyCode;

    @Size(max = 3,
          message = "countryCode size must be up to 3 characters long!") private String countryCode;

    @Size(max = 3,
          message = "languageCode size must be up to 3 characters long!") private String languageCode;

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

    @Override public String toString() {
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

        public Builder addCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }

        public Builder addCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Builder addLanguageCode(String languageCode) {
            this.languageCode = languageCode;
            return this;
        }

        @Override public SafechargeRequest build() throws ConstraintViolationException {
            GetMerchantPaymentMethodsRequest getMerchantPaymentMethodsRequest = new GetMerchantPaymentMethodsRequest();
            super.build(getMerchantPaymentMethodsRequest);
            getMerchantPaymentMethodsRequest.setCountryCode(countryCode);
            getMerchantPaymentMethodsRequest.setCurrencyCode(currencyCode);
            getMerchantPaymentMethodsRequest.setLanguageCode(languageCode);
            return ValidationUtil.validate(getMerchantPaymentMethodsRequest);
        }
    }

}
