/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.util;

import com.nuvei.model.DeviceDetails;

/**
 *
 * @author <a mailto:antona@nuvei.com>Anton Antonov</a>
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
