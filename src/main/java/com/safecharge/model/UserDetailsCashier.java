/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.USER_DETAILS)
public class UserDetailsCashier extends CommonUserDetailsInfo {

    private String birthdate;
    private String userTokenId;
    private Long userId;

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDetailsCashier{");
        sb.append(super.toString());
        sb.append(", birthdate='")
                .append(birthdate)
                .append('\'');
        sb.append(", userTokenId='")
                .append(userTokenId)
                .append('\'');
        sb.append(", userId='")
                .append(userId)
                .append('\'');
        sb.append('}');

        return sb.toString();
    }
}
