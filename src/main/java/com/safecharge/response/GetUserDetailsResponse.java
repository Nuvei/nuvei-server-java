package com.safecharge.response;

import com.safecharge.model.UserDetailsCashier;

public class GetUserDetailsResponse extends SafechargeResponse {

    UserDetailsCashier userDetails;

    public UserDetailsCashier getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetailsCashier userDetails) {
        this.userDetails = userDetails;
    }
}
