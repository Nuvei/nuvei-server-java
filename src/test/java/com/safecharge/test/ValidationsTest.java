package com.safecharge.test;

import java.util.UUID;

import javax.validation.ConstraintViolationException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.safecharge.model.Item;
import com.safecharge.model.MerchantInfo;
import com.safecharge.request.GetMerchantPaymentMethodsRequest;
import com.safecharge.request.GetOrderDetailsRequest;
import com.safecharge.request.GetSessionTokenRequest;
import com.safecharge.request.OpenOrderRequest;
import com.safecharge.request.PaymentAPMRequest;
import com.safecharge.request.PaymentCCRequest;
import com.safecharge.request.SafechargeRequest;
import com.safecharge.request.UpdateOrderRequest;
import com.safecharge.util.Constants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/24/2017
 */
public class ValidationsTest {

    private static final MerchantInfo validMerchantInfo =
            new MerchantInfo("dummy", "1234", "1234", "http://dummy:1234/ppp/", Constants.HashAlgorithm.MD5);
    private static final MerchantInfo invalidMerchantInfo =
            new MerchantInfo("dummy", null, null, "http://dummy:1234/ppp/", Constants.HashAlgorithm.MD5);
    private static final String dummySessionToken = "dummySessionToken";
    private static final Item dummyValidItem = new Item();
    private static final Item dummyInvalidItem = new Item();
    private static final String dummyOrderId = "1234";

    @Before public void initialization() {
        dummyValidItem.setQuantity("1");
        dummyValidItem.setName("dummyValidItem");
        dummyValidItem.setPrice("1");
        dummyInvalidItem.setName("dummyInvalidItem");
    }

    @Test public void testSuccessfulValidation_GetSessionToken() {
        SafechargeRequest safechargeRequest = GetSessionTokenRequest.builder()
                                                                    .addMerchantInfo(validMerchantInfo)
                                                                    .build();
        Assert.assertTrue(safechargeRequest != null);
    }

    @Test public void testFailedValidation_GetSessionToken() {

        try {
            GetSessionTokenRequest.builder()
                                  .addMerchantInfo(invalidMerchantInfo)
                                  .build();
            Assert.fail("ConstraintViolationException expected, object creation passed successfully.");
        } catch (ConstraintViolationException e) {
            Assert.assertEquals(2, e.getConstraintViolations()
                                    .size());
        }
    }

    @Test public void testSuccessfulValidation_GetOrderDetails() {
        SafechargeRequest safechargeRequest = GetOrderDetailsRequest.builder()
                                                                    .addInternalRequestId(UUID.randomUUID()
                                                                                              .toString())
                                                                    .addClientRequestId("Test-" + Math.random() * Math.random() * 100000000)
                                                                    .addMerchantInfo(validMerchantInfo)
                                                                    .addOrderId("1234")
                                                                    .addSessionToken(dummySessionToken)
                                                                    .build();
        Assert.assertTrue(safechargeRequest != null);
    }

    @Test public void testFailedValidation_GetOrderDetails() {

        try {
            GetOrderDetailsRequest.builder()
                                  .addMerchantInfo(validMerchantInfo)
                                  .build();
            Assert.fail("ConstraintViolationException expected, object creation passed successfully.");
        } catch (ConstraintViolationException e) {
            Assert.assertEquals(2, e.getConstraintViolations()
                                    .size());
        }
    }

    @Test public void testSuccessfulValidation_OpenOrder() {
        SafechargeRequest safechargeRequest = OpenOrderRequest.builder()
                                                              .addMerchantInfo(validMerchantInfo)
                                                              .addSessionToken(dummySessionToken)
                                                              .addCurrency("EUR")
                                                              .addAmount("1")
                                                              .addItem(dummyValidItem)
                                                              .build();
        Assert.assertTrue(safechargeRequest != null);
    }

