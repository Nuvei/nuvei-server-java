package com.safecharge.retail.response;

import com.safecharge.retail.util.Constants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */
public interface SafechargeResponse {

    /**
     * @return SafeCharge Internal unique request id (used for reconciliation purpose etc.).
     */
    Long getInternalRequestId();

    /**
     * @return the cashier status of merchant request.
     */
    Constants.APIResponseStatus getStatus();

    int getErrCode();

    /**
     * @return error reason if error occurred at the cashier side.
     */
    String getReason();

    /**
     * @return the Merchant ID provided by SafeCharge.
     */
    String getMerchantId();

    /**
     * @return the Merchant Site ID provided by SafeCharge.
     */
    String getMerchantSiteId();

    /**
     * @return the current version of the API method
     */
    String getVersion();

    /**
     * @return ID of the API request in merchant system.
     */
    String getClientRequestId();

    /**
     * @return the session identifier returned, to be used as input parameter in all methods. UUID = Universal unique ID.
     */
    String getSessionToken();

    /**
     * @return ID of the transaction in merchant system.
     */
    String getClientUniqueId();

    /**
     * @return
     */
    Constants.ErrorType getErrorType();

    /**
     * @return
     */
    Constants.APIType getApiType();

}
