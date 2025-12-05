/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.request;

import com.nuvei.request.basic.CashierUserRequest;
import com.nuvei.request.builder.NuveiCashierUserBuilder;
import com.nuvei.util.Constants;
import com.nuvei.util.ValidChecksum;
import com.nuvei.util.ValidationUtils;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.MODIFY_CASHIER_USER)
public class UpdateUserRequest extends CashierUserRequest {

    public static UpdateUserRequest.Builder builder() {
        return new UpdateUserRequest.Builder();
    }

    public static class Builder extends NuveiCashierUserBuilder {

        public UpdateUserRequest build() {
            UpdateUserRequest request = new UpdateUserRequest();
            return (UpdateUserRequest) ValidationUtils.validate(super.build(request));
        }
    }
}