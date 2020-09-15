package com.safecharge.request;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.safecharge.model.UserPaymentOption;

/**
 * Copyright (C) 2007-2020 SafeCharge International Group Limited.
 * <p>
 * Abstract class with basic fields used with requests to create an order in the SafeCharge's system.
 * </p>
 * <p>
 * This request represents the state of the order when it is created, it can be changed at later time.
 * Note that no payment request is send, it is used mainly to store the order details at the time of creation.
 * </p>
 *
 * @author <a mailto:vasiln@safecharge.com>Vassil Nikov</a>
 * @see GetOrderDetailsRequest
 * @see UpdateOrderRequest
 * @see OpenOrderRequest
 */
public abstract class OrderRequestWithDetails extends SafechargeOrderDetailsRequest {

    @Size(max = 50)
    private String paymentMethod;

    @Valid
    private UserPaymentOption userPaymentOption;

    @Size(max = 255)
    private String customData;

    private Boolean autoPayment3D;

    private String isMoto;

    @Size(max = 255)
    private String userId;

    private final String sourceApplication = "JAVA_SDK";

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderRequestWithDetails{");
        sb.append("paymentMethod='").append(paymentMethod)
                .append(", userPaymentOption=").append(userPaymentOption)
                .append(", customData='").append(customData)
                .append(", autoPayment3D=").append(autoPayment3D)
                .append(", isMoto='").append(isMoto)
                .append(", userId='").append(userId);
        sb.append(super.toString());

        return sb.toString();
    }
}
