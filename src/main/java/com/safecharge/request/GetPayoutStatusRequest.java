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

    private String clientRequestId;

    @Override
    public String getClientRequestId() {
        return clientRequestId;
    }

    @Override
    public void setClientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetPayoutStatusRequest{");
        sb.append(super.toString());
        sb.append(", clientRequestId='").append(clientRequestId).append('\'');
        sb.append("}");
        return sb.toString();
    }

    public static class Builder extends SafechargeBuilder<GetPayoutStatusRequest.Builder> {

        private String clientRequestId;

        public GetPayoutStatusRequest.Builder addClientRequestId(String clientRequestId) {
            this.clientRequestId = clientRequestId;
            return this;
        }

        @Override
        public GetPayoutStatusRequest build() throws ConstraintViolationException {
            GetPayoutStatusRequest request = new GetPayoutStatusRequest();
            request.setClientRequestId(this.clientRequestId);
            return ValidationUtils.validate(super.build(request));
        }
    }
}
