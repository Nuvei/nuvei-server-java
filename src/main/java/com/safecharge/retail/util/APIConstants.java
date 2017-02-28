package com.safecharge.retail.util;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */
public interface APIConstants {

    String PRODUCTION_HOST = "https://secure.safecharge.com/ppp/";
    String INTEGRATION_HOST = "https://secure.safecharge.com/ppp/";

    String GET_SESSION_TOKEN_URL = "api/v1/getSessionToken.do";
    String OPEN_ORDER_URL = "api/v1/openOrder.do";
    String UPDATE_ORDER_URL = "api/v1/updateOrder.do";
    String GET_ORDER_DETAILS_URL = "api/v1/getOrderDetails.do";
    String PAYMENT_CC_URL = "api/v1/paymentCC.do";
    String PAYMENT_APM_URL = "api/v1/paymentAPM.do";
    String AUTHORIZATION_3D_URL = "api/v1/authorization3D.do";
    String CARD_TOKENIZATION_URL = "api/v1/cardTokenization.do";

    Header[] REQUEST_HEADERS = new Header[] { new BasicHeader("Content-Type", "application/json") };

    short ADDRESS_MAX_LENGTH = 60;
    short FIRST_NAME_MAX_LENGTH = 30;
    short LAST_NAME_MAX_LENGTH = 40;
    short CARD_HOLDER_MAX_LENGTH = 70;
    short CITY_MAX_LENGTH = 30;
    short ZIP_MAX_LENGTH = 10;
    short PHONE_MAX_LENGTH = 18;
    short CREDIT_CARD_MAX_LENGTH = 20;
    short MERCHANT_DESCRIPTOR_PHONE_MAX_LENGTH = 13;
    short MERCHANT_DESCRIPTOR_NAME_MAX_LENGTH = 25;

    String IP_ADDRESS_REGEX = "^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$";
    String EMAIL_REGEX = "^[A-Za-z0-9._%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,10}$";

}
