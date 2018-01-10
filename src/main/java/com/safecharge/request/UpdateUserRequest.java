package com.safecharge.request;

import com.safecharge.request.basic.CashierUserRequest;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.MODIFY_CASHIER_USER)
public class UpdateUserRequest extends CashierUserRequest {

    public static Builder builder() {
        return new Builder();
    }

    public UpdateUserRequest(Builder b) {
        super(b);
    }

    public static class Builder extends CashierUserRequest.Builder {
        public UpdateUserRequest build() {
            return new UpdateUserRequest(this);
        }
    }
}