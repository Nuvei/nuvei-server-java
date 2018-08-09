package com.safecharge.request;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.safecharge.model.DynamicDescriptor;
import com.safecharge.model.MerchantDetails;
import com.safecharge.model.SubMethodDetails;
import com.safecharge.model.UrlDetails;
import com.safecharge.model.UserPaymentOption;
import com.safecharge.request.builder.SafechargeBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Request to execute payout.
 * <p>
 * This method is intended for  merchants implementing payout for Credit cards and APMs(paypal, skrill, neteller and so on).
 * and use a native mobile application are not required to use the payout client SDK.
 * However, they are able to use this {@link PayoutRequest} directly.
 * <p>
 * Merchants are able to use the payout client SDK, according to the instructions <
 * a href="https://www.safecharge.com/docs/api/?java#payout">here</a>
 * which performs credit card tokenization for them.
 *
 * @author <a mailto:bozhidarsh@safecharge.com>Bozhidar sHumanov</a>
 * @see <a href="https://www.safecharge.com/docs/api/?java#payout">payout</a>
 * @since 11/21/2017
 */

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class PayoutRequest extends SafechargeRequest {

    @Size(max = 255)
    private String userTokenId;

    @Size(max = 45)
    private String clientUniqueId;

    @Size(max = 12)
    private String amount;

    @Size(max = 3)
    private String currency;

    @Valid
    private UserPaymentOption userPaymentOption;

    @Size(max = 255)
    private String comment;

    @Valid
    private DynamicDescriptor dynamicDescriptor;

    @Valid
    private MerchantDetails merchantDetails;

    @Valid
    private UrlDetails urlDetails;

    @Valid
    private SubMethodDetails subMethodDetails;

    public static PayoutRequest.Builder builder() {
        return new PayoutRequest.Builder();
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    public String getClientUniqueId() {
        return clientUniqueId;
    }

    public void setClientUniqueId(String clientUniqueId) {
        this.clientUniqueId = clientUniqueId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public UserPaymentOption getUserPaymentOption() {
        return userPaymentOption;
    }

    public void setUserPaymentOption(UserPaymentOption userPaymentOption) {
        this.userPaymentOption = userPaymentOption;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public DynamicDescriptor getDynamicDescriptor() {
        return dynamicDescriptor;
    }

    public void setDynamicDescriptor(DynamicDescriptor dynamicDescriptor) {
        this.dynamicDescriptor = dynamicDescriptor;
    }

    public MerchantDetails getMerchantDetails() {
        return merchantDetails;
    }

    public void setMerchantDetails(MerchantDetails merchantDetails) {
        this.merchantDetails = merchantDetails;
    }

    public UrlDetails getUrlDetails() {
        return urlDetails;
    }

    public void setUrlDetails(UrlDetails urlDetails) {
        this.urlDetails = urlDetails;
    }

    public SubMethodDetails getSubMethodDetails() {
        return subMethodDetails;
    }

    public void setSubMethodDetails(SubMethodDetails subMethodDetails) {
        this.subMethodDetails = subMethodDetails;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PayoutRequest{");
        sb.append("userTokenId='").append(userTokenId).append('\'');
        sb.append(", clientUniqueId='").append(clientUniqueId).append('\'');
        sb.append(", amount='").append(amount).append('\'');
        sb.append(", currency='").append(currency).append('\'');
        sb.append(", userPaymentOption=").append(userPaymentOption);
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", dynamicDescriptor=").append(dynamicDescriptor);
        sb.append(", merchantDetails=").append(merchantDetails);
        sb.append(", urlDetails=").append(urlDetails);
        sb.append(", subMethodDetails=").append(subMethodDetails);
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeBuilder<Builder> {
        private String userTokenId;
        private String clientUniqueId;
        private String amount;
        private String currency;
        private UserPaymentOption userPaymentOption;
        private String comment;
        private DynamicDescriptor dynamicDescriptor;
        private MerchantDetails merchantDetails;
        private UrlDetails urlDetails;
        private SubMethodDetails subMethodDetails;

        /**
         * @param userTokenId
         * @return
         */
        public Builder addUserTokenId(String userTokenId) {
            this.userTokenId = userTokenId;
            return this;
        }

        /**
         * @param clientUniqueId
         * @return
         */
        public Builder addClientUniqueId(String clientUniqueId) {
            this.clientUniqueId = clientUniqueId;
            return this;
        }

        /**
         * @param amount
         * @param currency
         * @return
         */
        public Builder addAmountAndCurrency(String amount, String currency) {
            this.amount = amount;
            this.currency = currency;
            return this;
        }

        /**
         * @param userPaymentOption
         * @return
         */
        public Builder addUserPaymentOption(UserPaymentOption userPaymentOption) {
            this.userPaymentOption = userPaymentOption;
            return this;
        }

        /**
         * @param comment
         * @return
         */
        public Builder addComment(String comment) {
            this.comment = comment;
            return this;
        }

        /**
         * @param dynamicDescriptor
         * @return
         */
        public Builder addDynamicDescriptor(DynamicDescriptor dynamicDescriptor) {
            this.dynamicDescriptor = dynamicDescriptor;
            return this;
        }

        /**
         * @param merchantDetails
         * @return
         */
        public Builder addMerchantDetails(MerchantDetails merchantDetails) {
            this.merchantDetails = merchantDetails;
            return this;
        }

        /**
         * @param urlDetails
         * @return
         */
        public Builder addUrlDetails(UrlDetails urlDetails) {
            this.urlDetails = urlDetails;
            return this;
        }

        /**
         *
         * @param subMethodDetails
         * @return
         */
        public Builder addSubMethodDetails(SubMethodDetails subMethodDetails) {
            this.subMethodDetails = subMethodDetails;
            return this;
        }

        public Builder addSubMethodDetails(String subMethod) {
            SubMethodDetails subMethodDetails = new SubMethodDetails();
            subMethodDetails.setSubMethod(subMethod);
            this.subMethodDetails = subMethodDetails;
            return this;
        }

        /**
         * Builds the request.
         *
         * @return this object
         */
        @Override
        public PayoutRequest build() {
            PayoutRequest request = new PayoutRequest();
            request.setUserTokenId(userTokenId);
            request.setClientUniqueId(clientUniqueId);
            request.setAmount(amount);
            request.setCurrency(currency);
            request.setUserPaymentOption(userPaymentOption);
            request.setComment(comment);
            request.setDynamicDescriptor(dynamicDescriptor);
            request.setMerchantDetails(merchantDetails);
            request.setUrlDetails(urlDetails);
            request.setSubMethodDetails(subMethodDetails);
            return ValidationUtils.validate(super.build(request));
        }
    }
}
