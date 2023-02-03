/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.safecharge.request.builder.SafechargeBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.GET_CASHIER_USER_INFO)
public class GetUserDetailsRequest extends SafechargeRequest {

    @NotNull
    @Size(max = 255)
    protected String userTokenId;

    public static Builder builder() {
        return new Builder();
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    public static class Builder<T extends SafechargeBuilder<T>> extends SafechargeBuilder<T> {

        protected String userTokenId;

        public T userTokenId(String userTokenId) {
            this.userTokenId = userTokenId;
            return (T) this;
        }

        public GetUserDetailsRequest build() {
            GetUserDetailsRequest request = new GetUserDetailsRequest();
            request.setUserTokenId(userTokenId);
            return ValidationUtils.validate(super.build(request));
        }
    }
}
