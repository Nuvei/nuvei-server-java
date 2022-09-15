/*
 * Copyright (c) 2007-2021 SafeCharge International Group Limited.
 */

package com.safecharge.response;

/**
 * <p>
 * Response received from the SafeCharge's servers to the {@link com.safecharge.request.AccountCaptureRequest}.
 * </p>
 *
 * @see com.safecharge.request.AccountCaptureRequest
 * @since 29/04/2021
 */
public class AccountCaptureResponse extends SafechargeResponse {

    private String redirectUrl;
    private String userTokenId;

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }
}
