/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.request;

import javax.validation.ConstraintViolationException;

import com.nuvei.request.builder.NuveiBuilder;
import com.nuvei.util.Constants;
import com.nuvei.util.ValidChecksum;
import com.nuvei.util.ValidationUtils;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class GetPaymentStatusRequest extends NuveiRequest {

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetPaymentStatusRequest{");
        sb.append(super.toString())
                .append("}");
        return super.toString();
    }

    public static class Builder extends NuveiBuilder<Builder> {

        @Override
        public GetPaymentStatusRequest build() throws ConstraintViolationException {
            return ValidationUtils.validate(super.build(new GetPaymentStatusRequest()));
        }
    }
}
