package com.safecharge.response;

public class CreateCashierUserResponseDto extends SafechargeResponse {

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}