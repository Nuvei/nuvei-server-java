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

}
