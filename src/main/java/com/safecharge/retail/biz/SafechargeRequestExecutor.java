package com.safecharge.retail.biz;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.safecharge.retail.request.SafechargeRequest;
import com.safecharge.retail.response.SafechargeResponse;
import com.safecharge.retail.util.APIConstants;
import com.safecharge.retail.util.Constants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/16/2017
 */
public class SafechargeRequestExecutor {

    private static final Logger logger = LogManager.getLogger(SafechargeRequestExecutor.class);

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
     * @param request
     * @return
     */
    public SafechargeResponse executeRequest(SafechargeRequest request) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {
            String requestJSON = gson.toJson(request);
            HttpPost httpPost = new HttpPost(serverHost + Constants.REQUEST_URL_BY_REQUEST_TYPE.get(request.getClass()));
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

            return gson.fromJson(responseJSON, Constants.RESPONSE_TYPE_BY_REQUEST_TYPE.get(request.getClass()));

        } catch (IOException e) {

            if (logger.isDebugEnabled()) {
                logger.debug(e.getMessage());
            }
        }

        return null;
    }
}
