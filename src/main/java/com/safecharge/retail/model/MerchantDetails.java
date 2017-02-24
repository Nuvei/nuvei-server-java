package com.safecharge.retail.model;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/14/2017
 */

//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class MerchantDetails {

    //    @Size(max=255)
    private String customField1;

    //    @Size(max=255)
    private String customField2;

    //    @Size(max=255)
    private String customField3;

    //    @Size(max=255)
    private String customField4;

    //    @Size(max=255)
    private String customField5;

    //    @Size(max=255)
    private String customField6;

    //    @Size(max=255)
    private String customField7;

    //    @Size(max=255)
    private String customField8;

    //    @Size(max=255)
    private String customField9;

    //    @Size(max=255)
    private String customField10;

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
        }
    }
}
