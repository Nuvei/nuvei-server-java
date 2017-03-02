package com.safecharge.retail.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.safecharge.retail.request.SafechargeRequest;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/24/2017
 */
public class ValidationUtil {

    private static final Log logger = LogFactory.getLog(ValidationUtil.class);

    private static final Validator validator = Validation.buildDefaultValidatorFactory()
                                                         .getValidator();

    public static <T extends SafechargeRequest> T validate(T request) throws ValidationException {

        Set<ConstraintViolation<T>> constraintViolations = validator.validate(request);

        if (constraintViolations != null && !constraintViolations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                sb.append(constraintViolation.getMessage())
                  .append(" ");
            }

            String errorMessage = sb.toString();

            if (logger.isDebugEnabled()) {
                logger.debug(errorMessage);
            }

            throw new ConstraintViolationException(constraintViolations);
        }

        return request;
    }
}
