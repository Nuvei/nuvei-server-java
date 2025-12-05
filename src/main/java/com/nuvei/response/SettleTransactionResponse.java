/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.response;

/**
 * <p>
 * Response received from the Nuvei's servers to the {@link com.nuvei.request.SettleTransactionRequest}.
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @see com.nuvei.request.SettleTransactionRequest
 * @since 4/6/2017
 */
public class SettleTransactionResponse extends NuveiTransactionResponse {

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SettleTransactionResponse{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
