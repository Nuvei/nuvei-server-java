package com.safecharge.request;

import com.safecharge.request.builder.SafechargeCCBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtil;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING) public class Authorization3DRequest
        extends SafechargeCCRequest {

    public static Builder builder() {
        return new Builder();
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Authorization3DRequest{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeCCBuilder<Builder> {

        @Override public SafechargeRequest build() {
            Authorization3DRequest request = new Authorization3DRequest();
            return ValidationUtil.validate(super.build(request));
        }
    }
}
