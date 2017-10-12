package com.safecharge.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Test;

import com.safecharge.model.CardData;
import com.safecharge.model.CashierUserDetails;
import com.safecharge.model.Item;
import com.safecharge.model.MerchantInfo;
import com.safecharge.model.UrlDetails;
import com.safecharge.model.UserAddress;
import com.safecharge.request.AddUPOAPMRequest;
import com.safecharge.request.AddUPOCreditCardByTempTokenRequest;
import com.safecharge.request.AddUPOCreditCardRequest;
import com.safecharge.request.Authorization3DRequest;
import com.safecharge.request.CancelSubscriptionRequest;
import com.safecharge.request.CardTokenizationRequest;
import com.safecharge.request.CreateSubscriptionRequest;
import com.safecharge.request.GetMerchantPaymentMethodsRequest;
import com.safecharge.request.GetOrderDetailsRequest;
import com.safecharge.request.GetSessionTokenRequest;
import com.safecharge.request.GetSubscriptionPlansRequest;
import com.safecharge.request.GetSubscriptionsListRequest;
import com.safecharge.request.OpenOrderRequest;
import com.safecharge.request.Payment3DRequest;
import com.safecharge.request.PaymentAPMRequest;
import com.safecharge.request.PaymentCCRequest;
import com.safecharge.request.RefundTransactionRequest;
import com.safecharge.request.SafechargeRequest;
import com.safecharge.request.SettleTransactionRequest;
import com.safecharge.request.UpdateOrderRequest;
import com.safecharge.request.VoidTransactionRequest;
import com.safecharge.util.AddressUtils;
import com.safecharge.util.Constants;
import com.safecharge.util.UrlUtils;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/24/2017
 */
public class ValidationsTest {

    private static final String CONSTRAINT_VIOLATION_EXCEPTION_EXPECTED_BUT_OBJECT_CREATION_PASSED_SUCCESSFULLY =
            "ConstraintViolationException expected, but object creation passed successfully";
    private static final MerchantInfo validMerchantInfo =
            new MerchantInfo("dummy", "1234", "1234", "http://dummy:1234/ppp/", Constants.HashAlgorithm.MD5);
    private static final MerchantInfo invalidMerchantInfo =
            new MerchantInfo("dummy", null, null, "http://dummy:1234/ppp/", Constants.HashAlgorithm.MD5);
    private static final String dummySessionToken = "dummySessionToken";

    private static final Item dummyValidItem = new Item();
    private static final Item dummyValidItem2 = new Item();
    private static final Item dummyInvalidItem = new Item();

    private static final String dummyOrderId = "1234";
    private static final String dummyUserId = "dummyUserId";
    private static final Map<String, String> dummyValidApmData = new HashMap<>();
    private static final String dummyPaymentMethodName = "dummyPaymentMethodName";
    private static final String dummyCcToken = "dummyCcToken";

    private static final String validAmount = "1.00";
    private static final String invalidAmount = "-1.00";

    private static final String validAmountTwoItems = "5.00";
    private static final String invalidAmountTwoItems = "-5.00";

    private static final String validCurrencyCode = "EUR";
    private static final String invalidCurrencyCode = "Euro";

    private static final String validCountryCode = "GB";
    private static final String invalidCountryCode = "Ukraine";

    private static final String validLanguageCode = "en";
    private static final String invalidLanguageCode = "Russian";

    private static final CardData dummyCardData = new CardData();
    private static final String dummySubscriptionPlanId = "123456";
    private static final String dummyRelatedTransactionId = "1234567";
    private static final String dummyAuthCode = "auth_code";

    private static final CashierUserDetails dummyValidCashierUserDetails =
            AddressUtils.createCashierUserDetailsFromParams("Test street 1", "Sofia", "BG", "test@test.com",
                    "Test", "Testov", "0884123456", null, "1000", "1990-01-01");
    private static final CashierUserDetails dummyInvalidCashierUserDetails = AddressUtils.createCashierUserDetailsFromParams("Test street 1 ", "Sofia", "BG", "invalid_email",
            "Test Long Name that should fail the validation! Test Long Name that should fail the validation!",
            "Test Long Name that should fail the validation! Test Long Name that should fail the validation! Test Long Name that should fail the validation!",
            "0884123456", null, "1000", "1990-01-01");

