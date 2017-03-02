package com.safecharge.retail.biz;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.safecharge.retail.request.Authorization3DRequest;
import com.safecharge.retail.request.CardTokenizationRequest;
import com.safecharge.retail.request.GetOrderDetailsRequest;
import com.safecharge.retail.request.GetSessionTokenRequest;
import com.safecharge.retail.request.OpenOrderRequest;
import com.safecharge.retail.request.PaymentAPMRequest;
import com.safecharge.retail.request.PaymentCCRequest;
import com.safecharge.retail.request.SafechargeRequest;
import com.safecharge.retail.request.UpdateOrderRequest;
import com.safecharge.retail.response.Authorization3DResponse;
import com.safecharge.retail.response.CardTokenizationResponse;
import com.safecharge.retail.response.OpenOrderResponse;
import com.safecharge.retail.response.OrderDetailsResponse;
import com.safecharge.retail.response.PaymentAPMResponse;
import com.safecharge.retail.response.PaymentCCResponse;
import com.safecharge.retail.response.SafechargeResponse;
import com.safecharge.retail.response.SessionTokenResponse;
import com.safecharge.retail.response.UpdateOrderResponse;
import com.safecharge.retail.util.APIConstants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * This class provides functionality to execute {@link SafechargeRequest}s directly to the SafeCharge's REST API
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/16/2017
 */
public class SafechargeRequestExecutor {

    private static final Logger logger = LogManager.getLogger(SafechargeRequestExecutor.class);
    private static final Map<Class<? extends SafechargeRequest>, Class<? extends SafechargeResponse>> RESPONSE_TYPE_BY_REQUEST_TYPE =
            new HashMap<Class<? extends SafechargeRequest>, Class<? extends SafechargeResponse>>() {
                private static final long serialVersionUID = -5429154998138428047L;

                {
                    put(GetSessionTokenRequest.class, SessionTokenResponse.class);
                    put(OpenOrderRequest.class, OpenOrderResponse.class);
                    put(UpdateOrderRequest.class, UpdateOrderResponse.class);
                    put(GetOrderDetailsRequest.class, OrderDetailsResponse.class);
                    put(PaymentCCRequest.class, PaymentCCResponse.class);
                    put(PaymentAPMRequest.class, PaymentAPMResponse.class);
                    put(Authorization3DRequest.class, Authorization3DResponse.class);
                    put(CardTokenizationRequest.class, CardTokenizationResponse.class);
                }
            };
    private static final Map<Class<? extends SafechargeRequest>, String> REQUEST_URL_BY_REQUEST_TYPE =
            new HashMap<Class<? extends SafechargeRequest>, String>() {
                private static final long serialVersionUID = -6533247180543051173L;

                {
                    put(GetSessionTokenRequest.class, APIConstants.GET_SESSION_TOKEN_URL);
                    put(OpenOrderRequest.class, APIConstants.OPEN_ORDER_URL);
                    put(UpdateOrderRequest.class, APIConstants.UPDATE_ORDER_URL);
                    put(GetOrderDetailsRequest.class, APIConstants.GET_ORDER_DETAILS_URL);
                    put(PaymentCCRequest.class, APIConstants.PAYMENT_CC_URL);
                    put(PaymentAPMRequest.class, APIConstants.PAYMENT_APM_URL);
                    put(Authorization3DRequest.class, APIConstants.AUTHORIZATION_3D_URL);
                    put(CardTokenizationRequest.class, APIConstants.CARD_TOKENIZATION_URL);
                }
            };
    private static SafechargeRequestExecutor instance = null;
    private static HttpClient httpClient;
    private static boolean isInitialized = false;
    private static String serverHost = "";

    private SafechargeRequestExecutor() {
    }

    public static SafechargeRequestExecutor getInstance() {
        if (instance == null) {
            instance = new SafechargeRequestExecutor();
        }
        return instance;
    }

    /**
     * This method initiates the {@link SafechargeRequestExecutor} with a configured {@link HttpClient} and server information.
     *
     * @param httpClient           - the HttpClient used to connect to the SafeCharge API. <br />
     *                             &emsp;Example client: {@link SafechargeHttpClient#createDefault()}
     * @param safechargeServerHost - the SafeCharge API host. <br/>
     *                             &emsp;Integration value: {@link APIConstants#INTEGRATION_HOST} <br />
     *                             &emsp;Production value: {@link APIConstants#PRODUCTION_HOST} <br />
     */
    public void init(HttpClient httpClient, String safechargeServerHost) {

        if (isInitialized) {
            // already initialized
            return;
        }

        SafechargeRequestExecutor.httpClient = httpClient;
        SafechargeRequestExecutor.serverHost = safechargeServerHost;

        isInitialized = true;
    }

    /**
     * Sends a {@link SafechargeRequest} to SafeCharge's API via HTTP POST method.
     *
     * @param request
     * @return
     */
    public SafechargeResponse executeRequest(SafechargeRequest request) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {
            String requestJSON = gson.toJson(request);
            HttpPost httpPost = new HttpPost(serverHost + REQUEST_URL_BY_REQUEST_TYPE.get(request.getClass()));
            httpPost.setHeaders(APIConstants.REQUEST_HEADERS);
            httpPost.setEntity(new StringEntity(requestJSON));

            if (logger.isDebugEnabled()) {
                logger.debug("Sent " + request.getClass()
                                              .getSimpleName() + ": " + requestJSON);
            }

            HttpResponse response = httpClient.execute(httpPost);

            String responseJSON = EntityUtils.toString(response.getEntity());
            if (logger.isDebugEnabled()) {
                logger.debug("Received " + request.getClass()
                                                  .getSimpleName() + ": " + responseJSON);
            }

            return gson.fromJson(responseJSON, RESPONSE_TYPE_BY_REQUEST_TYPE.get(request.getClass()));

        } catch (IOException e) {

            if (logger.isDebugEnabled()) {
                logger.debug(e.getMessage());
            }
        }

        return null;
    }
}
