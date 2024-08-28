/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.request;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.safecharge.request.builder.SafechargeTransactionBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * <p>
 * Request to void a transaction.
 * </p>
 * This request is used for voiding a previously performed authorization, within a two-phase auth-settle process.
 * Please note that a void action is not always supported by the payment method or the card issuer.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see RefundTransactionRequest
 * @see SettleTransactionRequest
 * @since 3/20/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.VOID_GW_TRANSACTION)
public class VoidTransactionRequest
        extends SafechargeTransactionRequest {

    /**
     * The ID of the original auth transaction.
     */
    @NotNull(message = "relatedTransactionId parameter is mandatory!")
    @Size(max = 19)
    private String relatedTransactionId;

    public String getRelatedTransactionId() {
        return relatedTransactionId;
    }

    public void setRelatedTransactionId(String relatedTransactionId) {
        this.relatedTransactionId = relatedTransactionId;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VoidTransactionRequest{");
        sb.append(super.toString())
                .append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeTransactionBuilder<Builder> {

        private String relatedTransactionId;

        /**
         * Adds related transaction id to the request.
         *
         * @param relatedTransactionId the related transaction id to add to the request
         * @return this object
         */
        public Builder addRelatedTransactionId(String relatedTransactionId) {
            this.relatedTransactionId = relatedTransactionId;
            return this;
        }

        /**
         * Builds the request.
         *
         * @return {@link VoidTransactionRequest} object build from the params set by this builder
         * @throws ConstraintViolationException if the validation of the params fails
         */
        @Override
        public VoidTransactionRequest build() throws ConstraintViolationException {
            VoidTransactionRequest voidTransactionRequest = new VoidTransactionRequest();
            voidTransactionRequest.setRelatedTransactionId(relatedTransactionId);

            return ValidationUtils.validate(super.build(voidTransactionRequest));
        }
    }
}
