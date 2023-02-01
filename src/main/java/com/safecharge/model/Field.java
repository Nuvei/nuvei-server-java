/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import java.util.List;

/**
 * <p>
 * Holder for Checkout Page's Merchant's specific info. For example: order id, account name, etc. in the Merchant's ERP system.
 * The data in the field can be validated by regular expression.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 4/7/2017
 */
public class Field {

    private String name;

    private String regex;

    private String type;

    private List<LocalizationMessage> validationMessage;

    private List<LocalizationMessage> caption;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<LocalizationMessage> getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(List<LocalizationMessage> validationMessage) {
        this.validationMessage = validationMessage;
    }

    public List<LocalizationMessage> getCaption() {
        return caption;
    }

    public void setCaption(List<LocalizationMessage> caption) {
        this.caption = caption;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Field{");
        sb.append("name='")
                .append(name)
                .append('\'');
        sb.append(", regex='")
                .append(regex)
                .append('\'');
        sb.append(", type='")
                .append(type)
                .append('\'');
        sb.append(", validationMessage=")
                .append(validationMessage);
        sb.append(", caption=")
                .append(caption);
        sb.append('}');
        return sb.toString();
    }
}
