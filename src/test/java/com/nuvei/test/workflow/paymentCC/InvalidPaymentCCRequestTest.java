/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.test.workflow.paymentCC;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.nuvei.model.MerchantDetails;
import com.nuvei.model.MerchantInfo;
import com.nuvei.request.PaymentCCRequest;
import com.nuvei.request.NuveiBaseRequest;
import com.nuvei.response.GetSessionTokenResponse;
import com.nuvei.response.PaymentCCResponse;
import com.nuvei.test.workflow.TestVariables;
import com.nuvei.util.Constants;

/**
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @since 3/29/2017
 */
public class InvalidPaymentCCRequestTest extends BasePaymentCCTest {

    private static final MerchantInfo validMerchantInfo = new MerchantInfo("", "", "", "http://dummy:1234/ppp/", Constants.HashAlgorithm.MD5);

    @Test
    public void testExpiredSession() {
        GetSessionTokenResponse getSessionTokenResponse = executeGetSessionTokenRequest(validMerchantInfo);

        Mockito.when(nuveiRequestExecutor.executeRequest(Mockito.any(PaymentCCRequest.class)))
                .thenReturn(gson.fromJson(
                        "{\"userPaymentOptionId\":\"\",\"userTokenId\":\"Тest_0065\",\"sessionToken\":\"7d051160-4337-45f4-b11d-a31aa6df98c9\",\"clientUniqueId\":\"UniqueId\",\"internalRequestId\":13150706,\"status\":\"ERROR\",\"errCode\":1042,\"reason\":\"Invalid token\",\"merchantId\":\"5137702336228767168\",\"merchantSiteId\":\"23\",\"version\":\"1.0\",\"clientRequestId\":\"111899\"}",
                        PaymentCCResponse.class));

        NuveiBaseRequest request = PaymentCCRequest.builder()
                .addSessionToken(getSessionTokenResponse.getSessionToken())
                .addMerchantInfo(validMerchantInfo)
                .addUserTokenId(TestVariables.userTokenId)
                .addCurrency(TestVariables.currency)
                .addAmount(TestVariables.amount)
                .addItem(TestVariables.name, TestVariables.price, TestVariables.quantity)
                .addShippingDetails(TestVariables.firstName, TestVariables.lastName, TestVariables.email,
                        TestVariables.phone, TestVariables.address, TestVariables.city, TestVariables.country,
                        TestVariables.state, TestVariables.zip, TestVariables.cell, TestVariables.county)
                .addBillingDetails(TestVariables.firstName, TestVariables.lastName, TestVariables.email,
                        TestVariables.phone, TestVariables.address, TestVariables.city, TestVariables.country,
                        TestVariables.state, TestVariables.zip, TestVariables.cell, TestVariables.county)
                .addUserDetails(TestVariables.address, TestVariables.city, TestVariables.country,
                        TestVariables.email, TestVariables.firstName, TestVariables.lastName, TestVariables.phone,
                        TestVariables.state, TestVariables.zip, TestVariables.dateOfBirth, TestVariables.county)
                .addDeviceDetails(TestVariables.deviceType, TestVariables.deviceName, TestVariables.deviceOS,
                        TestVariables.browser, TestVariables.ipAddress)
                .addDynamicDescriptor(TestVariables.merchantName, TestVariables.merchantPhone)
                .addMerchantDetails(getMerchantDetails())
                .addCardData(TestVariables.cardNumber, TestVariables.cardHolderName,
                        TestVariables.expirationMonth, TestVariables.expirationYear, null, TestVariables.CVV)
                .build();

        PaymentCCResponse response = (PaymentCCResponse) nuveiRequestExecutor.executeRequest(request);

        Assert.assertTrue(Constants.ERR_CODE_INVALID_RBL_PAYMENT_TYPE == response.getErrCode());
        Assert.assertTrue("Invalid token".equals(response.getReason()));

    }

    private MerchantDetails getMerchantDetails() {

        MerchantDetails merchantDetails = new MerchantDetails();

        merchantDetails.setCustomField1(TestVariables.customField1);
        merchantDetails.setCustomField2(TestVariables.customField2);

        return merchantDetails;
    }

}
