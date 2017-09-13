package com.safecharge.model;

import javax.validation.constraints.Size;

import com.safecharge.util.APIConstants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Holds Merchant's dynamic data.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/14/2017
 */
public class DynamicDescriptor {

    @Size(max = APIConstants.MERCHANT_DESCRIPTOR_NAME_MAX_LENGTH, message = "merchantName size must be up to 25 characters long!")
    private String merchantName;

    @Size(max = APIConstants.MERCHANT_DESCRIPTOR_PHONE_MAX_LENGTH, message = "merchantPhone size must be up to 13 characters long!")
    private String merchantPhone;

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantPhone() {
        return merchantPhone;
    }

    public void setMerchantPhone(String merchantPhone) {
        this.merchantPhone = merchantPhone;
    }

}
