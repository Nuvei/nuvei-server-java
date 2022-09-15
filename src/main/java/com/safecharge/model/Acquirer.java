package com.safecharge.model;

import javax.validation.constraints.Size;

public class Acquirer {

    @Size(max = 6, message = "bin must be up to 6 characters long!")
    private String bin;

    @Size(max = 20, message = "merchantId must be up to 20 characters long!")
    private String merchantId;

    @Size(max = 25, message = "merchantName must be up to 25 characters long!")
    private String merchantName;

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
}
