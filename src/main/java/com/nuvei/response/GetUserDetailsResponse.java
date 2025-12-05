/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.response;

import com.nuvei.model.UserDetailsCashier;

public class GetUserDetailsResponse extends NuveiResponse {

    UserDetailsCashier userDetails;

    public UserDetailsCashier getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetailsCashier userDetails) {
        this.userDetails = userDetails;
    }
}
