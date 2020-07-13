package com.safecharge.request;

import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * Copyright (C) 2007-2020 SafeCharge International Group Limited.
 * <p>
 * This request is used when wanting to perform a 3d secure only request. It is used after an {@link InitPaymentRequest}
 * to provide to the merchant information whether a Challenge is needed or if they receive a frictionless response
 * <p>
 * Note that Authorize3d is virtually the same as the Payment request(has the same fields) but is executed against a different REST endpoint.
 * <p>
 * see <a href="https://www.safecharge.com/docs/api/?json#authorize3dAPI">Authorize3d API</a>
 *
 * @since 6/29/2020
 * </p>
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class Authorize3dRequest extends Authorize3dAndPaymentRequest {

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
                .append("currency='").append(getCurrency()).append('\'')
                .append(", amount='").append(getAmount()).append('\'')
                .append(", items=").append(getItems())
                .append(", deviceDetails=").append(getDeviceDetails())
                .append(", userDetails=").append(getUserDetails())
                .append(", shippingAddress=").append(getShippingAddress())
                .append(", billingAddress=").append(getBillingAddress())
                .append(", dynamicDescriptor=").append(getDynamicDescriptor())
                .append(", merchantDetails=").append(getMerchantDetails())
                .append(", urlDetails=").append(getUrlDetails())
                .append(", addendums=").append(getAddendums())
                .append(", userTokenId='").append(getUserTokenId()).append('\'')
                .append(", clientUniqueId='").append(getClientUniqueId())
                .append(", amountDetails='").append(getAmountDetails())
                .append(", merchantId='").append(getMerchantId()).append('\'')
                .append(", merchantSiteId='").append(getMerchantSiteId()).append('\'')
                .append("serverHost='").append(getServerHost()).append('\'')
                .append("internalRequestId='").append(getInternalRequestId()).append('\'')
                .append(", clientRequestId='").append(getClientRequestId()).append('\'')
                .append(", timeStamp='").append(getTimeStamp()).append('\'')
                .append(", checksum='").append(getChecksum()).append('\'')
                .append(", sessionToken='").append(getSessionToken()).append('\'')
                .append(", ")
                .append(", transactionType=").append(getTransactionType())
                .append(", customSiteName='").append(getCustomSiteName()).append('\'')
                .append(", productId='").append(getProductId()).append('\'')
                .append(", customData='").append(getCustomData()).append('\'')
                .append(", relatedTransactionId='").append(getRelatedTransactionId()).append('\'')
                .append('}');

        return sb.toString();
    }

    public static class Builder extends Authorize3dAndPaymentRequest.Builder<Builder> {

        @Override
        public Authorize3dRequest build() {
            Authorize3dRequest request = new Authorize3dRequest();
            return ValidationUtils.validate(super.build(request));
        }
    }
}