    private static final UserAddress dummyValidBillingDetails =
            AddressUtils.createUserAddressFromParams("Test", "Testov", "test@test.com", "0884123456", "Test street 1",
                    "Sofia", "BG", null, "1000", "0884123456");
    private static final UserAddress dummyValidShippingDetails = dummyValidBillingDetails; //shipping address same as billing address

    private static final UserAddress dummyInvalidBillingDetails =
            AddressUtils.createUserAddressFromParams("Test Long Name that should fail the validation! Test Long Name that should fail the validation!",
                    "Test Long Name that should fail the validation! Test Long Name that should fail the validation! Test Long Name that should fail the validation!",
                    "invalid_email", "0884123456", "Test street 1",
                    "Sofia", "BG", null, "1000", "0884123456");
    private static final UserAddress dummyInvalidShippingDetails = dummyInvalidBillingDetails; //shipping address same as billing address

    private static final UrlDetails dummyValidUrlDetails = UrlUtils.createUrlDetails("https://apmtest.gate2shop.com/nikolappp/cashier/cancel.do",
            "https://apmtest.gate2shop.com/nikolappp/defaultPending.do",
            "https://apmtest.gate2shop.com/nikolappp/defaultSuccess.do", null);
    private static final UrlDetails dummyInvalidUrlDetails = UrlUtils.createUrlDetails("https://apmtest.gate2shop.com/nikolappp/cashier/cancel.do",
            "https://apmtest.gate2shop.com/nikolappp/defaultPending.do",
            "https://apmtest.gate2shop.com/nikolappp/defaultSuccess.do https://apmtest.gate2shop.com/nikolappp/defaultSuccess.do" +
                    "https://apmtest.gate2shop.com/nikolappp/defaultSuccess.do https://apmtest.gate2shop.com/nikolappp/defaultSuccess.do" +
                    "https://apmtest.gate2shop.com/nikolappp/defaultSuccess.do https://apmtest.gate2shop.com/nikolappp/defaultSuccess.do" +
                    "https://apmtest.gate2shop.com/nikolappp/defaultSuccess.do https://apmtest.gate2shop.com/nikolappp/defaultSuccess.do" +
                    "https://apmtest.gate2shop.com/nikolappp/defaultSuccess.do https://apmtest.gate2shop.com/nikolappp/defaultSuccess.do" +
                    "https://apmtest.gate2shop.com/nikolappp/defaultSuccess.do https://apmtest.gate2shop.com/nikolappp/defaultSuccess.do" +
                    "https://apmtest.gate2shop.com/nikolappp/defaultSuccess.do https://apmtest.gate2shop.com/nikolappp/defaultSuccess.do" +
                    "https://apmtest.gate2shop.com/nikolappp/defaultSuccess.do https://apmtest.gate2shop.com/nikolappp/defaultSuccess.do", null);

    private static final String validPaymentMethodName = "apmgw_expresscheckout";

    private static final String dummyCcCardNumber = "4111 1111 1111 1111";
    private static final String dummyCcExpMonth = "12";
    private static final String dummyCcExpYear = "22";
    private static final String dummyCcNameOnCard = "Ivan Ivanov";

    @Before
    public void initialization() {
        dummyValidItem.setQuantity("1");
        dummyValidItem.setName("dummyValidItem");
        dummyValidItem.setPrice("1");
        dummyValidItem2.setQuantity("2");
        dummyValidItem2.setName("dummyValidItem2");
        dummyValidItem2.setPrice("2");

        dummyInvalidItem.setName("dummyInvalidItem");

        dummyValidApmData.put("dummyUserName", "dummyExample");

        dummyCardData.setCardHolderName("dummyName");
        dummyCardData.setCardNumber("4111 1111 1111 1111");
        dummyCardData.setCVV("123");
        dummyCardData.setExpirationMonth("01");
        dummyCardData.setExpirationYear("2020");

    }

