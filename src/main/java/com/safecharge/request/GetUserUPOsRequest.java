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

/**
 * <p>
 * Request to get specific order details.
 * <p>
 * Enables receiving specific order details of an existing order.
 * Note that order details can be viewed at any point in time.
 *
 * @author <a mailto:bozhidarsh@safecharge.com>Bozhidar Shumanov</a>
 * @since 1/29/2018
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.GET_CASHIER_USER_INFO)
public class GetUserUPOsRequest extends SafechargeRequest {

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

        public T addUserTokenId(String userTokenId) {
            this.userTokenId = userTokenId;
            return (T) this;
        }

        public GetUserUPOsRequest build() {
            GetUserUPOsRequest request = new GetUserUPOsRequest();
            request.setUserTokenId(userTokenId);
            return ValidationUtils.validate(super.build(request));
        }
    }
}
