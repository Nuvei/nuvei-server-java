/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.request;

import com.safecharge.util.Constants;

import javax.validation.constraints.Size;

public abstract class SafechargePaymentRequest extends SafechargeOrderDetailsRequest {

    /**
     * Transaction Type of the request. Possible values: Auth / Sale.
     */
    private Constants.TransactionType transactionType;

    @Size(max = 50)
    private String customSiteName;

    @Size(max = 50)
    private String productId;

    @Size(max = 255)
    private String customData;

    @Size(max = 19)
    private String relatedTransactionId;

    public Constants.TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Constants.TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getCustomSiteName() {
        return customSiteName;
    }

    public void setCustomSiteName(String customSiteName) {
        this.customSiteName = customSiteName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }

    public String getRelatedTransactionId() {
        return relatedTransactionId;
    }

    public void setRelatedTransactionId(String relatedTransactionId) {
        this.relatedTransactionId = relatedTransactionId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", transactionType=").append(transactionType);
        sb.append(", customSiteName='").append(customSiteName).append('\'');
        sb.append(", productId='").append(productId).append('\'');
        sb.append(", customData='").append(customData).append('\'');
        sb.append(", relatedTransactionId='").append(relatedTransactionId).append('\'');

        return super.toString();
    }
}
