package com.safecharge.request;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.safecharge.model.Addendums;
import com.safecharge.model.AmountDetails;
import com.safecharge.model.RestApiUserDetails;
import com.safecharge.model.DeviceDetails;
import com.safecharge.model.DynamicDescriptor;
import com.safecharge.model.Item;
import com.safecharge.model.MerchantDetails;
import com.safecharge.model.UrlDetails;
import com.safecharge.model.UserAddress;

/**
 * Copyright (C) 2007-2020 SafeCharge International Group Limited.
 * <p>
 * Abstract class to be used as a base for order related and payment requests.
 * </p>
 * @author Nikola Dichev
 * @since 2/15/2017
 */
public abstract class SafechargeOrderDetailsRequest extends SafechargeRequest {

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

    /**
     * List of items that will be purchased.
     */
    @Valid
    private List<Item> items = new ArrayList<>();

    /**
     * The details for the device from which the transaction will be made.
     */
    @Valid
    private DeviceDetails deviceDetails;

    /**
     * Details about the user which include the user's name, email, address, etc.
     */
    @Valid
    private RestApiUserDetails userDetails;

    /**
     * Shipping address related to a user's order.
     */
    @Valid
    private UserAddress shippingAddress;

    /**
     * Billing address related to a user payment option. Since order can contain only one payment option billing address is part of the order parameters.
     */
    @Valid
    private UserAddress billingAddress;

    /**
     * Merchant descriptor - this is the message(Merchant's name and phone) that the user will see in his payment bank report.
     */
    @Valid
    private DynamicDescriptor dynamicDescriptor;

    /**
     * Optional custom fields.
     */
    @Valid
    private MerchantDetails merchantDetails;

    /**
     * Although DMN response can be configured per merchant site, it will allow to dynamically return the DMN to the provided address per request.
     */
    private UrlDetails urlDetails;

    /**
     * This block contain industry specific addendums such as: Local payment, Hotel, Airline etc.
     */
    private Addendums addendums;

    /**
     * ID of the user in merchant system.
     */
    @Size(max = 45, message = "userTokenId size must be up to 45 characters long!")
    private String userTokenId;

    /**
     * ID of the transaction in merchant system.
     */
    @Size(max = 45, message = "clientUniqueId size must be up to 45 characters long!")
    private String clientUniqueId;

    private AmountDetails amountDetails;
    
    @NotNull(message = "sessionToken parameter is mandatory!")
    public String getSessionToken() {
        return super.getSessionToken();
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

    public List<Item> getItems() {
        return items;
    }

    /**
     * Adds an item that will be purchased.
     * <p>
     * At least one item must be added for a successful order.
     *
     * @param item the {@link Item} object to add to the list of items that the order contains.
     */
    public void addItem(Item item) {
        this.items.add(item);
    }

    public DeviceDetails getDeviceDetails() {
        return deviceDetails;
    }

    public void setDeviceDetails(DeviceDetails deviceDetails) {
        this.deviceDetails = deviceDetails;
    }

    public RestApiUserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(RestApiUserDetails userDetails) {
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

    public UrlDetails getUrlDetails() {
        return urlDetails;
    }

    public void setUrlDetails(UrlDetails urlDetails) {
        this.urlDetails = urlDetails;
    }

    public Addendums getAddendums() {
        return addendums;
    }

    public void setAddendums(Addendums addendums) {
        this.addendums = addendums;
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    public String getClientUniqueId() {
        return clientUniqueId;
    }

    public void setClientUniqueId(String clientUniqueId) {
        this.clientUniqueId = clientUniqueId;
    }

    public AmountDetails getAmountDetails() {
        return amountDetails;
    }

    public void setAmountDetails(AmountDetails amountDetails) {
        this.amountDetails = amountDetails;
    }

    @Override
    public String toString() {
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
        sb.append(", urlDetails=")
                .append(urlDetails);
        sb.append(", addendums=")
                .append(addendums);
        sb.append(", userTokenId='")
                .append(userTokenId)
                .append('\'');
        sb.append(", clientUniqueId='")
                .append(clientUniqueId);
        sb.append(", amountDetails='")
                .append(amountDetails);
        sb.append(", ");
        sb.append(super.toString());
        return sb.toString();
    }
}
