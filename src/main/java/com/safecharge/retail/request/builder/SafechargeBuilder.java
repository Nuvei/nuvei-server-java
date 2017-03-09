package com.safecharge.retail.request.builder;

import javax.validation.ConstraintViolationException;

import com.safecharge.retail.biz.SafechargeConfiguration;
import com.safecharge.retail.request.SafechargeRequest;
import com.safecharge.retail.util.RequestUtils;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/23/2017
 */
public abstract class SafechargeBuilder<T extends SafechargeBuilder<T>> {

    private String clientRequestId;
    private String sessionToken;

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
        safechargeRequest.setMerchantId(SafechargeConfiguration.getMerchantInfo()
                                                               .getMerchantId());
        safechargeRequest.setMerchantSiteId(SafechargeConfiguration.getMerchantInfo()
                                                                   .getMerchantSiteId());
        safechargeRequest.setSessionToken(sessionToken);
        safechargeRequest.setTimeStamp(timestamp);
        safechargeRequest.setClientRequestId(RequestUtils.calculateClientRequestId(timestamp));
        safechargeRequest.setChecksum(RequestUtils.calculateChecksum(safechargeRequest, SafechargeConfiguration.getMerchantInfo()
                                                                                                               .getMerchantKey(),
                SafechargeConfiguration.getMerchantInfo()
                                       .getHashAlgorithm()));
        return safechargeRequest;
    }

    /**
     * @return
     */
    public abstract SafechargeRequest build() throws ConstraintViolationException;
}
