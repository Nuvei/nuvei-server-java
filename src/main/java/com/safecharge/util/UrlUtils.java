package com.safecharge.util;

import com.safecharge.model.URLDetails;

/**
 * Copyright (C) 2007-2020 SafeCharge International Group Limited.
 *
 * @author <a mailto:antona@safecharge.com>Anton Antonov</a>
 * @since 19.09.2017 г.
 */
public class UrlUtils {

    private UrlUtils() {
    }

    public static URLDetails createUrlDetails(String failureUrl, String pendingUrl, String successUrl, String notificationUrl) {

        URLDetails urlDetails = new URLDetails();
        urlDetails.setFailureUrl(failureUrl);
        urlDetails.setPendingUrl(pendingUrl);
        urlDetails.setSuccessUrl(successUrl);
        urlDetails.setNotificationUrl(notificationUrl);

        return urlDetails;
    }
}
