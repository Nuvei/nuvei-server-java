package com.safecharge.retail.request.builder;

import com.safecharge.retail.model.URLDetails;
import com.safecharge.retail.request.SafechargeTransactionRequest;
import com.safecharge.retail.util.ChecksumUtils;
import com.safecharge.retail.util.Constants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/22/2017
 */
public abstract class SafechargeTransactionBuilder<T extends SafechargeTransactionBuilder<T>> extends SafechargeBuilder<T> {

    private String amount;
    private String currency;
    private String authCode;
    private String comment;
    private String clientUniqueId;
    private String relatedTransactionId;
    private URLDetails urlDetails;

    public T addAmount(String amount) {
        this.amount = amount;
        return (T) this;
    }

    public T addCurrency(String currency) {
        this.currency = currency;
        return (T) this;
    }

    public T addAuthCode(String authCode) {
        this.authCode = authCode;
        return (T) this;
    }

    public T addComment(String comment) {
        this.comment = comment;
        return (T) this;
    }

    public T addClientUniqueId(String clientUniqueId) {
        this.clientUniqueId = clientUniqueId;
        return (T) this;
    }

    public T addRelatedTransactionId(String relatedTransactionId) {
        this.relatedTransactionId = relatedTransactionId;
        return (T) this;
    }

    public T addURLDetails(String failureURL, String pendingURL, String successURL, String notificationUrl) {
        URLDetails urlDetails = new URLDetails();
        urlDetails.setFailureUrl(failureURL);
        urlDetails.setPendingUrl(pendingURL);
        urlDetails.setSuccessUrl(successURL);
        urlDetails.setNotificationUrl(notificationUrl);
        return addURLDetails(urlDetails);
    }

    public T addURLDetails(URLDetails urlDetails) {
        this.urlDetails = urlDetails;
        return (T) this;
    }

    protected <T extends SafechargeTransactionRequest> T build(T safechargeTransactionRequest) {

        super.build(safechargeTransactionRequest);

        safechargeTransactionRequest.setAmount(amount);
        safechargeTransactionRequest.setCurrency(currency);
        safechargeTransactionRequest.setAuthCode(authCode);
        safechargeTransactionRequest.setComment(comment);
        safechargeTransactionRequest.setClientUniqueId(clientUniqueId);
        safechargeTransactionRequest.setRelatedTransactionId(relatedTransactionId);
        safechargeTransactionRequest.setUrlDetails(urlDetails);

        safechargeTransactionRequest.setChecksum(
                ChecksumUtils.calculateChecksum(safechargeTransactionRequest, merchantInfo != null ? merchantInfo.getMerchantKey() : "",
                        Constants.CHARSET_UTF8, merchantInfo != null ? merchantInfo.getHashAlgorithm() : null));

        return safechargeTransactionRequest;
    }
}
