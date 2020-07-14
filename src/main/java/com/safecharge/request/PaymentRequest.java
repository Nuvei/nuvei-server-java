package com.safecharge.request;

import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * Copyright (C) 2007-2019 SafeCharge International Group Limited.
 * <p>
 * Uniform request to perform card transactions(credit or debit)
 * It supports 3D Secure and alternative payment method transactions.
 * </p>
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class PaymentRequest extends Authorize3dAndPaymentRequest {

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentRequest{");
        sb.append("paymentOption=").append(getPaymentOption())
                .append(", isRebilling=").append(getIsRebilling())
                .append(", isMoto=").append(getIsMoto())
                .append(", autoPayment3D=").append(isAutoPayment3D());
        sb.append(super.toString());
        sb.append('}');

        return sb.toString();
    }

    public static class Builder extends Authorize3dAndPaymentRequest.Builder<Builder> {

        @Override
        public PaymentRequest build() {
            PaymentRequest request = new PaymentRequest();
            return ValidationUtils.validate(super.build(request));
        }
    }
}
