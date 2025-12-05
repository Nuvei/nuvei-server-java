/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.request;

import javax.validation.ConstraintViolationException;

import com.nuvei.request.basic.EditUPOBasicRequest;
import com.nuvei.util.Constants;
import com.nuvei.util.ValidChecksum;
import com.nuvei.util.ValidationUtils;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.ENABLE_UPO)
public class EnableUPORequest extends EditUPOBasicRequest {

    public static EnableUPORequest.Builder builder() {
        return new EnableUPORequest.Builder();
    }

    public static class Builder extends EditUPOBasicRequest.Builder<EnableUPORequest.Builder> {

        @Override
        public NuveiBaseRequest build() throws ConstraintViolationException {
            EnableUPORequest enableUPORequest = new EnableUPORequest();
            return ValidationUtils.validate(super.build(enableUPORequest));
        }
    }
}
