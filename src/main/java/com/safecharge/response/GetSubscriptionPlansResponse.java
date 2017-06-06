package com.safecharge.response;

import java.util.List;

import com.safecharge.model.SubscriptionPlan;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 6/6/2017
 */
public class GetSubscriptionPlansResponse extends SafechargeResponse {

    private List<SubscriptionPlan> subscriptionPlans;

    public List<SubscriptionPlan> getSubscriptionPlans() {
        return subscriptionPlans;
    }

    public void setSubscriptionPlans(List<SubscriptionPlan> subscriptionPlans) {
        this.subscriptionPlans = subscriptionPlans;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("GetSubscriptionPlansResponse{");
        sb.append("subscriptionPlans=")
          .append(subscriptionPlans);
        sb.append(", ")
          .append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
