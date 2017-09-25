package com.safecharge.request;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Size;

import com.safecharge.request.builder.SafechargeTransactionBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/20/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.SETTLE_GW_TRANSACTION)
public class SettleTransactionRequest
        extends SafechargeTransactionRequest {

    @Size(max = 25,
            message = "descriptorMerchantName size must be up to 25 characters long!")
    private String descriptorMerchantName;

    @Size(max = 13,
            message = "descriptorMerchantPhone size must be up to 13 characters long!")
    private String descriptorMerchantPhone;

    public static Builder builder() {
        return new Builder();
    }

    public String getDescriptorMerchantName() {
        return descriptorMerchantName;
    }

    public void setDescriptorMerchantName(String descriptorMerchantName) {
        this.descriptorMerchantName = descriptorMerchantName;
    }

    public String getDescriptorMerchantPhone() {
        return descriptorMerchantPhone;
    }

    public void setDescriptorMerchantPhone(String descriptorMerchantPhone) {
        this.descriptorMerchantPhone = descriptorMerchantPhone;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SettleTransactionRequest{");
        sb.append("descriptorMerchantName='")
                .append(descriptorMerchantName)
                .append('\'');
        sb.append(", descriptorMerchantPhone='")
                .append(descriptorMerchantPhone);
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeTransactionBuilder<Builder> {

        private String descriptorMerchantName;
        private String descriptorMerchantPhone;

        public Builder addDescriptorMerchantName(String descriptorMerchantName) {
            this.descriptorMerchantName = descriptorMerchantName;
            return this;
        }

        public Builder addDescriptorMerchantPhone(String descriptorMerchantPhone) {
            this.descriptorMerchantPhone = descriptorMerchantPhone;
            return this;
        }

        @Override
        public SafechargeRequest build() throws ConstraintViolationException {
            SettleTransactionRequest settleTransactionRequest = new SettleTransactionRequest();
            settleTransactionRequest.setDescriptorMerchantName(descriptorMerchantName);
            settleTransactionRequest.setDescriptorMerchantPhone(descriptorMerchantPhone);
            return ValidationUtils.validate(super.build(settleTransactionRequest));
        }
    }
}
