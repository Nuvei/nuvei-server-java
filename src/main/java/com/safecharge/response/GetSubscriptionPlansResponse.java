/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.response;

import java.util.List;

import com.safecharge.model.SubscriptionPlan;

/**
 * <p>
 * Response received from the SafeCharge's servers to the {@link com.safecharge.request.GetSubscriptionPlansRequest}.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see com.safecharge.request.GetSubscriptionPlansRequest
 * @since 6/6/2017
 */
public class GetSubscriptionPlansResponse extends SafechargeResponse {

    /**
     * List of the available subscription plans as {@link SubscriptionPlan} objects.
     */
    private List<SubscriptionPlan> subscriptionPlans;

    public List<SubscriptionPlan> getSubscriptionPlans() {
        return subscriptionPlans;
    }

    public void setSubscriptionPlans(List<SubscriptionPlan> subscriptionPlans) {
        this.subscriptionPlans = subscriptionPlans;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetSubscriptionPlansResponse{");
        sb.append("subscriptionPlans=")
                .append(subscriptionPlans);
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
