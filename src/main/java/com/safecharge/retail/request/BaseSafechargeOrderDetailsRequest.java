package com.safecharge.retail.request;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @NotNull(message = "currency parameter is mandatory!") private String currency;

    @NotNull(message = "amount parameter is mandatory!") private String amount;

    @Valid @NotNull @Size(min = 1,
                          message = "Request must have at least one item!") private List<Item> items = new ArrayList<>();

    @Valid private DeviceDetails deviceDetails;

    @Valid private UserDetails userDetails;

    @Valid private UserAddress shippingAddress;

    @Valid private UserAddress billingAddress;

    @Valid private DynamicDescriptor dynamicDescriptor;

    @Valid private MerchantDetails merchantDetails;

    private Addendums addendums;

    @Size(max = 45,
          message = "userTokenId size must be up to 45 characters long!") private String userTokenId;

    @Size(max = 45,
          message = "clientUniqueId size must be up to 45 characters long!") private String clientUniqueId;

    @Override @NotNull(message = "sessionToken parameter is mandatory!") public String getSessionToken() {
        return super.getSessionToken();
    }

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

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("currency='")
          .append(currency)
          .append('\'');
        sb.append(", amount='")
          .append(amount)
          .append('\'');
        sb.append(", items=")
          .append(items);
        sb.append(", deviceDetails=")
          .append(deviceDetails);
        sb.append(", userDetails=")
          .append(userDetails);
        sb.append(", shippingAddress=")
          .append(shippingAddress);
        sb.append(", billingAddress=")
          .append(billingAddress);
        sb.append(", dynamicDescriptor=")
          .append(dynamicDescriptor);
        sb.append(", merchantDetails=")
          .append(merchantDetails);
        sb.append(", addendums=")
          .append(addendums);
        sb.append(", userTokenId='")
          .append(userTokenId)
          .append('\'');
        sb.append(", clientUniqueId='")
          .append(clientUniqueId)
          .append('\'');
        sb.append(", ");
        sb.append(super.toString());
        return sb.toString();
    }
}
