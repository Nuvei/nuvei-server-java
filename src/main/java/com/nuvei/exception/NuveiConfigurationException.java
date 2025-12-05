/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.exception;

/**
 * <p>
 * Wrapper class for exceptions due to configuration issues.
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @since 3/8/2017
 */
public class NuveiConfigurationException extends RuntimeException {

    public NuveiConfigurationException() {
        super();
    }

    public NuveiConfigurationException(String message) {
        super(message);
    }

}