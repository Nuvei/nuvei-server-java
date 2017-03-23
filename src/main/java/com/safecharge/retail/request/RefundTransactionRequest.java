package com.safecharge.retail.request;

import javax.validation.ConstraintViolationException;

import com.safecharge.retail.request.builder.SafechargeTransactionBuilder;
import com.safecharge.retail.util.Constants;
import com.safecharge.retail.util.ValidChecksum;
import com.safecharge.retail.util.ValidationUtil;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/20/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.REFUND_GW_TRANSACTION) public class RefundTransactionRequest
        extends SafechargeTransactionRequest {

    public static Builder builder() {
        return new Builder();
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("RefundTransactionRequest{");
        sb.append(super.toString())
          .append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeTransactionBuilder<Builder> {

        @Override public SafechargeRequest build() throws ConstraintViolationException {
            RefundTransactionRequest voidTransactionRequest = new RefundTransactionRequest();
            return ValidationUtil.validate(super.build(voidTransactionRequest));
        }
    }

}
