package com.safecharge.retail.model;

import javax.validation.constraints.NotNull;

import com.safecharge.retail.util.Constants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */
public class MerchantInfo {

    @NotNull(message = "merchantKey may not be null!") private String merchantKey;

    @NotNull(message = "merchantId may not be null!") private String merchantId;

    @NotNull(message = "merchantSiteId may not be null!") private String merchantSiteId;

    private Constants.HashAlgorithm hashAlgorithm;

    public MerchantInfo(String merchantKey, String merchantId, String merchantSiteId, Constants.HashAlgorithm hashAlgorithm) {
        this.merchantKey = merchantKey;
        this.merchantId = merchantId;
        this.merchantSiteId = merchantSiteId;
        this.hashAlgorithm = hashAlgorithm;
    }

    public String getMerchantKey() {
        return merchantKey;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getMerchantSiteId() {
        return merchantSiteId;
    }

    public Constants.HashAlgorithm getHashAlgorithm() {
        return hashAlgorithm;
    }
}
