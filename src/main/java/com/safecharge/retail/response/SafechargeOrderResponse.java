package com.safecharge.retail.response;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */
public interface SafechargeOrderResponse extends SafechargeResponse {

    /**
     * @return Merchant Order ID to be used as input parameter in update method and payment methods. The parameter passed to define which merchant order to update.
     */
    String getOrderId();

}
