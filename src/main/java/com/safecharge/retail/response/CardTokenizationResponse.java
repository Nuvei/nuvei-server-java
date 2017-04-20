package com.safecharge.retail.response;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/15/2017
 */
public class CardTokenizationResponse extends PaymentCCResponse {

    private String ccTempToken;

    /**
     * @return the credit/debit card token.
     */
    public String getCcTempToken() {
        return ccTempToken;
    }

    /**
     * Sets the credit/debit card token.
     *
     * @param ccTempToken
     */
    public void setCcTempToken(String ccTempToken) {
        this.ccTempToken = ccTempToken;
    }

    @Override public String toString() {
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
