/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.request;

import com.safecharge.request.basic.CashierUserRequest;
import com.safecharge.request.builder.SafechargeCashierUserBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.ADD_CASHIER_USER)
public class CreateUserRequest extends CashierUserRequest {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends SafechargeCashierUserBuilder {

        public CreateUserRequest build() {
            CreateUserRequest request = new CreateUserRequest();
            return (CreateUserRequest) ValidationUtils.validate(super.build(request));
        }
    }
}