package com.safecharge.response;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Response received from the SafeCharge's servers to the {@link com.safecharge.request.CardTokenizationRequest}.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see <a href="https://www.safecharge.com/docs/api/?java#cardtokenization">Card Tokenization documentation</a>
 * @see com.safecharge.request.CardTokenizationRequest
 * @since 2/15/2017
 */
public class CardTokenizationResponse extends PaymentCCResponse {

    /**
     * The generated card's temporary token, if the request is successful.
     */
    private String ccTempToken;

    public String getCcTempToken() {
        return ccTempToken;
    }

    public void setCcTempToken(String ccTempToken) {
        this.ccTempToken = ccTempToken;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CardTokenizationResponse{");
        sb.append("ccTempToken='")
                .append(ccTempToken)
                .append('\'');
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
