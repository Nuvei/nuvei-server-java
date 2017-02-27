package com.safecharge.retail.response;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/15/2017
 */
public class Authorization3DResponse extends PaymentCCResponse {

    private String paRequest;
    private String acsUrl;

    public Authorization3DResponse() {
        super();
    }

    public String getPaRequest() {
        return paRequest;
    }

    public void setPaRequest(String paRequest) {
        this.paRequest = paRequest;
    }

    public String getAcsUrl() {
        return acsUrl;
    }

    public void setAcsUrl(String acsUrl) {
        this.acsUrl = acsUrl;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Authorization3DResponse{");
        sb.append("paRequest='")
          .append(paRequest)
          .append('\'');
        sb.append(", acsUrl='")
          .append(acsUrl)
          .append('\'');
        sb.append(", ");
        sb.append(sb.append(super.toString()));
        sb.append('}');
        return sb.toString();
    }
}
