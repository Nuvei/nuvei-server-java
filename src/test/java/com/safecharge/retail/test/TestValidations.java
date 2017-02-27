package com.safecharge.retail.test;

import javax.validation.ConstraintViolationException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.safecharge.retail.model.Item;
import com.safecharge.retail.model.MerchantInfo;
import com.safecharge.retail.request.GetOrderDetailsRequest;
import com.safecharge.retail.request.GetSessionTokenRequest;
import com.safecharge.retail.request.OpenOrderRequest;
import com.safecharge.retail.request.SafechargeRequest;
import com.safecharge.retail.util.Constants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/24/2017
 */
public class TestValidations {

    private static final MerchantInfo validMerchantInfo = new MerchantInfo("dummy", "1234", "1234", Constants.HashAlgorithm.MD5);
    private static final MerchantInfo invalidMerchantInfo = new MerchantInfo("dummy", null, null, Constants.HashAlgorithm.MD5);
    private static final String dummySessionToken = "dummySessionToken";
    private static final Item dummyValidItem = new Item();
    private static final Item dummyInvalidItem = new Item();

    @Before public void initialization() {
        dummyValidItem.setQuantity("1");
        dummyValidItem.setName("dummyValidItem");
        dummyValidItem.setPrice("1");
        dummyInvalidItem.setName("dummyInvalidItem");
    }

    @Test public void testSuccessfulValidation_GetSessionToken() {
        SafechargeRequest safechargeRequest = new GetSessionTokenRequest.Builder().addMerchantInfo(validMerchantInfo)
                                                                                  .build();
        Assert.assertTrue(safechargeRequest != null);
    }

    @Test public void testFailedValidation_GetSessionToken() {

        try {
            new GetSessionTokenRequest.Builder().addMerchantInfo(invalidMerchantInfo)
                                                .build();
            Assert.fail("ConstraintViolationException expected, object creation passed successfully.");
        } catch (ConstraintViolationException e) {
            Assert.assertEquals(2, e.getConstraintViolations()
                                    .size());
        }
    }

    @Test public void testSuccessfulValidation_GetOrderDetails() {
        SafechargeRequest safechargeRequest = new GetOrderDetailsRequest.Builder().setOrderId("1234")
                                                                                  .addMerchantInfo(validMerchantInfo)
                                                                                  .addSessionToken(dummySessionToken)
                                                                                  .build();
        Assert.assertTrue(safechargeRequest != null);
    }

    @Test public void testFailedValidation_GetOrderDetails() {
        try {
            new GetOrderDetailsRequest.Builder().addMerchantInfo(validMerchantInfo)
                                                .build();
            Assert.fail("ConstraintViolationException expected, object creation passed successfully.");
        } catch (ConstraintViolationException e) {
            Assert.assertEquals(2, e.getConstraintViolations()
                                    .size());
        }
    }

    @Test public void testSuccessfulValidation_OpenOrder() {
        SafechargeRequest safechargeRequest = new OpenOrderRequest.Builder().addMerchantInfo(validMerchantInfo)
                                                                            .addSessionToken(dummySessionToken)
                                                                            .addCurrency("EUR")
                                                                            .addAmount("1")
                                                                            .addItem(dummyValidItem)
                                                                            .build();
        Assert.assertTrue(safechargeRequest != null);
    }

    @Test public void testFailedValidation_OpenOrder() {
        try {
            SafechargeRequest safechargeRequest = new OpenOrderRequest.Builder().addMerchantInfo(validMerchantInfo)
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

}
