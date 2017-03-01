package com.safecharge.retail.test.workflow;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.safecharge.retail.model.MerchantInfo;
import com.safecharge.retail.request.GetOrderDetailsRequest;
import com.safecharge.retail.request.GetSessionTokenRequest;
import com.safecharge.retail.request.OpenOrderRequest;
import com.safecharge.retail.request.PaymentCCRequest;
import com.safecharge.retail.request.SafechargeRequest;
import com.safecharge.retail.request.UpdateOrderRequest;
import com.safecharge.retail.response.SafechargeOrderResponse;
import com.safecharge.retail.response.SafechargeResponse;
import com.safecharge.retail.test.BaseTest;
import com.safecharge.retail.util.Constants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/16/2017
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING) public class CreditCardWorkflowTest extends BaseTest {

    // All static field values will be shared between tests
    private static String sessionToken;
    private static String orderId;
    private static MerchantInfo merchantInfo;

    @Before public void init() {
        super.init();
        merchantInfo = new MerchantInfo("2QMy87kirFbtdkl6Ubk9xCqhNICYNCewiOCm19DhJp3lqAI6lp7Oh2rZsn61LVw9", "2885023999185468261", "5612",
                Constants.HashAlgorithm.SHA256);

    }

    @Test public void test1_getSessionTokenTest() throws IOException {
        SafechargeRequest safechargeRequest = new GetSessionTokenRequest.Builder().addMerchantInfo(merchantInfo)
                                                                                  .build();
        SafechargeResponse response = safechargeRequestExecutor.executeRequest(safechargeRequest);

        Assert.assertTrue(response != null);
        Assert.assertTrue(Constants.APIResponseStatus.SUCCESS.equals(response.getStatus()));
        sessionToken = response.getSessionToken();
    }

    @Test public void test2_openOrder() {
        SafechargeRequest openOrderRequest = new OpenOrderRequest.Builder().addMerchantInfo(merchantInfo)
                                                                           .addCurrency("EUR")
                                                                           .addAmount("2")
                                                                           .addSessionToken(sessionToken)
                                                                           .addItem("test_item_1", "1", "1")
                                                                           .addItem("test_item_2", "1", "1")
                                                                           .addUserDetails("Test street 1", "Sofia", "BG", "test@test.com", "Test",
                                                                                   "Testov", "0884123456", null, "1000")
                                                                           .addBillingDetails("Test", "Testov", "test@test.com", "0884123456",
                                                                                   "Test street 1", "Sofia", "BG", null, "1000", "0884123456")
                                                                           .addShippingDetails("Test", "Testov", "test@test.com", "0884123456",
                                                                                   "Test street 1", "Sofia", "BG", null, "1000", "0884123456")
                                                                           .build();
        SafechargeOrderResponse openOrderResponse = (SafechargeOrderResponse) safechargeRequestExecutor.executeRequest(openOrderRequest);

        Assert.assertTrue(openOrderResponse != null);
        Assert.assertTrue(Constants.APIResponseStatus.SUCCESS.equals(openOrderResponse.getStatus()));

        orderId = openOrderResponse.getOrderId();
        Assert.assertTrue(orderId != null && !orderId.isEmpty());
    }

    @Test public void test3_updateOrder() {
        SafechargeRequest updateOrderRequest = new UpdateOrderRequest.Builder().addMerchantInfo(merchantInfo)
                                                                               .addCurrency("EUR")
                                                                               .addAmount("2")
                                                                               .addSessionToken(sessionToken)
                                                                               .addItem("test_item_1", "1", "1")
                                                                               .addItem("test_item_2", "1", "1")
                                                                               .addUserDetails("Test street 1", "Sofia", "BG", "test@test.com",
                                                                                       "Test", "Testov", "0884123456", null, "1000")
                                                                               .addBillingDetails("Test", "Testov", "test@test.com", "0884123456",
                                                                                       "Test street 1", "Sofia", "BG", null, "1000", "0884123456")
                                                                               .addShippingDetails("Test", "Testov", "test@test.com", "0884123456",
                                                                                       "Test street 1", "Sofia", "BG", null, "1000", "0884123456")
                                                                               .addOrderId(orderId)
                                                                               .build();

        SafechargeOrderResponse updateOrderResponse = (SafechargeOrderResponse) safechargeRequestExecutor.executeRequest(updateOrderRequest);

        Assert.assertTrue(updateOrderResponse != null);
        Assert.assertTrue(Constants.APIResponseStatus.SUCCESS.equals(updateOrderResponse.getStatus()));
    }

    @Test public void test4_getOrderDetails() {
        SafechargeRequest safechargeRequest = new GetOrderDetailsRequest.Builder().setOrderId(orderId)
                                                                                  .addMerchantInfo(merchantInfo)
                                                                                  .addSessionToken(sessionToken)
                                                                                  .build();
        SafechargeResponse response = safechargeRequestExecutor.executeRequest(safechargeRequest);

        Assert.assertTrue(response != null);
        Assert.assertTrue(Constants.APIResponseStatus.SUCCESS.equals(response.getStatus()));
    }

    @Test public void test5_paymentCC() {
        SafechargeRequest request = new PaymentCCRequest.Builder().addMerchantInfo(merchantInfo)
                                                                  .addCurrency("EUR")
                                                                  .addAmount("2")
                                                                  .addSessionToken(sessionToken)
                                                                  .addItem("test_item_1", "1", "1")
                                                                  .addItem("test_item_2", "1", "1")
                                                                  .addUserDetails("Test street 1", "Sofia", "BG", "test@test.com", "Test", "Testov",
                                                                          "0884123456", null, "1000")
                                                                  .addBillingDetails("Test", "Testov", "test@test.com", "0884123456", "Test street 1",
                                                                          "Sofia", "BG", null, "1000", "0884123456")
                                                                  .addShippingDetails("Test", "Testov", "test@test.com", "0884123456",
                                                                          "Test street 1", "Sofia", "BG", null, "1000", "0884123456")
                                                                  .addOrderId(orderId)
                                                                  .addCardData("4111111111111111", "Test Testov", "10", "2022", null, "123")
                                                                  .addTransactionType(Constants.TransactionType.Sale)
                                                                  // TODO add test with UserPaymentOption
                                                                  .build();
        SafechargeResponse response = safechargeRequestExecutor.executeRequest(request);

        Assert.assertTrue(response != null);
        Assert.assertTrue(Constants.APIResponseStatus.SUCCESS.equals(response.getStatus()));

    }

}
