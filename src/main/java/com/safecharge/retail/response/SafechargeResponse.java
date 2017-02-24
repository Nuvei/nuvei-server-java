package com.safecharge.retail.response;

import com.safecharge.retail.util.Constants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */
public interface SafechargeResponse {

    Long getInternalRequestId();

    Constants.APIResponseStatus getStatus();

    int getErrCode();

    String getReason();

    String getMerchantId();

    String getMerchantSiteId();

    String getVersion();

    String getClientRequestId();

    String getSessionToken();

    String getClientUniqueId();

    Constants.ErrorType getErrorType();

    Constants.APIType getApiType();

}
