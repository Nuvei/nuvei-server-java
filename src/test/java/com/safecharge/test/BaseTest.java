package com.safecharge.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;

import com.safecharge.request.*;
import com.safecharge.response.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.safecharge.biz.SafechargeRequestExecutor;
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

        when(safechargeRequestExecutor.executeRequest(Mockito.any(Dynamic3DRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("./mock/response/authorization3D.json"), Dynamic3DResponse.class));

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

        when(safechargeRequestExecutor.executeRequest(Mockito.any(PayoutRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("./mock/response/payout.json"), PayoutResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(CreateUserRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("mock/response/userActionResponse.json"), UserResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(UpdateUserRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("mock/response/userActionResponse.json"), UserResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(GetUserDetailsRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("mock/response/getUserDetails.json"), GetUserDetailsResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(AddUPOCreditCardByTokenRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("./mock/response/addUPOCreditCardByToken.json"), AddUPOCreditCardByTokenResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(GetUserUPOsRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("./mock/response/getUserUPOs.json"), GetUserUPOsResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(EditUPOCreditCardRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("mock/response/editUPOCreditCard.json"), EditUPOCreditCardResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(EditUPOAPMRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("mock/response/editUPOAPM.json"), EditUPOAPMResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(EnableUPORequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("mock/response/basicEditUPO.json"), EnableUPOResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(DeleteUPORequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("mock/response/basicEditUPO.json"), DeleteUPOResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(SuspendUPORequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("mock/response/basicEditUPO.json"), SuspendUPOResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(PaymentRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("mock/response/payment.json"), PaymentResponse.class));

        when(safechargeRequestExecutor.executeRequest(Mockito.any(InitPaymentRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("mock/response/initPayment.json"), InitPaymentResponse.class));
        when(safechargeRequestExecutor.executeRequest(Mockito.any(GetPaymentStatusRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("mock/response/getPaymentStatus.json"), GetPaymentStatusResponse.class));
        when(safechargeRequestExecutor.executeRequest(Mockito.any(Verify3dRequest.class))).thenReturn(
                gson.fromJson(loadResourceFile("mock/response/verify3d.json"), Verify3dResponse.class));
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
            return result;
        } catch (IOException ex) {
            return null;
        }
    }

    protected void validateRequest(SafechargeBaseRequest request) {
        try {
            ValidationUtils.validate(request);
        } catch (ValidationException e) {
            Assert.fail();
        }
    }

    protected <T extends SafechargeResponse> T baseMockTest(String jsonPath, Class<? extends SafechargeBaseRequest> requestClass) {

        T response = baseMockTestMethodWithoutSessionToken(jsonPath, requestClass);
        Assert.assertTrue(defined(response.getSessionToken()));

        return response;
    }

    protected <T extends SafechargeResponse> T baseMockTestMethodWithPrebuiltObjectWithoutSession(SafechargeBaseRequest request) {
        return executeAndValidateResponse(request);
    }

    protected <T extends SafechargeResponse> T baseMockTestMethodWithoutSessionToken(String jsonPath, Class<? extends SafechargeBaseRequest> requestClass) {
        SafechargeBaseRequest request = gson.fromJson(loadResourceFile(jsonPath), requestClass);

        validateRequest(request);

        return executeAndValidateResponse(request);
    }

    private <T extends SafechargeResponse> T executeAndValidateResponse(SafechargeBaseRequest request) {
        T response = (T) safechargeRequestExecutor.executeRequest(request);

        Assert.assertTrue(response != null);
        Assert.assertTrue(defined(response.getMerchantId()));
        Assert.assertTrue(defined(response.getMerchantSiteId()));
        Assert.assertTrue(defined(response.getClientRequestId()));
        return response;
    }

    protected boolean defined(String s) {
        return s != null && !s.isEmpty();
    }
}
