package com.safecharge.util;

import com.safecharge.model.MerchantDetails;

/**
 * Copyright (C) 2007-2020 SafeCharge International Group Limited.
 *
 * @author <a mailto:antona@safecharge.com>Anton Antonov</a>
 * @since 25.09.2017 г.
 */
public class MerchantUtils {

    private MerchantUtils() {
    }

    public static MerchantDetails createMerchantDetailsFromParams(String customField1, String customField2, String customField3,
                                                                  String customField4, String customField5, String customField6,
                                                                  String customField7, String customField8, String customField9,
                                                                  String customField10) {

        MerchantDetails merchantDetails = new MerchantDetails();
        merchantDetails.setCustomField1(customField1);
        merchantDetails.setCustomField2(customField2);
        merchantDetails.setCustomField3(customField3);
        merchantDetails.setCustomField4(customField4);
        merchantDetails.setCustomField5(customField5);
        merchantDetails.setCustomField6(customField6);
        merchantDetails.setCustomField7(customField7);
        merchantDetails.setCustomField8(customField8);
        merchantDetails.setCustomField9(customField9);
        merchantDetails.setCustomField10(customField10);

        return merchantDetails;
    }
}
