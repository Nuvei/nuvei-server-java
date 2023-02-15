/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.test.workflow.paymentCC;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.mockito.Mockito;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.safecharge.biz.SafechargeRequestExecutor;
import com.safecharge.model.MerchantInfo;
import com.safecharge.request.GetSessionTokenRequest;
import com.safecharge.request.SafechargeBaseRequest;
import com.safecharge.response.GetSessionTokenResponse;
import com.safecharge.util.Constants;

/**
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/29/2017
 */
public class BasePaymentCCTest {

    protected static Validator validator;
    protected static Gson gson;
    protected SafechargeRequestExecutor safechargeRequestExecutor;

    @BeforeClass
    public static void setup() {
        gson = new GsonBuilder().serializeNulls()
                .create();
        validator = Validation.buildDefaultValidatorFactory()
                .getValidator();
    }

    @Before
    public void init() {
        safechargeRequestExecutor = mock(SafechargeRequestExecutor.class);

        when(safechargeRequestExecutor.executeRequest(Mockito.any(GetSessionTokenRequest.class))).thenReturn(gson.fromJson(
                "{\"sessionToken\":\"997ecfc7-f3e3-44bb-9cbe-12a2bd724a31\",\"internalRequestId\":13150606,\"status\":\"SUCCESS\",\"errCode\":0,\"reason\":\"\",\"merchantId\":\"5137702336228767168\",\"merchantSiteId\":\"23\",\"version\":\"1.0\",\"clientRequestId\":\"111899\"}",
                GetSessionTokenResponse.class));
    }

    public GetSessionTokenResponse executeGetSessionTokenRequest(MerchantInfo merchantInfo) {
        SafechargeBaseRequest request = GetSessionTokenRequest.builder()
                .addMerchantInfo(merchantInfo)
                .build();
        GetSessionTokenResponse response = (GetSessionTokenResponse) safechargeRequestExecutor.executeRequest(request);

        Assert.assertTrue(0 == response.getErrCode());
        Assert.assertTrue(Constants.APIResponseStatus.SUCCESS.equals(response.getStatus()));

        return response;

    }
}
