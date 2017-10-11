package com.safecharge.model;

import javax.validation.constraints.Size;

import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Holder for Cashier's Merchant's specific URL to redirect to in case of successful, pending, failed transaction.
 * It also contains a URL to which to send a Direct Merchant Notification(DMN) with the result of the transaction.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/14/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.URL_DETAILS_CHECKSUM_MAPPING)
public class UrlDetails {

    @Size(max = 1000, message = "successUrl size must be up to 1000 characters long!")
    private String successUrl;

    @Size(max = 1000, message = "failureUrl size must be up to 1000 characters long!")
    private String failureUrl;

    @Size(max = 1000, message = "pendingUrl size must be up to 1000 characters long!")
    private String pendingUrl;

    @Size(max = 1000, message = "notificationUrl size must be up to 1000 characters long!")
    private String notificationUrl;

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String getFailureUrl() {
        return failureUrl;
    }

    public void setFailureUrl(String failureUrl) {
        this.failureUrl = failureUrl;
    }

    public String getPendingUrl() {
        return pendingUrl;
    }

    public void setPendingUrl(String pendingUrl) {
        this.pendingUrl = pendingUrl;
    }

    public String getNotificationUrl() {
        return notificationUrl;
    }

    public void setNotificationUrl(String notificationUrl) {
        this.notificationUrl = notificationUrl;
    }
}