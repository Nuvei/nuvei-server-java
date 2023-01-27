/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.exception;

/**
 * <p>
 * Wrapper class for exceptions due to configuration issues.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/8/2017
 */
public class SafechargeConfigurationException extends RuntimeException {

    public SafechargeConfigurationException() {
        super();
    }

    public SafechargeConfigurationException(String message) {
        super(message);
    }

}