    @Test
    public void testSuccessfulValidation_AddUPOAPMRequest() {

        SafechargeRequest safechargeRequest = AddUPOAPMRequest.builder()
                .addMerchantInfo(validMerchantInfo)
                .addApmData(dummyValidApmData)
                .addUserTokenId(dummyUserId)
                .addPaymentMethodName(dummyPaymentMethodName)
                .build();
        assertTrue(safechargeRequest != null);
    }

    @Test
    public void testFailedValidation_AddUPOAPMRequest() {

        try {
            AddUPOAPMRequest.builder()
                    .addMerchantInfo(invalidMerchantInfo)
                    .build();
            fail(CONSTRAINT_VIOLATION_EXCEPTION_EXPECTED_BUT_OBJECT_CREATION_PASSED_SUCCESSFULLY);
        } catch (ConstraintViolationException e) {
            assertEquals(5, e.getConstraintViolations().size());
        }
    }

    @Test
    public void testSuccessfulValidation_AddUPOCreditCardByTempTokenRequest() {

        SafechargeRequest safechargeRequest = AddUPOCreditCardByTempTokenRequest.builder()
                .addMerchantInfo(validMerchantInfo)
                .addCCTempToken(dummyCcToken)
                .addUserTokenId(dummyUserId)
                .build();
        assertTrue(safechargeRequest != null);
    }

    @Test
    public void testFailedValidation_AddUPOCreditCardByTempTokenRequest() {

        try {
            SafechargeRequest safechargeRequest = AddUPOCreditCardByTempTokenRequest.builder()
                    .addMerchantInfo(invalidMerchantInfo)
                    .build();
        } catch (ConstraintViolationException e) {
            assertEquals(4, e.getConstraintViolations().size());
        }
    }

    @Test
    public void testSuccessfulValidation_AddUPOCreditCardRequest() {

        SafechargeRequest safechargeRequest = AddUPOCreditCardRequest.builder()
                .addMerchantInfo(validMerchantInfo)
                .addUserTokenId(dummyUserId)
                .addCcCardNumber(dummyCcCardNumber)
                .addCcExpMonth(dummyCcExpMonth)
                .addCCExpYear(dummyCcExpYear)
                .addCcNameOnCard(dummyCcNameOnCard)
                .build();
        assertTrue(safechargeRequest != null);
    }

    @Test
    public void testFailedValidation_AddUPOCreditCardRequest() {

        try {
            AddUPOCreditCardRequest.builder()
                    .addMerchantInfo(invalidMerchantInfo)
                    .build();
            fail(CONSTRAINT_VIOLATION_EXCEPTION_EXPECTED_BUT_OBJECT_CREATION_PASSED_SUCCESSFULLY);
        } catch (ConstraintViolationException e) {
            assertEquals(7, e.getConstraintViolations().size());
        }
    }

    @Test
    public void testSuccessfulValidation_Authorization3DRequest() {

        SafechargeRequest safechargeRequest = Authorization3DRequest.builder()
                .addMerchantInfo(validMerchantInfo)
                .addSessionToken(dummySessionToken)
                .addIsDynamic3D("0")
                .addAmount(validAmount)
                .addCurrency(validCurrencyCode)
                .addItem(dummyValidItem)
                .build();
        assertTrue(safechargeRequest != null);
    }

    @Test
    public void testFailedValidation_Authorization3DRequest() {

        try {
            Authorization3DRequest.builder()
                    .addMerchantInfo(invalidMerchantInfo)
                    .build();
            fail(CONSTRAINT_VIOLATION_EXCEPTION_EXPECTED_BUT_OBJECT_CREATION_PASSED_SUCCESSFULLY);
        } catch (ConstraintViolationException e) {
            assertEquals(7, e.getConstraintViolations().size());
        }
    }

    @Test
    public void testSuccessfulValidation_CancelSubscriptionRequest() {

        SafechargeRequest safechargeRequest = CancelSubscriptionRequest.builder()
                .addMerchantInfo(validMerchantInfo)
                .addUserTokenId(dummyUserId)
                .addSubscriptionId("1234")
                .build();
        assertTrue(safechargeRequest != null);
    }

