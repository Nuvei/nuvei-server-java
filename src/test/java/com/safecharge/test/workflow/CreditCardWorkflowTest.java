package com.safecharge.test.workflow;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.safecharge.model.MerchantInfo;
import com.safecharge.request.GetOrderDetailsRequest;
import com.safecharge.request.GetSessionTokenRequest;
import com.safecharge.request.OpenOrderRequest;
import com.safecharge.request.PaymentCCRequest;
import com.safecharge.request.SafechargeRequest;
import com.safecharge.request.UpdateOrderRequest;
import com.safecharge.response.OpenOrderResponse;
import com.safecharge.response.SafechargeResponse;
import com.safecharge.response.UpdateOrderResponse;
import com.safecharge.test.BaseTest;
import com.safecharge.util.Constants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/16/2017
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreditCardWorkflowTest extends BaseTest {

    // All static field values will be shared between tests
    private static String sessionToken;
    private static String orderId;
    private static MerchantInfo merchantInfo;

    @Before
    public void init() {
        super.init();
        merchantInfo = new MerchantInfo("2QMy87kirFbtdkl6Ubk9xCqhNICYNCewiOCm19DhJp3lqAI6lp7Oh2rZsn61LVw9", "2885023999185468261",
                "http://192.168.102.155:8080/ppp/", "5612", Constants.HashAlgorithm.SHA256);

    }

    @Test
    public void test1_getSessionTokenTest() throws IOException {
        SafechargeRequest safechargeRequest = GetSessionTokenRequest.builder()
                .addMerchantInfo(merchantInfo)
                .build();
        SafechargeResponse response = safechargeRequestExecutor.executeRequest(safechargeRequest);

        Assert.assertTrue(response != null);
        Assert.assertTrue(Constants.APIResponseStatus.SUCCESS.equals(response.getStatus()));
        sessionToken = response.getSessionToken();
    }

    @Test
    public void test2_openOrder() {
        SafechargeRequest openOrderRequest = new OpenOrderRequest.Builder().addMerchantInfo(merchantInfo)
                .addCurrency("EUR")
                .addAmount("2")
                .addSessionToken(sessionToken)
                .addItem("test_item_1", "1", "1")
                .addItem("test_item_2", "1", "1")
                .addUserDetails("Test street 1", "Sofia", "BG", "test@test.com", "Test",
                        "Testov", "0884123456", null, "1000", "1990-01-01","county usr")
                .addBillingDetails("Test", "Testov", "test@test.com", "0884123456",
                        "Test street 1", "Sofia", "BG", null, "1000", "0884123456","county billing")
                .addShippingDetails("Test", "Testov", "test@test.com", "0884123456",
                        "Test street 1", "Sofia", "BG", null, "1000", "0884123456","county shipping")
                .addAmountDetails("1.5", "1.0", "1.0", "0.5")
                .build();
        OpenOrderResponse openOrderResponse = (OpenOrderResponse) safechargeRequestExecutor.executeRequest(openOrderRequest);

        Assert.assertTrue(openOrderResponse != null);
        Assert.assertTrue(Constants.APIResponseStatus.SUCCESS.equals(openOrderResponse.getStatus()));

        orderId = openOrderResponse.getOrderId();
        Assert.assertTrue(orderId != null && !orderId.isEmpty());
    }

    @Test
    public void test3_updateOrder() {
        SafechargeRequest updateOrderRequest = UpdateOrderRequest.builder()
                .addMerchantInfo(merchantInfo)
                .addCurrency("EUR")
                .addAmount("2")
                .addSessionToken(sessionToken)
                .addItem("test_item_1", "1", "1")
                .addItem("test_item_2", "1", "1")
                .addUserDetails("Test street 1", "Sofia", "BG", "test@test.com", "Test", "Testov",
                        "0884123456", null, "1000", "1990-01-01", "county usr")
                .addBillingDetails("Test", "Testov", "test@test.com", "0884123456", "Test street 1",
                        "Sofia", "BG", null, "1000", "0884123456","county billing")
                .addShippingDetails("Test", "Testov", "test@test.com", "0884123456", "Test street 1",
                        "Sofia", "BG", null, "1000", "0884123456","county shipping")
                .addAmountDetails("1.5", "1.0", "1.0", "0.5")
                .addOrderId(orderId)
                .build();

        UpdateOrderResponse updateOrderResponse = (UpdateOrderResponse) safechargeRequestExecutor.executeRequest(updateOrderRequest);

        Assert.assertTrue(updateOrderResponse != null);
        Assert.assertTrue(Constants.APIResponseStatus.SUCCESS.equals(updateOrderResponse.getStatus()));
    }

    @Test
    public void test4_getOrderDetails() {
        SafechargeRequest safechargeRequest = GetOrderDetailsRequest.builder()
                .addMerchantInfo(merchantInfo)
                .addOrderId(orderId)
                .addSessionToken(sessionToken)
                .build();
        SafechargeResponse response = safechargeRequestExecutor.executeRequest(safechargeRequest);

        Assert.assertTrue(response != null);
        Assert.assertTrue(Constants.APIResponseStatus.SUCCESS.equals(response.getStatus()));
    }

    @Test
    public void test5_paymentCC() {
        SafechargeRequest request = PaymentCCRequest.builder()
                .addMerchantInfo(merchantInfo)
                .addCurrency("EUR")
                .addAmount("2")
                .addSessionToken(sessionToken)
                .addItem("test_item_1", "1", "1")
                .addItem("test_item_2", "1", "1")
                .addUserDetails("Test street 1", "Sofia", "BG", "test@test.com", "Test", "Testov", "0884123456",
                        null, "1000", "1990-01-01","county usr")
                .addBillingDetails("Test", "Testov", "test@test.com", "0884123456", "Test street 1", "Sofia",
                        "BG", null, "1000", "0884123456", "county billing")
                .addShippingDetails("Test", "Testov", "test@test.com", "0884123456", "Test street 1", "Sofia",
                        "BG", null, "1000", "0884123456", "county shipping")
                .addAmountDetails("1.5", "1.0", "1.0", "0.5")
                .addOrderId(orderId)
                .addCardData("4111111111111111", "Test Testov", "10", "2022", null, "123")
                .addTransactionType(Constants.TransactionType.Sale)
                .build();
        SafechargeResponse response = safechargeRequestExecutor.executeRequest(request);

        Assert.assertTrue(response != null);
        Assert.assertTrue(Constants.APIResponseStatus.SUCCESS.equals(response.getStatus()));

    }

}
