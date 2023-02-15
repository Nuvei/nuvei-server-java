/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

/**
 * <p>
 * Local payment info specific for some clients. Part of {@link Addendums}.
 *
 * @author <a mailto:bozhidarsh@safecharge.com>Bozhidar Shumanov</a>
 * @see Addendums
 * @since 8/8/2018
 */
public class AddendumsCardPresentPointOfSale {

    private String terminalId;
    private String trackData;
    private String trackType;
    private String icc;
    private String pinData;
    private String entryMode;
    private String terminalCapability;
    private String terminalAttendance;
    private String cardSequenceNum;
    private String offlineResCode;
    private String localTime;
    private String localDate;
    private String cvMethod;
    private String cvEntity;
    private String outputCapability;
    private String autoReversal;
    private String autoReversalAmount;
    private String autoReversalCurrency;
    private String channel;
    private String suppressAuth;
    private String terminalCity;
    private String terminalAddress;
    private String terminalCountry;
    private String terminalZip;
    private String terminalState;
    private String terminalModel;
    private String terminalManufacturer;
    private String terminalMacAddress;
    private String terminalKernel;
    private String terminalImei;
    private String mobileTerminal;
    private String terminalType;
    private String securityControl;

    public String getTerminalId() {
        return terminalId;
    }

    public String getTrackData() {
        return trackData;
    }

    public String getTrackType() {
        return trackType;
    }

    public String getIcc() {
        return icc;
    }

    public String getPinData() {
        return pinData;
    }

    public String getEntryMode() {
        return entryMode;
    }

    public String getTerminalCapability() {
        return terminalCapability;
    }

    public String getTerminalAttendance() {
        return terminalAttendance;
    }

    public String getCardSequenceNum() {
        return cardSequenceNum;
    }

    public String getOfflineResCode() {
        return offlineResCode;
    }

    public String getLocalTime() {
        return localTime;
    }

    public String getLocalDate() {
        return localDate;
    }

    public String getCvMethod() {
        return cvMethod;
    }

    public String getCvEntity() {
        return cvEntity;
    }

    public String getOutputCapability() {
        return outputCapability;
    }

    public String getAutoReversal() {
        return autoReversal;
    }

    public String getAutoReversalAmount() {
        return autoReversalAmount;
    }

    public String getAutoReversalCurrency() {
        return autoReversalCurrency;
    }

    public String getChannel() {
        return channel;
    }

    public String getSuppressAuth() {
        return suppressAuth;
    }

    public String getTerminalCity() {
        return terminalCity;
    }

    public String getTerminalAddress() {
        return terminalAddress;
    }

    public String getTerminalCountry() {
        return terminalCountry;
    }

    public String getTerminalZip() {
        return terminalZip;
    }

    public String getTerminalState() {
        return terminalState;
    }

    public String getTerminalModel() {
        return terminalModel;
    }

    public String getTerminalManufacturer() {
        return terminalManufacturer;
    }

    public String getTerminalMacAddress() {
        return terminalMacAddress;
    }

    public String getTerminalKernel() {
        return terminalKernel;
    }

    public String getTerminalImei() {
        return terminalImei;
    }

    public String getMobileTerminal() {
        return mobileTerminal;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public void setTrackData(String trackData) {
        this.trackData = trackData;
    }

    public void setTrackType(String trackType) {
        this.trackType = trackType;
    }

    public void setIcc(String icc) {
        this.icc = icc;
    }

    public void setPinData(String pinData) {
        this.pinData = pinData;
    }

    public void setEntryMode(String entryMode) {
        this.entryMode = entryMode;
    }

    public void setTerminalCapability(String terminalCapability) {
        this.terminalCapability = terminalCapability;
    }

    public void setTerminalAttendance(String terminalAttendance) {
        this.terminalAttendance = terminalAttendance;
    }

    public void setCardSequenceNum(String cardSequenceNum) {
        this.cardSequenceNum = cardSequenceNum;
    }

    public void setOfflineResCode(String offlineResCode) {
        this.offlineResCode = offlineResCode;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public void setCvMethod(String cvMethod) {
        this.cvMethod = cvMethod;
    }

    public void setCvEntity(String cvEntity) {
        this.cvEntity = cvEntity;
    }

    public void setOutputCapability(String outputCapability) {
        this.outputCapability = outputCapability;
    }

    public void setAutoReversal(String autoReversal) {
        this.autoReversal = autoReversal;
    }

    public void setAutoReversalAmount(String autoReversalAmount) {
        this.autoReversalAmount = autoReversalAmount;
    }

    public void setAutoReversalCurrency(String autoReversalCurrency) {
        this.autoReversalCurrency = autoReversalCurrency;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public void setSuppressAuth(String suppressAuth) {
        this.suppressAuth = suppressAuth;
    }

    public void setTerminalCity(String terminalCity) {
        this.terminalCity = terminalCity;
    }

    public void setTerminalAddress(String terminalAddress) {
        this.terminalAddress = terminalAddress;
    }

    public void setTerminalCountry(String terminalCountry) {
        this.terminalCountry = terminalCountry;
    }

    public void setTerminalZip(String terminalZip) {
        this.terminalZip = terminalZip;
    }

    public void setTerminalState(String terminalState) {
        this.terminalState = terminalState;
    }

    public void setTerminalModel(String terminalModel) {
        this.terminalModel = terminalModel;
    }

    public void setTerminalManufacturer(String terminalManufacturer) {
        this.terminalManufacturer = terminalManufacturer;
    }

    public void setTerminalMacAddress(String terminalMacAddress) {
        this.terminalMacAddress = terminalMacAddress;
    }

    public void setTerminalKernel(String terminalKernel) {
        this.terminalKernel = terminalKernel;
    }

    public void setTerminalImei(String terminalImei) {
        this.terminalImei = terminalImei;
    }

    public void setMobileTerminal(String mobileTerminal) {
        this.mobileTerminal = mobileTerminal;
    }

    public String getTerminalType() {
        return terminalType;
    }

    public String getSecurityControl() {
        return securityControl;
    }

    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType;
    }

    public void setSecurityControl(String securityControl) {
        this.securityControl = securityControl;
    }
}
