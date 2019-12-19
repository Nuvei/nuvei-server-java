package com.safecharge.biz;

public class ServiceFactory {

    public PaymentService getPaymentService() {
        return new PaymentService();
    }
}
