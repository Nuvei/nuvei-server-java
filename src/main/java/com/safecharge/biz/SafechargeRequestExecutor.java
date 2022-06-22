package com.safecharge.biz;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import com.safecharge.exception.SafechargeException;
import com.safecharge.request.*;
import com.safecharge.response.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.safecharge.util.APIConstants;

/**
 * Copyright (C) 2007-2020 SafeCharge International Group Limited.
 * <p>
 * This class provides functionality to execute {@link SafechargeRequest}s directly to the SafeCharge's REST API
 *</p>
 * @author <a href="mailto:nikolad@safecharge.com">Nikola Dichev</a>
 *
 * @since 2/16/2017
 */
public class SafechargeRequestExecutor {

    private static final Log logger = LogFactory.getLog(SafechargeRequestExecutor.class);
    private static final Map<Class<? extends SafechargeBaseRequest>, Class<? extends SafechargeResponse>> RESPONSE_TYPE_BY_REQUEST_TYPE =
            new HashMap<Class<? extends SafechargeBaseRequest>, Class<? extends SafechargeResponse>>() {
                private static final long serialVersionUID = -5429154998138428048L;

                {
                    put(GetSessionTokenRequest.class, GetSessionTokenResponse.class);
                    put(OpenOrderRequest.class, OpenOrderResponse.class);
                    put(UpdateOrderRequest.class, UpdateOrderResponse.class);
                    put(GetOrderDetailsRequest.class, GetOrderDetailsResponse.class);
                    put(PaymentCCRequest.class, PaymentCCResponse.class);
                    put(PaymentAPMRequest.class, PaymentAPMResponse.class);
                    put(Authorization3DRequest.class, Authorization3DResponse.class);
                    put(Dynamic3DRequest.class, Dynamic3DResponse.class);
                    put(CardTokenizationRequest.class, CardTokenizationResponse.class);
                    put(Payment3DRequest.class, Payment3DResponse.class);
                    put(AddUPOCreditCardByTempTokenRequest.class, AddUPOCreditCardByTempTokenResponse.class);
                    put(SettleTransactionRequest.class, SettleTransactionResponse.class);
                    put(VoidTransactionRequest.class, VoidTransactionResponse.class);
                    put(RefundTransactionRequest.class, RefundTransactionResponse.class);
                    put(AddUPOCreditCardRequest.class, AddUPOCreditCardResponse.class);
                    put(AddUPOAPMRequest.class, AddUPOAPMResponse.class);
                    put(GetMerchantPaymentMethodsRequest.class, GetMerchantPaymentMethodsResponse.class);
                    put(CancelSubscriptionRequest.class, CancelSubscriptionResponse.class);
                    put(CreateSubscriptionRequest.class, CreateSubscriptionResponse.class);
                    put(GetSubscriptionsListRequest.class, GetSubscriptionsListResponse.class);
                    put(GetSubscriptionPlansRequest.class, GetSubscriptionPlansResponse.class);
                    put(PayoutRequest.class, PayoutResponse.class);
                    put(CreateUserRequest.class, UserResponse.class);
                    put(UpdateUserRequest.class, UserResponse.class);
                    put(GetUserDetailsRequest.class, GetUserDetailsResponse.class);
                    put(AddUPOCreditCardByTokenRequest.class, AddUPOCreditCardByTokenResponse.class);
                    put(GetUserUPOsRequest.class, GetUserUPOsResponse.class);
                    put(EditUPOCreditCardRequest.class, EditUPOCreditCardResponse.class);
                    put(EditUPOAPMRequest.class, EditUPOAPMResponse.class);
                    put(EnableUPORequest.class, EnableUPOResponse.class);
                    put(DeleteUPORequest.class, DeleteUPOResponse.class);
                    put(SuspendUPORequest.class, SuspendUPOResponse.class);
                    put(PaymentRequest.class, PaymentResponse.class);
                    put(InitPaymentRequest.class, InitPaymentResponse.class);
                    put(GetPaymentStatusRequest.class, GetPaymentStatusResponse.class);
                    put(Verify3dRequest.class, Verify3dResponse.class);
                    put(Authorize3dRequest.class, Authorize3dResponse.class);
                    put(CardDetailsRequest.class, CardDetailsResponse.class);
                    put(DccDetailsRequest.class, DccDetailsResponse.class);
                    put(McpRatesRequest.class, McpRatesResponse.class);
                    put(AccountCaptureRequest.class, AccountCaptureResponse.class);
                }
            };
    private static final Map<Class<? extends SafechargeBaseRequest>, String> REQUEST_URL_BY_REQUEST_TYPE =
            new HashMap<Class<? extends SafechargeBaseRequest>, String>() {
                private static final long serialVersionUID = -6533247180543051173L;

                {
                    put(GetSessionTokenRequest.class, APIConstants.GET_SESSION_TOKEN_URL);
                    put(OpenOrderRequest.class, APIConstants.OPEN_ORDER_URL);
                    put(UpdateOrderRequest.class, APIConstants.UPDATE_ORDER_URL);
                    put(GetOrderDetailsRequest.class, APIConstants.GET_ORDER_DETAILS_URL);
                    put(PaymentCCRequest.class, APIConstants.PAYMENT_CC_URL);
                    put(PaymentAPMRequest.class, APIConstants.PAYMENT_APM_URL);
                    put(Authorization3DRequest.class, APIConstants.AUTHORIZATION_3D_URL);
                    put(Dynamic3DRequest.class, APIConstants.DYNAMIC_3D_URL);
                    put(CardTokenizationRequest.class, APIConstants.CARD_TOKENIZATION_URL);
                    put(Payment3DRequest.class, APIConstants.PAYMENT_3D_URL);
                    put(AddUPOCreditCardByTempTokenRequest.class, APIConstants.ADD_UPO_CREDIT_CARD_BY_TEMP_TOKEN_URL);
                    put(SettleTransactionRequest.class, APIConstants.SETTLE_TRANSACTION_URL);
                    put(VoidTransactionRequest.class, APIConstants.VOID_TRANSACTION_URL);
                    put(RefundTransactionRequest.class, APIConstants.REFUND_TRANSACTION_URL);
                    put(AddUPOCreditCardRequest.class, APIConstants.ADD_UPO_CREDIT_CARD_URL);
                    put(AddUPOAPMRequest.class, APIConstants.ADD_UPO_APM_URL);
                    put(GetMerchantPaymentMethodsRequest.class, APIConstants.GET_MERCHANT_PAYMENT_METHODS_REQUEST_URL);
                    put(CancelSubscriptionRequest.class, APIConstants.CANCEL_SUBSCRIPTION_REQUEST_URL);
                    put(CreateSubscriptionRequest.class, APIConstants.CREATE_SUBSCRIPTION_REQUEST_URL);
                    put(GetSubscriptionsListRequest.class, APIConstants.GET_SUBSCRIPTION_LIST_REQUEST_URL);
                    put(GetSubscriptionPlansRequest.class, APIConstants.GET_SUBSCRIPTION_PLANS_REQUEST_URL);
                    put(PayoutRequest.class, APIConstants.PAYOUT_URL);
                    put(CreateUserRequest.class, APIConstants.CREATE_USER_URL);
                    put(UpdateUserRequest.class, APIConstants.UPDATE_USER_URL);
                    put(GetUserDetailsRequest.class, APIConstants.GET_USER_DETAILS_URL);
                    put(AddUPOCreditCardByTokenRequest.class, APIConstants.ADD_UPO_CREDIT_CARD_BY_TOKEN_URL);
                    put(GetUserUPOsRequest.class, APIConstants.GET_USER_UPOS_REQUEST);
                    put(EditUPOCreditCardRequest.class, APIConstants.EDIT_UPO_CREDIT_CARD_URL);
                    put(EditUPOAPMRequest.class, APIConstants.EDIT_UPO_APM_URL);
                    put(EnableUPORequest.class, APIConstants.ENABLE_UPO_URL);
                    put(DeleteUPORequest.class, APIConstants.DELETE_UPO_APM_URL);
                    put(SuspendUPORequest.class, APIConstants.SUSPEND_UPO_APM_URL);
                    put(PaymentRequest.class, APIConstants.PAYMENT_URL);
                    put(InitPaymentRequest.class, APIConstants.INIT_PAYMENT_URL);
                    put(GetPaymentStatusRequest.class, APIConstants.GET_PAYMENT_STATUS_URL);
                    put(Verify3dRequest.class, APIConstants.VERIFY3D_URL);
                    put(Authorize3dRequest.class, APIConstants.AUTHORIZE3D_URL);
                    put(CardDetailsRequest.class, APIConstants.GET_CARD_DETAILS_URL);
                    put(DccDetailsRequest.class, APIConstants.DCC_DETAILS_URL);
                    put(McpRatesRequest.class, APIConstants.MCP_RATES_URL);
                    put(AccountCaptureRequest.class, APIConstants.ACCOUNT_CAPTURE_URL);
                }
            };