    @Test
    public void testFailedValidation_CancelSubscriptionRequest() {

        try {
            CancelSubscriptionRequest.builder()
                    .addMerchantInfo(invalidMerchantInfo)
                    .build();
            fail(CONSTRAINT_VIOLATION_EXCEPTION_EXPECTED_BUT_OBJECT_CREATION_PASSED_SUCCESSFULLY);
        } catch (ConstraintViolationException e) {
            assertEquals(4, e.getConstraintViolations().size());
        }
    }

    @Test
    public void testSuccessfulValidation_CardTokenizationRequest() {

        SafechargeRequest safechargeRequest = CardTokenizationRequest.builder()
                .addMerchantInfo(validMerchantInfo)
                .addCardData(dummyCardData)
                .build();
        assertTrue(safechargeRequest != null);
    }

    @Test
    public void testFailedValidation_CardTokenizationRequest() {

        try {
            CardTokenizationRequest.builder()
                    .addMerchantInfo(invalidMerchantInfo)
                    .build();

            fail(CONSTRAINT_VIOLATION_EXCEPTION_EXPECTED_BUT_OBJECT_CREATION_PASSED_SUCCESSFULLY);
        } catch (ConstraintViolationException e) {
            assertEquals(3, e.getConstraintViolations().size());
        }
    }

    @Test
    public void testSuccessfulValidation_CreateSubscriptionRequest() {

        SafechargeRequest safechargeRequest = CreateSubscriptionRequest.builder()
                .addMerchantInfo(validMerchantInfo)
                .addUserTokenId(dummyUserId)
                .addSubscriptionPlanId(dummySubscriptionPlanId)
                .build();
        assertTrue(safechargeRequest != null);
    }

    @Test
    public void testFailedValidation_CreateSubscriptionRequest() {

        try {
            CreateSubscriptionRequest.builder()
                    .addMerchantInfo(invalidMerchantInfo)
                    .build();

            fail(CONSTRAINT_VIOLATION_EXCEPTION_EXPECTED_BUT_OBJECT_CREATION_PASSED_SUCCESSFULLY);
        } catch (ConstraintViolationException e) {
            assertEquals(4, e.getConstraintViolations().size());
        }
    }

    @Test
    public void testSuccessfulValidation_GetMerchantPaymentMethodsRequest() {

        SafechargeRequest safechargeRequest = GetMerchantPaymentMethodsRequest.builder()
                .addMerchantInfo(validMerchantInfo)
                .addSessionToken(dummySessionToken)
                .addCountryCode(validCountryCode)
                .addLanguageCode(validLanguageCode)
                .addCurrencyCode(validCurrencyCode)
                .build();
        assertTrue(safechargeRequest != null);
    }

    @Test
    public void testFailedValidation_GetMerchantPaymentMethodsRequest() {

        try {
            GetMerchantPaymentMethodsRequest.builder()
                    .addMerchantInfo(invalidMerchantInfo)
                    .addCountryCode(invalidCountryCode)
                    .addLanguageCode(invalidLanguageCode)
                    .addCurrencyCode(invalidCurrencyCode)
                    .build();
            fail(CONSTRAINT_VIOLATION_EXCEPTION_EXPECTED_BUT_OBJECT_CREATION_PASSED_SUCCESSFULLY);
        } catch (ConstraintViolationException e) {
            assertEquals(5, e.getConstraintViolations().size());
        }
    }

    @Test
    public void testSuccessfulValidation_GetOrderDetailsRequest() {

        SafechargeRequest safechargeRequest = GetOrderDetailsRequest.builder()
                .addMerchantInfo(validMerchantInfo)
                .addSessionToken(dummySessionToken)
                .addOrderId(dummyOrderId)
                .build();
        assertTrue(safechargeRequest != null);
    }

