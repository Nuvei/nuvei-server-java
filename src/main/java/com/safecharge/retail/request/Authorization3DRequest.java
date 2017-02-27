package com.safecharge.retail.request;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */
public class Authorization3DRequest extends PaymentCCRequest {

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Authorization3DRequest{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