    @Test public void testFailedValidation_OpenOrder() {

        try {
            SafechargeRequest safechargeRequest = OpenOrderRequest.builder()
                                                                  .addMerchantInfo(validMerchantInfo)
                                                                  .addSessionToken(dummySessionToken)
                                                                  .addAmount("1")
                                                                  .addItem(dummyInvalidItem)
                                                                  .build();
            Assert.fail("ConstraintViolationException expected, object creation passed successfully.");
        } catch (ConstraintViolationException e) {
            Assert.assertEquals(3, e.getConstraintViolations()
                                    .size());
        }
    }

    @Test public void testSuccessfulValidation_UpdateOrder() {
        SafechargeRequest safechargeRequest = UpdateOrderRequest.builder()
                                                                .addMerchantInfo(validMerchantInfo)
                                                                .addSessionToken(dummySessionToken)
                                                                .addOrderId(dummyOrderId)
                                                                .addCurrency("EUR")
                                                                .addAmount("1")
                                                                .addItem(dummyValidItem)
                                                                .build();
        Assert.assertTrue(safechargeRequest != null);
    }

    @Test public void testFailedValidation_UpdateOrder() {

        try {
            SafechargeRequest safechargeRequest = UpdateOrderRequest.builder()
                                                                    .addMerchantInfo(validMerchantInfo)
                                                                    .addSessionToken(dummySessionToken)
                                                                    .addOrderId(dummyOrderId)
                                                                    .addAmount("1")
                                                                    .addItem(dummyInvalidItem)
                                                                    .build();
            Assert.fail("ConstraintViolationException expected, object creation passed successfully.");
        } catch (ConstraintViolationException e) {
            Assert.assertEquals(3, e.getConstraintViolations()
                                    .size());
        }
    }

    @Test public void testSuccessfulValidation_PaymentAPM() {
        SafechargeRequest safechargeRequest = PaymentAPMRequest.builder()
                                                               .addMerchantInfo(validMerchantInfo)
                                                               .addCurrency("EUR")
                                                               .addAmount("2")
                                                               .addSessionToken(dummySessionToken)
                                                               .addItem("test_item_1", "1", "1")
                                                               .addItem("test_item_2", "1", "1")
                                                               .addUserDetails("Test street 1", "Sofia", "BG", "test@test.com", "Test", "Testov",
                                                                       "0884123456", null, "1000", "1990-01-01")
                                                               .addBillingDetails("Test", "Testov", "test@test.com", "0884123456", "Test street 1",
                                                                       "Sofia", "BG", null, "1000", "0884123456")
                                                               .addShippingDetails("Test", "Testov", "test@test.com", "0884123456", "Test street 1",
                                                                       "Sofia", "BG", null, "1000", "0884123456")
                                                               .addOrderId(dummyOrderId)
                                                               .addCountry("US")
                                                               .addURLDetails("https://apmtest.gate2shop.com/nikolappp/cashier/cancel.do",
                                                                       "https://apmtest.gate2shop.com/nikolappp/defaultPending.do",
                                                                       "https://apmtest.gate2shop.com/nikolappp/defaultSuccess.do", null)
                                                               .addPaymentMethod("apmgw_expresscheckout")
                                                               .build();
        Assert.assertTrue(safechargeRequest != null);
    }

    @Test public void testFailedValidation_PaymentAPM() {

        try {
            SafechargeRequest safechargeRequest = PaymentAPMRequest.builder()
                                                                   .addMerchantInfo(invalidMerchantInfo)
                                                                   .addSessionToken(dummySessionToken)
                                                                   .addItem(null, "1", "1")
                                                                   .addUserDetails("Test street 1 ", "Sofia", "BG", "test@test.com",
                                                                           "Test street 1 Test street 1 Test street 1 Test street 1 ",
                                                                           "Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 ",
                                                                           "0884123456", null, "1000", "1990-01-01")
                                                                   .addBillingDetails("Test", "Testov", "test@test.com", "0884123456",
                                                                           "Test street 1", "Sofia", "BG", null, "1000", "0884123456")
                                                                   .addShippingDetails("Test", "Testov", "test@test.com", "0884123456",
                                                                           "Test street 1", "Sofia", "BG", null, "1000", "0884123456")
                                                                   .addOrderId(dummyOrderId)
                                                                   .addURLDetails("https://apmtest.gate2shop.com/nikolappp/cashier/cancel.do",
                                                                           "https://apmtest.gate2shop.com/nikolappp/defaultPending.do",
                                                                           "https://apmtest.gate2shop.com/nikolappp/defaultSuccess.do", null)
                                                                   .addPaymentMethod("apmgw_expresscheckout")
                                                                   .addCountry("US")
                                                                   .build();
            Assert.fail("ConstraintViolationException expected, object creation passed successfully.");
        } catch (ConstraintViolationException e) {
            Assert.assertEquals(7, e.getConstraintViolations()
                                    .size());
        }
    }

