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

/**
 * <p>
 * Request to get specific order details.
 * <p>
 * Enables receiving specific order details of an existing order.
 * Note that order details can be viewed at any point in time.
 *
 * @author <a mailto:bozhidarsh@nuvei.com>Bozhidar Shumanov</a>
 * @since 1/29/2018
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.GET_CASHIER_USER_INFO)
public class GetUserUPOsRequest extends NuveiRequest {

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
