/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.response;

/**
 * <p>
 * Response received from the Nuvei's servers to the {@link com.nuvei.request.RefundTransactionRequest}.
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @see com.nuvei.request.RefundTransactionRequest
 * @since 4/6/2017
 */
public class RefundTransactionResponse extends NuveiTransactionResponse {

    private String merchantAdviceCode;

    public String getMerchantAdviceCode() {
        return merchantAdviceCode;
    }

    public void setMerchantAdviceCode(String merchantAdviceCode) {
        this.merchantAdviceCode = merchantAdviceCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RefundTransactionResponse{");
        sb.append("merchantAdviceCode='").append(merchantAdviceCode).append("\',");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
