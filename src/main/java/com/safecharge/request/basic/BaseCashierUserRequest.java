package com.safecharge.request.basic;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.GET_CASHIER_USER_INFO)
public class BaseCashierUserRequest extends BaseApiRequest {

    private static final long serialVersionUID = 7797583313378121191L;

    @NotNull
    @Size(max = 255)
    private String userTokenId;

    public BaseCashierUserRequest() {
        super();
    }

    public BaseCashierUserRequest(Builder b) {
        super(b);
        this.userTokenId = b.userTokenId;
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    public static class Builder extends BaseApiRequest.Builder {

        private String userTokenId;

        public Builder userTokenId(String userTokenId) {
            this.userTokenId = userTokenId;
            return this;
        }

        public BaseCashierUserRequest build() {
            return new BaseCashierUserRequest(this);
        }
    }
}