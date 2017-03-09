package com.safecharge.retail.request.builder;

import java.util.ArrayList;
import java.util.List;

import com.safecharge.retail.biz.SafechargeConfiguration;
import com.safecharge.retail.model.Addendums;
import com.safecharge.retail.model.DeviceDetails;
import com.safecharge.retail.model.DynamicDescriptor;
import com.safecharge.retail.model.Item;
import com.safecharge.retail.model.MerchantDetails;
import com.safecharge.retail.model.UserAddress;
import com.safecharge.retail.model.UserDetails;
import com.safecharge.retail.request.SafechargeOrderDetailsRequest;
import com.safecharge.retail.util.RequestUtils;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/20/2017
 */
public abstract class SafechargeOrderBuilder<T extends SafechargeOrderBuilder<T>> extends SafechargeBuilder<T> {

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

    /**
     * @param amount
     * @return
     */
    public T addAmount(String amount) {
        this.amount = amount;
        return (T) this;
    }

    /**
     * @param currency
     * @return
     */
    public T addCurrency(String currency) {
        this.currency = currency;
        return (T) this;
    }

    /**
     * TODO
     *
     * @param item
     * @return
     */
    public T addItem(Item item) {

        items.add(item);
        return (T) this;
    }

    /**
     * TODO
     *
     * @param name
     * @param price
     * @param quantity
     * @return
     */
    public T addItem(String name, String price, String quantity) {

        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        item.setQuantity(quantity);

        return addItem(item);
    }

    /**
     * TODO
     *
     * @param deviceDetails
     * @return
     */
    public T addDeviceDetails(DeviceDetails deviceDetails) {

        this.deviceDetails = deviceDetails;
        return (T) this;
    }

    /**
     * @param deviceType
     * @param deviceName
     * @param deviceOS
     * @param browser
     * @param ipAddress
     * @return
     */
    public T addDeviceDetails(String deviceType, String deviceName, String deviceOS, String browser, String ipAddress) {

        DeviceDetails deviceDetails = new DeviceDetails();
        deviceDetails.setDeviceType(deviceType);
        deviceDetails.setDeviceName(deviceName);
        deviceDetails.setDeviceOS(deviceOS);
        deviceDetails.setBrowser(browser);
        deviceDetails.setIpAddress(ipAddress);

        return addDeviceDetails(deviceDetails);
    }

    /**
     * @param userDetails
     * @return
     */
    public T addUserDetails(UserDetails userDetails) {

        this.userDetails = userDetails;
        return (T) this;
    }

    /**
     * @param address
     * @param city
     * @param country
     * @param email
     * @param firstName
     * @param lastName
     * @param phone
     * @param state
     * @param zip
     * @return
     */
    public T addUserDetails(String address, String city, String country, String email, String firstName, String lastName, String phone, String state,
            String zip) {

        UserDetails userDetails = new UserDetails();
        userDetails.setAddress(address);
        userDetails.setCity(city);
        userDetails.setCountry(country);
        userDetails.setEmail(email);
        userDetails.setFirstName(firstName);
        userDetails.setLastName(lastName);
        userDetails.setPhone(phone);
        userDetails.setState(state);
        userDetails.setZip(zip);

        return addUserDetails(userDetails);
    }

    /**
     * TODO
     *
     * @param userAddress
     * @return
     */
    public T addShippingDetails(UserAddress userAddress) {

        this.shippingAddress = userAddress;
        return (T) this;
    }

    /**
     * TODO
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param phone
     * @param address
     * @param city
     * @param country
     * @param state
     * @param zip
     * @param cell
     * @return
     */
    public T addShippingDetails(String firstName, String lastName, String email, String phone, String address, String city, String country,
            String state, String zip, String cell) {

        UserAddress userAddress = new UserAddress();
        userAddress.setFirstName(firstName);
        userAddress.setLastName(lastName);
        userAddress.setEmail(email);
        userAddress.setPhone(phone);
        userAddress.setAddress(address);
        userAddress.setCity(city);
        userAddress.setCountry(country);
        userAddress.setState(state);
        userAddress.setZip(zip);
        userAddress.setCell(cell);

        return addShippingDetails(userAddress);
    }

    /**
     * TODO
     *
     * @param userAddress
     * @return
     */
    public T addBillingDetails(UserAddress userAddress) {

        this.billingAddress = userAddress;
        return (T) this;
    }

