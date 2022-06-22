package com.safecharge.biz;

import com.google.gson.GsonBuilder;

public class ServiceFactory {

    public RequestBuilder getRequestBuilder() {
        return new RequestBuilder();
    }
}
