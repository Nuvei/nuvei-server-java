package com.safecharge.request;

import com.safecharge.model.DeviceDetails;
import com.safecharge.model.InitPaymentPaymentOption;
import com.safecharge.model.UrlDetails;
import com.safecharge.model.UserAddress;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Copyright (C) 2007-2019 SafeCharge International Group Limited.
 * <p>
 * Request for initiation of payment process for transactions.
 * </p>
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class InitPaymentRequest extends SafechargeRequest {

    @Size(max = 255, message = "userTokenId size must be up to 255 characters long!")
    private String userTokenId;

    /**
     * The three character ISO currency code.
     */
    @NotNull(message = "currency parameter is mandatory!")
    private String currency;

    /**
     * The transaction amount.
     */
    @NotNull(message = "amount parameter is mandatory!")
    private String amount;

    private DeviceDetails deviceDetails;

    private InitPaymentPaymentOption paymentOption;

    private UrlDetails urlDetails;

    @Size(max = 255, message = "customData size must be up to 255 characters long!")
    private String customData;

    private UserAddress billingAddress;

    private String sourceApplication;

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public DeviceDetails getDeviceDetails() {
        return deviceDetails;
    }

    public void setDeviceDetails(DeviceDetails deviceDetails) {
        this.deviceDetails = deviceDetails;
    }

    public InitPaymentPaymentOption getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(InitPaymentPaymentOption paymentOption) {
        this.paymentOption = paymentOption;
    }

    public UrlDetails getUrlDetails() {
        return urlDetails;
    }

    public void setUrlDetails(UrlDetails urlDetails) {
        this.urlDetails = urlDetails;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }

    public UserAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(UserAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getSourceApplication() {
        return sourceApplication;
    }

    public void setSourceApplication(String sourceApplication) {
        this.sourceApplication = sourceApplication;
    }
}
