package com.safecharge.retail.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.safecharge.retail.util.APIConstants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/14/2017
 */
public class DeviceDetails {

    @Size(max = 45) private String deviceType;

    @Size(max = 45) private String deviceName;

    @Size(max = 45) private String deviceOS;

    @Size(max = 45) private String browser;

    @Pattern(regexp = APIConstants.IP_ADDRESS_REGEX,
             message = APIConstants.ERROR_MESSAGE_INVALID_REGEX) private String ipAddress;

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

}
