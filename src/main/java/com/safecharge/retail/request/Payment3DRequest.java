package com.safecharge.retail.request;

import com.safecharge.retail.request.builder.SafechargeCCBuilder;
import com.safecharge.retail.util.Constants;
import com.safecharge.retail.util.ValidChecksum;
import com.safecharge.retail.util.ValidationUtil;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/15/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING) public class Payment3DRequest
        extends SafechargeCCRequest {

    private String paResponse;

    public static Builder builder() {
        return new Builder();
    }

    public String getPaResponse() {
        return paResponse;
    }

    public void setPaResponse(String paResponse) {
        this.paResponse = paResponse;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Payment3DRequest{");
        sb.append("paResponse=")
          .append(getPaResponse());
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeCCBuilder<Builder> {

        private String paResponse;

        public Builder addPaResponse(String paResponse) {
            this.paResponse = paResponse;
            return this;
        }

        @Override public SafechargeRequest build() {
            Payment3DRequest request = new Payment3DRequest();
            request.setPaResponse(paResponse);
            return ValidationUtil.validate(super.build(request));
        }

    }
}
