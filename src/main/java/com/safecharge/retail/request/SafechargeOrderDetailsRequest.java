package com.safecharge.retail.request;

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
 * @since 2/20/2017
 */
public interface SafechargeOrderDetailsRequest extends SafechargeRequest {

    /**
     * The three character ISO currency code.
     *
     * @param currency
     */
    void setCurrency(String currency);

    /**
     * The transaction amount.
     *
     * @param amount
     */
    void setAmount(String amount);

    /**
     * An item that will be purchased.
     *
     * @param item
     */
    void addItem(Item item);

    /**
     * The details for the device from which the transaction will be made.
     *
     * @param deviceDetails
     */
    void setDeviceDetails(DeviceDetails deviceDetails);

    /**
     * Details about the user which include the user's name, email, address, etc.
     *
     * @param userDetails
     */
    void setUserDetails(UserDetails userDetails);

    /**
     * Shipping address related to a user order.
     *
     * @param shippingAddress
     */
    void setShippingAddress(UserAddress shippingAddress);

    /**
     * Billing address related to a user payment option. Since order can contain only one payment option billing address is part of the order parameters.
     *
     * @param billingAddress
     */
    void setBillingAddress(UserAddress billingAddress);

    /**
     * @param dynamicDescriptor
     */
    void setDynamicDescriptor(DynamicDescriptor dynamicDescriptor);

    /**
     * Additional custom parameters.
     *
     * @param merchantDetails
     */
    void setMerchantDetails(MerchantDetails merchantDetails);

    /**
     * This block contain industry specific addendums such as: Local payment, Hotel, Airline etc.
     *
     * @param addendums
     */
    void setAddendums(Addendums addendums);

    /**
     * ID of the user in merchant system.
     *
     * @param userTokenId
     */
    void setUserTokenId(String userTokenId);

    /**
     * ID of the transaction in merchant system.
     *
     * @param clientUniqueId
     */
    void setClientUniqueId(String clientUniqueId);
}
