package com.safecharge.model;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 6/6/2017
 */
public class SubscriptionsList {

    private Long subscriptionId;
    private String subscriptionStatus;
    private String subscriptionCreateDate;
    private Long subscriptionPlanId;
    private String userTokenId;
    private CashierPaymentMethodDetails userPaymentOption;

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(String subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

    public String getSubscriptionCreateDate() {
        return subscriptionCreateDate;
    }

    public void setSubscriptionCreateDate(String subscriptionCreateDate) {
        this.subscriptionCreateDate = subscriptionCreateDate;
    }

    public Long getSubscriptionPlanId() {
        return subscriptionPlanId;
    }

    public void setSubscriptionPlanId(Long subscriptionPlanId) {
        this.subscriptionPlanId = subscriptionPlanId;
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    public CashierPaymentMethodDetails getUserPaymentOption() {
        return userPaymentOption;
    }

    public void setUserPaymentOption(CashierPaymentMethodDetails userPaymentOption) {
        this.userPaymentOption = userPaymentOption;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("SubscriptionsList{");
        sb.append("subscriptionId=")
          .append(subscriptionId);
        sb.append(", subscriptionStatus='")
          .append(subscriptionStatus)
          .append('\'');
        sb.append(", subscriptionCreateDate='")
          .append(subscriptionCreateDate)
          .append('\'');
        sb.append(", subscriptionPlanId=")
          .append(subscriptionPlanId);
        sb.append(", userTokenId='")
          .append(userTokenId)
          .append('\'');
        sb.append(", userPaymentOption=")
          .append(userPaymentOption);
        sb.append('}');
        return sb.toString();
    }
}
