package com.safecharge.request.builder;

import javax.validation.ConstraintViolationException;

import com.safecharge.model.MerchantInfo;
import com.safecharge.request.SafechargeBaseRequest;
import com.safecharge.request.SafechargeRequest;
import com.safecharge.util.ChecksumUtils;
import com.safecharge.util.Constants;
import com.safecharge.util.RequestUtils;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * A base builder class for a request to Safecharge.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see SafechargeCCBuilder
 * @see SafechargeOrderBuilder
 * @see SafechargeTransactionBuilder
 * @since 2/23/2017
 */
public abstract class SafechargeBuilder<T extends SafechargeBuilder<T>> {

    protected MerchantInfo merchantInfo;
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
     * @param merchantInfo A {@link MerchantInfo} object to get the merchant info from, when building the request
     * @return this object
     * @see MerchantInfo
     * @see SafechargeBuilder#addMerchantInfo(String, String, String, String, Constants.HashAlgorithm)
     */
    public T addMerchantInfo(MerchantInfo merchantInfo) {
        this.merchantInfo = merchantInfo;
        return (T) this;
    }

    /**
     * Adds required merchant info to the request.
     *
     * @param merchantKey    The secret merchant key obtained by the Merchant during integration process with Safecharge
     * @param merchantId     Merchant id in the Safecharge's system
     * @param merchantSiteId Merchant site id in the Safecharge's system
     * @param serverHost     The Safecharge's server address to send the request to
     * @param hashAlgorithm  The hashing algorithm used to generate the checksum
     * @return this object
     * @see MerchantInfo
     * @see SafechargeBuilder#addMerchantInfo(MerchantInfo)
     */
    public T addMerchantInfo(String merchantKey, String merchantId, String merchantSiteId, String serverHost, Constants.HashAlgorithm hashAlgorithm) {
        this.merchantInfo = new MerchantInfo(merchantKey, merchantId, merchantSiteId, serverHost, hashAlgorithm);
        return (T) this;
    }

    /**
     * Adds the common data, collected by this builder. The intent of this method is to be used from the derived classes.
     *
     * @param safechargeRequest an already created request of type <{@code T} extends {@link SafechargeRequest}>
     * @param <S>               type parameter
     * @return the passed {@code safechargeRequest} filled with the data from this builder
     */
    protected <S extends SafechargeRequest> S build(S safechargeRequest) {

        String timestamp = RequestUtils.calculateTimestamp();
        safechargeRequest.setMerchantId(merchantInfo != null ? merchantInfo.getMerchantId() : null);
        safechargeRequest.setMerchantSiteId(merchantInfo != null ? merchantInfo.getMerchantSiteId() : null);
        safechargeRequest.setServerHost(merchantInfo != null ? merchantInfo.getServerHost() : null);
        safechargeRequest.setSessionToken(sessionToken);
        safechargeRequest.setTimeStamp(timestamp);
        safechargeRequest.setClientRequestId(clientRequestId);
        safechargeRequest.setInternalRequestId(internalRequestId);
        safechargeRequest.setChecksum(
                ChecksumUtils.calculateChecksum(safechargeRequest, merchantInfo != null ? merchantInfo.getMerchantKey() : "", Constants.CHARSET_UTF8,
                        merchantInfo != null ? merchantInfo.getHashAlgorithm() : null));

        return safechargeRequest;
    }

    /**
     * Adds the common data, collected by this builder. The intent of this method is to be used from the derived classes.
     *
     * @param safechargeBaseRequest an already created request of type <{@code T} extends {@link SafechargeRequest}>
     * @param <S>               type parameter
     * @return the passed {@code safechargeRequest} filled with the data from this builder
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
