package com.safecharge.retail.request;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */
public interface SafechargeRequest {

    String getMerchantId();

    void setMerchantId(String merchantId);

    String getMerchantSiteId();

    void setMerchantSiteId(String merchantSiteId);

    String getTimeStamp();

    void setTimeStamp(String timestamp);

    String getClientRequestId();

    void setClientRequestId(String clientRequestId);

    void setChecksum(String checksum);

    void setSessionToken(String sessionToken);

}