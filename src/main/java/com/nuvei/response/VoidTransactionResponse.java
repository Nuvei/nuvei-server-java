/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.response;

/**
 * <p>
 * Response received from the Nuvei's servers to the {@link com.nuvei.request.VoidTransactionRequest}.
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @see com.nuvei.request.VoidTransactionRequest
 * @since 4/6/2017
 */
public class VoidTransactionResponse extends NuveiTransactionResponse {

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VoidTransactionResponse{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
