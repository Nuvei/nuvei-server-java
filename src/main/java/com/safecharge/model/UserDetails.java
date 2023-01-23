package com.safecharge.model;

import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Holder for User's personal details and a "generic" address. Note that a User can have different billing/shipping
 * address per order stored in {@link UserAddress} object.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/21/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.USER_DETAILS)
public class UserDetails extends CommonUserDetailsInfo {

    private String birthdate;

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDetails{");
        sb.append(super.toString());
        sb.append(", Birthdate='")
                .append(birthdate)
                .append('\'');
        sb.append('}');

        return sb.toString();
    }
}
