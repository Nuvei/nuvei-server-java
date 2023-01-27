/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import javax.validation.constraints.Size;

/**
 * <p>
 * Holder for Checkout Page's Merchant's specific uncategorized data.
 * </p>
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/14/2017
 */

public class MerchantDetails {

    @Size(max = 255, message = "customField1 size must be up to 255 characters long!")
    private String customField1;

    @Size(max = 255, message = "customField2 size must be up to 255 characters long!")
    private String customField2;

    @Size(max = 255, message = "customField3 size must be up to 255 characters long!")
    private String customField3;

    @Size(max = 255, message = "customField4 size must be up to 255 characters long!")
    private String customField4;

    @Size(max = 255, message = "customField5 size must be up to 255 characters long!")
    private String customField5;

    @Size(max = 255, message = "customField6 size must be up to 255 characters long!")
    private String customField6;

    @Size(max = 255, message = "customField7 size must be up to 255 characters long!")
    private String customField7;

    @Size(max = 255, message = "customField8 size must be up to 255 characters long!")
    private String customField8;

    @Size(max = 255, message = "customField9 size must be up to 255 characters long!")
    private String customField9;

    @Size(max = 255, message = "customField10 size must be up to 255 characters long!")
    private String customField10;

    @Size(max = 255, message = "customField11 size must be up to 255 characters long!")
    private String customField11;

    @Size(max = 255, message = "customField12 size must be up to 255 characters long!")
    private String customField12;

    @Size(max = 255, message = "customField13 size must be up to 255 characters long!")
    private String customField13;

    @Size(max = 255, message = "customField14 size must be up to 255 characters long!")
    private String customField14;

    @Size(max = 255, message = "customField15 size must be up to 255 characters long!")
    private String customField15;

    public String getCustomField1() {
        return customField1;
    }

    public void setCustomField1(String customField1) {
        this.customField1 = customField1;
    }

    public String getCustomField2() {
        return customField2;
    }

    public void setCustomField2(String customField2) {
        this.customField2 = customField2;
    }

    public String getCustomField3() {
        return customField3;
    }

    public void setCustomField3(String customField3) {
        this.customField3 = customField3;
    }

    public String getCustomField4() {
        return customField4;
    }

    public void setCustomField4(String customField4) {
        this.customField4 = customField4;
    }

    public String getCustomField5() {
        return customField5;
    }

    public void setCustomField5(String customField5) {
        this.customField5 = customField5;
    }

    public String getCustomField6() {
        return customField6;
    }

    public void setCustomField6(String customField6) {
        this.customField6 = customField6;
    }

    public String getCustomField7() {
        return customField7;
    }

    public void setCustomField7(String customField7) {
        this.customField7 = customField7;
    }

    public String getCustomField8() {
        return customField8;
    }

    public void setCustomField8(String customField8) {
        this.customField8 = customField8;
    }

    public String getCustomField9() {
        return customField9;
    }

    public void setCustomField9(String customField9) {
        this.customField9 = customField9;
    }

    public String getCustomField10() {
        return customField10;
    }

    public void setCustomField10(String customField10) {
        this.customField10 = customField10;
    }

    public String getCustomField11() {
        return customField11;
    }

    public void setCustomField11(String customField11) {
        this.customField11 = customField11;
    }

    public String getCustomField12() {
        return customField12;
    }

    public void setCustomField12(String customField12) {
        this.customField12 = customField12;
    }

    public String getCustomField13() {
        return customField13;
    }

    public void setCustomField13(String customField13) {
        this.customField13 = customField13;
    }

    public String getCustomField14() {
        return customField14;
    }

    public void setCustomField14(String customField14) {
        this.customField14 = customField14;
    }

    public String getCustomField15() {
        return customField15;
    }

    public void setCustomField15(String customField15) {
        this.customField15 = customField15;
    }

    public String getCustomFieldByNumber(int customFieldNumber) {
        switch (customFieldNumber) {
            case 1:
                return customField1;
            case 2:
                return customField2;
            case 3:
                return customField3;
            case 4:
                return customField4;
            case 5:
                return customField5;
            case 6:
                return customField6;
            case 7:
                return customField7;
            case 8:
                return customField8;
            case 9:
                return customField9;
            case 10:
                return customField10;
            case 11:
                return customField11;
            case 12:
                return customField12;
            case 13:
                return customField13;
            case 14:
                return customField14;
            case 15:
                return customField15;
        }
        return null;
    }

    public void setCustomFieldByNumber(String fieldValue, int customFieldNumber) {
        switch (customFieldNumber) {
            case 1:
                this.customField1 = fieldValue;
                break;
            case 2:
                this.customField2 = fieldValue;
                break;
            case 3:
                this.customField3 = fieldValue;
                break;
            case 4:
                this.customField4 = fieldValue;
                break;
            case 5:
                this.customField5 = fieldValue;
                break;
            case 6:
                this.customField6 = fieldValue;
                break;
            case 7:
                this.customField7 = fieldValue;
                break;
            case 8:
                this.customField8 = fieldValue;
                break;
            case 9:
                this.customField9 = fieldValue;
                break;
            case 10:
                this.customField10 = fieldValue;
                break;
            case 11:
                this.customField11 = fieldValue;
                break;
            case 12:
                this.customField12 = fieldValue;
                break;
            case 13:
                this.customField13 = fieldValue;
                break;
            case 14:
                this.customField14 = fieldValue;
                break;
            case 15:
                this.customField15 = fieldValue;
                break;
        }
    }
}
