/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.response;

/**
 * <p>
 * Response received from the Nuvei's servers to the {@link com.nuvei.request.PaymentCCRequest}.
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @see com.nuvei.request.PaymentCCRequest
 * @since 2/15/2017
 */
public class PaymentCCResponse extends PaymentsCCResponse {

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentCCResponse{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}