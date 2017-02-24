package com.safecharge.retail.biz;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

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

    private static SafechargeRequestExecutor instance = null;
    private static HttpClient httpClient;
    private static boolean isInitialized = false;
    private static String serverHost = "";

    public static SafechargeRequestExecutor getInstance() {
        if (instance == null) {
            instance = new SafechargeRequestExecutor();
        }
        return instance;
    }

    private SafechargeRequestExecutor() {
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

    public SafechargeResponse executePostRequest(SafechargeRequest request) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {
            String requestJSON = gson.toJson(request);
            HttpPost httpPost = new HttpPost(serverHost + Constants.REQUEST_URL_BY_REQUEST_TYPE.get(request.getClass()));
            httpPost.setHeaders(APIConstants.REQUEST_HEADERS);
            httpPost.setEntity(new StringEntity(requestJSON));

            System.out.println("Sent " + request.getClass()
                                                .getSimpleName() + ":\n\t\t" + requestJSON);
            HttpResponse response = httpClient.execute(httpPost);

            String responseJSON = EntityUtils.toString(response.getEntity());
            System.out.println("Received " + request.getClass()
                                                    .getSimpleName() + ":\n\t\t" + responseJSON);

            return gson.fromJson(responseJSON, Constants.RESPONSE_TYPE_BY_REQUEST_TYPE.get(request.getClass()));
        } catch (UnsupportedEncodingException | ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
