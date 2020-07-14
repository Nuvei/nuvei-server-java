package com.safecharge.request;

import com.safecharge.model.OpenOrderPaymentOption;
import com.safecharge.request.builder.SafechargeOrderBuilder;
import com.safecharge.request.builder.SafechargeOrderWithDetailsBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Request to create an order in the SafeCharge's system.
 * <p>
 * This request represents the state of the order when it is created, it can be changed at later time.
 * Note that no payment request is send, it is used mainly to store the order details at the time of creation.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see GetOrderDetailsRequest
 * @see UpdateOrderRequest
 * @since 2/15/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class OpenOrderRequest extends OrderRequestWithDetails {

    private String customSiteName;

    @Size(max=50, message = "productId size must be up to 50 characters long!")
    private String productId;

    @Valid
    private OpenOrderPaymentOption paymentOption;

    private Constants.TransactionType transactionType;

    public String getCustomSiteName() {
        return customSiteName;
    }

    public void setCustomSiteName(String customSiteName) {
        this.customSiteName = customSiteName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public OpenOrderPaymentOption getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(OpenOrderPaymentOption paymentOption) {
        this.paymentOption = paymentOption;
    }

    public Constants.TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Constants.TransactionType transactionType) {
        this.transactionType = transactionType;
    }


    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OpenOrderRequest{");
        sb.append(super.toString());
        sb.append(", customSiteName=").append(customSiteName)
                .append(", productId=").append(productId)
                .append(", paymentOption=").append(paymentOption)
                .append(", transactionType=").append(transactionType);
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeOrderWithDetailsBuilder<Builder> {

        private String customSiteName;
        private String productId;
        private OpenOrderPaymentOption paymentOption;
        private Constants.TransactionType transactionType;
        private String paymentMethod;

        public Builder addCustomSiteName(String customSiteName) {
            this.customSiteName = customSiteName;
            return this;
        }

        public Builder addProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder addOpenOrderPaymentOption(OpenOrderPaymentOption paymentOption) {
            this.paymentOption = paymentOption;
            return this;
        }

        public Builder addTransactionType(Constants.TransactionType transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public Builder addPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        /**
         * Builds the request.
         *
         *
         * @return {@link SafechargeRequest} object build from the params set by this builder
         */
        @Override
        public SafechargeBaseRequest build() {
            OpenOrderRequest request = new OpenOrderRequest();
            request.setCustomSiteName(customSiteName);
            request.setProductId(productId);
            request.setPaymentOption(paymentOption);
            request.setTransactionType(transactionType);

            return ValidationUtils.validate(super.build(request));
        }
    }
}
