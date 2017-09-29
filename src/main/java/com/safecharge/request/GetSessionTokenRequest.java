package com.safecharge.request;

import com.safecharge.request.builder.SafechargeBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Request to obtain a session token.
 * <p>
 * This request returns a unique session token. Almost all Safecharge's requests require a valid session token.
 * The unique token is created upon the initial successful authorization and represents the client session.
 * It also contains an expiration date, as well as information about user granted privileges.
 * For subsequent calls to the session, the token must be provided for validation to ensure that it is still active and valid.
 * <p>
 * Note that most of the payment requests consume the token, so it can be used for one payment only.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class GetSessionTokenRequest extends SafechargeRequest {

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetSessionTokenRequest{");
        sb.append(super.toString())
                .append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeBuilder<Builder> {

        /**
         * Builds the request.
         *
         * @return {@link SafechargeRequest} object build from the params set by this builder
         */
        @Override
        public SafechargeRequest build() {
            return ValidationUtils.validate(super.build(new GetSessionTokenRequest()));
        }
    }
}
