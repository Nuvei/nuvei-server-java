/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.request;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.safecharge.model.*;
import com.safecharge.request.builder.SafechargeOrderWithDetailsBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * <p>
 * Request to create an order in the SafeCharge's system.
 * </p>
 * This request represents the state of the order when it is created, it can be changed at later time.
 * Note that no payment request is send, it is used mainly to store the order details at the time of creation.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see GetOrderDetailsRequest
 * @see UpdateOrderRequest
 * @since 2/15/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class OpenOrderRequest extends OrderRequestWithDetails {

    private String customSiteName;

    @Size(max = 50, message = "productId size must be up to 50 characters long!")
    private String productId;

    @Valid
    private OpenOrderPaymentOption paymentOption;

    private Constants.TransactionType transactionType;

    private String authenticationOnlyType;

    @Valid
    private SubMerchant subMerchant;

    private Integer isRebilling;

    @Size(max = 10)
    private String rebillingType;

    @Size(max = 1)
    private String preventOverride;

    @Size(max = 1)
    private String isPartialApproval;

    public String getCustomSiteName() {
        return customSiteName;
    }

    public void setCustomSiteName(String customSiteName) {
        this.customSiteName = customSiteName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public OpenOrderPaymentOption getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(OpenOrderPaymentOption paymentOption) {
        this.paymentOption = paymentOption;
    }

    public Constants.TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Constants.TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getAuthenticationOnlyType() {
        return authenticationOnlyType;
    }

    public void setAuthenticationOnlyType(String authenticationOnlyType) {
        this.authenticationOnlyType = authenticationOnlyType;
    }

    public SubMerchant getSubMerchant() {
        return subMerchant;
    }

    public void setSubMerchant(SubMerchant subMerchant) {
        this.subMerchant = subMerchant;
    }

    public Integer getIsRebilling() {
        return isRebilling;
    }

    public void setIsRebilling(Integer isRebilling) {
        this.isRebilling = isRebilling;
    }

    public String getRebillingType() {
        return rebillingType;
    }

    public void setRebillingType(String rebillingType) {
        this.rebillingType = rebillingType;
    }

    public String getPreventOverride() {
        return preventOverride;
    }

    public void setPreventOverride(String preventOverride) {
        this.preventOverride = preventOverride;
    }

    public String getIsPartialApproval() {
        return isPartialApproval;
    }

    public void setIsPartialApproval(String isPartialApproval) {
        this.isPartialApproval = isPartialApproval;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OpenOrderRequest{");
        sb.append(super.toString());
        sb.append(", customSiteName=").append(customSiteName)
                .append(", productId=").append(productId)
                .append(", paymentOption=").append(paymentOption)
                .append(", transactionType=").append(transactionType)
                .append(", authenticationOnlyType=").append(authenticationOnlyType)
                .append(", subMerchant=").append(subMerchant)
                .append(", isRebilling=").append(isRebilling)
                .append(", rebillingType=").append(rebillingType)
                .append(", preventOverride=").append(preventOverride)
                .append(", isPartialApproval=").append(isPartialApproval);
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeOrderWithDetailsBuilder<Builder> {

        private String customSiteName;
        private String productId;
        private OpenOrderPaymentOption paymentOption;
        private Constants.TransactionType transactionType;
        private String authenticationOnlyType;
        private SubMerchant subMerchant;
        private Integer isRebilling;
        private String rebillingType;
        private String paymentMethod;
        private String preventOverride;
        private String isPartialApproval;
        private ExternalSchemeDetails externalSchemeDetails;
        private CurrencyConversion currencyConversion;
        private OpenAmount openAmount;
        private String aftOverride;


        public Builder addCustomSiteName(String customSiteName) {
            this.customSiteName = customSiteName;
            return this;
        }

        public Builder addProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder addOpenOrderPaymentOption(OpenOrderPaymentOption paymentOption) {
            this.paymentOption = paymentOption;
            return this;
        }

        public Builder addTransactionType(Constants.TransactionType transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public Builder addAuthenticationOnlyType(String authenticationOnlyType) {
            this.authenticationOnlyType = authenticationOnlyType;
            return this;
        }

        public Builder addSubMerchant(SubMerchant subMerchant) {
            this.subMerchant = subMerchant;
            return this;
        }

        public Builder addIsRebilling(Integer isRebilling) {
            this.isRebilling = isRebilling;
            return this;
        }

        public Builder addRebillingType(String rebillingType) {
            this.rebillingType = rebillingType;
            return this;
        }

        public Builder addPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder addPreventOverride(String preventOverride) {
            this.preventOverride = preventOverride;
            return this;
        }

        public Builder addExternalSchemaDetails(ExternalSchemeDetails externalSchemeDetails) {
            this.externalSchemeDetails = externalSchemeDetails;
            return this;
        }

        public Builder addCurrencyConversion(CurrencyConversion currencyConversion) {
            this.currencyConversion = currencyConversion;
            return this;
        }

        public Builder addOpenAmount(OpenAmount openAmount) {
            this.openAmount = openAmount;
            return this;
        }

        public Builder addAftOverride(String aftOverride) {
            this.aftOverride = aftOverride;
            return this;
        }

        public Builder addIsPartialApproval(String isPartialApproval) {
            this.isPartialApproval = isPartialApproval;
            return this;
        }
        /**
         * Builds the request.
         *
         * @return {@link SafechargeRequest} object build from the params set by this builder
         */
        @Override
        public SafechargeBaseRequest build() {
            OpenOrderRequest request = new OpenOrderRequest();
            request.setCustomSiteName(customSiteName);
            request.setProductId(productId);
            request.setPaymentOption(paymentOption);
            request.setTransactionType(transactionType);
            request.setAuthenticationOnlyType(authenticationOnlyType);
            request.setSubMerchant(subMerchant);
            request.setIsRebilling(isRebilling);
            request.setRebillingType(rebillingType);
            request.setPaymentMethod(paymentMethod);
            request.setPreventOverride(preventOverride);
            request.setIsPartialApproval(isPartialApproval);
            request.setExternalSchemeDetails(externalSchemeDetails);
            request.setCurrencyConversion(currencyConversion);
            request.setOpenAmount(openAmount);
            request.setAftOverride(aftOverride);

            return ValidationUtils.validate(super.build(request));
        }
    }
}

