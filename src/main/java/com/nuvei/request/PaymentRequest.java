/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.request;

import com.nuvei.util.Constants;
import com.nuvei.util.ValidChecksum;
import com.nuvei.util.ValidationUtils;

/**
 * <p>
 * Uniform request to perform card transactions(credit or debit)
 * It supports 3D Secure and alternative payment method transactions.
 * </p>
 * see <a href="https://www.nuvei.com/docs/api/?json#payment">Payment</a>
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class PaymentRequest extends Authorize3dAndPaymentRequest {

    private String isMoto;

    private String cvvNotUsed;

    private String serviceDueDate;

    private String conversionAffiliateCountryCode;

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

    public String getConversionAffiliateCountryCode() {
        return conversionAffiliateCountryCode;
    }

    public void setConversionAffiliateCountryCode(String conversionAffiliateCountryCode) {
        this.conversionAffiliateCountryCode = conversionAffiliateCountryCode;
    }

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
                .append(", serviceDueDate=").append(getServiceDueDate())
                .append(", conversionAffiliateCountryCode=").append(getConversionAffiliateCountryCode());
        sb.append(super.toString());
        sb.append('}');

        return sb.toString();
    }

    public static class Builder extends Authorize3dAndPaymentRequest.Builder<Builder> {

        private String isMoto;
        private String cvvNotUsed;
        private String serviceDueDate;
        private String conversionAffiliateCountryCode;

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

        public Builder addConversionAffiliateCountryCode(String conversionAffiliateCountryCode) {
            this.conversionAffiliateCountryCode = conversionAffiliateCountryCode;
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
            request.setConversionAffiliateCountryCode(conversionAffiliateCountryCode);

            return ValidationUtils.validate(super.build(request));
        }
    }
}
