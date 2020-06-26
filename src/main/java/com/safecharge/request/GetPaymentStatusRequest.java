package com.safecharge.request;

import javax.validation.ConstraintViolationException;

import com.safecharge.request.builder.SafechargeBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class GetPaymentStatusRequest extends SafechargeRequest {

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

    public static class Builder extends SafechargeBuilder<Builder> {

        @Override
        public GetPaymentStatusRequest build() throws ConstraintViolationException {
            return ValidationUtils.validate(super.build(new GetPaymentStatusRequest()));
        }
    }
}