    @Test public void testSuccessfulValidation_PaymentCCRequest() {
        SafechargeRequest safechargeRequest = PaymentCCRequest.builder()
                                                              .addMerchantInfo(validMerchantInfo)
                                                              .addCurrency("EUR")
                                                              .addAmount("2")
                                                              .addSessionToken(dummySessionToken)
                                                              .addItem("test_item_1", "1", "1")
                                                              .addItem("test_item_2", "1", "1")
                                                              .addUserDetails("Test street 1", "Sofia", "BG", "test@test.com", "Test", "Testov",
                                                                      "0884123456", null, "1000", "1990-01-01")
                                                              .addBillingDetails("Test", "Testov", "test@test.com", "0884123456", "Test street 1",
                                                                      "Sofia", "BG", null, "1000", "0884123456")
                                                              .addShippingDetails("Test", "Testov", "test@test.com", "0884123456", "Test street 1",
                                                                      "Sofia", "BG", null, "1000", "0884123456")
                                                              .addOrderId(dummyOrderId)
                                                              .addTransactionType(Constants.TransactionType.Sale)
                                                              .addCardData("4111111111111111", "Test Test", "11", "2011", null, "123")
                                                              .build();
        Assert.assertTrue(safechargeRequest != null);
    }

    @Test public void testFailedValidation_PaymentCCRequest() {

        try {
            SafechargeRequest safechargeRequest = PaymentCCRequest.builder()
                                                                  .addMerchantInfo(invalidMerchantInfo)
                                                                  .addSessionToken(dummySessionToken)
                                                                  .addItem(null, "1", "1")
                                                                  .addUserDetails("Test street 1 ", "Sofia", "BG", "test@test.com",
                                                                          "Test street 1 Test street 1 Test street 1 Test street 1 ",
                                                                          "Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 Test street 1 ",
                                                                          "0884123456", null, "1000", "1990-01-01")
                                                                  .addBillingDetails("Test", "Testov", "test@test.com", "0884123456", "Test street 1",
                                                                          "Sofia", "BG", null, "1000", "0884123456")
                                                                  .addShippingDetails("Test", "Testov", "test@test.com", "0884123456",
                                                                          "Test street 1", "Sofia", "BG", null, "1000", "0884123456")
                                                                  .addOrderId(dummyOrderId)
                                                                  .addCardData(null, null, "11", "2011", null, "123")
                                                                  .addUserPaymentOption(null, "12")
                                                                  .build();
            Assert.fail("ConstraintViolationException expected, object creation passed successfully.");
        } catch (ConstraintViolationException e) {
            Assert.assertEquals(8, e.getConstraintViolations()
                                    .size());
        }
    }

    @Test public void testFailedValidation_GetPaymentMethodsListRequest() {

        try {
            GetMerchantPaymentMethodsRequest.builder()
                                            .addMerchantInfo(validMerchantInfo)
                                            .addSessionToken(dummySessionToken)
                                            .addCountryCode("Ukraine")
                                            .addLanguageCode("Russian")
                                            .addCurrencyCode("Euro")
                                            .build();
            Assert.fail("ConstraintViolationException expected, object creation passed successfully.");
        } catch (ConstraintViolationException e) {
            Assert.assertEquals(3, e.getConstraintViolations()
                                    .size());
        }
    }
}
