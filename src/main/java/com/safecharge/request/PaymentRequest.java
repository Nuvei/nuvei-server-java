package com.safecharge.request;

import com.safecharge.model.PaymentOption;
import com.safecharge.request.builder.SafechargeOrderBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Copyright (C) 2007-2019 SafeCharge International Group Limited.
 * <p>
 * Uniform request to perform card transactions(credit or debit)
 * It supports 3D Secure and alternative payment method transactions.
 * </p>
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class PaymentRequest extends SafechargeOrderDetailsRequest {

    /**
     * Copyright (C) 2007-2019 SafeCharge International Group Limited.
     * <p>
     *  Represents the details of the payment method. Can be one of 3 options:
     * </p>
     * <ol>
     *     <li>
     *         CardData(such as card number, cardholder name, CVV, expiration date)
     *     </li>
     *     <li>
     *         Alternative payment method. See
     *     </li>
     *     <li>
     *         User Payment Option ID of previously used credit/debit card, which info is stored by the SafeCharge's system.
     *     </li>
     * </ol>
     * <
     */
    @NotNull(message = "currency parameter is mandatory!")
    private PaymentOption paymentOption;

    private Integer isRebilling;


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

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", paymentOption=").append(paymentOption)
                .append(", isRebilling=").append(isRebilling);

        return super.toString();
    }

    public static class Builder extends SafechargeOrderBuilder<Builder> {

        private PaymentOption paymentOption;
        private Integer isRebilling;


        public Builder addPaymentOption(PaymentOption paymentOption) {
            this.paymentOption = paymentOption;
            return this;
        }

        public Builder addIsRebilling(Integer isRebilling) {
            this.isRebilling = isRebilling;
            return this;
        }

        @Override
        public PaymentRequest build() {
            PaymentRequest request = new PaymentRequest();
            request.setPaymentOption(paymentOption);
            request.setIsRebilling(isRebilling);

            return ValidationUtils.validate(super.build(request));
        }
    }
}
