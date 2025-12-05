/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.response;

/**
 * <p>
 * Response received from the Nuvei's servers to the {@link com.nuvei.request.CreateSubscriptionRequest}.
 * </p>
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @see com.nuvei.request.CreateSubscriptionRequest
 * @since 6/6/2017
 */
public class CreateSubscriptionResponse extends NuveiResponse {

    private String subscriptionId;

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateSubscriptionResponse{");
        sb.append("subscriptionId='")
                .append(subscriptionId)
                .append('\'');
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
