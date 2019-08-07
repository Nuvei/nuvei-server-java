package com.safecharge.util;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */
public interface APIConstants {

    // Pre-configured hosts:

    String PRODUCTION_HOST = "https://secure.safecharge.com/ppp/";
    String INTEGRATION_HOST = "https://ppp-test.safecharge.com/ppp/";

    // API enpoints:

    String GET_SESSION_TOKEN_URL = "api/v1/getSessionToken.do";
    String OPEN_ORDER_URL = "api/v1/openOrder.do";
    String UPDATE_ORDER_URL = "api/v1/updateOrder.do";
    String GET_ORDER_DETAILS_URL = "api/v1/getOrderDetails.do";
    String PAYMENT_CC_URL = "api/v1/paymentCC.do";
    String PAYMENT_APM_URL = "api/v1/paymentAPM.do";
    String AUTHORIZATION_3D_URL = "api/v1/authorization3D.do"; // the same method as "api/v1/dynamic3D.do". The provided two entry points are one method.
    String DYNAMIC_3D_URL = "api/v1/dynamic3D.do"; // the same method as "api/v1/authorization3D.do". The provided two entry points are one method.
    String CARD_TOKENIZATION_URL = "api/v1/cardTokenization.do";
    String ADD_UPO_CREDIT_CARD_BY_TEMP_TOKEN_URL = "api/v1/addUPOCreditCardByTempToken.do";
    String PAYMENT_3D_URL = "api/v1/payment3D.do";
    String SETTLE_TRANSACTION_URL = "api/v1/settleTransaction.do";
    String VOID_TRANSACTION_URL = "api/v1/voidTransaction.do";
    String REFUND_TRANSACTION_URL = "api/v1/refundTransaction.do";
    String ADD_UPO_CREDIT_CARD_URL = "api/v1/addUPOCreditCard.do";
    String ADD_UPO_APM_URL = "api/v1/addUPOAPM.do";
    String GET_MERCHANT_PAYMENT_METHODS_REQUEST_URL = "api/v1/getMerchantPaymentMethods.do";
    String CANCEL_SUBSCRIPTION_REQUEST_URL = "api/v1/cancelSubscription.do";
    String CREATE_SUBSCRIPTION_REQUEST_URL = "api/v1/createSubscription.do";
    String GET_SUBSCRIPTION_LIST_REQUEST_URL = "api/v1/getSubscriptionsList.do";
    String GET_SUBSCRIPTION_PLANS_REQUEST_URL = "api/v1/getSubscriptionPlans.do";
    String PAYOUT_URL = "api/v1/payout.do";
    String CREATE_USER_URL = "api/v1/createUser.do";
    String UPDATE_USER_URL = "api/v1/updateUser.do";
    String GET_USER_DETAILS_URL = "api/v1/getUserDetails.do";
    String ADD_UPO_CREDIT_CARD_BY_TOKEN_URL = "api/v1/addUPOCreditCardByToken.do";
    String GET_USER_UPOS_REQUEST = "api/v1/getUserUPOs.do";
    String EDIT_UPO_CREDIT_CARD_URL = "api/v1/editUPOCC.do";
    String EDIT_UPO_APM_URL = "api/v1/editUPOAPM.do";
    String ENABLE_UPO_URL = "api/v1/enableUPO.do";
    String DELETE_UPO_APM_URL = "api/v1/deleteUPO.do";
    String SUSPEND_UPO_APM_URL = "api/v1/suspendUPO.do";
    String GET_PAYMENT_PAGE_URL = "api/v1/getPaymentPageUrl.do";


    // Request Headers:

    Header[] REQUEST_HEADERS = new Header[]{new BasicHeader("Content-Type", "application/json"), new BasicHeader("Client-Name",
            APIConstants.class.getPackage()
                    .getImplementationTitle()), new BasicHeader("Client-Version", APIConstants.class.getPackage()
            .getImplementationVersion())};

    // Field limitations:

    short ADDRESS_MAX_LENGTH = 120;
    short FIRST_NAME_MAX_LENGTH = 30;
    short LAST_NAME_MAX_LENGTH = 40;
    short CARD_HOLDER_MAX_LENGTH = 70;
    short CITY_MAX_LENGTH = 30;
    short ZIP_MAX_LENGTH = 10;
    short PHONE_MAX_LENGTH = 18;
    short CREDIT_CARD_MAX_LENGTH = 20;
    short MERCHANT_DESCRIPTOR_PHONE_MAX_LENGTH = 13;
    short MERCHANT_DESCRIPTOR_NAME_MAX_LENGTH = 25;
    short COUNTY_MAX_LENGTH = 255;
    short EMAIL_MAX_LENGTH = 100;

    // field limitations using regular expressions:

    String IP_ADDRESS_REGEX = "^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$";
    String EXP_YEAR_REGEX = "^$|(?:(20)\\d{2}|\\d{2})$"; // two or four digits
    String EXP_MONTH_REGEX = "^$|(0?[1-9]|1[012])$";
    String DATE_OF_BIRTH_REGEX = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";
    String IS_DYNAMIC_3D_REGEX = "^(0|1)$";

    String SDK_JAVA_VERSION = "sdk_java_ver";
}
