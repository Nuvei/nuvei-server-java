package com.safecharge.response;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Response received from the SafeCharge's servers to the {@link com.safecharge.request.Authorization3DRequest}.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see <a href="https://www.safecharge.com/docs/api/?java#3DSecure">3D Secure documentation</a>
 * @see com.safecharge.request.Authorization3DRequest
 * @since 2/15/2017
 */
public class Authorization3DResponse extends PaymentsResponse {

    /**
     * The 3D secure request data for the card issuer/bank.
     */
    private String paRequest;

    /**
     * URL/endpoint used to redirect the consumer to the card issuer/bank’s 3D secure verification page.
     */
    private String acsUrl;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Authorization3DResponse{");
        sb.append("paRequest='")
                .append(paRequest)
                .append('\'');
        sb.append(", acsUrl='")
                .append(acsUrl)
                .append('\'');
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
