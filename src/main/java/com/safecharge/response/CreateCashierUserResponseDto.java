package com.safecharge.response;

import com.safecharge.response.basic.BaseApiResponseDTO;

public class CreateCashierUserResponseDto extends SafechargeResponse {

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}