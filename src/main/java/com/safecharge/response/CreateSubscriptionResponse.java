package com.safecharge.response;

/**
 * Copyright (C) 2007-2020 SafeCharge International Group Limited.
 * <p>
 * Response received from the SafeCharge's servers to the {@link com.safecharge.request.CreateSubscriptionRequest}.
 * </p>
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see com.safecharge.request.CreateSubscriptionRequest
 * @since 6/6/2017
 */
public class CreateSubscriptionResponse extends SafechargeResponse {

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
