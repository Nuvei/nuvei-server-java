/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.request.builder;

import com.safecharge.model.UserPaymentOption;
import com.safecharge.request.OrderRequestWithDetails;

/**
 * <p>
 * A base builder for order with details related requests.
 * </p>
 *
 * @author <a mailto:vasiln@safecharge.com>Vassil Nikov</a>
 * @see SafechargeBuilder
 * @see SafechargeOrderBuilder
 */
public abstract class SafechargeOrderWithDetailsBuilder<T extends SafechargeOrderWithDetailsBuilder<T>> extends SafechargeOrderBuilder<T> {

    private String paymentMethod;
    private UserPaymentOption userPaymentOption;
    private String customData;
    private Boolean autoPayment3D;
    private String isMoto;
    private String userId;

    public T addPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return (T) this;
    }

    public T addUserPaymentOption(UserPaymentOption userPaymentOption) {
        this.userPaymentOption = userPaymentOption;
        return (T) this;
    }

    public T addCustomData(String customData) {
        this.customData = customData;
        return (T) this;
    }

    public T addAutoPayment3D(Boolean autoPayment3D) {
        this.autoPayment3D = Boolean.TRUE.equals(autoPayment3D);
        return (T) this;
    }

    public T addIsMoto(String isMoto) {
        this.isMoto = isMoto;
        return (T) this;
    }

    public T addUserId(String userId) {
        this.userId = userId;
        return (T) this;
    }

    /**
     * Adds the common order data, collected by this builder.
     *
     * @param request an already created request of type T
     * @param <S>     type parameter
     * @return the passed {@code request} filled with the data from this builder
     */
    protected <S extends OrderRequestWithDetails> S build(S request) {
        super.build(request);

        request.setPaymentMethod(paymentMethod);
        request.setUserPaymentOption(userPaymentOption);
        request.setCustomData(customData);
        request.setAutoPayment3D(autoPayment3D);
        request.setIsMoto(isMoto);
        request.setUserId(userId);

        return request;
    }
}
