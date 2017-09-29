package com.safecharge.request;

import javax.validation.ConstraintViolationException;

import com.safecharge.request.builder.SafechargeTransactionBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Request to void a transaction.
 * <p>
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

        /**
         * Builds the request.
         *
         * @return {@link SafechargeRequest} object build from the params set by this builder
         * @throws ConstraintViolationException if the validation of the params fails
         */
        @Override
        public SafechargeRequest build() throws ConstraintViolationException {
            VoidTransactionRequest voidTransactionRequest = new VoidTransactionRequest();
            return ValidationUtils.validate(super.build(voidTransactionRequest));
        }
    }
}
