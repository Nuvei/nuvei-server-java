/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.util;

import com.safecharge.model.DynamicDescriptor;

public class DynamicDescriptorUtils {

    private DynamicDescriptorUtils() {
    }

    public static DynamicDescriptor createDynamicDescriptor(String merchantName, String merchantPhone) {

        DynamicDescriptor dynamicDescriptor = new DynamicDescriptor();
        dynamicDescriptor.setMerchantName(merchantName);
        dynamicDescriptor.setMerchantPhone(merchantPhone);

        return dynamicDescriptor;
    }
}
