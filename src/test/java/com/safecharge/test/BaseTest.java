package com.safecharge.test;

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
import com.safecharge.biz.SafechargeRequestExecutor;
import com.safecharge.request.AddUPOAPMRequest;
import com.safecharge.request.AddUPOCreditCardByTempTokenRequest;
import com.safecharge.request.AddUPOCreditCardRequest;
import com.safecharge.request.Authorization3DRequest;
import com.safecharge.request.CardTokenizationRequest;
import com.safecharge.request.GetMerchantPaymentMethodsRequest;
import com.safecharge.request.GetOrderDetailsRequest;
import com.safecharge.request.GetSessionTokenRequest;
import com.safecharge.request.OpenOrderRequest;
import com.safecharge.request.Payment3DRequest;
import com.safecharge.request.PaymentAPMRequest;
import com.safecharge.request.PaymentCCRequest;
import com.safecharge.request.RefundTransactionRequest;
import com.safecharge.request.SafechargeRequest;
import com.safecharge.request.SettleTransactionRequest;
import com.safecharge.request.UpdateOrderRequest;
import com.safecharge.request.VoidTransactionRequest;
import com.safecharge.response.AddUPOAPMResponse;
import com.safecharge.response.AddUPOCreditCardByTempTokenResponse;
import com.safecharge.response.AddUPOCreditCardResponse;
import com.safecharge.response.Authorization3DResponse;
import com.safecharge.response.CardTokenizationResponse;
import com.safecharge.response.GetMerchantPaymentMethodsResponse;
import com.safecharge.response.GetOrderDetailsResponse;
import com.safecharge.response.GetSessionTokenResponse;
import com.safecharge.response.OpenOrderResponse;
import com.safecharge.response.Payment3DResponse;
import com.safecharge.response.PaymentAPMResponse;
import com.safecharge.response.PaymentCCResponse;
import com.safecharge.response.RefundTransactionResponse;
import com.safecharge.response.SafechargeResponse;
import com.safecharge.response.SettleTransactionResponse;
import com.safecharge.response.UpdateOrderResponse;
import com.safecharge.response.VoidTransactionResponse;
import com.safecharge.util.ValidationUtils;

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

    @BeforeClass
    public static void setup() {
        gson = new GsonBuilder().create();
        validator = Validation.buildDefaultValidatorFactory()
                .getValidator();
    }

    @Before
    public void init() {
        safechargeRequestExecutor = mock(SafechargeRequestExecutor.class);

        when(safechargeRequestExecutor.executeRequest(Mockito.any(GetSessionTokenRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("./mock/response/getSessionToken.json"), GetSessionTokenResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(GetOrderDetailsRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("./mock/response/getOrderDetails.json"), GetOrderDetailsResponse.class));

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

        when(safechargeRequestExecutor.executeRequest(Mockito.any(CardTokenizationRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("./mock/response/cardTokenization.json"), CardTokenizationResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(AddUPOCreditCardRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("./mock/response/addUPOCreditCard.json"), AddUPOCreditCardResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(AddUPOAPMRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("./mock/response/addUPOAPM.json"), AddUPOAPMResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(SettleTransactionRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("./mock/response/settleTransaction.json"), SettleTransactionResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(RefundTransactionRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("./mock/response/refundTransaction.json"), RefundTransactionResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(VoidTransactionRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("./mock/response/voidTransaction.json"), VoidTransactionResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(GetMerchantPaymentMethodsRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("./mock/response/getMerchantPaymentMethods.json"), GetMerchantPaymentMethodsResponse.class));
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
            ValidationUtils.validate(request);
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
