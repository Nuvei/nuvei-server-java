/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.request;

import com.safecharge.request.basic.CashierUserRequest;
import com.safecharge.request.builder.SafechargeCashierUserBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.MODIFY_CASHIER_USER)
public class UpdateUserRequest extends CashierUserRequest {

    public static UpdateUserRequest.Builder builder() {
        return new UpdateUserRequest.Builder();
    }

    public static class Builder extends SafechargeCashierUserBuilder {

        public UpdateUserRequest build() {
            UpdateUserRequest request = new UpdateUserRequest();
            return (UpdateUserRequest) ValidationUtils.validate(super.build(request));
        }
    }
}