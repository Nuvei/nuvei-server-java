package com.safecharge.retail.response;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */
public interface PaymentsResponse extends SafechargeResponse {

    /**
     * @return the Merchant Order ID to be used as input parameter in update method and payment methods. The parameter passed to define which merchant order to update.
     */
    String getOrderId();

    /**
     * @return the gateway/APM gateway transaction status.
     */
    String getTransactionStatus();

    /**
     * @return the error code if error occurred at the cashier side.
     */
    String getPaymentMethodErrorCode();

    /**
     * @return the error reason if error occurred at the cashier side.
     */
    String getPaymentMethodErrorReason();

    /**
     * @return the error reason if error occurred at the gateway/APM gateway side.
     */
    String getGwErrorReason();

    /**
     * @return the Id of newly generated userPaymentOption, in case of new userPaymentOption is generated, or userPaymentOptionId that has been used for transaction processing and it had been sent into the request.
     */
    Long getUserPaymentOptionId();

    /**
     * @return the Bank transaction ID.
     */
    String getExternalTransactionId();

    /**
     * @return Gateway Transaction ID.
     */
    String getTransactionId();

    /**
     * @return error code if error occurred at the gateway/APM gateway side.
     */
    Integer getGwErrorCode();

    /**
     * @return error code if error occurred at the bank side.
     */
    Integer getGwExtendedErrorCode();

    /**
     * @return the ID of the user in merchant system.
     */
    String getUserTokenId();

    /**
     * @return the Auth code.
     */
    String getAuthCode();
}
