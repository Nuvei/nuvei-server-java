package com.safecharge.request;

import com.safecharge.request.builder.SafechargeBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
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
public class GetUserUPOsRequest extends GetUserDetailsRequest {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder<T extends SafechargeBuilder<T>> extends GetUserDetailsRequest.Builder<T> {

        private String userTokenId;

        public T addUserTokenId(String userTokenId) {
            this.userTokenId = userTokenId;
            return (T) this;
        }

        public GetUserDetailsRequest build() {
            GetUserUPOsRequest request = new GetUserUPOsRequest();
            request.setUserTokenId(userTokenId);
            return ValidationUtils.validate(super.build(request));
        }
    }
}
