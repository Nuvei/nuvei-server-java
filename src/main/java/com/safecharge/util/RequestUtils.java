/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * <p>
 * Utility class with helper methods for calculating some of the params needed when creating a request to Safecharge
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */

public class RequestUtils {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    private RequestUtils() {
    }

    /**
     * This method is used to calculate the current timestamp of a request.
     * <p>
     * The format of the returned String is "yyyyMMddHHmmss".
     *
     * @return the current time as a String
     */
    public static String calculateTimestamp() {
        Calendar cal = new GregorianCalendar();
        sdf.setTimeZone(cal.getTimeZone());
        return sdf.format(cal.getTime());
    }

    /**
     * This method is used to calculate the clientRequestId parameter of a request.
     *
     * @param timestamp the timestamp to generate clientRequestId from. It should be in "yyyyMMddHHmmss" format
     * @return the clientRequestId or -1 if it can't be calculated
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
