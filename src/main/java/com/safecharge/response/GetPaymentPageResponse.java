package com.safecharge.response;

public class GetPaymentPageResponse extends SafechargeResponse {

    private String paymentPageUrl;

    public String getPaymentPageUrl() {
        return paymentPageUrl;
    }

    public void setPaymentPageUrl(String paymentPageUrl) {
        this.paymentPageUrl = paymentPageUrl;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetPaymentPageResponse{");
        sb.append("paymentPageUrl='")
                .append(paymentPageUrl)
                .append('\'');
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}