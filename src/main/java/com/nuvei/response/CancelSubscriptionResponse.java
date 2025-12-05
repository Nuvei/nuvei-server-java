/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.response;

/**
 * <p>
 * Response received from the Nuvei's servers to the {@link com.nuvei.request.CancelSubscriptionRequest}.
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @see com.nuvei.request.CancelSubscriptionRequest
 * @since 6/6/2017
 */
public class CancelSubscriptionResponse extends NuveiResponse {

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CancelSubscriptionResponse{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
