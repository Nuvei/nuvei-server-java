package com.safecharge.retail.request;

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
 * @since 2/20/2017
 */
public interface SafechargeOrderDetailsRequest extends SafechargeRequest {

    void setCurrency(String currency);

    void setAmount(String amount);

    void addItem(Item item);

    void setDeviceDetails(DeviceDetails deviceDetails);

    void setUserDetails(UserDetails userDetails);

    void setShippingAddress(UserAddress shippingAddress);

    void setBillingAddress(UserAddress billingAddress);

    void setDynamicDescriptor(DynamicDescriptor dynamicDescriptor);

    void setMerchantDetails(MerchantDetails merchantDetails);

    void setAddendums(Addendums addendums);

    void setUserTokenId(String userTokenId);

    void setClientUniqueId(String clientUniqueId);
}
