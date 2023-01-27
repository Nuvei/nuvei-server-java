/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import javax.validation.constraints.Size;

public class BrowserDetails {

    @Size(max = 2048, message = "acceptHeader must be up to 2048 characters long!")
    private String acceptHeader;

    @Size(max = 45, message = "ip must be up to 45 characters long!")
    private String ip;

    private String javaEnabled;

    private String javaScriptEnabled;

    @Size(max = 8, message = "language must be up to 8 characters long!")
    private String language;

    @Size(max = 2, message = "colorDepth must be up to 2 characters long!")
    private String colorDepth;

    @Size(max = 6, message = "screenHeight must be up to 6 characters long!")
    private String screenHeight;

    @Size(max = 6, message = "screenWidth must be up to 6 characters long!")
    private String screenWidth;

    @Size(max = 5, message = "timeZone must be up to 5 characters long!")
    private String timeZone;

    @Size(max = 2048, message = "userAgent must be up to 2048 characters long!")
    private String userAgent;

    public String getAcceptHeader() {
        return acceptHeader;
    }

    public void setAcceptHeader(String acceptHeader) {
        this.acceptHeader = acceptHeader;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getJavaEnabled() {
        return javaEnabled;
    }

    public void setJavaEnabled(String javaEnabled) {
        this.javaEnabled = javaEnabled;
    }

    public String getJavaScriptEnabled() {
        return javaScriptEnabled;
    }

    public void setJavaScriptEnabled(String javaScriptEnabled) {
        this.javaScriptEnabled = javaScriptEnabled;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getColorDepth() {
        return colorDepth;
    }

    public void setColorDepth(String colorDepth) {
        this.colorDepth = colorDepth;
    }

    public String getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(String screenHeight) {
        this.screenHeight = screenHeight;
    }

    public String getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(String screenWidth) {
        this.screenWidth = screenWidth;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