    private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");
    private static SafechargeRequestExecutor instance = null;
    private static HttpClient httpClient;
    private static boolean isInitialized = false;

    private SafechargeRequestExecutor() {
    }

    /**
     * Obtains the single instance of {@link SafechargeRequestExecutor}
     *
     * @return the single instance of {@link SafechargeRequestExecutor}
     */
    public static SafechargeRequestExecutor getInstance() {
        if (instance == null) {
            instance = new SafechargeRequestExecutor();
        }
        return instance;
    }

    /**
     * This method initiates the {@link SafechargeRequestExecutor} with a default Safecharge's {@link HttpClient} and server information.
     */
    public void init() {
        init(SafechargeHttpClient.createDefault());
    }

    /**
     * This method initiates the {@link SafechargeRequestExecutor} with a configured {@link HttpClient} and server information.
     *
     * @param httpClient to get the client's properties from
     */
    public void init(HttpClient httpClient) {

        if (isInitialized) {
            // already initialized
            if (logger.isDebugEnabled()) {
                logger.debug(SafechargeRequestExecutor.class.getSimpleName() + " is already initialized!");
            }
            return;
        }

        SafechargeRequestExecutor.httpClient = httpClient;

        isInitialized = true;
    }

    /**
     * Sends a {@link SafechargeRequest} to SafeCharge's API via HTTP POST method.
     *
     * @param request {@link SafechargeRequest} API request object
     * @return {@link SafechargeResponse} API response object or null if the response can't be parsed
     */
    public SafechargeResponse executeRequest(SafechargeBaseRequest request) {
        try {
            return execute(request);
        } catch (SafechargeException e) {
            return null;
        }
    }

