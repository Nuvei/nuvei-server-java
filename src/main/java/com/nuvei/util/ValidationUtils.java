/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.nuvei.request.NuveiBaseRequest;

/**
 * <p>
 * Utility class for validating the request 2007 - 2024 Nuvei Corporation
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @since 2/24/2017
 */
public class ValidationUtils {

    private static final Log logger = LogFactory.getLog(ValidationUtils.class);

    private static final Validator validator = Validation.buildDefaultValidatorFactory()
            .getValidator();

    private ValidationUtils() {
    }

    /**
     * Validates the {@code request} based on its type and returns it or throws a {@code ValidationException}
     * if any {@link ConstraintViolation} is found.
     *
     * @param request the request object to validate
     * @param <T>     request type param
     * @return The validated request(the same object passed as {@code request})
     * @throws ValidationException if any {@link ConstraintViolation} is found
     */
    public static <T extends NuveiBaseRequest> T validate(T request) throws ValidationException {

        Set<ConstraintViolation<T>> constraintViolations = validator.validate(request);

        if (constraintViolations != null && !constraintViolations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                sb.append(constraintViolation.getPropertyPath()).append(" ").append(constraintViolation.getMessage())
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
