package com.safecharge.request;

import javax.validation.ConstraintViolationException;

import com.safecharge.request.builder.SafechargeTransactionBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Request to refund a transaction.
 * <p>
 * This request can be used to refund a previously settled transaction. Full or partial refunds are supported.
 * When partial refunds are issued, multiple refund requests can be performed for up to the entire amount
 * of the original settled transaction.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see SettleTransactionRequest
 * @see VoidTransactionRequest
 * @since 3/20/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.REFUND_GW_TRANSACTION)
public class RefundTransactionRequest
        extends SafechargeTransactionRequest {

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RefundTransactionRequest{");
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
            RefundTransactionRequest voidTransactionRequest = new RefundTransactionRequest();
            return ValidationUtils.validate(super.build(voidTransactionRequest));
        }
    }

}
