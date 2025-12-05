/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.biz.simple.payment;

import java.util.Map;

import com.nuvei.biz.NuveiRequestExecutor;
import com.nuvei.model.MerchantInfo;
import com.nuvei.request.GetSessionTokenRequest;
import com.nuvei.request.NuveiBaseRequest;
import com.nuvei.request.PaymentAPMRequest;
import com.nuvei.response.PaymentsResponse;
import com.nuvei.response.NuveiResponse;
import com.nuvei.util.Constants;

/**
 * <p>
 * An example class demonstrating the use of the Nuvei's API to process a payment using
 * Alternative Payment Method(E.g. PayPal, Netteler, Skrill, ...).
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @since 3/27/2017
 */
public class SimpleAPMPayment {

    private MerchantInfo merchantInfo;

    private NuveiRequestExecutor requestExecutor = NuveiRequestExecutor.getInstance();

    /**
     * Even if this constructor allows the {@code merchantInfo} to be null, the payment request will fail due to missing parameters
     *
     * @param merchantInfo (required) A {@link MerchantInfo} object containing info needed to create a request 2007 - 2024 Nuvei Corporation
     */
    public SimpleAPMPayment(MerchantInfo merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    /**
     * Executes an APM payment.
     *
     * @param paymentMethod      The Nuvei's name of the payment method to use for the payment. For a list of possible
     *                           values check <a href="https://www.nuvei.com/docs/api/#apm-account-identifiers">APM Unique Nuvei Names</a>
     * @param userAccountDetails Account details specific for the concrete payment method(E.g. user, pass, tokenId, ...)
     * @param amount             The transaction amount
     * @param currency           The three character ISO currency code
     * @param countryCode        The two-letter ISO country code of the origin of the request (most payment methods have some kind of restriction)
     * @return PaymentsResponse object(containing the transaction result) or null if the obtaining of a session is unsuccessful
     */
    public PaymentsResponse executePayment(String paymentMethod, Map<String, String> userAccountDetails, String amount, String currency, String countryCode) {
        NuveiResponse getSessionTokenResponse = requestExecutor.executeRequest(GetSessionTokenRequest.builder()
                .addMerchantInfo(merchantInfo)
                .build());

        if (getSessionTokenResponse != null && Constants.APIResponseStatus.SUCCESS.equals(getSessionTokenResponse.getStatus())) {
            NuveiBaseRequest paymentAPMRequest = PaymentAPMRequest.builder()
                    .addSessionToken(getSessionTokenResponse.getSessionToken())
                    .addMerchantInfo(merchantInfo)
                    .addCurrency(currency)
                    .addAmount(amount)
                    .addPaymentMethod(paymentMethod)
                    .addUserAccountDetails(userAccountDetails)
                    .addItem("fast-payment-apm", amount, "1")
                    .build();
            return (PaymentsResponse) requestExecutor.executeRequest(paymentAPMRequest);
        } else {
            return null;
        }
    }
}
