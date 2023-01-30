/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.request;

import com.safecharge.request.builder.SafechargeCCBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * <p>
 * Request to perform a payment using a credit/debit card.
 * <p>
 * The request must contain only one of the three:
 * <ol>
 * <li>CardData(such as card number, cardholder name, CVV, expiration date)
 * <li>User Payment Option ID of previouslt used credit/debit card, which info is stored by the SafeCharge's system.
 * <li>Temporary card token.
 * </ol>
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see Payment3DRequest
 * @see PaymentAPMRequest
 * @since 2/15/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class PaymentCCRequest extends SafechargeCCRequest {

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentCCRequest{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeCCBuilder<Builder> {

        /**
         * Builds the request.
         *
         * @return {@link SafechargeRequest} object build from the params set by this builder
         */
        @Override
        public SafechargeBaseRequest build() {
            PaymentCCRequest request = new PaymentCCRequest();
            return ValidationUtils.validate(super.build(request));
        }
    }
}
