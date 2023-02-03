/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.util;

import com.safecharge.model.DeviceDetails;

/**
 *
 * @author <a mailto:antona@safecharge.com>Anton Antonov</a>
 * @since 25.09.2017 г.
 */
public class DeviceUtils {

    private DeviceUtils() {
    }

    public static DeviceDetails createDeviceDetailsFromParams(String deviceType, String deviceName, String deviceOS, String browser, String ipAddress) {

        DeviceDetails deviceDetails = new DeviceDetails();
        deviceDetails.setDeviceType(deviceType);
        deviceDetails.setDeviceName(deviceName);
        deviceDetails.setDeviceOS(deviceOS);
        deviceDetails.setBrowser(browser);
        deviceDetails.setIpAddress(ipAddress);

        return deviceDetails;
    }
}
