/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import java.util.Map;

import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;

/**
 * <p>
 * Holder for an already saved Checkout Page's User Payment Option(UPO) data. It can hold credit/debit card or APM data.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 6/6/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.USER_DETAILS)
public class CashierPaymentMethodDetails {

    private Long userPaymentOptionId;
    private String upoName;
    private String paymentMethodName;
    private String upoStatus;
    private String upoRegistrationDate;
    private String expiryDate;
    private String depositSuccess;
    private String withdrawSuccess;
    private UserDetailsCashier billingAddress;
    private Map<String, String> upoData;

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

    public UserDetailsCashier getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(UserDetailsCashier billingAddress) {
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

    public String getUpoRegistrationDate() {
        return upoRegistrationDate;
    }

    public void setUpoRegistrationDate(String upoRegistrationDate) {
        this.upoRegistrationDate = upoRegistrationDate;
    }

    public String getDepositSuccess() {
        return depositSuccess;
    }

    public void setDepositSuccess(String depositSuccess) {
        this.depositSuccess = depositSuccess;
    }

    public String getWithdrawSuccess() {
        return withdrawSuccess;
    }

    public void setWithdrawSuccess(String withdrawSuccess) {
        this.withdrawSuccess = withdrawSuccess;
    }

    @Override
    public String toString() {
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
        sb.append(", upoRegistrationDate='")
                .append(upoRegistrationDate)
                .append('\'');
        sb.append(", depositSuccess='")
                .append(depositSuccess)
                .append('\'');
        sb.append(", withdrawSuccess='")
                .append(withdrawSuccess)
                .append('\'');
        sb.append('}');
        return sb.toString();
    }
}
