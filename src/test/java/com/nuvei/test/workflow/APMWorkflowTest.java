/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.test.workflow;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.nuvei.request.*;
import com.nuvei.response.NuveiResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.nuvei.model.MerchantInfo;
import com.nuvei.request.NuveiBaseRequest;
import com.nuvei.response.OpenOrderResponse;
import com.nuvei.response.UpdateOrderResponse;
import com.nuvei.test.BaseTest;
import com.nuvei.util.Constants;

/**
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @since 2/16/2017
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class APMWorkflowTest extends BaseTest {

    // All static field values will be shared between tests
    private static String sessionToken;
    private static String orderId;
    private static MerchantInfo merchantInfo;

    @Before
    public void init() {
        super.init();
        merchantInfo =
                new MerchantInfo("2QMy87kirFbtdkl6Ubk9xCqhNICYNCewiOCm19DhJp3lqAI6lp7Oh2rZsn61LVw9", "2885023999185468261", "http://dummy:1234/ppp/",
                        "5612", Constants.HashAlgorithm.SHA256);
    }

    @Test
    public void test1_getSessionTokenTest() throws IOException {
        NuveiBaseRequest nuveiRequest = GetSessionTokenRequest.builder()
                .addMerchantInfo(merchantInfo)
                .build();
        NuveiResponse response = (NuveiResponse) nuveiRequestExecutor.executeRequest(nuveiRequest);

        Assert.assertTrue(response != null);
        Assert.assertTrue(Constants.APIResponseStatus.SUCCESS.equals(response.getStatus()));
        sessionToken = response.getSessionToken();
    }

    @Test
    public void test2_openOrder() {
        NuveiBaseRequest openOrderRequest = OpenOrderRequest.builder()
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
                .build();
        OpenOrderResponse openOrderResponse = (OpenOrderResponse) nuveiRequestExecutor.executeRequest(openOrderRequest);

        Assert.assertTrue(openOrderResponse != null);
        Assert.assertTrue(Constants.APIResponseStatus.SUCCESS.equals(openOrderResponse.getStatus()));

        orderId = openOrderResponse.getOrderId();
        Assert.assertTrue(orderId != null && !orderId.isEmpty());
    }

    @Test
    public void test3_updateOrder() {
        NuveiBaseRequest updateOrderRequest = UpdateOrderRequest.builder()
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
                        "Sofia", "BG", null, "1000", "0884123456", "county shipping")
                .addAmountDetails("1.5", "1.0", "1.0", "0.5")
                .addOrderId(orderId)
                .build();

        UpdateOrderResponse updateOrderResponse = (UpdateOrderResponse) nuveiRequestExecutor.executeRequest(updateOrderRequest);

        Assert.assertTrue(updateOrderResponse != null);
        Assert.assertTrue(Constants.APIResponseStatus.SUCCESS.equals(updateOrderResponse.getStatus()));
    }

    @Test
    public void test4_getOrderDetails() {
        NuveiBaseRequest nuveiRequest = GetOrderDetailsRequest.builder()
                .addMerchantInfo(merchantInfo)
                .addOrderId(orderId)
                .addSessionToken(sessionToken)
                .build();
        NuveiResponse response = (NuveiResponse) nuveiRequestExecutor.executeRequest(nuveiRequest);

        Assert.assertTrue(response != null);
        Assert.assertTrue(Constants.APIResponseStatus.SUCCESS.equals(response.getStatus()));
    }

    @Test
    public void test5_paymentAPM() {
        Map<String, String> userAccountDetails = new HashMap<>();
        userAccountDetails.put("email", "nikolad_nuvei_2@abv.bg");
        userAccountDetails.put("account_id", "XX362V4DC76VU");
        NuveiBaseRequest request = PaymentAPMRequest.builder()
                .addMerchantInfo(merchantInfo)
                .addCurrency("EUR")
                .addAmount("2")
                .addSessionToken(sessionToken)
                .addItem("test_item_1", "1", "1")
                .addItem("test_item_2", "1", "1")
                .addUserDetails("Test street 1", "Sofia", "BG", "test@test.com", "Test", "Testov", "0884123456",
                        null, "1000", "1990-01-01","county usr")
                .addBillingDetails("Test", "Testov", "test@test.com", "0884123456", "Test street 1", "Sofia",
                        "BG", null, "1000", "0884123456","county billing")
                .addShippingDetails("Test", "Testov", "test@test.com", "0884123456", "Test street 1", "Sofia",
                        "BG", null, "1000", "0884123456","county shipping")
                .addAmountDetails("1.5", "1.0", "1.0", "0.5")
                .addOrderId(orderId)
                .addURLDetails("https://apmtest.gate2shop.com/nikolappp/cashier/cancel.do",
                        "https://apmtest.gate2shop.com/nikolappp/defaultPending.do",
                        "https://apmtest.gate2shop.com/nikolappp/defaultSuccess.do", null)
                .addPaymentMethod("apmgw_expresscheckout")
                .addUserAccountDetails(userAccountDetails)
                .build();
        NuveiResponse response = nuveiRequestExecutor.executeRequest(request);

        Assert.assertTrue(response != null);
        Assert.assertTrue(Constants.APIResponseStatus.SUCCESS.equals(response.getStatus()));

    }

}
