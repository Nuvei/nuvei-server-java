package com.safecharge.biz.simple.payment;

import com.safecharge.biz.SafechargeRequestExecutor;
import com.safecharge.model.CardData;
import com.safecharge.model.ExternalMpi;
import com.safecharge.model.MerchantInfo;
import com.safecharge.request.GetSessionTokenRequest;
import com.safecharge.request.PaymentCCRequest;
import com.safecharge.request.SafechargeBaseRequest;
import com.safecharge.response.PaymentsResponse;
import com.safecharge.response.SafechargeResponse;
import com.safecharge.util.Constants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * An example class demonstrating the use of the Safecharge's API to process a payment using credit card.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/27/2017
 */
public class SimpleCreditCardPayment {

    private MerchantInfo merchantInfo;

    private SafechargeRequestExecutor requestExecutor = SafechargeRequestExecutor.getInstance();

    /**
     * Even if this constructor allows the {@code merchantInfo} to be null, the payment request will fail due to missing parameters
     *
     * @param merchantInfo (required) A {@link MerchantInfo} object containing info needed to create a request to Safecharge
     */
    public SimpleCreditCardPayment(MerchantInfo merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    /**
     * Executes Auth transaction to check the availability of a required amount of funds.
     * No funds are collected during an authorization. For more info check the
     * <a href="https://www.safecharge.com/docs/api/#Glossary">Safecharge API glossary.</a>
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
     * <a href="https://www.safecharge.com/docs/api/#Glossary">Safecharge API glossary.</a>
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
        SafechargeResponse getSessionTokenResponse = requestExecutor
                .executeRequest(GetSessionTokenRequest.builder().addMerchantInfo(merchantInfo).build());

        if (getSessionTokenResponse != null
                && Constants.APIResponseStatus.SUCCESS.equals(getSessionTokenResponse.getStatus())) {
            SafechargeBaseRequest paymentCCRequest = PaymentCCRequest.builder()
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
