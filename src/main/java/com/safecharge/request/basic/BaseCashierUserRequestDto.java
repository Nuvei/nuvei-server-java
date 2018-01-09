package com.safecharge.request.basic;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.GET_CASHIER_USER_INFO)
public class BaseCashierUserRequestDto extends BaseApiRequestDTO {

    private static final long serialVersionUID = 7797583313378121191L;

    @NotNull
    @Size(max = 255)
    private String userTokenId;

    public BaseCashierUserRequestDto() {
        super();
    }

    public BaseCashierUserRequestDto(Builder b) {
        super(b);
        this.userTokenId = b.userTokenId;
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    public static class Builder extends BaseApiRequestDTO.Builder {

        private String userTokenId;

        public Builder userTokenId(String userTokenId) {
            this.userTokenId = userTokenId;
            return this;
        }

        public BaseCashierUserRequestDto build() {
            return new BaseCashierUserRequestDto(this);
        }
    }
}