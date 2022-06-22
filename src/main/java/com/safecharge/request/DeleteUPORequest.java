package com.safecharge.request;

import javax.validation.ConstraintViolationException;

import com.safecharge.request.basic.EditUPOBasicRequest;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.DELETE_UPO)
public class DeleteUPORequest extends EditUPOBasicRequest {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends EditUPOBasicRequest.Builder<DeleteUPORequest.Builder> {

        @Override
        public SafechargeBaseRequest build() throws ConstraintViolationException {
            DeleteUPORequest deleteUPORequest = new DeleteUPORequest();
            return ValidationUtils.validate(super.build(deleteUPORequest));
        }
    }
}
