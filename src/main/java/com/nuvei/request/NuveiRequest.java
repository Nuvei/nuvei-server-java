/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.request;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * Abstract class to be used as a base for all of the requests 2007 - 2024 Nuvei Corporation's servers.
 *</p>
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @since 2/14/2017
 */
public abstract class NuveiRequest extends NuveiBaseRequest {

    /**
     * Merchant ID provided by Nuvei.
     */
    @NotNull(message = "merchantId parameter is mandatory!")
    private String merchantId;

    /**
     * Merchant Site ID provided by Nuvei.
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
