package com.safecharge.request;

import javax.validation.ConstraintViolationException;

import com.safecharge.request.basic.EditUPOBasicRequest;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.ENABLE_UPO)
public class EnableUPORequest extends EditUPOBasicRequest {

    public static EnableUPORequest.Builder builder() {
        return new EnableUPORequest.Builder();
    }

    public static class Builder extends EditUPOBasicRequest.Builder<EnableUPORequest.Builder> {

        @Override
        public SafechargeBaseRequest build() throws ConstraintViolationException {
            EnableUPORequest enableUPORequest = new EnableUPORequest();
            return ValidationUtils.validate(super.build(enableUPORequest));
        }
    }
}
