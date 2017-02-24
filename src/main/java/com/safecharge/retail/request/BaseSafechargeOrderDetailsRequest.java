package com.safecharge.retail.request;

import java.util.ArrayList;
import java.util.List;

import com.safecharge.retail.model.Addendums;
import com.safecharge.retail.model.DeviceDetails;
import com.safecharge.retail.model.DynamicDescriptor;
import com.safecharge.retail.model.Item;
import com.safecharge.retail.model.MerchantDetails;
import com.safecharge.retail.model.UserAddress;
import com.safecharge.retail.model.UserDetails;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/15/2017
 */
public abstract class BaseSafechargeOrderDetailsRequest extends BaseSafechargeRequest implements SafechargeOrderDetailsRequest {

    private String currency;

    private String amount;

    private List<Item> items = new ArrayList<>();

    private DeviceDetails deviceDetails;

    private UserDetails userDetails;

    private UserAddress shippingAddress;

    private UserAddress billingAddress;

    private DynamicDescriptor dynamicDescriptor;

    private MerchantDetails merchantDetails;

    private Addendums addendums;

    private String userTokenId;

    private String clientUniqueId;

    public String getCurrency() {
        return currency;
    }

    @Override public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    @Override public void setAmount(String amount) {
        this.amount = amount;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override public void addItem(Item item) {
        this.items.add(item);
    }

    public DeviceDetails getDeviceDetails() {
        return deviceDetails;
    }

    @Override public void setDeviceDetails(DeviceDetails deviceDetails) {
        this.deviceDetails = deviceDetails;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    @Override public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public UserAddress getShippingAddress() {
        return shippingAddress;
    }

    @Override public void setShippingAddress(UserAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public UserAddress getBillingAddress() {
        return billingAddress;
    }

    @Override public void setBillingAddress(UserAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public DynamicDescriptor getDynamicDescriptor() {
        return dynamicDescriptor;
    }

    @Override public void setDynamicDescriptor(DynamicDescriptor dynamicDescriptor) {
        this.dynamicDescriptor = dynamicDescriptor;
    }

    public MerchantDetails getMerchantDetails() {
        return merchantDetails;
    }

    @Override public void setMerchantDetails(MerchantDetails merchantDetails) {
        this.merchantDetails = merchantDetails;
    }

    public Addendums getAddendums() {
        return addendums;
    }

    @Override public void setAddendums(Addendums addendums) {
        this.addendums = addendums;
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    @Override public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    public String getClientUniqueId() {
        return clientUniqueId;
    }

    @Override public void setClientUniqueId(String clientUniqueId) {
        this.clientUniqueId = clientUniqueId;
    }
}
