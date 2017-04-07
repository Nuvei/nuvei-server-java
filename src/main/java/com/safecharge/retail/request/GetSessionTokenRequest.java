package com.safecharge.retail.request;

import com.safecharge.retail.request.builder.SafechargeBuilder;
import com.safecharge.retail.util.Constants;
import com.safecharge.retail.util.ValidChecksum;
import com.safecharge.retail.util.ValidationUtil;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class GetSessionTokenRequest extends SafechargeRequest {

    public static Builder builder() {
        return new Builder();
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("GetSessionTokenRequest{");
        sb.append(super.toString())
          .append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeBuilder<Builder> {

        @Override public SafechargeRequest build() {
            return ValidationUtil.validate(super.build(new GetSessionTokenRequest()));
        }
    }
}
