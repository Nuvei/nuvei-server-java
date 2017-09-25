package com.safecharge.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.safecharge.model.URLDetails;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/22/2017
 */
public abstract class SafechargeTransactionRequest extends SafechargeRequest {

    @NotNull(message = "amount parameter is mandatory!")
    protected String amount;

    @NotNull(message = "currency parameter is mandatory!")
    protected String currency;

    @NotNull(message = "authCode parameter is mandatory!")
    protected String authCode;

    @Size(max = 255,
            message = "comment size must be up to 255 characters long!")
    protected String comment;

    @Size(max = 45,
            message = "clientUniqueId size must be up to 45 characters long!")
    protected String clientUniqueId;

    @NotNull(message = "relatedTransactionId parameter is mandatory!")
    protected String relatedTransactionId;

    @Valid
    protected URLDetails urlDetails;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getClientUniqueId() {
        return clientUniqueId;
    }

    public void setClientUniqueId(String clientUniqueId) {
        this.clientUniqueId = clientUniqueId;
    }

    public String getRelatedTransactionId() {
        return relatedTransactionId;
    }

    public void setRelatedTransactionId(String relatedTransactionId) {
        this.relatedTransactionId = relatedTransactionId;
    }

    public URLDetails getUrlDetails() {
        return urlDetails;
    }

    public void setUrlDetails(URLDetails urlDetails) {
        this.urlDetails = urlDetails;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("amount='")
                .append(amount)
                .append('\'');
        sb.append(", currency='")
                .append(currency)
                .append('\'');
        sb.append(", authCode='")
                .append(authCode)
                .append('\'');
        sb.append(", comment='")
                .append(comment)
                .append('\'');
        sb.append(", clientUniqueId='")
                .append(clientUniqueId)
                .append('\'');
        sb.append(", relatedTransactionId='")
                .append(relatedTransactionId)
                .append('\'');
        sb.append(", urlDetails=")
                .append(urlDetails);
        sb.append(", ")
                .append(super.toString());
        return sb.toString();
    }
}
