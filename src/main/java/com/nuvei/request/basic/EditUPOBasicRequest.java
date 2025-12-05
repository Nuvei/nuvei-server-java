/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.request.basic;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;

import com.nuvei.request.*;
import com.nuvei.request.NuveiBaseRequest;
import com.nuvei.request.builder.NuveiBuilder;
import com.nuvei.util.Constants;
import com.nuvei.util.ValidationUtils;

/**
 * <p>
 * Request to add Credit/Debit card User Payment Option(UPO) to a User.
 * <p>
 * This goal of this request is to add a credit card UPO for a specific user according to their User Token ID.
 * Once a credit card UPO is added to the user’s list of UPOs, the credit card is displayed in the payment page.
 *
 * @author <a mailto:bozhidarsh@nuvei.com>Bozhidar Shumanov</a>
 * @since 3/21/2017
 */

public class EditUPOBasicRequest extends NuveiRequest {

    @NotNull(message = "userPaymentOptionId parameter is mandatory!")
    private String userPaymentOptionId;

    @NotNull(message = "userTokenId parameter is mandatory!")
    private String userTokenId;

    public static EditUPOBasicRequest.Builder builder() {
        return new EditUPOBasicRequest.Builder();
    }

    public static <T extends EditUPOBasicRequest.Builder> T builder(Constants.EditUpoBuilderType builderType) {
        switch (builderType) {
            case APM:
                return (T)new EditUPOAPMRequest.Builder();
            case CCARD:
                return (T)new EditUPOCreditCardRequest.Builder();
            case DELETE:
                return (T)new DeleteUPORequest.Builder();
            case SUSPEND:
                return (T)new SuspendUPORequest.Builder();
            case ENABLE:
                return (T)new EnableUPORequest.Builder();
            default:
                return (T)new EditUPOBasicRequest.Builder();
        }
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    public String getUserPaymentOptionId() {
        return userPaymentOptionId;
    }

    public void setUserPaymentOptionId(String userPaymentOptionId) {
        this.userPaymentOptionId = userPaymentOptionId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EditUPOCreditCard{");
        sb.append(", userTokenId='")
                .append(userTokenId)
                .append('\'');
        sb.append(", userPaymentOptionId='")
                .append(userPaymentOptionId)
                .append('\'');
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder<T extends NuveiBuilder<T>> extends NuveiBuilder<T> {

        private String userTokenId;
        private String userPaymentOptionId;

        /**
         * Adds user token id to the request.
         *
         * @param userTokenId the user token as {@link String}
         * @return this object
         */
        public T addUserTokenId(String userTokenId) {
            this.userTokenId = userTokenId;
            return (T)this;
        }

        /**
         * Adds userPaymentOptionId to the request.
         *
         * @param userPaymentOptionId the user token as {@link String}
         * @return this object
         */
        public T addUserPaymentOptionId(String userPaymentOptionId) {
            this.userPaymentOptionId = userPaymentOptionId;
            return (T)this;
        }

        /**
         * Builds the request.
         *
         * @return {@link NuveiRequest} object build from the params set by this builder
         * @throws ConstraintViolationException if the validation of the params fails
         */
        protected EditUPOBasicRequest build(EditUPOBasicRequest editUPOBasicRequest) throws ConstraintViolationException {
            editUPOBasicRequest.setUserTokenId(userTokenId);
            editUPOBasicRequest.setUserPaymentOptionId(userPaymentOptionId);
            return ValidationUtils.validate(super.build(editUPOBasicRequest));
        }

        @Override
        public NuveiBaseRequest build() throws ConstraintViolationException {
            EditUPOBasicRequest editUPOBasicRequest = new EditUPOBasicRequest();
            editUPOBasicRequest.setUserTokenId(userTokenId);
            editUPOBasicRequest.setUserPaymentOptionId(userPaymentOptionId);
            return ValidationUtils.validate(super.build(editUPOBasicRequest));
        }
    }
}
