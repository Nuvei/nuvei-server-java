/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.request;

import javax.validation.ConstraintViolationException;

import com.safecharge.request.basic.EditUPOBasicRequest;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.SUSPEND_UPO)
public class SuspendUPORequest extends EditUPOBasicRequest {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends EditUPOBasicRequest.Builder<SuspendUPORequest.Builder> {

        @Override
        public SafechargeBaseRequest build() throws ConstraintViolationException {
            SuspendUPORequest suspendUPORequest = new SuspendUPORequest();
            return ValidationUtils.validate(super.build(suspendUPORequest));
        }
    }
}
