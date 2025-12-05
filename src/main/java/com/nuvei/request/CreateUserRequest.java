/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.request;

import com.nuvei.request.basic.CashierUserRequest;
import com.nuvei.request.builder.NuveiCashierUserBuilder;
import com.nuvei.util.Constants;
import com.nuvei.util.ValidChecksum;
import com.nuvei.util.ValidationUtils;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.ADD_CASHIER_USER)
public class CreateUserRequest extends CashierUserRequest {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends NuveiCashierUserBuilder {

        public CreateUserRequest build() {
            CreateUserRequest request = new CreateUserRequest();
            return (CreateUserRequest) ValidationUtils.validate(super.build(request));
        }
    }
}