    /**
     * Sends a {@link SafechargeRequest} to SafeCharge's API via HTTP POST method.
     *
     * @param request {@link SafechargeRequest} API request object
     * @return {@link SafechargeResponse} API response object.
     * @throws SafechargeException If the request execution throws IOException it is wrapped and rethrown in {@link SafechargeException}
     */
    public SafechargeResponse execute(SafechargeBaseRequest request) throws SafechargeException {
        if (!isInitialized) {
            init();
        }

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {
            Class<? extends SafechargeBaseRequest> requestClass = request.getClass();
            String serviceUrl = request.getServerHost() + REQUEST_URL_BY_REQUEST_TYPE.get(requestClass);
            request.setServerHost(null); // remove API url from request

            String requestJSON = gson.toJson(request);
            String responseJSON = executeJsonRequest(requestJSON, serviceUrl, requestClass);

            return gson.fromJson(responseJSON, RESPONSE_TYPE_BY_REQUEST_TYPE.get(requestClass));

        } catch (IOException e) {

            if (logger.isDebugEnabled()) {
                logger.debug(e.getMessage());
            }
            throw new SafechargeException(e.getMessage());
        }
    }

    /**
     * Sends a POST request to the service at {@code serviceUrl} with a payload of {@code requestJSON}.
     *
     * @param requestJSON A {@link String} representation of a JSON object
     * @param serviceUrl  The service URL to sent the request to
     * @return {@link String} response from the service (representing JSON object)
     * @throws IOException if the connection is interrupted or the response is unparsable
     */
    public String executeJsonRequest(String requestJSON, String serviceUrl, Class<? extends SafechargeBaseRequest> requestClass) throws IOException {
        return executeRequest(requestJSON, serviceUrl, APIConstants.REQUEST_HEADERS, requestClass);
    }

    /**
     * Sends a POST request to the service at {@code serviceUrl} with a payload of {@code request}.
     * The request type is determined by the {@code headers} param.
     *
     * @param request    A {@link String} representation of a request object. Can be JSON object, form data, etc...
     * @param serviceUrl The service URL to sent the request to
     * @param headers    An array of {@link Header} objects, used to determine the request type
     * @param requestClass  The Type Of request Used
     * @return {@link String} response from the service (representing JSON object)
     * @throws IOException if the connection is interrupted or the response is unparsable
     */
    public String executeRequest(String request, String serviceUrl, Header[] headers, Class<? extends SafechargeBaseRequest> requestClass) throws IOException {
        HttpPost httpPost = new HttpPost(serviceUrl);
        httpPost.setHeaders(headers);
        httpPost.setEntity(new StringEntity(request, Charset.forName("UTF-8")));

        if (logger.isDebugEnabled()) {
            logger.debug(requestClass.getSimpleName() + " Sent " + System.lineSeparator() + request);
        }

        HttpResponse response = httpClient.execute(httpPost);

        String responseJSON = EntityUtils.toString(response.getEntity(), UTF8_CHARSET);
        if (logger.isDebugEnabled()) {
            Class<? extends SafechargeResponse> responseClass = RESPONSE_TYPE_BY_REQUEST_TYPE.get(requestClass);
            logger.debug(responseClass.getSimpleName() + " Received " + responseJSON);
        }

        return responseJSON;
    }
}
