package com.safecharge.biz;

public class ServiceFactory {

    public RequestBuilder getRequestBuilder() {
        return new RequestBuilder();
    }
}