    /**
     * TODO
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param phone
     * @param address
     * @param city
     * @param country
     * @param state
     * @param zip
     * @param cell
     * @return
     */
    public T addBillingDetails(String firstName, String lastName, String email, String phone, String address, String city, String country,
            String state, String zip, String cell) {

        UserAddress userAddress = new UserAddress();
        userAddress.setFirstName(firstName);
        userAddress.setLastName(lastName);
        userAddress.setEmail(email);
        userAddress.setPhone(phone);
        userAddress.setAddress(address);
        userAddress.setCity(city);
        userAddress.setCountry(country);
        userAddress.setState(state);
        userAddress.setZip(zip);
        userAddress.setCell(cell);

        return addBillingDetails(userAddress);
    }

    /**
     * TODO
     *
     * @param dynamicDescriptor
     * @return
     */
    public T addDynamicDescriptor(DynamicDescriptor dynamicDescriptor) {

        this.dynamicDescriptor = dynamicDescriptor;
        return (T) this;
    }

    /**
     * TODO
     *
     * @param merchantName
     * @param merchantPhone
     * @return
     */
    public T addDynamicDescriptor(String merchantName, String merchantPhone) {

        DynamicDescriptor dynamicDescriptor = new DynamicDescriptor();
        dynamicDescriptor.setMerchantName(merchantName);
        dynamicDescriptor.setMerchantPhone(merchantPhone);

        return addDynamicDescriptor(dynamicDescriptor);
    }

    /**
     * TODO
     *
     * @param merchantDetails
     * @return
     */
    public T addMerchantDetails(MerchantDetails merchantDetails) {

        this.merchantDetails = merchantDetails;
        return (T) this;
    }

    /**
     * TODO
     *
     * @param customField1
     * @param customField2
     * @param customField3
     * @param customField4
     * @param customField5
     * @param customField6
     * @param customField7
     * @param customField8
     * @param customField9
     * @param customField10
     * @return
     */
    public T addMerchantDetails(String customField1, String customField2, String customField3, String customField4, String customField5,
            String customField6, String customField7, String customField8, String customField9, String customField10) {

        MerchantDetails merchantDetails = new MerchantDetails();
        merchantDetails.setCustomField1(customField1);
        merchantDetails.setCustomField2(customField2);
        merchantDetails.setCustomField3(customField3);
        merchantDetails.setCustomField4(customField4);
        merchantDetails.setCustomField5(customField5);
        merchantDetails.setCustomField6(customField6);
        merchantDetails.setCustomField7(customField7);
        merchantDetails.setCustomField8(customField8);
        merchantDetails.setCustomField9(customField9);
        merchantDetails.setCustomField10(customField10);

        return addMerchantDetails(merchantDetails);
    }

    /**
     * TODO
     *
     * @param addendums
     * @return
     */
    public T addAddendums(Addendums addendums) {

        this.addendums = addendums;
        return (T) this;
    }

    /**
     * TODO
     *
     * @return
     */
    public T addAddendums() {

        Addendums addendums = new Addendums();

        return addAddendums(addendums);
    }

    /**
     * TODO
     *
     * @param userTokenId
     * @return
     */
    public T addUserTokenId(String userTokenId) {

        this.userTokenId = userTokenId;
        return (T) this;
    }

    /**
     * TODO
     *
     * @param clientUniqueId
     * @return
     */
    public T addClientUniqueId(String clientUniqueId) {

        this.clientUniqueId = clientUniqueId;
        return (T) this;
    }

    /**
     * @return
     */
    protected <T extends SafechargeOrderDetailsRequest> T build(T safechargeOrderDetailsRequest) {

        safechargeOrderDetailsRequest = super.build(safechargeOrderDetailsRequest);

        safechargeOrderDetailsRequest.setCurrency(currency);
        safechargeOrderDetailsRequest.setAmount(amount);
        for (Item item : items) {
            safechargeOrderDetailsRequest.addItem(item);
        }
        safechargeOrderDetailsRequest.setDeviceDetails(deviceDetails);
        safechargeOrderDetailsRequest.setUserDetails(userDetails);
        safechargeOrderDetailsRequest.setShippingAddress(shippingAddress);
        safechargeOrderDetailsRequest.setBillingAddress(billingAddress);
        safechargeOrderDetailsRequest.setDynamicDescriptor(dynamicDescriptor);
        safechargeOrderDetailsRequest.setMerchantDetails(merchantDetails);
        safechargeOrderDetailsRequest.setAddendums(addendums);
        safechargeOrderDetailsRequest.setUserTokenId(userTokenId);
        safechargeOrderDetailsRequest.setClientUniqueId(clientUniqueId);

        safechargeOrderDetailsRequest.setChecksum(RequestUtils.calculateChecksum(safechargeOrderDetailsRequest, amount, currency,
                SafechargeConfiguration.getMerchantInfo()
                                       .getMerchantKey(), SafechargeConfiguration.getMerchantInfo()
                                                                                 .getHashAlgorithm()));
        return safechargeOrderDetailsRequest;
    }
}
