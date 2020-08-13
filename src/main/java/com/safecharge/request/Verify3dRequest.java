package com.safecharge.request;

import java.util.Date;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.safecharge.model.MerchantDetails;
import com.safecharge.model.SubMerchant;
import com.safecharge.model.UserAddress;
import com.safecharge.model.Verify3dPaymentOption;
import com.safecharge.request.builder.SafechargeBuilder;
import com.safecharge.request.builder.SafechargePaymentBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * Copyright (C) 2007-2020 SafeCharge International Group Limited.
 * <p>
 * Use this request if you need the SafeCharge MPI service to perform a 3D Secure only request. This method is called
 * after the {@link Authorize3dRequest} method in case of the Challenge.
 * </p>
 * This method retrieves the generic 3D Secure result (ECI and CAVV) that you need to send to your PSP or acquirer to benefit
 * from the 3D Secure liability shift received from the SafeCharge 3D Secure service.
 * see <a href="https://www.safecharge.com/docs/api/?json#verify3d">Verify3d</a>
 *
 * @since 6/29/2020
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class Verify3dRequest extends SafechargeRequest {

    @Size(max = 255)
    private String userTokenId;

    @Size(max = 45)
    private String clientUniqueId;

    @NotNull
    @Size(max = 3)
    private String currency;

    @NotNull
    @Size(max = 12)
    private String amount;

    @Size(max = 50)
    private String customSiteName;

    @Size(max = 255)
    private String customData;

    @Size(max = 19)
    @NotNull
    private String relatedTransactionId;

    @Valid
    private UserAddress billingAddress;

    @Valid
    private MerchantDetails merchantDetails;

    @Valid
    private Verify3dPaymentOption paymentOption;

    private final String sourceApplication = "JAVA_SDK";

    @Size(max = 255)
    private String userId;

    @Valid
    private SubMerchant subMerchant;

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCustomSiteName() {
        return customSiteName;
    }

    public void setCustomSiteName(String customSiteName) {
        this.customSiteName = customSiteName;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }

    public String getRelatedTransactionId() {
        return relatedTransactionId;
    }

    public void setRelatedTransactionId(String relatedTransactionId) {
        this.relatedTransactionId = relatedTransactionId;
    }

    public UserAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(UserAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public MerchantDetails getMerchantDetails() {
        return merchantDetails;
    }

    public void setMerchantDetails(MerchantDetails merchantDetails) {
        this.merchantDetails = merchantDetails;
    }

    public Verify3dPaymentOption getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(Verify3dPaymentOption paymentOption) {
        this.paymentOption = paymentOption;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public SubMerchant getSubMerchant() {
        return subMerchant;
    }

    public void setSubMerchant(SubMerchant subMerchant) {
        this.subMerchant = subMerchant;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Verify3dRequest{");
        sb.append(super.toString())
                .append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeBuilder<Builder> {

        private String userTokenId;
        private String clientUniqueId;
        private String currency;
        private String amount;
        private String customSiteName;
        private String customData;
        private String relatedTransactionId;
        private UserAddress billingAddress;
        private MerchantDetails merchantDetails;
        private Verify3dPaymentOption paymentOption;
        private String userId;
        private SubMerchant subMerchant;

        public Builder addUserTokenId(String userTokenId) {
            this.userTokenId = userTokenId;
            return this;
        }

        public Builder addClientUniqueId(String clientUniqueId) {
            this.clientUniqueId = clientUniqueId;
            return this;
        }

        public Builder addCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder addAmount(String amount) {
            this.amount = amount;
            return this;
        }

        public Builder addCustomSiteName(String customSiteName) {
            this.customSiteName = customSiteName;
            return this;
        }

        public Builder addCustomData(String customData) {
            this.customData = customData;
            return this;
        }

        public Builder addRelatedTransactionId(String relatedTransactionId) {
            this.relatedTransactionId = relatedTransactionId;
            return this;
        }

        public Builder addBillingAddress(UserAddress billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        public Builder addMerchantDetails(MerchantDetails merchantDetails) {
            this.merchantDetails = merchantDetails;
            return this;
        }

        public Builder addPaymentOption(Verify3dPaymentOption paymentOption) {
            this.paymentOption = paymentOption;
            return this;
        }

        public Builder addUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder addSubMerchant(SubMerchant subMerchant) {
            this.subMerchant = subMerchant;
            return this;
        }

        @Override
        public SafechargeBaseRequest build() throws ConstraintViolationException {
            Verify3dRequest verify3dRequest = new Verify3dRequest();
            verify3dRequest.setAmount(amount);
            verify3dRequest.setBillingAddress(billingAddress);
            verify3dRequest.setClientUniqueId(clientUniqueId);
            verify3dRequest.setCurrency(currency);
            verify3dRequest.setCustomData(customData);
            verify3dRequest.setCustomSiteName(customSiteName);
            verify3dRequest.setMerchantDetails(merchantDetails);
            verify3dRequest.setPaymentOption(paymentOption);
            verify3dRequest.setRelatedTransactionId(relatedTransactionId);
            verify3dRequest.setSubMerchant(subMerchant);
            verify3dRequest.setUserId(userId);
            verify3dRequest.setUserTokenId(userTokenId);

            return ValidationUtils.validate(super.build(verify3dRequest));
        }
    }
}
