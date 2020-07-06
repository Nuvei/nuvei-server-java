package com.safecharge.request;

/**
 * Copyright (C) 2007-2019 SafeCharge International Group Limited.
 * <p>
 * Uniform request to perform card transactions(credit or debit)
 * It supports 3D Secure and alternative payment method transactions.
 * <p>
 * Note that Authorize3d is virtually the same as the Payment request but is executed against a different REST endpoint.
 * </p>
 */
public class Authorize3dRequest extends PaymentRequest {

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentRequest{");
        sb.append("paymentOption=").append(getPaymentOption())
                .append(", isRebilling=").append(getIsRebilling())
                .append(", sourceApplication=").append(getSourceApplication())
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
}
