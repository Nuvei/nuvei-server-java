/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.request;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.safecharge.model.Addendums;
import com.safecharge.model.DynamicDescriptor;
import com.safecharge.request.builder.SafechargeTransactionBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * <p>
 * Request to settle a transaction.
 * </p>
 * This request is used for settling an authorization transaction that was previously performed, with a two-phase
 * auth-settle process, for either a full or partial settles. When partial settles are issued – multiple settle requests
 * can be performed for up to the entire amount of the original authorized transaction.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see RefundTransactionRequest
 * @see VoidTransactionRequest
 * @since 3/20/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.SETTLE_GW_TRANSACTION)
public class SettleTransactionRequest
        extends SafechargeTransactionRequest {

    @Size(max = 25, message = "descriptorMerchantName size must be up to 25 characters long!")
    private String descriptorMerchantName;

    @Size(max = 13, message = "descriptorMerchantPhone size must be up to 13 characters long!")
    private String descriptorMerchantPhone;

    @Valid
    private Addendums addendums;

    public static Builder builder() {
        return new Builder();
    }

    public String getDescriptorMerchantName() {
        return descriptorMerchantName;
    }

    public void setDescriptorMerchantName(String descriptorMerchantName) {
        this.descriptorMerchantName = descriptorMerchantName;
    }

    public String getDescriptorMerchantPhone() {
        return descriptorMerchantPhone;
    }

    public void setDescriptorMerchantPhone(String descriptorMerchantPhone) {
        this.descriptorMerchantPhone = descriptorMerchantPhone;
    }

    public Addendums getAddendums() {
        return addendums;
    }

    public void setAddendums(Addendums addendums) {
        this.addendums = addendums;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SettleTransactionRequest{");
        sb.append("descriptorMerchantName='")
                .append(descriptorMerchantName)
                .append('\'');
        sb.append(", descriptorMerchantPhone='")
                .append(descriptorMerchantPhone);
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeTransactionBuilder<Builder> {

        private String descriptorMerchantName;
        private String descriptorMerchantPhone;

        private Addendums addendums;

        /**
         * Sets the Descriptor merchant name in the request.
         *
         * @param descriptorMerchantName - the name that will appear in the payment statement
         * @return this object
         */
        public Builder addDescriptorMerchantName(String descriptorMerchantName) {
            this.descriptorMerchantName = descriptorMerchantName;
            return this;
        }

        /**
         * Sets the Descriptor merchant phone in the request.
         *
         * @param descriptorMerchantPhone - the phone that will appear in the payment statement
         * @return this object
         */
        public Builder addDescriptorMerchantPhone(String descriptorMerchantPhone) {
            this.descriptorMerchantPhone = descriptorMerchantPhone;
            return this;
        }

        /**
         * Adds dynamic descriptor to the request.
         * <p>
         * Note that this request do not send the data as a {@code dynamicDescriptor} JSON,
         * it sends the two params instead: {@code descriptorMerchantName} and {@code descriptorMerchantPhone}
         * </p>
         *
         * @param dynamicDescriptor {@link DynamicDescriptor} object to add to the request
         * @return this object
         */
        public Builder addDynamicDescriptor(DynamicDescriptor dynamicDescriptor) {
            this.descriptorMerchantName = dynamicDescriptor.getMerchantName();
            this.descriptorMerchantPhone = dynamicDescriptor.getMerchantPhone();
            return this;
        }

        public Builder addAddendums(Addendums addendums) {
            this.addendums = addendums;
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
            SettleTransactionRequest settleTransactionRequest = new SettleTransactionRequest();
            settleTransactionRequest.setDescriptorMerchantName(descriptorMerchantName);
            settleTransactionRequest.setDescriptorMerchantPhone(descriptorMerchantPhone);
            settleTransactionRequest.setAddendums(addendums);
            return ValidationUtils.validate(super.build(settleTransactionRequest));
        }
    }
}
