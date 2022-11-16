package com.safecharge.request;

import com.safecharge.request.builder.SafechargeBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

import javax.validation.ConstraintViolationException;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class GetPayoutStatusRequest extends SafechargeRequest {

    public static GetPayoutStatusRequest.Builder builder() {
        return new GetPayoutStatusRequest.Builder();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetPayoutStatusRequest{");
        sb.append(super.toString())
                .append("}");
        return super.toString();
    }

    public static class Builder extends SafechargeBuilder<GetPayoutStatusRequest.Builder> {

        @Override
        public GetPayoutStatusRequest build() throws ConstraintViolationException {
            return ValidationUtils.validate(super.build(new GetPayoutStatusRequest()));
        }
    }
}
