

/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.response;

/**
 * <p>
 * Response received from the Nuvei's servers to the {@link com.nuvei.request.AccountCaptureRequest}.
 * </p>
 *
 * @see com.nuvei.request.AccountCaptureRequest
 * @since 29/04/2021
 */
public class AccountCaptureResponse extends NuveiResponse {

    private String redirectUrl;
    private String userTokenId;
    private String openInExternalBrowser;

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

    public String getOpenInExternalBrowser() {
        return openInExternalBrowser;
    }

    public void setOpenInExternalBrowser(String openInExternalBrowser) {
        this.openInExternalBrowser = openInExternalBrowser;
    }
}
