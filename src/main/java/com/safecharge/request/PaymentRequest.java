/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.request;

import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * <p>
 * Uniform request to perform card transactions(credit or debit)
 * It supports 3D Secure and alternative payment method transactions.
 * </p>
 * see <a href="https://www.safecharge.com/docs/api/?json#payment">Payment</a>
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class PaymentRequest extends Authorize3dAndPaymentRequest {

    private String isMoto;

    private String cvvNotUsed;

    private String serviceDueDate;

    public String getIsMoto() {
        return isMoto;
    }

    public void setIsMoto(String isMoto) {
        this.isMoto = isMoto;
    }

    public String getCvvNotUsed() {
        return cvvNotUsed;
    }

    public void setCvvNotUsed(String cvvNotUsed) {
        this.cvvNotUsed = cvvNotUsed;
    }

    public String getServiceDueDate() { return serviceDueDate; }

    public void setServiceDueDate(String serviceDueDate) { this.serviceDueDate = serviceDueDate; }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentRequest{");
        sb.append("paymentOption=").append(getPaymentOption())
                .append(", isRebilling=").append(getIsRebilling())
                .append(", isMoto=").append(getIsMoto())
                .append(", autoPayment3D=").append(isAutoPayment3D())
                .append(", cvvNotUsed=").append(cvvNotUsed)
                .append(", serviceDueDate=").append(getServiceDueDate());
        sb.append(super.toString());
        sb.append('}');

        return sb.toString();
    }

    public static class Builder extends Authorize3dAndPaymentRequest.Builder<Builder> {

        private String isMoto;
        private String cvvNotUsed;
        private String serviceDueDate;

        public Builder addIsMoto(String isMoto) {
            this.isMoto = isMoto;
            return this;
        }

        public Builder addCvvNotUsed(String cvvNotUsed) {
            this.cvvNotUsed = cvvNotUsed;
            return this;
        }

        public Builder addServiceDueDate(String serviceDueDate) {
            this.serviceDueDate = serviceDueDate;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public PaymentRequest build() {
            PaymentRequest request = new PaymentRequest();
            request.setIsMoto(isMoto);
            request.setCvvNotUsed(cvvNotUsed);
            request.setServiceDueDate(serviceDueDate);

            return ValidationUtils.validate(super.build(request));
        }
    }
}
