package com.safecharge.retail.request;

import com.safecharge.retail.request.builder.SafechargeOrderBuilder;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */
public class Authorization3DRequest extends PaymentCCRequest {

    public Authorization3DRequest() {
        throw new NotImplementedException();
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Authorization3DRequest{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeOrderBuilder<Builder> {

        @Override public SafechargeRequest build() {
            throw new NotImplementedException();
        }
    }
}
