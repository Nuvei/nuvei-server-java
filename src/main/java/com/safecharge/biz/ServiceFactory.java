/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.biz;

import com.google.gson.GsonBuilder;

public class ServiceFactory {

    public RequestBuilder getRequestBuilder() {
        return new RequestBuilder();
    }
}
