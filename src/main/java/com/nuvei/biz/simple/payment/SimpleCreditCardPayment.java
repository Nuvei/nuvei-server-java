/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.biz.simple.payment;

import com.nuvei.biz.NuveiRequestExecutor;
import com.nuvei.model.CardData;
import com.nuvei.model.ExternalMpi;
import com.nuvei.model.MerchantInfo;
import com.nuvei.request.GetSessionTokenRequest;
import com.nuvei.request.NuveiBaseRequest;
import com.nuvei.request.PaymentCCRequest;
import com.nuvei.response.NuveiResponse;
import com.nuvei.response.PaymentsResponse;
import com.nuvei.util.Constants;

/**
 * <p>
 * An example class demonstrating the use of the Nuvei's API to process a payment using credit card.
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @since 3/27/2017
 */
public class SimpleCreditCardPayment {

    private MerchantInfo merchantInfo;

    private NuveiRequestExecutor requestExecutor = NuveiRequestExecutor.getInstance();

    /**
     * Even if this constructor allows the {@code merchantInfo} to be null, the payment request will fail due to missing parameters
     *
     * @param merchantInfo (required) A {@link MerchantInfo} object containing info needed to create a request 2007 - 2024 Nuvei Corporation
     */
    public SimpleCreditCardPayment(MerchantInfo merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    /**
     * Executes Auth transaction to check the availability of a required amount of funds.
     * No funds are collected during an authorization. For more info check the
     * <a href="https://www.nuvei.com/docs/api/#Glossary">Nuvei API glossary.</a>
     *
     * @param cardData An object representing credit card
     * @param amount   The amount which availability should be checked
     * @param currency The three character ISO currency code
     * @return PaymentsResponse object(containing the transaction result) or null if the obtaining of a session is unsuccessful
     */
    public PaymentsResponse executeAuthPayment(CardData cardData, String amount, String currency, String isPartialApproval, ExternalMpi externalMpi) {
        return executePayment(cardData, amount, currency, Constants.TransactionType.Auth, isPartialApproval, externalMpi);
    }

    /**
     * Executes both Auth and Sale transaction to check the availability of a required amount of funds and settle the transaction.
     * For more info check the
     * <a href="https://www.nuvei.com/docs/api/#Glossary">Nuvei API glossary.</a>
     *
     * @param cardData An object representing credit card
     * @param amount   The amount which availability should be checked
     * @param currency The three character ISO currency code
     * @return PaymentsResponse object(containing the transaction result) or null if the obtaining of a session is unsuccessful
     */
    public PaymentsResponse executeSalePayment(CardData cardData, String amount, String currency, String isPartialApproval, ExternalMpi externalMpi) {
        return executePayment(cardData, amount, currency, Constants.TransactionType.Sale, isPartialApproval, externalMpi);
    }

    private PaymentsResponse executePayment(CardData cardData, String amount, String currency,
            Constants.TransactionType transactionType, String isPartialApproval, ExternalMpi externalMpi) {
        NuveiResponse getSessionTokenResponse = requestExecutor
                .executeRequest(GetSessionTokenRequest.builder().addMerchantInfo(merchantInfo).build());

        if (getSessionTokenResponse != null
                && Constants.APIResponseStatus.SUCCESS.equals(getSessionTokenResponse.getStatus())) {
            NuveiBaseRequest paymentCCRequest = PaymentCCRequest.builder()
                    .addSessionToken(getSessionTokenResponse.getSessionToken())
                    .addMerchantInfo(merchantInfo)
                    .addCurrency(currency)
                    .addAmount(amount)
                    .addCardData(cardData)
                    .addTransactionType(transactionType)
                    .addItem("fast-payment-cc", amount, "1")
                    .addIsPartialApproval(isPartialApproval)
                    .addExternalMpi(externalMpi)
                    .build();
            return (PaymentsResponse) requestExecutor.executeRequest(paymentCCRequest);
        } else {
            return null;
        }
    }
}
