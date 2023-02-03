/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.request.builder;

import javax.validation.ConstraintViolationException;

import com.safecharge.model.MerchantBaseInfo;
import com.safecharge.model.MerchantInfo;
import com.safecharge.request.SafechargeBaseRequest;
import com.safecharge.request.SafechargeRequest;
import com.safecharge.util.ChecksumUtils;
import com.safecharge.util.Constants;
import com.safecharge.util.RequestUtils;

/**
 * <p>
 * A base builder class for a request to Safecharge.
 *
 * @author <a mailto:bozhidarsh@safecharge.com>Bozhidar Shumanov</a>
 * @see SafechargeBuilder
 * @since 2/23/2017
 */
public abstract class SafechargeBaseBuilder<T extends SafechargeBaseBuilder<T>> {

    protected MerchantBaseInfo merchantInfo;
    private String clientRequestId;
    private String internalRequestId;
    private String sessionToken;

    /**
     * Adds previously obtained {@code sessionToken} to the request. All requests(except the one to obtain session token)
     * to Safecharge's API require a valid session token. Some requests (such as Payment*) consume it.
     *
     * @param sessionToken Previously obtained session token as {@link String}
     * @return this object
     */
    public T addSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
        return (T) this;
    }

    /**
     * Adds a client request id to the request. It is used to track the different client requests.
     *
     * @param clientRequestId id used to track the request
     * @return this object
     */
    public T addClientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
        return (T) this;
    }

    /**
     * Adds an internal id to the request. It is used to track the different client requests internally.
     *
     * @param internalRequestId id used to track the request
     * @return this object
     */
    public T addInternalRequestId(String internalRequestId) {
        this.internalRequestId = internalRequestId;
        return (T) this;
    }

    /**
     * Adds required merchant info to the request.
     *
     * @param merchantInfo A {@link MerchantBaseInfo} object to get the merchant info from, when building the request
     * @return this object
     * @see MerchantBaseInfo
     * @see SafechargeBuilder#addMerchantInfo(String, String, String, String, Constants.HashAlgorithm)
     */
    public T addMerchantInfo(MerchantBaseInfo merchantInfo) {
        this.merchantInfo = merchantInfo;
        return (T) this;
    }

    /**
     * Adds required merchant info to the request.
     *
     * @param merchantKey    The secret merchant key obtained by the Merchant during integration process with Safecharge
     * @param serverHost     The Safecharge's server address to send the request to
     * @param hashAlgorithm  The hashing algorithm used to generate the checksum
     * @return this object
     * @see MerchantBaseInfo
     * @see SafechargeBaseBuilder#addMerchantInfo(MerchantBaseInfo)
     */
    public T addMerchantInfo(String merchantKey, String serverHost, Constants.HashAlgorithm hashAlgorithm) {
        this.merchantInfo = new MerchantBaseInfo(merchantKey, serverHost, hashAlgorithm);
        return (T) this;
    }

    /**
     * Adds the common data, collected by this builder. The intent of this method is to be used from the derived classes.
     *
     * @param safechargeBaseRequest an already created request of type <{@code T} extends {@link SafechargeBaseRequest}>
     * @param <S>               type parameter
     * @return the passed {@code safechargeBaseRequest} filled with the data from this builder
     */
    protected <S extends SafechargeBaseRequest> S build(S safechargeBaseRequest) {

        String timestamp = RequestUtils.calculateTimestamp();
        safechargeBaseRequest.setServerHost(merchantInfo != null ? merchantInfo.getServerHost() : null);
        safechargeBaseRequest.setSessionToken(sessionToken);
        safechargeBaseRequest.setTimeStamp(timestamp);
        safechargeBaseRequest.setClientRequestId(clientRequestId);
        safechargeBaseRequest.setInternalRequestId(internalRequestId);
        safechargeBaseRequest.setChecksum(
                ChecksumUtils.calculateChecksum(safechargeBaseRequest, merchantInfo != null ? merchantInfo.getMerchantKey() : "", Constants.CHARSET_UTF8,
                        merchantInfo != null ? merchantInfo.getHashAlgorithm() : null));

        return safechargeBaseRequest;
    }

    /**
     * Builds the request.
     *
     * @return the created SafechargeRequest
     * @throws ConstraintViolationException if any part of the request is invalid
     */
    public abstract SafechargeBaseRequest build() throws ConstraintViolationException;
}