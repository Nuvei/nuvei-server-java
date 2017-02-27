package com.safecharge.retail.request;

import com.safecharge.retail.request.builder.SafechargeBuilder;
import com.safecharge.retail.util.ValidationUtil;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */
public class GetSessionTokenRequest extends BaseSafechargeRequest {

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("GetSessionTokenRequest{");
        sb.append(sb.append(super.toString()));
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeBuilder<Builder> {

        @Override public SafechargeRequest build() {
            SafechargeRequest request = super.build(new GetSessionTokenRequest());
            return ValidationUtil.validate(request);
        }
    }
}
