package com.safecharge.biz.simple.payment;

import java.util.Map;

import com.safecharge.biz.SafechargeRequestExecutor;
import com.safecharge.model.MerchantInfo;
import com.safecharge.request.GetSessionTokenRequest;
import com.safecharge.request.PaymentAPMRequest;
import com.safecharge.request.SafechargeRequest;
import com.safecharge.response.PaymentsResponse;
import com.safecharge.response.SafechargeResponse;
import com.safecharge.util.Constants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * An example class demonstrating the use of the Safecharge's API to process a payment using
 * Alternative Payment Method(E.g. PayPal, Netteler, Skrill, ...).
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/27/2017
 */
public class SimpleAPMPayment {

    private MerchantInfo merchantInfo;

    private SafechargeRequestExecutor requestExecutor = SafechargeRequestExecutor.getInstance();

    /**
     * Even if this constructor allows the {@code merchantInfo} to be null, the payment request will fail due to missing parameters
     *
     * @param merchantInfo (required) A {@link MerchantInfo} object containing info needed to create a request to Safecharge
     */
    public SimpleAPMPayment(MerchantInfo merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    /**
     * Executes an APM payment.
     *
     * @param paymentMethod      The Safecharge's name of the payment method to use for the payment. For a list of possible
     *                           values check <a href="https://www.safecharge.com/docs/api/#apm-account-identifiers">APM Unique SafeCharge Names</a>
     * @param userAccountDetails Account details specific for the concrete payment method(E.g. user, pass, tokenId, ...)
     * @param amount             The transaction amount
     * @param currency           The three character ISO currency code
     * @param countryCode        The two-letter ISO country code of the origin of the request (most payment methods have some kind of restriction)
     * @return PaymentsResponse object(containing the transaction result) or null if the obtaining of a session is unsuccessful
     */
    public PaymentsResponse executePayment(String paymentMethod, Map<String, String> userAccountDetails, String amount, String currency, String countryCode) {
        SafechargeResponse getSessionTokenResponse = requestExecutor.executeRequest(GetSessionTokenRequest.builder()
                .addMerchantInfo(merchantInfo)
                .build());

        if (getSessionTokenResponse != null && Constants.APIResponseStatus.SUCCESS.equals(getSessionTokenResponse.getStatus())) {
            SafechargeRequest paymentAPMRequest = PaymentAPMRequest.builder()
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
