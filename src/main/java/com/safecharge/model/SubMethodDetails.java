package com.safecharge.model;

import javax.validation.constraints.Size;

/**
 * Copyright (C) 2007-2018 SafeCharge International Group Limited.
 * <p>
 *
 * @author <a mailto:bozhidarsh@safecharge.com>Bozhidar Shumanov</a>
 * @since 8/7/2018
 */
public class SubMethodDetails {

    @Size(max = 50, message = "successUrl size must be up to 50 characters long!")
    private String subMethod;

    @Size(max = 2048, message = "successUrl size must be up to 2048 characters long!")
    private String subMethodField1;

    @Size(max = 2048, message = "successUrl size must be up to 2048 characters long!")
    private String subMethodField2;

    public String getSubMethod() {
        return subMethod;
    }

    public void setSubMethod(String subMethod) {
        this.subMethod = subMethod;
    }

    public String getSubMethodField1() {
        return subMethodField1;
    }

    public void setSubMethodField1(String subMethodField1) {
        this.subMethodField1 = subMethodField1;
    }

    public String getSubMethodField2() {
        return subMethodField2;
    }

    public void setSubMethodField2(String subMethodField2) {
        this.subMethodField2 = subMethodField2;
    }

    public SubMethodDetails() {
    }

    public SubMethodDetails(String subMethod, String subMethodField1, String subMethodField2) {
        this.subMethod = subMethod;
        this.subMethodField1 = subMethodField1;
        this.subMethodField2 = subMethodField2;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SubMethodDetails{");
        sb.append("subMethod='").append(subMethod).append('\'');
        sb.append(", subMethodField1='").append(subMethodField1).append('\'');
        sb.append(", subMethodField2='").append(subMethodField2).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
