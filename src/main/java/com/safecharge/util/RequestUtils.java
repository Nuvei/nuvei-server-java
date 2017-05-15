package com.safecharge.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */

public class RequestUtils {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * This method is used to calculate the timestamp of a request.
     *
     * @return
     */
    public static String calculateTimestamp() {
        Calendar cal = new GregorianCalendar();
        sdf.setTimeZone(cal.getTimeZone());
        return sdf.format(cal.getTime());
    }

    /**
     * This method is used to calculate the clientRequestId parameter of a request.
     *
     * @param timestamp
     * @return
     */
    public static String calculateClientRequestId(String timestamp) {
        try {
            return String.valueOf(sdf.parse(timestamp)
                                     .getTime());
        } catch (ParseException e) {
            return "-1";
        }
    }
}
