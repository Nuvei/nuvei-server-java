

/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.biz;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.safecharge.exception.SafechargeConfigurationException;
import com.safecharge.exception.SafechargeException;
import com.safecharge.model.CardData;
import com.safecharge.model.RefundPaymentOption;
import com.safecharge.request.AccountCaptureRequest;
import com.safecharge.request.Authorize3dRequest;
import com.safecharge.request.CardDetailsRequest;
import com.safecharge.request.DccDetailsRequest;
import com.safecharge.request.GetPaymentStatusRequest;
import com.safecharge.request.GetSessionTokenRequest;
import com.safecharge.request.InitPaymentRequest;
import com.safecharge.request.McpRatesRequest;
import com.safecharge.request.OpenOrderRequest;
import com.safecharge.request.PaymentRequest;
import com.safecharge.request.RefundTransactionRequest;
import com.safecharge.request.SettleTransactionRequest;
import com.safecharge.request.Verify3dRequest;
import com.safecharge.request.VoidTransactionRequest;
import com.safecharge.response.AccountCaptureResponse;
import com.safecharge.response.Authorize3dResponse;
import com.safecharge.response.CardDetailsResponse;
import com.safecharge.response.DccDetailsResponse;
import com.safecharge.response.GetPaymentStatusResponse;
import com.safecharge.response.InitPaymentResponse;
import com.safecharge.response.McpRatesResponse;
import com.safecharge.response.OpenOrderResponse;
import com.safecharge.response.PaymentResponse;
import com.safecharge.response.RefundTransactionResponse;
import com.safecharge.response.SafechargeResponse;
import com.safecharge.response.SettleTransactionResponse;
import com.safecharge.response.Verify3dResponse;
import com.safecharge.response.VoidTransactionResponse;
import com.safecharge.util.Constants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;


public class SafechargeTest {

    @Mock
    private SafechargeRequestExecutor executor;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @InjectMocks
    private Safecharge sut;

