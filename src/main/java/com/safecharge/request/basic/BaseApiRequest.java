package com.safecharge.request.basic;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.safecharge.request.SafechargeBaseRequest;

public class BaseApiRequest extends SafechargeBaseRequest implements Serializable {

    private static final long serialVersionUID = 153059344311719085L;

    @NotNull
    private String merchantId;

    @NotNull
    private String merchantSiteId;

    public static Builder builder() {
        return new Builder();
    }

    public BaseApiRequest() {
    }

    protected BaseApiRequest(Builder b) {
        this.setClientRequestId(b.clientRequestId);
        this.setTimeStamp(b.timeStamp);
        this.setChecksum(b.checksum);
        this.setServerHost(b.serverHost);

        this.merchantId = b.merchantId;
        this.merchantSiteId = b.merchantSiteId;
    }

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

    public static class Builder {

        private String clientRequestId;
        private String merchantId;
        private String merchantSiteId;
        private String timeStamp;
        private String checksum;
        private String serverHost;

        public Builder clientRequestId(String clientRequestId) {
            this.clientRequestId = clientRequestId;
            return this;
        }

        public Builder merchantId(String merchantId) {
            this.merchantId = merchantId;
            return this;
        }

        public Builder merchantSiteId(String merchantSiteId) {
            this.merchantSiteId = merchantSiteId;
            return this;
        }

        public Builder timeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }

        public Builder checksum(String checksum) {
            this.checksum = checksum;
            return this;
        }

        public Builder serverHost(String serverHost) {
            this.serverHost = serverHost;
            return this;
        }

        public BaseApiRequest build() {
            return new BaseApiRequest(this);
        }
    }
}