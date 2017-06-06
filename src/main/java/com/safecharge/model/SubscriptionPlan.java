package com.safecharge.model;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 6/6/2017
 */
public class SubscriptionPlan {

    private Long subscriptionPlanId;
    private String productName;
    private String currency;
    private String initialAmount;
    private String rebillAmount;
    private String startUnit;
    private String startUnitValue;
    private String recurrungUnit;
    private String recurringUnitValue;
    private String endUnit;
    private String endUnitValue;

    public Long getSubscriptionPlanId() {
        return subscriptionPlanId;
    }

    public void setSubscriptionPlanId(Long subscriptionPlanId) {
        this.subscriptionPlanId = subscriptionPlanId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(String initialAmount) {
        this.initialAmount = initialAmount;
    }

    public String getRebillAmount() {
        return rebillAmount;
    }

    public void setRebillAmount(String rebillAmount) {
        this.rebillAmount = rebillAmount;
    }

    public String getStartUnit() {
        return startUnit;
    }

    public void setStartUnit(String startUnit) {
        this.startUnit = startUnit;
    }

    public String getStartUnitValue() {
        return startUnitValue;
    }

    public void setStartUnitValue(String startUnitValue) {
        this.startUnitValue = startUnitValue;
    }

    public String getRecurrungUnit() {
        return recurrungUnit;
    }

    public void setRecurrungUnit(String recurrungUnit) {
        this.recurrungUnit = recurrungUnit;
    }

    public String getRecurringUnitValue() {
        return recurringUnitValue;
    }

    public void setRecurringUnitValue(String recurringUnitValue) {
        this.recurringUnitValue = recurringUnitValue;
    }

    public String getEndUnit() {
        return endUnit;
    }

    public void setEndUnit(String endUnit) {
        this.endUnit = endUnit;
    }

    public String getEndUnitValue() {
        return endUnitValue;
    }

    public void setEndUnitValue(String endUnitValue) {
        this.endUnitValue = endUnitValue;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("SubscriptionPlan{");
        sb.append("subscriptionPlanId=")
          .append(subscriptionPlanId);
        sb.append(", productName='")
          .append(productName)
          .append('\'');
        sb.append(", currency='")
          .append(currency)
          .append('\'');
        sb.append(", initialAmount='")
          .append(initialAmount)
          .append('\'');
        sb.append(", rebillAmount='")
          .append(rebillAmount)
          .append('\'');
        sb.append(", startUnit='")
          .append(startUnit)
          .append('\'');
        sb.append(", startUnitValue='")
          .append(startUnitValue)
          .append('\'');
        sb.append(", recurrungUnit='")
          .append(recurrungUnit)
          .append('\'');
        sb.append(", recurringUnitValue='")
          .append(recurringUnitValue)
          .append('\'');
        sb.append(", endUnit='")
          .append(endUnit)
          .append('\'');
        sb.append(", endUnitValue='")
          .append(endUnitValue)
          .append('\'');
        sb.append('}');
        return sb.toString();
    }
}
