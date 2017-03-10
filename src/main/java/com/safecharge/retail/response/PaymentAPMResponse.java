package com.safecharge.retail.response;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/15/2017
 */
public class PaymentAPMResponse extends BasePaymentsResponse implements PaymentsResponse {

    private String redirectURL;

    public PaymentAPMResponse() {
        super();
    }

    /**
     * @return URL that will be used by merchant to redirect end user to the payment method for authentication and authorization of the payment. Will be returned only if the APM payment is done using redirect APM flow.
     */
    public String getRedirectURL() {
        return redirectURL;
    }

    /**
     * URL that will be used by merchant to redirect end user to the payment method for authentication and authorization of the payment. Will be returned only if the APM payment is done using redirect APM flow.
     *
     * @param redirectURL
     */
    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentAPMResponse{");
        sb.append("redirectURL='")
          .append(redirectURL)
          .append('\'');
        sb.append(", ")
          .append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
