package com.safecharge.exception;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
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