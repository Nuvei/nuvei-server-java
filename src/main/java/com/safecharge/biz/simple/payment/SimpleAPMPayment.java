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
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/27/2017
 */
public class SimpleAPMPayment {

    private MerchantInfo merchantInfo;

    private SafechargeRequestExecutor requestExecutor = SafechargeRequestExecutor.getInstance();

    public SimpleAPMPayment(MerchantInfo merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    public PaymentsResponse executePayment(String paymentMethod, Map<String, String> userAccountDetails, String amount, String currency, String countryCode) {
        SafechargeResponse getSessionTokenResponse = requestExecutor.executeRequest(GetSessionTokenRequest.builder()
                                                                                                          .addMerchantInfo(merchantInfo)
                                                                                                          .build());

        if (getSessionTokenResponse != null && Constants.APIResponseStatus.SUCCESS.equals(getSessionTokenResponse.getStatus())) {
            SafechargeRequest paymentCCRequest = PaymentAPMRequest.builder()
                                                                  .addSessionToken(getSessionTokenResponse.getSessionToken())
                                                                  .addMerchantInfo(merchantInfo)
                                                                  .addCountry(countryCode)
                                                                  .addCurrency(currency)
                                                                  .addAmount(amount)
                                                                  .addPaymentMethod(paymentMethod)
                                                                  .addUserAccountDetails(userAccountDetails)
                                                                  .addItem("fast-payment-cc", amount, "1")
                                                                  .build();
            return (PaymentsResponse) requestExecutor.executeRequest(paymentCCRequest);
        } else {
            return null;
        }
    }
}
