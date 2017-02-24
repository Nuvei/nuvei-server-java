package com.safecharge.retail.response;

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
public class OrderDetailsResponse extends BaseResponse implements SafechargeOrderResponse {

    private String orderId;
    private String currency;
    private Double amount;
    private List<Item> items;
    private DeviceDetails deviceDetails;
    private UserDetails userDetails;
    private UserAddress shippingAddress;
    private UserAddress billingAddress;
    private DynamicDescriptor dynamicDescriptor;
    private MerchantDetails merchantDetails;
    private Addendums addendums;

    private String transactionCreationDate;
    private String orderCreationDate;
    private String orderStatus;
    private String transactionStatus;
    private String transactionId;

    @Override public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public DeviceDetails getDeviceDetails() {
        return deviceDetails;
    }

    public void setDeviceDetails(DeviceDetails deviceDetails) {
        this.deviceDetails = deviceDetails;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public UserAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(UserAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public UserAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(UserAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public DynamicDescriptor getDynamicDescriptor() {
        return dynamicDescriptor;
    }

    public void setDynamicDescriptor(DynamicDescriptor dynamicDescriptor) {
        this.dynamicDescriptor = dynamicDescriptor;
    }

    public MerchantDetails getMerchantDetails() {
        return merchantDetails;
    }

    public void setMerchantDetails(MerchantDetails merchantDetails) {
        this.merchantDetails = merchantDetails;
    }

    public Addendums getAddendums() {
        return addendums;
    }

    public void setAddendums(Addendums addendums) {
        this.addendums = addendums;
    }

    public String getTransactionCreationDate() {
        return transactionCreationDate;
    }

    public void setTransactionCreationDate(String transactionCreationDate) {
        this.transactionCreationDate = transactionCreationDate;
    }

    public String getOrderCreationDate() {
        return orderCreationDate;
    }

    public void setOrderCreationDate(String orderCreationDate) {
        this.orderCreationDate = orderCreationDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
