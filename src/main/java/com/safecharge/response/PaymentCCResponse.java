package com.safecharge.response;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Response received from the SafeCharge's servers to the {@link com.safecharge.request.PaymentCCRequest}.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see com.safecharge.request.PaymentCCRequest
 * @since 2/15/2017
 */
public class PaymentCCResponse extends PaymentsResponse {

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentCCResponse{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}