    @Test
    public void testFailedValidation_GetOrderDetailsRequest() {

        try {
            GetOrderDetailsRequest.builder()
                    .addMerchantInfo(invalidMerchantInfo)
                    .build();

            fail(CONSTRAINT_VIOLATION_EXCEPTION_EXPECTED_BUT_OBJECT_CREATION_PASSED_SUCCESSFULLY);
        } catch (ConstraintViolationException e) {
            assertEquals(4, e.getConstraintViolations().size());
        }
    }

    @Test
    public void testSuccessfulValidation_GetSessionToken() {
        SafechargeRequest safechargeRequest = GetSessionTokenRequest.builder()
                .addMerchantInfo(validMerchantInfo)
                .build();
        assertTrue(safechargeRequest != null);
    }

    @Test
    public void testFailedValidation_GetSessionToken() {

        try {
            GetSessionTokenRequest.builder()
                    .addMerchantInfo(invalidMerchantInfo)
                    .build();
            fail(CONSTRAINT_VIOLATION_EXCEPTION_EXPECTED_BUT_OBJECT_CREATION_PASSED_SUCCESSFULLY);
        } catch (ConstraintViolationException e) {
            assertEquals(2, e.getConstraintViolations().size());
        }
    }

    @Test
    public void testSuccessfulValidation_GetSubscriptionPlansRequest() {

        SafechargeRequest safechargeRequest = GetSubscriptionPlansRequest.builder()
                .addMerchantInfo(validMerchantInfo)
                .build();
        assertTrue(safechargeRequest != null);
    }

    @Test
    public void testFailedValidation_GetSubscriptionPlansRequest() {

        try {
            GetSubscriptionPlansRequest.builder()
                    .addMerchantInfo(invalidMerchantInfo)
                    .build();

            fail(CONSTRAINT_VIOLATION_EXCEPTION_EXPECTED_BUT_OBJECT_CREATION_PASSED_SUCCESSFULLY);
        } catch (ConstraintViolationException e) {
            assertEquals(2, e.getConstraintViolations().size());
        }
    }

    @Test
    public void testSuccessfulValidation_GetSubscriptionsListRequest() {

        SafechargeRequest safechargeRequest = GetSubscriptionsListRequest.builder()
                .addMerchantInfo(validMerchantInfo)
                .build();
        assertTrue(safechargeRequest != null);
    }

    @Test
    public void testFailedValidation_GetSubscriptionsListRequest() {

        try {
            GetSubscriptionsListRequest.builder()
                    .addMerchantInfo(invalidMerchantInfo)
                    .build();

            fail(CONSTRAINT_VIOLATION_EXCEPTION_EXPECTED_BUT_OBJECT_CREATION_PASSED_SUCCESSFULLY);
        } catch (ConstraintViolationException e) {
            assertEquals(2, e.getConstraintViolations().size());
        }
    }

    @Test
    public void testSuccessfulValidation_OpenOrderRequest() {
        SafechargeRequest safechargeRequest = OpenOrderRequest.builder()
                .addMerchantInfo(validMerchantInfo)
                .addSessionToken(dummySessionToken)
                .addCurrency(validCurrencyCode)
                .addAmount(validAmount)
                .addItem(dummyValidItem)
                .build();
        assertTrue(safechargeRequest != null);
    }

    @Test
    public void testFailedValidation_OpenOrderRequest() {

        try {
            SafechargeRequest safechargeRequest = OpenOrderRequest.builder()
                    .addMerchantInfo(invalidMerchantInfo)
                    .addAmount(invalidAmount)
                    .addCurrency(invalidCurrencyCode)
                    .addItem(dummyInvalidItem)
                    .build();
            fail(CONSTRAINT_VIOLATION_EXCEPTION_EXPECTED_BUT_OBJECT_CREATION_PASSED_SUCCESSFULLY);
        } catch (ConstraintViolationException e) {
            assertEquals(5, e.getConstraintViolations()
                    .size());
        }
    }

    @Test
    public void testSuccessfulValidation_Payment3DRequest() {

        SafechargeRequest safechargeRequest = Payment3DRequest.builder()
                .addMerchantInfo(validMerchantInfo)
                .addSessionToken(dummySessionToken)
                .addAmount(validAmount)
                .addCurrency(validCurrencyCode)
                .addItem(dummyValidItem)
                .build();
        assertTrue(safechargeRequest != null);
    }

