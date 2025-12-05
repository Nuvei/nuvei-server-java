/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.response;

import java.util.List;

import com.nuvei.model.SubscriptionsListElement;

/**
 * <p>
 * Response received from the Nuvei's servers to the {@link com.nuvei.request.GetSubscriptionsListRequest}.
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @see com.nuvei.request.GetSubscriptionsListRequest
 * @since 6/6/2017
 */
public class GetSubscriptionsListResponse extends NuveiResponse {

    /**
     * The list of the subscriptions per user.
     */
    private List<SubscriptionsListElement> subscriptionsList;

    /**
     * The total count of subscriptions per user.
     */
    private Long totalCount;

    public List<SubscriptionsListElement> getSubscriptionsList() {
        return subscriptionsList;
    }

    public void setSubscriptionsList(List<SubscriptionsListElement> subscriptionsList) {
        this.subscriptionsList = subscriptionsList;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetSubscriptionListResponse{");
        sb.append("subscriptionsList=")
                .append(subscriptionsList);
        sb.append(", totalCount=")
                .append(totalCount);
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
