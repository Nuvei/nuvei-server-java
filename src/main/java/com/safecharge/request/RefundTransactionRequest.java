package com.safecharge.request;

import javax.validation.ConstraintViolationException;

import com.safecharge.request.builder.SafechargeTransactionBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
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

        @Override
        public SafechargeRequest build() throws ConstraintViolationException {
            RefundTransactionRequest voidTransactionRequest = new RefundTransactionRequest();
            return ValidationUtils.validate(super.build(voidTransactionRequest));
        }
    }

}
