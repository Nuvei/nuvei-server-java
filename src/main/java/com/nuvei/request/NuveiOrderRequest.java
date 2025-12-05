/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.request;

/**
 * <p>
 * Interface that all request working with order must implement, except for the request(s) that create an order.
 * <p>
 * The reason is that merchant order id is required param to work with an already created order.
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @since 2/22/2017
 */
public interface NuveiOrderRequest {

    /**
     * MerchantOrderID to be used as input parameter in update request and payment requests.
     *
     * @param orderId the order id received as response to order creation request
     */
    void setOrderId(String orderId);

}
