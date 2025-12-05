/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.request;

import javax.validation.ConstraintViolationException;

import com.nuvei.request.basic.EditUPOBasicRequest;
import com.nuvei.util.Constants;
import com.nuvei.util.ValidChecksum;
import com.nuvei.util.ValidationUtils;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.SUSPEND_UPO)
public class SuspendUPORequest extends EditUPOBasicRequest {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends EditUPOBasicRequest.Builder<SuspendUPORequest.Builder> {

        @Override
        public NuveiBaseRequest build() throws ConstraintViolationException {
            SuspendUPORequest suspendUPORequest = new SuspendUPORequest();
            return ValidationUtils.validate(super.build(suspendUPORequest));
        }
    }
}
