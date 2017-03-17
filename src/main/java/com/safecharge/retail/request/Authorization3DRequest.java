package com.safecharge.retail.request;

import com.safecharge.retail.util.ValidationUtil;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */
public class Authorization3DRequest extends PaymentCCRequest {

    public static Builder builder() {
        return new Builder();
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Authorization3DRequest{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends PaymentCCRequest.Builder {

        @Override public SafechargeRequest build() {
            PaymentCCRequest request = super.build(new Authorization3DRequest());
            request.setUserPaymentOption(userPaymentOption);
            request.setTransactionType(transactionType);
            request.setCardData(cardData);
            request.setOrderId(orderId);
            return ValidationUtil.validate(request);
        }
    }
}
