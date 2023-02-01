/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.response;

/**
 * <p>
 * Response received from the SafeCharge's servers to the {@link com.safecharge.request.GetSessionTokenRequest}.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see com.safecharge.request.GetSessionTokenRequest
 * @since 2/15/2017
 */
public class GetSessionTokenResponse extends SafechargeResponse {

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetSessionTokenResponse{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
