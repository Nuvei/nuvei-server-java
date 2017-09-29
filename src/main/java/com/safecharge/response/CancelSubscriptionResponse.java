package com.safecharge.response;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Response received from the SafeCharge's servers to the {@link com.safecharge.request.CancelSubscriptionRequest}.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see com.safecharge.request.CancelSubscriptionRequest
 * @since 6/6/2017
 */
public class CancelSubscriptionResponse extends SafechargeResponse {

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CancelSubscriptionResponse{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
