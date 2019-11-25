package com.safecharge.request;

import com.safecharge.model.PaymentOption;
import com.safecharge.request.builder.SafechargeOrderBuilder;
import com.safecharge.request.builder.SafechargePaymentBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

import javax.validation.Valid;

/**
 * Copyright (C) 2007-2019 SafeCharge International Group Limited.
 * <p>
 * Uniform request to perform card transactions(credit or debit)
 * It supports 3D Secure and alternative payment method transactions.
 * </p>
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class PaymentRequest extends SafechargePaymentRequest {

    @Valid
    private PaymentOption paymentOption;

    private Integer isRebilling;

    private boolean autoPayment3D;

    private String sourceApplication;

    private String isMoto;

    public PaymentOption getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(PaymentOption paymentOption) {
        this.paymentOption = paymentOption;
    }

    public Integer getIsRebilling() {
        return isRebilling;
    }

    public void setIsRebilling(Integer isRebilling) {
        this.isRebilling = isRebilling;
    }

    public boolean isAutoPayment3D() {
        return autoPayment3D;
    }

    public void setAutoPayment3D(boolean autoPayment3D) {
        this.autoPayment3D = autoPayment3D;
    }

    public String getSourceApplication() {
        return sourceApplication;
    }

    public void setSourceApplication(String sourceApplication) {
        this.sourceApplication = sourceApplication;
    }

    public String getIsMoto() {
        return isMoto;
    }

    public void setIsMoto(String isMoto) {
        this.isMoto = isMoto;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", paymentOption=").append(paymentOption)
                .append(", isRebilling=").append(isRebilling)
                .append(", sourceApplication=").append(sourceApplication)
                .append(", isMoto=").append(isMoto)
                .append(", autoPayment3D=").append(autoPayment3D);

        return super.toString();
    }

    public static class Builder extends SafechargePaymentBuilder<Builder> {

        private PaymentOption paymentOption;
        private Integer isRebilling;
        private String sourceApplication;
        private String isMoto;
        private boolean autoPayment3D;


        public Builder addPaymentOption(PaymentOption paymentOption) {
            this.paymentOption = paymentOption;
            return this;
        }

        public Builder addIsRebilling(Integer isRebilling) {
            this.isRebilling = isRebilling;
            return this;
        }

        public Builder addSourceApplication(String sourceApplication) {
            this.sourceApplication = sourceApplication;
            return this;
        }

        public Builder addIsMoto(String isMoto) {
            this.isMoto = isMoto;
            return this;
        }

        public Builder addAutoPayment3D(Boolean autoPayment3D) {
            this.autoPayment3D = Boolean.TRUE.equals(autoPayment3D);
            return this;
        }

        @Override
        public PaymentRequest build() {
            PaymentRequest request = new PaymentRequest();
            request.setPaymentOption(paymentOption);
            request.setIsRebilling(isRebilling);
            request.setSourceApplication(sourceApplication);
            request.setIsMoto(isMoto);
            request.setIsRebilling(isRebilling);
            request.setAutoPayment3D(autoPayment3D);

            return ValidationUtils.validate(super.build(request));
        }
    }
}
