package com.safecharge.retail.util;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.safecharge.retail.request.SafechargeRequest;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */

public class RequestUtils {

    private static final Log logger = LogFactory.getLog(RequestUtils.class);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * Checksum parameters must be in the order: "merchantId", "merchantSiteId", "clientRequestId", "amount", "currency", "timeStamp"
     *
     * @param request
     * @param amount
     * @param currency
     * @param merchantKey
     * @param hashAlgorithm
     * @return
     */
    public static String calculateChecksum(SafechargeRequest request, String amount, String currency, String merchantKey,
            Constants.HashAlgorithm hashAlgorithm) {

        StringBuilder sb = new StringBuilder();

        sb.append(request.getMerchantId() != null ? request.getMerchantId() : "");
        sb.append(request.getMerchantSiteId() != null ? request.getMerchantSiteId() : "");
        sb.append(request.getClientRequestId() != null ? request.getClientRequestId() : "");
        if (amount != null && currency != null) {
            sb.append(amount);
            sb.append(currency);
        }
        sb.append(request.getTimeStamp());
        sb.append(merchantKey);

        if (logger.isDebugEnabled()) {
            logger.debug("Hash: " + sb.toString());
        }

        return getHash(sb.toString(), Constants.CHARSET_UTF8, hashAlgorithm);
    }

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

    private static String getHash(String text, String charset, Constants.HashAlgorithm algorithm) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm.getAlgorithm());

        } catch (NoSuchAlgorithmException nsae) {
            //            logger.error("Implementation of {} not found", algorithm, nsae);
            return null;
        }

        CharsetEncoder encoder = Charset.forName(charset)
                                        .newEncoder();

        ByteBuffer encoded;
        try {
            encoded = encoder.encode(CharBuffer.wrap(text));
        } catch (CharacterCodingException e) {
            //            logger.error("Cannot encode text into bytes using charset {}: {}", charset, e.getMessage());
            return null;
        }

        byte[] inbytes;

        inbytes = new byte[encoded.remaining()];

        encoded.get(inbytes, 0, inbytes.length);

        byte[] bytes = md.digest(inbytes);

        // Output the bytes of the hash as a String (text/plain)
        StringBuilder sb = new StringBuilder(2 * bytes.length);
        for (int i = 0; i < bytes.length; i++) {
            int low = bytes[i] & 0x0f;
            int high = (bytes[i] & 0xf0) >> 4;
            sb.append(Constants.HEXADECIMAL[high]);
            sb.append(Constants.HEXADECIMAL[low]);
        }

        return sb.toString();
    }
}
