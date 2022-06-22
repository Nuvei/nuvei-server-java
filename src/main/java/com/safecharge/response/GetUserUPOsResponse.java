package com.safecharge.response;

import java.util.ArrayList;
import java.util.List;

import com.safecharge.model.CashierPaymentMethodDetails;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Request to add Credit/Debit card User Payment Option(UPO) to a User.
 * <p>
 * This goal of this request is to add a credit card UPO for a specific user according to their User Token ID.
 * Once a credit card UPO is added to the user’s list of UPOs, the credit card is displayed in the payment page.
 *
 * @author <a mailto:bozhidarsh@safecharge.com>Bozhidar Shumanov</a>
 * @since 3/21/2017
 */
public class GetUserUPOsResponse extends SafechargeResponse {

    private final List<CashierPaymentMethodDetails> paymentMethods = new ArrayList<CashierPaymentMethodDetails>();

    public List<CashierPaymentMethodDetails> getPaymentMethods() {
        return paymentMethods;
    }
}
