package com.safecharge.request;

import com.safecharge.request.basic.CashierUserRequest;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.ADD_CASHIER_USER)
public class CreateUserRequest extends CashierUserRequest {

    public static Builder builder() {
        return new Builder();
    }

    public CreateUserRequest(Builder b) {
        super(b);
    }

    public static class Builder extends CashierUserRequest.Builder {
        public CreateUserRequest build() {
            return new CreateUserRequest(this);
        }
    }
}