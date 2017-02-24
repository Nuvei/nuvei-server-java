package com.safecharge.retail.request.builder;

import com.safecharge.retail.model.MerchantInfo;
import com.safecharge.retail.request.SafechargeOrderDetailsRequest;
import com.safecharge.retail.request.SafechargeRequest;
import com.safecharge.retail.util.Constants;
import com.safecharge.retail.util.RequestUtils;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/23/2017
 */
public abstract class SafechargeBuilder<T extends SafechargeBuilder<T>> {

    protected MerchantInfo merchantInfo;
    private String clientRequestId;
    private String sessionToken;

    public T addMerchantInfo(MerchantInfo merchantInfo) {
        this.merchantInfo = merchantInfo;
        return (T) this;
    }

    public T addMerchantInfo(String merchantId, String merchantKey, String merchantSiteId, Constants.HashAlgorithm hashAlgorithm) {
        MerchantInfo merchantInfo = new MerchantInfo(merchantKey, merchantId, merchantSiteId, hashAlgorithm);
        return addMerchantInfo(merchantInfo);
    }

    /**
     * @param sessionToken
     * @return
     */
    public T addSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
        return (T) this;
    }

    /**
     * @param clientRequestId
     * @return
     */
    public T addClientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
        return (T) this;
    }

    protected <T extends SafechargeRequest> T build(T safechargeRequest) {
        String timestamp = RequestUtils.calculateTimestamp();
        safechargeRequest.setMerchantId(merchantInfo.getMerchantId());
        safechargeRequest.setMerchantSiteId(merchantInfo.getMerchantSiteId());
        safechargeRequest.setSessionToken(sessionToken);
        safechargeRequest.setTimeStamp(timestamp);
        safechargeRequest.setClientRequestId(RequestUtils.calculateClientRequestId(timestamp));
        safechargeRequest.setChecksum(
                RequestUtils.calculateChecksum(safechargeRequest, merchantInfo.getMerchantKey(), merchantInfo.getHashAlgorithm()));
        return safechargeRequest;
    }

    /**
     * @return
     */
    public abstract SafechargeRequest build();
}
