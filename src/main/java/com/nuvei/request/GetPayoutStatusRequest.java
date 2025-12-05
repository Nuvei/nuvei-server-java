/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.request;

import com.nuvei.request.builder.NuveiBuilder;
import com.nuvei.util.Constants;
import com.nuvei.util.ValidChecksum;
import com.nuvei.util.ValidationUtils;

import javax.validation.ConstraintViolationException;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class GetPayoutStatusRequest extends NuveiRequest {

    public static GetPayoutStatusRequest.Builder builder() {
        return new GetPayoutStatusRequest.Builder();
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetPayoutStatusRequest{");
        sb.append(super.toString());
        sb.append("}");
        return sb.toString();
    }

    public static class Builder extends NuveiBuilder<Builder> {

        @Override
        public GetPayoutStatusRequest build() throws ConstraintViolationException {
            return ValidationUtils.validate(super.build(new GetPayoutStatusRequest()));
        }
    }
}
