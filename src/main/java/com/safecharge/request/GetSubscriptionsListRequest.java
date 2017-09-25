package com.safecharge.request;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Size;

import com.safecharge.request.builder.SafechargeBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 6/5/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.GET_CASHIER_SUBSCRIPTIONS)
public class GetSubscriptionsListRequest
        extends SafechargeRequest {

    private int firstResult = 0;
    private int maxResults = 0;
    private String subscriptionStatus;
    @Size(max = 255,
            message = "userTokenId value size must be up to 255 characters")
    private String userTokenId;

    public static Builder builder() {
        return new Builder();
    }

    public int getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(int firstResult) {
        this.firstResult = firstResult;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(String subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    public static class Builder extends SafechargeBuilder<GetSubscriptionsListRequest.Builder> {

        private int firstResult = 0;
        private int maxResults = 0;
        private String subscriptionStatus;
        private String userTokenId;

        public GetSubscriptionsListRequest.Builder addFirstResult(int firstResult) {
            this.firstResult = firstResult;
            return this;
        }

        public GetSubscriptionsListRequest.Builder addMaxResults(int maxResults) {
            this.maxResults = maxResults;
            return this;
        }

        public GetSubscriptionsListRequest.Builder addSubscriptionStatus(String subscriptionStatus) {
            this.subscriptionStatus = subscriptionStatus;
            return this;
        }

        public GetSubscriptionsListRequest.Builder addUserTokenId(String userTokenId) {
            this.userTokenId = userTokenId;
            return this;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Builder{");
            sb.append("firstResult=")
                    .append(firstResult);
            sb.append(", maxResults=")
                    .append(maxResults);
            sb.append(", subscriptionStatus='")
                    .append(subscriptionStatus)
                    .append('\'');
            sb.append(", userTokenId='")
                    .append(userTokenId)
                    .append('\'');
            sb.append(", ")
                    .append(super.toString());
            sb.append('}');
            return sb.toString();
        }

        @Override
        public SafechargeRequest build() throws ConstraintViolationException {
            GetSubscriptionsListRequest getSubscriptionListRequest = new GetSubscriptionsListRequest();
            getSubscriptionListRequest.setFirstResult(firstResult);
            getSubscriptionListRequest.setMaxResults(maxResults);
            getSubscriptionListRequest.setSubscriptionStatus(subscriptionStatus);
            getSubscriptionListRequest.setUserTokenId(userTokenId);
            return ValidationUtils.validate(super.build(getSubscriptionListRequest));
        }
    }
}
