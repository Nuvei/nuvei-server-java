package com.safecharge.retail.request;

import com.safecharge.retail.request.builder.SafechargeOrderBuilder;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/15/2017
 */
public class OpenOrderRequest extends BaseSafechargeOrderDetailsRequest {

    public static class Builder extends SafechargeOrderBuilder<Builder> {

        @Override public SafechargeRequest build() {
            return super.build(new OpenOrderRequest());
        }
    }
}
