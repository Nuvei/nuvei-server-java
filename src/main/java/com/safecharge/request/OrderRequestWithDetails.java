package com.safecharge.request;

import com.safecharge.model.UserPaymentOption;

/**
 * Copyright (C) 2007-2019 SafeCharge International Group Limited.
 * <p>
 * Abstract class with basic fields used with requests to create an order in the SafeCharge's system.
 * </p>
 * <p>
 * This request represents the state of the order when it is created, it can be changed at later time.
 * Note that no payment request is send, it is used mainly to store the order details at the time of creation.
 *</p>
 *
 * @author <a mailto:vasiln@safecharge.com>Vassil Nikovv</a>
 * @see GetOrderDetailsRequest
 * @see UpdateOrderRequest
 * @see OpenOrderRequest
 */
public abstract class OrderRequestWithDetails extends SafechargeOrderDetailsRequest {

    private String paymentMethod;
    private UserPaymentOption userPaymentOption;
    private String customData;
    private Boolean autoPayment3D;
    private final String sourceApplication = "JAVA_SDK";
    private String isMoto;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public UserPaymentOption getUserPaymentOption() {
        return userPaymentOption;
    }

    public void setUserPaymentOption(UserPaymentOption userPaymentOption) {
        this.userPaymentOption = userPaymentOption;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }

    public boolean isAutoPayment3D() {
        return autoPayment3D;
    }

    public void setAutoPayment3D(Boolean autoPayment3D) {
        this.autoPayment3D = autoPayment3D;
    }

    public String getIsMoto() {
        return isMoto;
    }

    public void setIsMoto(String isMoto) {
        this.isMoto = isMoto;
    }
}
