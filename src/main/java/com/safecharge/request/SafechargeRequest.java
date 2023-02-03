/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.request;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * Abstract class to be used as a base for all of the requests to SafeCharge's servers.
 *</p>
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/14/2017
 */
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
