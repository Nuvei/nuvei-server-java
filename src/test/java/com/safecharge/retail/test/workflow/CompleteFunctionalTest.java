package com.safecharge.retail.test.workflow;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/28/2017
 */

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.safecharge.retail.model.Item;
import com.safecharge.retail.request.AddUPOAPMRequest;
import com.safecharge.retail.request.AddUPOCreditCardByTempTokenRequest;
import com.safecharge.retail.request.AddUPOCreditCardRequest;
import com.safecharge.retail.request.Authorization3DRequest;
import com.safecharge.retail.request.CardTokenizationRequest;
import com.safecharge.retail.request.GetOrderDetailsRequest;
import com.safecharge.retail.request.GetSessionTokenRequest;
import com.safecharge.retail.request.OpenOrderRequest;
import com.safecharge.retail.request.Payment3DRequest;
import com.safecharge.retail.request.PaymentAPMRequest;
import com.safecharge.retail.request.PaymentCCRequest;
import com.safecharge.retail.request.RefundTransactionRequest;
import com.safecharge.retail.request.SettleTransactionRequest;
import com.safecharge.retail.request.UpdateOrderRequest;
import com.safecharge.retail.request.VoidTransactionRequest;
import com.safecharge.retail.response.AddUPOAPMResponse;
import com.safecharge.retail.response.AddUPOCreditCardByTempTokenResponse;
import com.safecharge.retail.response.AddUPOCreditCardResponse;
import com.safecharge.retail.response.Authorization3DResponse;
import com.safecharge.retail.response.CardTokenizationResponse;
import com.safecharge.retail.response.GetOrderDetailsResponse;
import com.safecharge.retail.response.OpenOrderResponse;
import com.safecharge.retail.response.Payment3DResponse;
import com.safecharge.retail.response.PaymentAPMResponse;
import com.safecharge.retail.response.PaymentCCResponse;
import com.safecharge.retail.response.SafechargeTransactionResponse;
import com.safecharge.retail.response.SessionTokenResponse;
import com.safecharge.retail.response.UpdateOrderResponse;
import com.safecharge.retail.test.BaseTest;
import com.safecharge.retail.util.Constants;

public class CompleteFunctionalTest extends BaseTest {

    @Test public void testSessionTokenRequest() throws IOException {
        SessionTokenResponse sessionTokenResponse = baseMockTest("./mock/request/getSessionToken.json", GetSessionTokenRequest.class);

        Assert.assertTrue(defined(sessionTokenResponse.getVersion()));

        //        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());

    }

    @Test public void testGetOrderDetailsRequest() {
        GetOrderDetailsResponse response = baseMockTest("./mock/request/getOrderDetails.json", GetOrderDetailsRequest.class);

        Assert.assertTrue(defined(response.getOrderId()));
        Assert.assertTrue(defined(response.getCurrency()));
        Assert.assertTrue(response.getAmount() != null && response.getAmount() > 0.0D);
        Assert.assertTrue(response.getItems() != null && !response.getItems()
                                                                  .isEmpty());
        for (Item item : response.getItems()) {
            Assert.assertTrue(validator.validate(item)
                                       .size() == 0);
        }

        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test public void testOpenOrderRequest() {
        OpenOrderResponse response = baseMockTest("./mock/request/openOrder.json", OpenOrderRequest.class);

        Assert.assertTrue(defined(response.getOrderId()));
        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test public void testUpdateOrderRequest() {
        UpdateOrderResponse response = baseMockTest("./mock/request/updateOrder.json", UpdateOrderRequest.class);

        Assert.assertTrue(defined(response.getOrderId()));
        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test public void testPaymentCCRequest() {
        PaymentCCResponse response = baseMockTest("./mock/request/paymentCC.json", PaymentCCRequest.class);

        Assert.assertTrue(defined(response.getOrderId()));
        Assert.assertTrue(defined(response.getTransactionId()));
        Assert.assertEquals("APPROVED", response.getTransactionStatus());
        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test public void testPaymentAPMRequest() {
        PaymentAPMResponse response = baseMockTest("./mock/request/paymentAPM.json", PaymentAPMRequest.class);

        Assert.assertTrue(defined(response.getOrderId()));
        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test public void testPayment3DRequest() {
        Payment3DResponse response = baseMockTest("./mock/request/payment3D.json", Payment3DRequest.class);

        Assert.assertTrue(defined(response.getOrderId()));
        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test public void testAuthorization3DRequest() {
        Authorization3DResponse response = baseMockTest("./mock/request/authorization3D.json", Authorization3DRequest.class);

        Assert.assertTrue(defined(response.getOrderId()));
        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test public void testAddUPOCreditCardByTempTokenRequest() {
        AddUPOCreditCardByTempTokenResponse response =
                baseMockTest("./mock/request/addUPOCreditCardByTempToken.json", AddUPOCreditCardByTempTokenRequest.class);

        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test public void testCardTokenizationRequest() {
        CardTokenizationResponse response = baseMockTest("./mock/request/cardTokenization.json", CardTokenizationRequest.class);

        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test public void testAddUpoCreditCardRequest() {
        AddUPOCreditCardResponse response = baseMockTest("./mock/request/addUPOCreditCard.json", AddUPOCreditCardRequest.class);

        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test public void testAddUPOAPMRequest() {
        AddUPOAPMResponse response = baseMockTest("./mock/request/addUPOAPM.json", AddUPOAPMRequest.class);

        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test public void testSettleTransactionRequest() {
        SafechargeTransactionResponse response = baseMockTest("./mock/request/settleTransaction.json", SettleTransactionRequest.class);

        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test public void testVoidTransactionRequest() {
        SafechargeTransactionResponse response = baseMockTest("./mock/request/voidTransaction.json", VoidTransactionRequest.class);

        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test public void testRefundTransactionRequest() {
        SafechargeTransactionResponse response = baseMockTest("./mock/request/refundTransaction.json", RefundTransactionRequest.class);

        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }
}
