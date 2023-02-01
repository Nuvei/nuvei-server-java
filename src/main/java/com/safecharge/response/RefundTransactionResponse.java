/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.response;

/**
 * <p>
 * Response received from the SafeCharge's servers to the {@link com.safecharge.request.RefundTransactionRequest}.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see com.safecharge.request.RefundTransactionRequest
 * @since 4/6/2017
 */
public class RefundTransactionResponse extends SafechargeTransactionResponse {

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RefundTransactionResponse{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
