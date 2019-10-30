package com.safecharge.request;

import javax.validation.constraints.NotNull;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Abstract class to be used as a base for all of the requests to SafeCharge's servers.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/14/2017
 */
//@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING.GET_CASHIER_USER_INFO)
public abstract class SafechargeRequest extends SafechargeBaseRequest {

    /**
     * Merchant ID provided by SafeCharge.
     */
    @NotNull(message = "merchantId parameter is mandatory!")
    private String merchantId;

    /**
     * Merchant Site ID provided by SafeCharge.
     */
    @NotNull(message = "merchantSiteId parameter is mandatory!")
    private String merchantSiteId;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantSiteId() {
        return merchantSiteId;
    }

    public void setMerchantSiteId(String merchantSiteId) {
        this.merchantSiteId = merchantSiteId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", merchantId='")
                .append(merchantId)
                .append('\'');
        sb.append(", merchantSiteId='")
                .append(merchantSiteId)
                .append('\'');
        return sb.toString();
    }
}
