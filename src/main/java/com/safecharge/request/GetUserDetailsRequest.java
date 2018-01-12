package com.safecharge.request;

import com.safecharge.request.basic.BaseCashierUserRequest;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.GET_CASHIER_USER_INFO)
public class GetUserDetailsRequest extends BaseCashierUserRequest {

    public static Builder builder() {
        return new Builder();
    }

    public GetUserDetailsRequest(Builder b) {
        super(b);
    }

    public static class Builder extends BaseCashierUserRequest.Builder {
        public GetUserDetailsRequest build() {
            return new GetUserDetailsRequest(this);
        }
    }
}
