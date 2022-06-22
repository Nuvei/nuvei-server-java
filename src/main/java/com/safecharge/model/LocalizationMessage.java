package com.safecharge.model;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Holder used to store localized messages.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 4/7/2017
 */
public class LocalizationMessage {

    private String language;

    private String message;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LocalizationMessage{");
        sb.append("language='")
                .append(language)
                .append('\'');
        sb.append(", message='")
                .append(message)
                .append('\'');
        sb.append('}');
        return sb.toString();
    }
}
