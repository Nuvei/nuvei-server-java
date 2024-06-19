/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.request.builder;

import com.safecharge.model.CompanyDetails;
import com.safecharge.model.ShippingTrackingDetails;
import com.safecharge.model.SubMerchant;
import com.safecharge.model.UrlDetails;
import com.safecharge.request.SafechargeTransactionRequest;
import com.safecharge.util.ChecksumUtils;
import com.safecharge.util.Constants;
import com.safecharge.util.UrlUtils;

/**
 * <p>
 * A base builder for a transaction related requests.
 * </p>
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see SafechargeBuilder
 * @see SafechargeCCBuilder
 * @see SafechargeOrderBuilder
 * @since 3/22/2017
 */
public abstract class SafechargeTransactionBuilder<T extends SafechargeTransactionBuilder<T>> extends SafechargeBuilder<T> {

    private String amount;
    private String currency;
    private String authCode;
    private String comment;
    private String clientUniqueId;
    private String relatedTransactionId;
    private UrlDetails urlDetails;
    private String customSiteName;
    private String productId;
    private String customData;
    private SubMerchant subMerchant;
    private CompanyDetails companyDetails;

    /**
     * Adds amount to the request.
     *
     * @param amount amount value as {@link String} E.g. "10", "10.11", "10.1101"
     * @return this object
     */
    public T addAmount(String amount) {
        this.amount = amount;
        return (T) this;
    }

    /**
     * Adds currency to the request.
     *
     * @param currency the three character ISO currency code
     * @return this object
     */
    public T addCurrency(String currency) {
        this.currency = currency;
        return (T) this;
    }

    /**
     * Adds authentication code to the request.
     *
     * @param authCode authentication code to add to the request
     * @return this object
     */
    public T addAuthCode(String authCode) {
        this.authCode = authCode;
        return (T) this;
    }

    /**
     * Adds comment to the request.
     *
     * @param comment comment to add to the request
     * @return this object
     */
    public T addComment(String comment) {
        this.comment = comment;
        return (T) this;
    }

    /**
     * Adds client's unique id to the request.
     *
     * @param clientUniqueId the client's unique id to add to the request
     * @return this object
     */
    public T addClientUniqueId(String clientUniqueId) {
        this.clientUniqueId = clientUniqueId;
        return (T) this;
    }

    /**
     * Adds related transaction id to the request.
     *
     * @param relatedTransactionId the related transaction id to add to the request
     * @return this object
     */
    public T addRelatedTransactionId(String relatedTransactionId) {
        this.relatedTransactionId = relatedTransactionId;
        return (T) this;
    }

    /**
     * Adds URLs to redirect to in case of success/failure and URL to send notification(DMN) to.
     *
     * @param urlDetails {@code urlDetails} object to add to the request
     * @return this object
     */
    public T addURLDetails(UrlDetails urlDetails) {
        this.urlDetails = urlDetails;
        return (T) this;
    }

    /**
     * Adds URLs to redirect to in case of success/failure and URL to send notification(DMN) to.
     *
     * @param failureUrl      URL to redirect to in case of failed transaction
     * @param pendingUrl      URL to redirect to in case of pending transaction
     * @param successUrl      URL to redirect to in case of successful transaction
     * @param notificationUrl URL to send notification(DMN) to
     * @return this object
     */
    public T addURLDetails(String failureUrl, String pendingUrl, String successUrl, String notificationUrl) {

        UrlDetails urlDetails = UrlUtils.createUrlDetails(failureUrl, pendingUrl, successUrl, notificationUrl);
        return addURLDetails(urlDetails);
    }

    /**
     * The method is used to add to the builder custom site name which will overwrite the one of the merchant site.
     *
     * @param customSiteName The merchant’s site name.
     * @return this object
     */
    public T addCustomSiteName(String customSiteName) {
        this.customSiteName = customSiteName;
        return (T) this;
    }

    /**
     * Adds product id to request builder.
     * @param productId A free text field used to identify the product/service sold.
     * @return this object
     */
    public T addProductId(String productId) {
        this.productId = productId;
        return (T) this;
    }

    /**
     * Adds custom data to request builder.
     * @param customData Can be used to pass any type of information.
     * @return this object
     */
    public T addCustomData(String customData) {
        this.customData = customData;
        return (T) this;
    }

    /**
     * Adds SubMerchant to request builder.
     *
     * @param subMerchant Information about the SubMerchant.
     * @return this object
     */
    public T addSubMerchant(SubMerchant subMerchant) {
        this.subMerchant = subMerchant;
        return (T) this;
    }

    public T addCompanyDetails(CompanyDetails companyDetails) {
        this.companyDetails = companyDetails;
        return (T) this;
    }



    /**
     * Adds the order details data, collected by this builder.
     *
     * @param safechargeTransactionRequest an already created request of type T
     * @param <S>                          type parameter
     * @return this object
     */
    protected <S extends SafechargeTransactionRequest> S build(S safechargeTransactionRequest) {

        super.build(safechargeTransactionRequest);

        safechargeTransactionRequest.setAmount(amount);
        safechargeTransactionRequest.setCurrency(currency);
        safechargeTransactionRequest.setAuthCode(authCode);
        safechargeTransactionRequest.setComment(comment);
        safechargeTransactionRequest.setClientUniqueId(clientUniqueId);
        safechargeTransactionRequest.setRelatedTransactionId(relatedTransactionId);
        safechargeTransactionRequest.setUrlDetails(urlDetails);
        safechargeTransactionRequest.setCustomSiteName(customSiteName);
        safechargeTransactionRequest.setProductId(productId);
        safechargeTransactionRequest.setCustomData(customData);
        safechargeTransactionRequest.setSubMerchant(subMerchant);
        safechargeTransactionRequest.setChecksum(
                ChecksumUtils.calculateChecksum(safechargeTransactionRequest, merchantInfo != null ? merchantInfo.getMerchantKey() : "",
                        Constants.CHARSET_UTF8, merchantInfo != null ? merchantInfo.getHashAlgorithm() : null));
        safechargeTransactionRequest.setCompanyDetails(companyDetails);

        return safechargeTransactionRequest;
    }
}
