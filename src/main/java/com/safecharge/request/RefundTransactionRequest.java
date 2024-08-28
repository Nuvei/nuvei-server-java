/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.request;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.safecharge.model.RefundPaymentOption;
import com.safecharge.request.builder.SafechargeTransactionBuilder;
import com.safecharge.util.AtLeastOneFieldPresent;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * <p>
 * Request to refund a transaction.
 * </p>
 * This request can be used to refund a previously settled transaction. Full or partial refunds are supported.
 * When partial refunds are issued, multiple refund requests can be performed for up to the entire amount
 * of the original settled transaction.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see SettleTransactionRequest
 * @see VoidTransactionRequest
 * @since 3/20/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.REFUND_GW_TRANSACTION)
@AtLeastOneFieldPresent(fields = { "paymentOption", "relatedTransactionId" },
                        message = "Either \"paymentOption\" or \"relatedTransactionId\" must be defined")
public class RefundTransactionRequest
        extends SafechargeTransactionRequest {

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Card or user payment option information for unreferenced refunds
     */
    @Valid
    private RefundPaymentOption paymentOption;

    /**
     * Used for unreferenced refunds (for connecting and validating the UPO).
     */
    @Size(max = 255, message = "userTokenId size must be up to 255 characters long!")
    private String userTokenId;

    /**
     * The ID of the original auth transaction.
     */
    @Size(max = 19)
    private String relatedTransactionId;


    public RefundPaymentOption getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(RefundPaymentOption paymentOption) {
        this.paymentOption = paymentOption;
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    @Override
    public String getRelatedTransactionId() {
        return relatedTransactionId;
    }

    @Override
    public void setRelatedTransactionId(String relatedTransactionId) {
        this.relatedTransactionId = relatedTransactionId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RefundTransactionRequest{");
        sb.append(super.toString())
                .append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeTransactionBuilder<Builder> {

        private RefundPaymentOption refundPaymentOption;
        private String userTokenId;
        private String relatedTransactionId;

        /**
         * Adds RefundPaymentOption to request builder for unreferenced refunds.
         *
         * @param refundPaymentOption card or user payment option information for the refund
         * @return this object
         */
        public Builder addRefundPaymentOption(RefundPaymentOption refundPaymentOption) {
            this.refundPaymentOption = refundPaymentOption;
            return this;
        }

        /**
         * Adds userTokenId to request builder for unreferenced refunds.
         *
         * @param userTokenId used for connecting and validating the UPO.
         * @return this object
         */
        public Builder addUserTokenId(String userTokenId) {
            this.userTokenId = userTokenId;
            return this;
        }

        @Override
        public Builder addRelatedTransactionId(String relatedTransactionId) {
            this.relatedTransactionId = relatedTransactionId;
            return this;
        }

        /**
         * Builds the request.
         *
         * @return {@link SafechargeRequest} object build from the params set by this builder
         * @throws ConstraintViolationException if the validation of the params fails
         */
        @Override
        public SafechargeBaseRequest build() throws ConstraintViolationException {
            RefundTransactionRequest refundTransactionRequest = new RefundTransactionRequest();
            refundTransactionRequest.setPaymentOption(refundPaymentOption);
            refundTransactionRequest.setUserTokenId(userTokenId);
            refundTransactionRequest.setRelatedTransactionId(relatedTransactionId);
            return ValidationUtils.validate(super.build(refundTransactionRequest));
        }
    }

}
