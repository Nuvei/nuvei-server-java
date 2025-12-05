/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.nuvei.request.builder.NuveiBuilder;
import com.nuvei.util.Constants;
import com.nuvei.util.ValidChecksum;
import com.nuvei.util.ValidationUtils;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.GET_CASHIER_USER_INFO)
public class GetUserDetailsRequest extends NuveiRequest {

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

    public static class Builder<T extends NuveiBuilder<T>> extends NuveiBuilder<T> {

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