    @Before
    public void setUp() throws Exception {
        sut = new Safecharge();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCorrectlyInitializeMerchantInfo() throws SafechargeException {
        SafechargeResponse response = mock(SafechargeResponse.class);

        when(executor.execute(any(GetSessionTokenRequest.class))).thenReturn(response);

        sut.initialize("merchantKey", "id", "siteId", "localhost", Constants.HashAlgorithm.SHA256);

        verify(executor).execute(any(GetSessionTokenRequest.class));
        verify(response).getStatus();
    }

    @Test
    public void shouldThrowExceptionWithGivenReasonWhenResponseStatusIsError() throws SafechargeException {
        SafechargeResponse response = mock(SafechargeResponse.class);
        when(response.getStatus()).thenReturn(Constants.APIResponseStatus.ERROR);
        when(response.getReason()).thenReturn("Invalid data.");

        when(executor.execute(any(GetSessionTokenRequest.class))).thenReturn(response);

        exception.expect(SafechargeConfigurationException.class);
        exception.expectMessage("Invalid data.");

        sut.initialize("merchantKey", "id", "siteId", "localhost", Constants.HashAlgorithm.SHA256);
    }

    @Test
    public void shouldExecutePaymentRequestAndReturnResponse() throws SafechargeException {
        SafechargeResponse sessionResponse = mock(SafechargeResponse.class);
        when(sessionResponse.getSessionToken()).thenReturn("sessionToken");

        SafechargeResponse paymentResponse = new PaymentResponse();

        when(executor.execute(any(GetSessionTokenRequest.class))).thenReturn(sessionResponse);
        when(executor.execute(any(PaymentRequest.class))).thenReturn(paymentResponse);

        sut.initialize("merchantKey", "id", "siteId", "localhost", Constants.HashAlgorithm.SHA256);
        PaymentResponse response = sut.payment("userTokenId", "clientUniqueId", "clientRequestId", null, null, "BGN", "11", null, null,
                null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null);

        verify(executor).execute(any(GetSessionTokenRequest.class));
        verify(executor).execute(any(PaymentRequest.class));
        verifyNoMoreInteractions(executor);
        verify(sessionResponse).getStatus();
        verify(sessionResponse).getSessionToken();
        assertNotNull(response);
    }

    @Test
    public void shouldThrowExceptionIfPaymentRequestIsExecutedWithoutInitializeRequestBeforehand() throws SafechargeException {
        exception.expect(SafechargeConfigurationException.class);
        exception.expectMessage("Missing mandatory info for execution of payments! Please run initialization method before creating payments.");

        sut.payment("userTokenId", "clientUniqueId", "clientRequestId", null, null, "BGN", "11", null, null,
                null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null);
    }

    @Test
    public void shouldExecuteInitPaymentRequestAndReturnResponse() throws SafechargeException {
        SafechargeResponse sessionResponse = mock(SafechargeResponse.class);
        when(sessionResponse.getSessionToken()).thenReturn("sessionToken");

        SafechargeResponse initPaymentResponse = new InitPaymentResponse();

        when(executor.execute(any(GetSessionTokenRequest.class))).thenReturn(sessionResponse);
        when(executor.execute(any(InitPaymentRequest.class))).thenReturn(initPaymentResponse);

        sut.initialize("merchantKey", "id", "siteId", "localhost", Constants.HashAlgorithm.SHA256);
        InitPaymentResponse response = sut.initPayment("userTokenId", "clientUniqueId", "clientRequestId", "BGN", "11",
                null, null, null, null, null, null, null, null, null);

        verify(executor).execute(any(GetSessionTokenRequest.class));
        verify(executor).execute(any(InitPaymentRequest.class));
        verifyNoMoreInteractions(executor);
        verify(sessionResponse).getStatus();
        verify(sessionResponse).getSessionToken();
        assertNotNull(response);
    }

    @Test
    public void shouldThrowExceptionWhenInitPaymentRequestIsExecutedWithoutInitializeRequestBeforehand() throws SafechargeException {
        exception.expect(SafechargeConfigurationException.class);
        exception.expectMessage("Missing mandatory info for execution of payments! Please run initialization method before creating payments.");

        sut.initPayment("userTokenId", "clientUniqueId", "clientRequestId", "BGN", "11",
                null, null, null, null, null, null, null, null, null);
    }

    @Test
    public void shouldExecuteOpenOrderRequestAndReturnResponse() throws SafechargeException {
        SafechargeResponse sessionResponse = mock(SafechargeResponse.class);
        when(sessionResponse.getSessionToken()).thenReturn("sessionToken");

        SafechargeResponse openOrderResponse = new OpenOrderResponse();

        when(executor.execute(any(GetSessionTokenRequest.class))).thenReturn(sessionResponse);
        when(executor.execute(any(OpenOrderRequest.class))).thenReturn(openOrderResponse);

        sut.initialize("merchantKey", "id", "siteId", "localhost", Constants.HashAlgorithm.SHA256);
        OpenOrderResponse response = sut.openOrder("userTokenId", "clientRequestId", "clientUniqueId", null, null, null, null, "BGN", "11", null,
                null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null,
                null, null, null, null, null, null);

        verify(executor).execute(any(GetSessionTokenRequest.class));
        verify(executor).execute(any(OpenOrderRequest.class));
        verifyNoMoreInteractions(executor);
        verify(sessionResponse).getStatus();
        verify(sessionResponse).getSessionToken();
        assertNotNull(response);
    }

    @Test
    public void shouldThrowExceptionWhenOpenOrderRequestIsExecutedWithoutInitializeRequestBeforehand() throws SafechargeException {
        exception.expect(SafechargeConfigurationException.class);
        exception.expectMessage("Missing mandatory info for execution of payments! Please run initialization method before creating payments.");

        sut.openOrder("userTokenId", "clientRequestId", "clientUniqueId", null, null, null, null, "BGN", "11", null,
                null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null);
    }

    @Test
    public void shouldExecuteGetPaymentStatusRequestAndReturnResponse() throws SafechargeException {
        SafechargeResponse sessionResponse = mock(SafechargeResponse.class);
        when(sessionResponse.getSessionToken()).thenReturn("sessionToken");

        SafechargeResponse getPaymentStatusResponse = new GetPaymentStatusResponse();

        when(executor.execute(any(GetSessionTokenRequest.class))).thenReturn(sessionResponse);
        when(executor.execute(any(GetPaymentStatusRequest.class))).thenReturn(getPaymentStatusResponse);

        sut.initialize("merchantKey", "id", "siteId", "localhost", Constants.HashAlgorithm.SHA256);
        GetPaymentStatusResponse response = sut.getPaymentStatus();

        verify(executor).execute(any(GetSessionTokenRequest.class));
        verify(executor).execute(any(GetPaymentStatusRequest.class));
        verifyNoMoreInteractions(executor);
        verify(sessionResponse).getStatus();
        verify(sessionResponse).getSessionToken();
        assertNotNull(response);
    }

    @Test
    public void shouldThrowExceptionWhenGetPaymentStatusRequestIsExecutedWithoutInitializeRequstBeforehand() throws SafechargeException {
        exception.expect(SafechargeConfigurationException.class);
        exception.expectMessage("Missing mandatory info for execution of payments! Please run initialization method before creating payments.");

        sut.getPaymentStatus();
    }

    @Test
    public void shouldExecuteVoidTransactionRequestAndReturnResponse() throws SafechargeException {
        SafechargeResponse sessionResponse = mock(SafechargeResponse.class);
        when(sessionResponse.getSessionToken()).thenReturn("sessionToken");

        SafechargeResponse voidTransactionResponse = new VoidTransactionResponse();

        when(executor.execute(any(GetSessionTokenRequest.class))).thenReturn(sessionResponse);
        when(executor.execute(any(VoidTransactionRequest.class))).thenReturn(voidTransactionResponse);

        sut.initialize("merchantKey", "id", "siteId", "localhost", Constants.HashAlgorithm.SHA256);
        VoidTransactionResponse response = sut.voidTransaction("clientRequestId", "relatedTransactioId", "11", "BGN", "authCode",
                null, null, null, null, null, null, null);

        verify(executor).execute(any(GetSessionTokenRequest.class));
        verify(executor).execute(any(VoidTransactionRequest.class));
        verifyNoMoreInteractions(executor);
        verify(sessionResponse).getStatus();
        verify(sessionResponse).getSessionToken();
        assertNotNull(response);
    }

    @Test
    public void shouldThrowExceptionWhenVoidTransactionRequestIsExecutedWithoutInitializeRequestBeforehand() throws SafechargeException {
        exception.expect(SafechargeConfigurationException.class);
        exception.expectMessage("Missing mandatory info for execution of payments! Please run initialization method before creating payments.");

        sut.voidTransaction("clientRequestId", "relatedTransactionId", "11", "BGN", "authCode",
                null, null, null, null, null, null, null);
    }

    @Test
    public void shouldExecuteSettleTransactionRequestAndReturnResponse() throws SafechargeException {
        SafechargeResponse sessionResponse = mock(SafechargeResponse.class);
        when(sessionResponse.getSessionToken()).thenReturn("sessionToken");

        SafechargeResponse settleTransactionResponse = new SettleTransactionResponse();

        when(executor.execute(any(GetSessionTokenRequest.class))).thenReturn(sessionResponse);
        when(executor.execute(any(SettleTransactionRequest.class))).thenReturn(settleTransactionResponse);

        sut.initialize("merchantKey", "id", "siteId", "localhost", Constants.HashAlgorithm.SHA256);
        SettleTransactionResponse response = sut.settleTransaction("clientUniqueId", "clientRequestId", null, null, null, null, "11",
                "authCode", null, null, "BGN", null, null, "relatedTransactioId", null, null);

        verify(executor).execute(any(GetSessionTokenRequest.class));
        verify(executor).execute(any(SettleTransactionRequest.class));
        verifyNoMoreInteractions(executor);
        verify(sessionResponse).getStatus();
        verify(sessionResponse).getSessionToken();
        assertNotNull(response);
    }

    @Test
    public void shouldThrowExceptionWhenSettleTransactionRequestIsExecutedWithoutInitializeRequestBeforehand() throws SafechargeException {
        exception.expect(SafechargeConfigurationException.class);
        exception.expectMessage("Missing mandatory info for execution of payments! Please run initialization method before creating payments.");

        sut.settleTransaction("clientUniqueId", "clientRequestId", null, null, null, null, "11",
                "authCode", null, null, "BGN", null, null, "relatedTransactionId", null, null);
    }

    @Test
    public void shouldExecuteRefundTransactionRequestAndReturnResponse() throws SafechargeException {
        SafechargeResponse sessionResponse = mock(SafechargeResponse.class);
        when(sessionResponse.getSessionToken()).thenReturn("sessionToken");

        SafechargeResponse refundTransactionResponse = new RefundTransactionResponse();

        when(executor.execute(any(GetSessionTokenRequest.class))).thenReturn(sessionResponse);
        when(executor.execute(any(RefundTransactionRequest.class))).thenReturn(refundTransactionResponse);

        sut.initialize("merchantKey", "id", "siteId", "localhost", Constants.HashAlgorithm.SHA256);
        RefundTransactionResponse response = sut.refundTransaction("clientUniqueId", "clientRequestId", null, "11", "authCode", null, "BGN",
                null, null, null, "relatedTransactioId", null, null, null, null);

        verify(executor).execute(any(GetSessionTokenRequest.class));
        verify(executor).execute(any(RefundTransactionRequest.class));
        verifyNoMoreInteractions(executor);
        verify(sessionResponse).getStatus();
        verify(sessionResponse).getSessionToken();
        assertNotNull(response);
    }

    @Test
    public void shouldExecuteUnreferencedRefundTransactionRequestAndReturnResponse() throws SafechargeException {
        SafechargeResponse sessionResponse = mock(SafechargeResponse.class);
        when(sessionResponse.getSessionToken()).thenReturn("sessionToken");

        SafechargeResponse refundTransactionResponse = new RefundTransactionResponse();

        when(executor.execute(any(GetSessionTokenRequest.class))).thenReturn(sessionResponse);
        when(executor.execute(any(RefundTransactionRequest.class))).thenReturn(refundTransactionResponse);

        sut.initialize("merchantKey", "id", "siteId", "localhost", Constants.HashAlgorithm.SHA256);
        RefundPaymentOption refundPaymentOption = new RefundPaymentOption();
        refundPaymentOption.setCard(new CardData());
        RefundTransactionResponse response = sut.refundTransaction("clientUniqueId", "clientRequestId", null, "11",
                "authCode", null, "BGN",
                null, null, null, null, null, null, refundPaymentOption, null);

        verify(executor).execute(any(GetSessionTokenRequest.class));
        verify(executor).execute(any(RefundTransactionRequest.class));
        verifyNoMoreInteractions(executor);
        verify(sessionResponse).getStatus();
        verify(sessionResponse).getSessionToken();
        assertNotNull(response);
    }

    @Test
    public void shouldThrowExceptionWhenRefundTransactionRequestIsExecutedWithoutInitializeRequestBeforehand() throws SafechargeException {
        exception.expect(SafechargeConfigurationException.class);
        exception.expectMessage("Missing mandatory info for execution of payments! Please run initialization method before creating payments.");

        sut.refundTransaction("clientUniqueId", "clientRequestId", null, "11", "authCode", null, "BGN",
                null, null, null, "relatedTransactionId", null, null, null, null);
    }

    @Test
    public void shouldExecuteVerify3dRequestAndReturnResponse() throws SafechargeException {
        SafechargeResponse sessionResponse = mock(SafechargeResponse.class);
        when(sessionResponse.getSessionToken()).thenReturn("sessionToken");

        SafechargeResponse verify3dResponse = new Verify3dResponse();

        when(executor.execute(any(GetSessionTokenRequest.class))).thenReturn(sessionResponse);
        when(executor.execute(any(Verify3dRequest.class))).thenReturn(verify3dResponse);

        sut.initialize("merchantKey", "id", "siteId", "localhost", Constants.HashAlgorithm.SHA256);
        Verify3dResponse response = sut.verify3d("clientUniqueId", "clienRequestId", "11", "BGN", null, null, null, null,
                "relatedTransaction", null, null, null, null);

        verify(executor).execute(any(GetSessionTokenRequest.class));
        verify(executor).execute(any(Verify3dRequest.class));
        verifyNoMoreInteractions(executor);
        verify(sessionResponse).getStatus();
        verify(sessionResponse).getSessionToken();
        assertNotNull(response);
    }

    @Test
    public void shouldThrowExceptionWhenVerify3dRequestIsExecutedWithoutInitializeRequestBeforehand() throws SafechargeException {
        exception.expect(SafechargeConfigurationException.class);
        exception.expectMessage("Missing mandatory info for execution of payments! Please run initialization method before creating payments.");

        sut.verify3d("clientUniqueId", "clienRequestId", "11", "BGN", null, null, null, null,
                "relatedTransaction", null, null, null, null);
    }

    @Test
    public void shouldExecuteAuthorize3dRequestAndReturnResponse() throws SafechargeException {
        SafechargeResponse sessionResponse = mock(SafechargeResponse.class);
        when(sessionResponse.getSessionToken()).thenReturn("sessionToken");

        SafechargeResponse authorize3dResponse = new Authorize3dResponse();

        when(executor.execute(any(GetSessionTokenRequest.class))).thenReturn(sessionResponse);
        when(executor.execute(any(Authorize3dRequest.class))).thenReturn(authorize3dResponse);

        sut.initialize("merchantKey", "id", "siteId", "localhost", Constants.HashAlgorithm.SHA256);
        Authorize3dResponse response = sut.authorize3d("usertTokenId", "clientUniqueId", "clientRequestId", null, null, "BGN", "11",
                null, null, null, null, null, null, null, null, null, null,
                null, null, null, "relatedTransaction", null, null, null, null, null, null,
                null);

        verify(executor).execute(any(GetSessionTokenRequest.class));
        verify(executor).execute(any(Authorize3dRequest.class));
        verifyNoMoreInteractions(executor);
        verify(sessionResponse).getStatus();
        verify(sessionResponse).getSessionToken();
        assertNotNull(response);
    }

    @Test
    public void shouldThrowExceptionWhenAuthorize3dRequestIsExecutedWithouthInitializeRequestBeforehand() throws SafechargeException {
        exception.expect(SafechargeConfigurationException.class);
        exception.expectMessage("Missing mandatory info for execution of payments! Please run initialization method before creating payments.");

        sut.authorize3d("usertTokenId", "clientUniqueId", "clientRequestId", null, null, "BGN", "11",
                null, null, null, null, null, null, null, null, null, null,
                null, null, null, "relatedTransaction", null, null, null, null, null,
                null, null);
    }

    @Test
    public void shouldExecuteGetGardDetailsRequestAndReturnResponse() throws SafechargeException {
        SafechargeResponse sessionResponse = mock(SafechargeResponse.class);
        when(sessionResponse.getSessionToken()).thenReturn("sessionToken");

        SafechargeResponse getCardDetailsResponse = new CardDetailsResponse();

        when(executor.execute(any(GetSessionTokenRequest.class))).thenReturn(sessionResponse);
        when(executor.execute(any(CardDetailsRequest.class))).thenReturn(getCardDetailsResponse);

        sut.initialize("merchantKey", "id", "siteId", "localhost", Constants.HashAlgorithm.SHA256);
        CardDetailsResponse response = sut.getCardDetails(null, null, "123456");

        verify(executor).execute(any(GetSessionTokenRequest.class));
        verify(executor).execute(any(CardDetailsRequest.class));
        verifyNoMoreInteractions(executor);
        verify(sessionResponse).getStatus();
        verify(sessionResponse).getSessionToken();
        assertNotNull(response);
    }

    @Test
    public void shouldThrowExceptionWhenGetCardDetailsRequestIsExecutedWithoutInitializeRequestBeforehand() throws SafechargeException {
        exception.expect(SafechargeConfigurationException.class);
        exception.expectMessage("Missing mandatory info for execution of payments! Please run initialization method before creating payments.");

        sut.getCardDetails(null, null, "123456");
    }

    @Test
    public void shouldExecuteGetDccDetailsRequestAndReturnResponse() throws SafechargeException {
        SafechargeResponse sessionResponse = mock(SafechargeResponse.class);
        when(sessionResponse.getSessionToken()).thenReturn("sessionToken");

        SafechargeResponse dccDetailsResponse = new DccDetailsResponse();

        when(executor.execute(any(GetSessionTokenRequest.class))).thenReturn(sessionResponse);
        when(executor.execute(any(DccDetailsRequest.class))).thenReturn(dccDetailsResponse);

        sut.initialize("merchantKey", "id", "siteId", "localhost", Constants.HashAlgorithm.SHA256);
        DccDetailsResponse response = sut.getDccDetails("clientUniqueId", "clentRequestId", "123456", null, "10",
                "BGN", "EUR", null);

        verify(executor).execute(any(GetSessionTokenRequest.class));
        verify(executor).execute(any(DccDetailsRequest.class));
        verifyNoMoreInteractions(executor);
        verify(sessionResponse).getStatus();
        verify(sessionResponse).getSessionToken();
        assertNotNull(response);
    }

    @Test
    public void shouldThrowExceptionWhenGetDccDetailsRequestIsExecutedWithoutInitializeRequestBeforehand() throws SafechargeException {
        exception.expect(SafechargeConfigurationException.class);
        exception.expectMessage("Missing mandatory info for execution of payments! Please run initialization method before creating payments.");

        sut.getDccDetails("clientUniqueId", "clentRequestId", "123456", null, "10",
                "BGN", "EUR", null);
    }

    @Test
    public void shouldExecuteGetMcpRatesRequestAndReturnResponse() throws SafechargeException {
        SafechargeResponse sessionResponse = mock(SafechargeResponse.class);
        when(sessionResponse.getSessionToken()).thenReturn("sessionToken");

        SafechargeResponse mcpRatesRequest = new McpRatesResponse();

        when(executor.execute(any(GetSessionTokenRequest.class))).thenReturn(sessionResponse);
        when(executor.execute(any(McpRatesRequest.class))).thenReturn(mcpRatesRequest);

        sut.initialize("merchantKey", "id", "siteId", "localhost", Constants.HashAlgorithm.SHA256);
        McpRatesResponse response = sut.getMcpRates("clientUniqueId", "clentRequestId", "BGN", null, null);

        verify(executor).execute(any(GetSessionTokenRequest.class));
        verify(executor).execute(any(McpRatesRequest.class));
        verifyNoMoreInteractions(executor);
        verify(sessionResponse).getStatus();
        verify(sessionResponse).getSessionToken();
        assertNotNull(response);
    }

    @Test
    public void shouldThrowExceptionWhenGetMcpRatesRequestIsExecutedWithoutInitializeRequestBeforehand() throws SafechargeException {
        exception.expect(SafechargeConfigurationException.class);
        exception.expectMessage("Missing mandatory info for execution of payments! Please run initialization method before creating payments.");

        sut.getMcpRates("clientUniqueId", "clentRequestId", "BGN", null, null);
    }

    @Test
    public void shouldExecuteAccountCaptureRequestAndReturnResponse() throws SafechargeException {
        SafechargeResponse sessionResponse = mock(SafechargeResponse.class);
        when(sessionResponse.getSessionToken()).thenReturn("sessionToken");

        SafechargeResponse accountCaptureResponse = new AccountCaptureResponse();

        when(executor.execute(any(GetSessionTokenRequest.class))).thenReturn(sessionResponse);
        when(executor.execute(any(AccountCaptureRequest.class))).thenReturn(accountCaptureResponse);

        sut.initialize("merchantKey", "id", "siteId", "localhost", Constants.HashAlgorithm.SHA256);
        AccountCaptureResponse response = sut.accountCapture("clientRequestId", "userTokenId", "paymentMethod", "BGN", "BG",
                "BG", null, null, null, null, null);

        verify(executor).execute(any(GetSessionTokenRequest.class));
        verify(executor).execute(any(AccountCaptureRequest.class));
        verifyNoMoreInteractions(executor);
        verify(sessionResponse).getStatus();
        verify(sessionResponse).getSessionToken();
        assertNotNull(response);
    }

    @Test
    public void shouldThrowExceptionWhenAccountCaptureRequestIsExecutedWithoutInitializeRequestBeforehand() throws SafechargeException {
        exception.expect(SafechargeConfigurationException.class);
        exception.expectMessage("Missing mandatory info for execution of payments! Please run initialization method before creating payments.");

        sut.accountCapture("clientRequestId", "userTokenId", "paymentMethod", "BGN", "BG",
                null, null,null, null, null, null);
    }

    @Test
    public void shouldThrowExceptionIfARequestIsExecutedWithoutSomeMandatoryField() throws SafechargeException {
        SafechargeResponse sessionResponse = mock(SafechargeResponse.class);
        when(sessionResponse.getSessionToken()).thenReturn("sessionToken");

        when(executor.execute(any(GetSessionTokenRequest.class))).thenReturn(sessionResponse);

        exception.expect(ConstraintViolationException.class);

        sut.initialize("merchantKey", "id", "siteId", "localhost", Constants.HashAlgorithm.SHA256);
        sut.getCardDetails(null, null, null);
    }
}