/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.request;

import javax.validation.constraints.*;

import com.nuvei.request.builder.NuveiCCBuilder;
import com.nuvei.util.APIConstants;
import com.nuvei.util.Constants;
import com.nuvei.util.ValidChecksum;
import com.nuvei.util.ValidationUtils;

/**
 * <p>
 * Request to start the 3D secure payment process.
 * <p>
 * This is the initial stage of the 3D secure payment process, providing the merchant with the necessary data,
 * and provides the card issuer/bank with the verification page URL.
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @see Payment3DRequest
 * @since 2/17/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class Authorization3DRequest
        extends NuveiCCRequest {

    /**
     * This parameter determines whether the 3DSecure rule engine is to be managed by Nuvei (1)
     * or the 3DSecure rule engine not managed by Nuvei and method will always try to
     * send a 3DSecure transaction (0).
     */
    @Pattern(regexp = APIConstants.IS_DYNAMIC_3D_REGEX, message = "isDynamic3D value is invalid")
    private String isDynamic3D;

    @Size(max=5)
    private String dynamic3DMode;

    public static Builder builder() {
        return new Builder();
    }

    public String getIsDynamic3D() {
        return isDynamic3D;
    }

    public void setIsDynamic3D(String isDynamic3D) {
        this.isDynamic3D = isDynamic3D;
    }

    public String getDynamic3DMode() {
        return dynamic3DMode;
    }

    public void setDynamic3DMode(String dynamic3DMode) {
        this.dynamic3DMode = dynamic3DMode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Authorization3DRequest{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends NuveiCCBuilder<Builder> {

        private String isDynamic3D;
        private String dynamic3DMode;

        /**
         * Adds the Dynamic3D parameter.
         *
         * @param isDynamic3D This parameter determines whether the 3DSecure rule engine is to be managed by Nuvei (1)
         *                    or the 3DSecure rule engine not managed by Nuvei and method will always try to
         *                    send a 3DSecure transaction (0).
         * @return this object
         */
        public Builder addIsDynamic3D(String isDynamic3D, String dynamic3DMode) {
            this.isDynamic3D = isDynamic3D;
            this.dynamic3DMode = dynamic3DMode;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public NuveiRequest build() {
            Authorization3DRequest request = new Authorization3DRequest();
            request.setIsDynamic3D(isDynamic3D);
            request.setDynamic3DMode(dynamic3DMode);
            return ValidationUtils.validate(super.build(request));
        }
    }
}
