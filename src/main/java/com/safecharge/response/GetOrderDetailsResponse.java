package com.safecharge.response;

import java.util.List;

import com.safecharge.model.Addendums;
import com.safecharge.model.RestApiUserDetails;
import com.safecharge.model.DeviceDetails;
import com.safecharge.model.DynamicDescriptor;
import com.safecharge.model.Item;
import com.safecharge.model.MerchantDetails;
import com.safecharge.model.UserAddress;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Response received from the SafeCharge's servers to the {@link com.safecharge.request.GetOrderDetailsRequest}.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see com.safecharge.request.GetOrderDetailsRequest
 * @since 2/15/2017
 */
public class GetOrderDetailsResponse extends SafechargeResponse implements SafechargeOrderResponse {

    /**
     * The order ID provided by SafeCharge.
     */
    private String orderId;

    /**
     * The three character ISO currency code.
     */
    private String currency;

    /**
     * The transaction amount.
     */
    private Double amount;

    /**
     * List of the items assigned to the order.
     */
    private List<Item> items;

    /**
     * The device details assigned to the order.
     */
    private DeviceDetails deviceDetails;

    /**
     * The user details assigned to the order.
     */
    private RestApiUserDetails userDetails;

    /**
     * The shipping address assigned to the order.
     */
    private UserAddress shippingAddress;

    /**
     * The billing address assigned to the order.
     */
    private UserAddress billingAddress;

    /**
     * The dynamic descriptor assigned to the order.
     */
    private DynamicDescriptor dynamicDescriptor;

    /**
     * The custom fields assigned to the order.
     */
    private MerchantDetails merchantDetails;

    /**
     * The addendums assigned to the order.
     */
    private Addendums addendums;

    /**
     * The date that the transaction related to the order was created.
     */
    private String transactionCreationDate;

    /**
     * The date that the order was created.
     */
    private String orderCreationDate;

    /**
     * The status of the order. Possible values:
     * <ul>
     * <li> OPENED – Order is open and can be modified.
     * <li> CLOSED – Order was paid, and can no longer be modified.
     * <li> IN_PROGRESS – Order is being paid, and can no longer be modified.
     * <li> FAILED – The order failed and can no longer be modified.
     * </ul>
     */
    private String orderStatus;

    /**
     * The status of the transaction. Possible values:
     * <ul>
     * <li> APPROVED
     * <li> DECLINED
     * <li> ERROR
     * </ul>
     */
    private String transactionStatus;

    /**
     * The id of the related transaction.
     */
    private String transactionId;

    @Override
    public String getOrderId() {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderDetailsResponse{");
        sb.append("orderId='")
                .append(orderId)
                .append('\'');
        sb.append(", currency='")
                .append(currency)
                .append('\'');
        sb.append(", amount=")
                .append(amount);
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
        sb.append(", transactionCreationDate='")
                .append(transactionCreationDate)
                .append('\'');
        sb.append(", orderCreationDate='")
                .append(orderCreationDate)
                .append('\'');
        sb.append(", orderStatus='")
                .append(orderStatus)
                .append('\'');
        sb.append(", transactionStatus='")
                .append(transactionStatus)
                .append('\'');
        sb.append(", transactionId='")
                .append(transactionId)
                .append('\'');
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
