package com.safecharge.request;

import com.safecharge.request.basic.CashierUserRequest;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.MODIFY_CASHIER_USER)
public class UpdateUserRequest extends CashierUserRequest {

    private static final long serialVersionUID = 3945508076987109885L;

    public UpdateUserRequest() {
        super();
    }
}