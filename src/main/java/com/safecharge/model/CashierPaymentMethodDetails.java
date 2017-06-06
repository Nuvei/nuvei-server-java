package com.safecharge.model;

import java.util.Map;

import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 6/6/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.USER_DETAILS) public class CashierPaymentMethodDetails {

    private Long userPaymentOptionId;
    private String upoName;
    private String paymentMethodName;
    private String upoStatus;
    private UserDetails billingAddress;
    private Map<String, String> upoData;
    private String expiryDate;

    public Long getUserPaymentOptionId() {
        return userPaymentOptionId;
    }

    public void setUserPaymentOptionId(Long userPaymentOptionId) {
        this.userPaymentOptionId = userPaymentOptionId;
    }

    public String getUpoName() {
        return upoName;
    }

    public void setUpoName(String upoName) {
        this.upoName = upoName;
    }

    public String getPaymentMethodName() {
        return paymentMethodName;
    }

    public void setPaymentMethodName(String paymentMethodName) {
        this.paymentMethodName = paymentMethodName;
    }

    public String getUpoStatus() {
        return upoStatus;
    }

    public void setUpoStatus(String upoStatus) {
        this.upoStatus = upoStatus;
    }

    public UserDetails getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(UserDetails billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Map<String, String> getUpoData() {
        return upoData;
    }

    public void setUpoData(Map<String, String> upoData) {
        this.upoData = upoData;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("CashierPaymentMethodDetails{");
        sb.append("userPaymentOptionId=")
          .append(userPaymentOptionId);
        sb.append(", upoName='")
          .append(upoName)
          .append('\'');
        sb.append(", paymentMethodName='")
          .append(paymentMethodName)
          .append('\'');
        sb.append(", upoStatus='")
          .append(upoStatus)
          .append('\'');
        sb.append(", billingAddress=")
          .append(billingAddress);
        sb.append(", upoData=")
          .append(upoData);
        sb.append(", expiryDate='")
          .append(expiryDate)
          .append('\'');
        sb.append('}');
        return sb.toString();
    }
}
