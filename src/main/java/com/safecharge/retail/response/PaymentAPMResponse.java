package com.safecharge.retail.response;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/15/2017
 */
public class PaymentAPMResponse extends PaymentCCResponse implements PaymentsResponse {

    private String redirectURL;

    public PaymentAPMResponse() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getRedirectURL() {
        return redirectURL;
    }

    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentAPMResponse{");
        sb.append("redirectURL='")
          .append(redirectURL)
          .append('\'');
        sb.append(", ");
        sb.append(sb.append(super.toString()));
        sb.append('}');
        return sb.toString();
    }
}
