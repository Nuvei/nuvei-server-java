/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.nuvei.util.APIConstants;

/**
 * <p>
 * Holder for a device data.
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @since 2/14/2017
 */
public class DeviceDetails {

    @Size(max = 10, message = "deviceType size must be up to 45 characters long!")
    private String deviceType;

    @Size(max = 255, message = "deviceName size must be up to 45 characters long!")
    private String deviceName;

    @Size(max = 255, message = "deviceOS size must be up to 45 characters long!")
    private String deviceOS;

    @Size(max = 255, message = "browser size must be up to 45 characters long!")
    private String browser;

    private String ipAddress;

    private String deviceManufacturerIdentifier;

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceOS() {
        return deviceOS;
    }

    public void setDeviceOS(String deviceOS) {
        this.deviceOS = deviceOS;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDeviceManufacturerIdentifier() {
        return deviceManufacturerIdentifier;
    }

    public void setDeviceManufacturerIdentifier(String deviceManufacturerIdentifier) {
        this.deviceManufacturerIdentifier = deviceManufacturerIdentifier;
    }
}
