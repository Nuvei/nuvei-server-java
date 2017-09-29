package com.safecharge.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.safecharge.request.builder.SafechargeCCBuilder;
import com.safecharge.util.APIConstants;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Request to start the 3D secure payment process.
 * <p>
 * This is the initial stage of the 3D secure payment process, providing the merchant with the necessary data,
 * and provides the card issuer/bank with the verification page URL.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see Payment3DRequest
 * @since 2/17/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class Authorization3DRequest
        extends SafechargeCCRequest {

    /**
     * This parameter determines whether the 3DSecure rule engine is to be managed by SafeCharge (1)
     * or the 3DSecure rule engine not managed by SafeCharge and method will always try to
     * send a 3DSecure transaction (0).
     */
    @NotNull(message = "isDynamic3D parameter is mandatory!")
    @Pattern(regexp = APIConstants.IS_DYNAMIC_3D_REGEX, message = "isDynamic3D value is invalid")
    private String isDynamic3D;

    public static Builder builder() {
        return new Builder();
    }

    public String getIsDynamic3D() {
        return isDynamic3D;
    }

    public void setIsDynamic3D(String isDynamic3D) {
        this.isDynamic3D = isDynamic3D;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Authorization3DRequest{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeCCBuilder<Builder> {

        private String isDynamic3D;

        /**
         * Adds the Dynamic3D parameter.
         *
         * @param isDynamic3D This parameter determines whether the 3DSecure rule engine is to be managed by SafeCharge (1)
         *                    or the 3DSecure rule engine not managed by SafeCharge and method will always try to
         *                    send a 3DSecure transaction (0).
         * @return this object
         */
        public Builder addIsDynamic3D(String isDynamic3D) {
            this.isDynamic3D = isDynamic3D;
            return this;
        }

        /**
         * Builds the request.
         *
         * @return this object
         */
        @Override
        public SafechargeRequest build() {
            Authorization3DRequest request = new Authorization3DRequest();
            request.setIsDynamic3D(isDynamic3D);
            return ValidationUtils.validate(super.build(request));
        }
    }
}
