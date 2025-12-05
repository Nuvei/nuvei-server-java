/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.request;

import javax.validation.ConstraintViolationException;

import com.nuvei.request.basic.EditUPOBasicRequest;
import com.nuvei.util.Constants;
import com.nuvei.util.ValidChecksum;
import com.nuvei.util.ValidationUtils;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.DELETE_UPO)
public class DeleteUPORequest extends EditUPOBasicRequest {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends EditUPOBasicRequest.Builder<DeleteUPORequest.Builder> {

        @Override
        public NuveiBaseRequest build() throws ConstraintViolationException {
            DeleteUPORequest deleteUPORequest = new DeleteUPORequest();
            return ValidationUtils.validate(super.build(deleteUPORequest));
        }
    }
}
