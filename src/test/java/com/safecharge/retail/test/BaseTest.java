package com.safecharge.retail.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.mockito.Mockito;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.safecharge.retail.biz.SafechargeRequestExecutor;
import com.safecharge.retail.request.AddUPOCreditCardByTempTokenRequest;
import com.safecharge.retail.request.Authorization3DRequest;
import com.safecharge.retail.request.GetOrderDetailsRequest;
import com.safecharge.retail.request.GetSessionTokenRequest;
import com.safecharge.retail.request.OpenOrderRequest;
import com.safecharge.retail.request.Payment3DRequest;
import com.safecharge.retail.request.PaymentAPMRequest;
import com.safecharge.retail.request.PaymentCCRequest;
import com.safecharge.retail.request.SafechargeRequest;
import com.safecharge.retail.request.UpdateOrderRequest;
import com.safecharge.retail.response.AddUPOCreditCardByTempTokenResponse;
import com.safecharge.retail.response.Authorization3DResponse;
import com.safecharge.retail.response.OpenOrderResponse;
import com.safecharge.retail.response.OrderDetailsResponse;
import com.safecharge.retail.response.Payment3DResponse;
import com.safecharge.retail.response.PaymentAPMResponse;
import com.safecharge.retail.response.PaymentCCResponse;
import com.safecharge.retail.response.SafechargeResponse;
import com.safecharge.retail.response.SessionTokenResponse;
import com.safecharge.retail.response.UpdateOrderResponse;
import com.safecharge.retail.util.ValidationUtil;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/28/2017
 */
public abstract class BaseTest {

    protected static Validator validator;
    protected static Gson gson;
    protected SafechargeRequestExecutor safechargeRequestExecutor;

    @BeforeClass public static void setup() {
        gson = new GsonBuilder().create();
        validator = Validation.buildDefaultValidatorFactory()
                              .getValidator();
    }

    @Before public void init() {
        safechargeRequestExecutor = mock(SafechargeRequestExecutor.class);

        when(safechargeRequestExecutor.executeRequest(Mockito.any(GetSessionTokenRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("./mock/response/getSessionToken.json"), SessionTokenResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(GetOrderDetailsRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("./mock/response/getOrderDetails.json"), OrderDetailsResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(OpenOrderRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("./mock/response/openOrder.json"), OpenOrderResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(UpdateOrderRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("./mock/response/updateOrder.json"), UpdateOrderResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(PaymentAPMRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("./mock/response/paymentAPM.json"), PaymentAPMResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(PaymentCCRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("./mock/response/paymentCC.json"), PaymentCCResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(Payment3DRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("./mock/response/payment3D.json"), Payment3DResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(Authorization3DRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("./mock/response/authorization3D.json"), Authorization3DResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(AddUPOCreditCardByTempTokenRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("./mock/response/addUPOCreditCardByTempToken.json"), AddUPOCreditCardByTempTokenResponse.class));
    }

    protected String loadResourceFile(String path) {

        String result = null;
        try (InputStream fileInputStream = getClass().getClassLoader()
                                                     .getResourceAsStream(path); ByteArrayOutputStream os = new ByteArrayOutputStream(1024)) {
            byte[] buf = new byte[1024];

            for (int i = fileInputStream.read(buf); i > 0; i = fileInputStream.read(buf)) {
                os.write(buf, 0, i);
            }
            result = os.toString("utf8");
        } finally {
            return result;
        }
    }

    protected void validateRequest(SafechargeRequest request) {
        try {
            ValidationUtil.validate(request);
        } catch (ValidationException e) {
            Assert.fail();
        }
    }

    protected <T extends SafechargeResponse> T baseMockTest(String jsonPath, Class<? extends SafechargeRequest> requestClass) {
        SafechargeRequest request = gson.fromJson(loadResourceFile(jsonPath), requestClass);

        validateRequest(request);

        T response = (T) safechargeRequestExecutor.executeRequest(request);

        Assert.assertTrue(response != null);
        Assert.assertTrue(defined(response.getSessionToken()));
        Assert.assertTrue(defined(response.getMerchantId()));
        Assert.assertTrue(defined(response.getMerchantSiteId()));
        Assert.assertTrue(defined(response.getClientRequestId()));

        return response;
    }

    protected boolean defined(String s) {
        return s != null && !s.isEmpty();
    }
}
