package com.safecharge.retail.request;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/22/2017
 */
public interface SafechargeOrderRequest {

    /**
     * MerchantOrderID to be used as input parameter in update method and payment methods. The parameter passed to define which merchant order to update.
     *
     * @param orderId
     */
    void setOrderId(String orderId);

}
