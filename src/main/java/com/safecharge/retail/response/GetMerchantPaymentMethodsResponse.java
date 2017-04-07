package com.safecharge.retail.response;

import java.util.List;

import com.safecharge.retail.model.PaymentMethod;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 4/7/2017
 */
public class GetMerchantPaymentMethodsResponse extends SafechargeResponse {

    private List<PaymentMethod> paymentMethods;

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("GetMerchantPaymentMethodsResponse{");
        sb.append("paymentMethods=")
          .append(paymentMethods);
        sb.append(", ")
          .append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
