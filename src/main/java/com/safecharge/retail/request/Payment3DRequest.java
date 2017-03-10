package com.safecharge.retail.request;

import com.safecharge.retail.util.ValidationUtil;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/15/2017
 */
public class Payment3DRequest extends PaymentCCRequest {

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Payment3DRequest{");
        sb.append("orderId='")
          .append(getOrderId())
          .append('\'');
        sb.append(", transactionType=")
          .append(getTransactionType());
        sb.append(", cardData=")
          .append(getCardData());
        sb.append(", userPaymentOption=")
          .append(getUserPaymentOption());
        sb.append(", ")
          .append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends PaymentCCRequest.Builder {

        @Override public SafechargeRequest build() {
            PaymentCCRequest request = super.build(new Payment3DRequest());
            request.setUserPaymentOption(userPaymentOption);
            request.setTransactionType(transactionType);
            request.setCardData(cardData);
            request.setOrderId(orderId);
            return ValidationUtil.validate(request);
        }

    }
}