    @Test
    public void testFailedValidation_Payment3DRequest() {

        try {
            Payment3DRequest.builder()
                    .addMerchantInfo(invalidMerchantInfo)
                    .build();

            fail(CONSTRAINT_VIOLATION_EXCEPTION_EXPECTED_BUT_OBJECT_CREATION_PASSED_SUCCESSFULLY);
        } catch (ConstraintViolationException e) {
            assertEquals(6, e.getConstraintViolations().size());
        }
    }

    @Test
    public void testSuccessfulValidation_PaymentAPMRequest() {
        SafechargeRequest safechargeRequest = PaymentAPMRequest.builder()
                .addMerchantInfo(validMerchantInfo)
                .addCurrency(validCurrencyCode)
                .addAmount(validAmountTwoItems)
                .addSessionToken(dummySessionToken)
                .addItem(dummyValidItem)
                .addItem(dummyValidItem2)
                .addUserDetails(dummyValidCashierUserDetails)
                .addBillingDetails(dummyValidBillingDetails)
                .addShippingDetails(dummyValidShippingDetails)
                .addOrderId(dummyOrderId)
                .addCountry(validCountryCode)
                .addURLDetails(dummyValidUrlDetails)
                .addPaymentMethod(validPaymentMethodName)
                .build();
        assertTrue(safechargeRequest != null);
    }

    @Test
    public void testFailedValidation_PaymentAPMRequest() {

        try {
            SafechargeRequest safechargeRequest = PaymentAPMRequest.builder()
                    .addMerchantInfo(invalidMerchantInfo)
                    .addItem(dummyInvalidItem)
                    .addUserDetails(dummyInvalidCashierUserDetails)
                    .addBillingDetails(dummyInvalidShippingDetails)
                    .addShippingDetails(dummyInvalidShippingDetails)
                    .addURLDetails(dummyInvalidUrlDetails)
                    .addCountry(invalidCountryCode)
                    .build();
            fail(CONSTRAINT_VIOLATION_EXCEPTION_EXPECTED_BUT_OBJECT_CREATION_PASSED_SUCCESSFULLY);
        } catch (ConstraintViolationException e) {
            assertEquals(18, e.getConstraintViolations()
                    .size());
        }
    }

    @Test
    public void testSuccessfulValidation_PaymentCCRequest() {
        SafechargeRequest safechargeRequest = PaymentCCRequest.builder()
                .addMerchantInfo(validMerchantInfo)
                .addCurrency(validCurrencyCode)
                .addAmount(validAmountTwoItems)
                .addSessionToken(dummySessionToken)
                .addItem(dummyValidItem)
                .addItem(dummyValidItem2)
                .addUserDetails(dummyValidCashierUserDetails)
                .addBillingDetails(dummyValidBillingDetails)
                .addShippingDetails(dummyValidShippingDetails)
                .addOrderId(dummyOrderId)
                .addURLDetails(dummyValidUrlDetails)
                .addTransactionType(Constants.TransactionType.Sale)
                .addCardData(dummyCardData)
                .build();
        assertTrue(safechargeRequest != null);
    }

    @Test
    public void testFailedValidation_PaymentCCRequest() {

        try {
            SafechargeRequest safechargeRequest = PaymentCCRequest.builder()
                    .addMerchantInfo(invalidMerchantInfo)
                    .addItem(dummyInvalidItem)
                    .addUserDetails(dummyInvalidCashierUserDetails)
                    .addBillingDetails(dummyInvalidShippingDetails)
                    .addShippingDetails(dummyInvalidShippingDetails)
                    .addURLDetails(dummyInvalidUrlDetails)
                    .addCardData(dummyCardData)
                    .addUserPaymentOption(null, "12")
                    .build();
            fail(CONSTRAINT_VIOLATION_EXCEPTION_EXPECTED_BUT_OBJECT_CREATION_PASSED_SUCCESSFULLY);
        } catch (ConstraintViolationException e) {
            assertEquals(17, e.getConstraintViolations()
                    .size());
        }
    }

