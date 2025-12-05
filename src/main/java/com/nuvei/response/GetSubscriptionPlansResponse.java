/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.response;

import java.util.List;

import com.nuvei.model.SubscriptionPlan;

/**
 * <p>
 * Response received from the Nuvei's servers to the {@link com.nuvei.request.GetSubscriptionPlansRequest}.
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @see com.nuvei.request.GetSubscriptionPlansRequest
 * @since 6/6/2017
 */
public class GetSubscriptionPlansResponse extends NuveiResponse {

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
