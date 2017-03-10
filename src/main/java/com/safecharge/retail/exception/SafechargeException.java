package com.safecharge.retail.exception;

import com.safecharge.retail.util.Constants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/9/2017
 */
public class SafechargeException extends Exception {

    private Constants.APIResponseStatus status;
    private int errCode;
    private String errorReason;

    public SafechargeException() {
        super();
    }

    public SafechargeException(Constants.APIResponseStatus status, int errCode, String errorReason) {
        super(errorReason);
        this.status = status;
        this.errCode = errCode;
        this.errorReason = errorReason;
    }

    public Constants.APIResponseStatus getStatus() {
        return status;
    }

    public int getErrCode() {
        return errCode;
    }

    public String getErrorReason() {
        return errorReason;
    }
}
