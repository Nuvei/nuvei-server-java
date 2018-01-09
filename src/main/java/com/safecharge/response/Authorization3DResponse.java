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
public class Authorization3DResponse extends PaymentsCCResponse {

    /**
     * The 3D secure request data for the card issuer/bank.
     */
    private String paRequest;

    /**
     * URL/endpoint used to redirect the consumer to the card issuer/bank’s 3D secure verification page.
     */
    private String acsUrl;

    private String threeDFlow;

    private String eci;

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

    public String getThreeDFlow() {
        return threeDFlow;
    }

    public void setThreeDFlow(String threeDFlow) {
        this.threeDFlow = threeDFlow;
    }

    public String getEci() {
        return eci;
    }

    public void setEci(String eci) {
        this.eci = eci;
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
        sb.append(", ");
        sb.append(", threeDFlow='")
                .append(threeDFlow)
                .append('\'');
        sb.append(", ");
        sb.append(", eci='")
                .append(eci)
                .append('\'');
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
