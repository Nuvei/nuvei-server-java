package com.safecharge.test.workflow;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/28/2017
 */

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.safecharge.model.Item;
import com.safecharge.request.AddUPOAPMRequest;
import com.safecharge.request.AddUPOCreditCardByTempTokenRequest;
import com.safecharge.request.AddUPOCreditCardRequest;
import com.safecharge.request.Authorization3DRequest;
import com.safecharge.request.CardTokenizationRequest;
import com.safecharge.request.CreateUserRequest;
import com.safecharge.request.GetMerchantPaymentMethodsRequest;
import com.safecharge.request.GetOrderDetailsRequest;
import com.safecharge.request.GetSessionTokenRequest;
import com.safecharge.request.OpenOrderRequest;
import com.safecharge.request.Payment3DRequest;
import com.safecharge.request.PaymentAPMRequest;
import com.safecharge.request.PaymentCCRequest;
import com.safecharge.request.PayoutRequest;
import com.safecharge.request.RefundTransactionRequest;
import com.safecharge.request.SettleTransactionRequest;
import com.safecharge.request.UpdateOrderRequest;
import com.safecharge.request.UpdateUserRequest;
import com.safecharge.request.VoidTransactionRequest;
import com.safecharge.response.AddUPOAPMResponse;
import com.safecharge.response.AddUPOCreditCardByTempTokenResponse;
import com.safecharge.response.AddUPOCreditCardResponse;
import com.safecharge.response.Authorization3DResponse;
import com.safecharge.response.CardTokenizationResponse;
import com.safecharge.response.UserResponse;
import com.safecharge.response.GetMerchantPaymentMethodsResponse;
import com.safecharge.response.GetOrderDetailsResponse;
import com.safecharge.response.GetSessionTokenResponse;
import com.safecharge.response.OpenOrderResponse;
import com.safecharge.response.Payment3DResponse;
import com.safecharge.response.PaymentAPMResponse;
import com.safecharge.response.PaymentCCResponse;
import com.safecharge.response.PayoutResponse;
import com.safecharge.response.RefundTransactionResponse;
import com.safecharge.response.SettleTransactionResponse;
import com.safecharge.response.UpdateOrderResponse;
import com.safecharge.response.VoidTransactionResponse;
import com.safecharge.test.BaseTest;
import com.safecharge.util.Constants;

public class CompleteFunctionalTest extends BaseTest {

    @Test
    public void testSessionTokenRequest() throws IOException {
        GetSessionTokenResponse getSessionTokenResponse = baseMockTest("./mock/request/getSessionToken.json", GetSessionTokenRequest.class);

        Assert.assertTrue(defined(getSessionTokenResponse.getVersion()));

        //        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());

    }

    @Test
    public void testGetOrderDetailsRequest() {
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

    @Test
    public void testOpenOrderRequest() {
        OpenOrderResponse response = baseMockTest("./mock/request/openOrder.json", OpenOrderRequest.class);

        Assert.assertTrue(defined(response.getOrderId()));
        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test
    public void testUpdateOrderRequest() {
        UpdateOrderResponse response = baseMockTest("./mock/request/updateOrder.json", UpdateOrderRequest.class);

        Assert.assertTrue(defined(response.getOrderId()));
        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test
    public void testPaymentCCRequest() {
        PaymentCCResponse response = baseMockTest("./mock/request/paymentCC.json", PaymentCCRequest.class);

        Assert.assertTrue(defined(response.getOrderId()));
        Assert.assertTrue(defined(response.getTransactionId()));
        Assert.assertEquals("APPROVED", response.getTransactionStatus());
        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test
    public void testPaymentAPMRequest() {
        PaymentAPMResponse response = baseMockTest("./mock/request/paymentAPM.json", PaymentAPMRequest.class);

        Assert.assertTrue(defined(response.getOrderId()));
        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test
    public void testPayment3DRequest() {
        Payment3DResponse response = baseMockTest("./mock/request/payment3D.json", Payment3DRequest.class);

        Assert.assertTrue(defined(response.getOrderId()));
        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test
    public void testAuthorization3DRequest() {
        Authorization3DResponse response = baseMockTest("./mock/request/authorization3D.json", Authorization3DRequest.class);

        Assert.assertTrue(defined(response.getOrderId()));
        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test
    public void testAddUPOCreditCardByTempTokenRequest() {
        AddUPOCreditCardByTempTokenResponse response =
                baseMockTest("./mock/request/addUPOCreditCardByTempToken.json", AddUPOCreditCardByTempTokenRequest.class);

        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test
    public void testCardTokenizationRequest() {
        CardTokenizationResponse response = baseMockTest("./mock/request/cardTokenization.json", CardTokenizationRequest.class);

        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test
    public void testAddUpoCreditCardRequest() {
        AddUPOCreditCardResponse response = baseMockTest("./mock/request/addUPOCreditCard.json", AddUPOCreditCardRequest.class);

        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test
    public void testAddUPOAPMRequest() {
        AddUPOAPMResponse response = baseMockTest("./mock/request/addUPOAPM.json", AddUPOAPMRequest.class);

        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test
    public void testSettleTransactionRequest() {
        SettleTransactionResponse response = baseMockTest("./mock/request/settleTransaction.json", SettleTransactionRequest.class);

        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test
    public void testVoidTransactionRequest() {
        VoidTransactionResponse response = baseMockTest("./mock/request/voidTransaction.json", VoidTransactionRequest.class);

        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test
    public void testRefundTransactionRequest() {
        RefundTransactionResponse response = baseMockTest("./mock/request/refundTransaction.json", RefundTransactionRequest.class);

        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test
    public void testGetMerchantPaymentMethodsRequest() {
        GetMerchantPaymentMethodsResponse response =
                baseMockTest("./mock/request/getMerchantPaymentMethods.json", GetMerchantPaymentMethodsRequest.class);

        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
    }

    @Test
    public void testPayoutMethodsRequest() {
        PayoutResponse response =
                baseMockTestMethodWithoutSessionToken("./mock/request/payout.json", PayoutRequest.class);

        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
        Assert.assertTrue(!response.getUserPaymentOptionId().trim().isEmpty());
        Assert.assertTrue(!response.getUserTokenId().trim().isEmpty());
    }

    @Test
    public void testCreateCashierUserMethodsRequest() {
        UserResponse response =
                baseMockTestMethodWithoutSessionToken("mock/request/createUser.json", CreateUserRequest.class);

        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
        Assert.assertTrue(response.getUserId() != 0);
        Assert.assertTrue(response.getInternalRequestId() != 0);
    }

    @Test
    public void testUpdateCashierUserMethodsRequest() {
        UserResponse response =
                baseMockTestMethodWithoutSessionToken("mock/request/updateUser.json", UpdateUserRequest.class);

        Assert.assertEquals(Constants.APIResponseStatus.SUCCESS, response.getStatus());
        Assert.assertTrue(response.getUserId() != 0);
        Assert.assertTrue(response.getInternalRequestId() != 0);
    }
}
