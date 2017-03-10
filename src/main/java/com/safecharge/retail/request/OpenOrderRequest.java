package com.safecharge.retail.request;

import com.safecharge.retail.request.builder.SafechargeOrderBuilder;
import com.safecharge.retail.util.ValidationUtil;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/15/2017
 */
public class OpenOrderRequest extends BaseSafechargeOrderDetailsRequest {

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("OpenOrderRequest{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeOrderBuilder<Builder> {

        @Override public SafechargeRequest build() {
            SafechargeRequest openOrderRequest = super.build(new OpenOrderRequest());
            return ValidationUtil.validate(openOrderRequest);
        }
    }
}
