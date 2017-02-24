package com.safecharge.retail.request;

import com.safecharge.retail.request.builder.SafechargeBuilder;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */
public class GetSessionTokenRequest extends BaseSafechargeRequest {

    public static class Builder extends SafechargeBuilder<Builder> {

        @Override public SafechargeRequest build() {
            return super.build(new GetSessionTokenRequest());
        }
    }

}
