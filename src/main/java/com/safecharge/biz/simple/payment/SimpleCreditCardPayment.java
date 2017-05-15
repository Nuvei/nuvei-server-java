package com.safecharge.biz.simple.payment;

import com.safecharge.biz.SafechargeRequestExecutor;
import com.safecharge.model.CardData;
import com.safecharge.request.GetSessionTokenRequest;
import com.safecharge.response.PaymentsResponse;
import com.safecharge.model.MerchantInfo;
import com.safecharge.request.PaymentCCRequest;
import com.safecharge.request.SafechargeRequest;
import com.safecharge.response.SafechargeResponse;
import com.safecharge.util.Constants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/27/2017
 */
public class SimpleCreditCardPayment {

    private MerchantInfo merchantInfo;

    private SafechargeRequestExecutor requestExecutor = SafechargeRequestExecutor.getInstance();

    public SimpleCreditCardPayment(MerchantInfo merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    public PaymentsResponse executeAuthPayment(CardData cardData, String amount, String currency) {
        return executePayment(cardData, amount, currency, Constants.TransactionType.Auth);
    }

    public PaymentsResponse executeSalePayment(CardData cardData, String amount, String currency) {
        return executePayment(cardData, amount, currency, Constants.TransactionType.Sale);
    }

    private PaymentsResponse executePayment(CardData cardData, String amount, String currency, Constants.TransactionType transactionType) {
        SafechargeResponse getSessionTokenResponse = requestExecutor.executeRequest(GetSessionTokenRequest.builder()
                                                                                                          .addMerchantInfo(merchantInfo)
                                                                                                          .build());

        if (getSessionTokenResponse != null && Constants.APIResponseStatus.SUCCESS.equals(getSessionTokenResponse.getStatus())) {
            SafechargeRequest paymentCCRequest = PaymentCCRequest.builder()
                                                                 .addSessionToken(getSessionTokenResponse.getSessionToken())
                                                                 .addMerchantInfo(merchantInfo)
                                                                 .addCurrency(currency)
                                                                 .addAmount(amount)
                                                                 .addCardData(cardData)
                                                                 .addTransactionType(transactionType)
                                                                 .addItem("fast-payment-cc", amount, "1")
                                                                 .build();
            return (PaymentsResponse) requestExecutor.executeRequest(paymentCCRequest);
        } else {
            return null;
        }
    }
}