    @Test
    public void testSuccessfulValidation_RefundTransactionRequest() {

        SafechargeRequest safechargeRequest = RefundTransactionRequest.builder()
                .addMerchantInfo(validMerchantInfo)
                .addCurrency(validCurrencyCode)
                .addAmount(validAmount)
                .addRelatedTransactionId(dummyRelatedTransactionId)
                .addAuthCode(dummyAuthCode)
                .build();
        assertTrue(safechargeRequest != null);
    }

    @Test
    public void testFailedValidation_RefundTransactionRequest() {

        try {
            RefundTransactionRequest.builder()
                    .addMerchantInfo(invalidMerchantInfo)
                    .build();

            fail(CONSTRAINT_VIOLATION_EXCEPTION_EXPECTED_BUT_OBJECT_CREATION_PASSED_SUCCESSFULLY);
        } catch (ConstraintViolationException e) {
            assertEquals(6, e.getConstraintViolations().size());
        }
    }

    @Test
    public void testSuccessfulValidation_SettleTransactionRequest() {

        SafechargeRequest safechargeRequest = SettleTransactionRequest.builder()
                .addMerchantInfo(validMerchantInfo)
                .addAuthCode(dummyAuthCode)
                .addAmount(validAmount)
                .addCurrency(validCurrencyCode)
                .addRelatedTransactionId(dummyRelatedTransactionId)
                .build();
        assertTrue(safechargeRequest != null);
    }

    @Test
    public void testFailedValidation_SettleTransactionRequest() {

        try {
            SettleTransactionRequest.builder()
                    .addMerchantInfo(invalidMerchantInfo)
                    .build();

            fail(CONSTRAINT_VIOLATION_EXCEPTION_EXPECTED_BUT_OBJECT_CREATION_PASSED_SUCCESSFULLY);
        } catch (ConstraintViolationException e) {
            assertEquals(6, e.getConstraintViolations().size());
        }
    }

    @Test
    public void testSuccessfulValidation_UpdateOrderRequest() {
        SafechargeRequest safechargeRequest = UpdateOrderRequest.builder()
                .addMerchantInfo(validMerchantInfo)
                .addSessionToken(dummySessionToken)
                .addOrderId(dummyOrderId)
                .addCurrency(validCurrencyCode)
                .addAmount(validAmount)
                .addItem(dummyValidItem)
                .build();
        assertTrue(safechargeRequest != null);
    }

    @Test
    public void testFailedValidation_UpdateOrderRequest() {

        try {
            SafechargeRequest safechargeRequest = UpdateOrderRequest.builder()
                    .addMerchantInfo(invalidMerchantInfo)
                    .addItem(dummyInvalidItem)
                    .build();
            fail(CONSTRAINT_VIOLATION_EXCEPTION_EXPECTED_BUT_OBJECT_CREATION_PASSED_SUCCESSFULLY);
        } catch (ConstraintViolationException e) {
            assertEquals(7, e.getConstraintViolations()
                    .size());
        }
    }

    @Test
    public void testSuccessfulValidation_VoidTransactionRequest() {

        SafechargeRequest safechargeRequest = VoidTransactionRequest.builder()
                .addMerchantInfo(validMerchantInfo)
                .addAuthCode(dummyAuthCode)
                .addAmount(validAmount)
                .addCurrency(validCurrencyCode)
                .addRelatedTransactionId(dummyRelatedTransactionId)
                .build();
        assertTrue(safechargeRequest != null);
    }

    @Test
    public void testFailedValidation_VoidTransactionRequest() {

        try {
            VoidTransactionRequest.builder()
                    .addMerchantInfo(invalidMerchantInfo)
                    .build();

            fail(CONSTRAINT_VIOLATION_EXCEPTION_EXPECTED_BUT_OBJECT_CREATION_PASSED_SUCCESSFULLY);
        } catch (ConstraintViolationException e) {
            assertEquals(6, e.getConstraintViolations().size());
        }
    }
}
