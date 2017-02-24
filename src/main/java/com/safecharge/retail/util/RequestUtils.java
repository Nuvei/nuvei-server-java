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

import com.safecharge.retail.request.SafechargeOrderDetailsRequest;
import com.safecharge.retail.request.SafechargeRequest;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/17/2017
 */

//         requestChecksumOrder.put(ApiChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING.name(), Arrays.asList(
//                "merchantId", "merchantSiteId", "clientRequestId", "amount", "currency", "timeStamp"));
public class RequestUtils {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    public static String calculateChecksum(SafechargeOrderDetailsRequest request, String amount, String currency, String merchantKey,
            Constants.HashAlgorithm hashAlgorithm) {

        StringBuilder sb = new StringBuilder();

        sb.append(request.getMerchantId() != null ? request.getMerchantId() : "");
        sb.append(request.getMerchantSiteId() != null ? request.getMerchantSiteId() : "");
        sb.append(request.getClientRequestId() != null ? request.getClientRequestId() : "");
        sb.append(amount);
        sb.append(currency);
        sb.append(request.getTimeStamp());
        sb.append(merchantKey);

        System.out.println("Hash: " + sb.toString());

        return getHash(sb.toString(), Constants.CHARSET_UTF8, hashAlgorithm);
    }

    public static String calculateChecksum(SafechargeRequest request, String merchantKey, Constants.HashAlgorithm hashAlgorithm) {

        StringBuilder sb = new StringBuilder();
        sb.append(request.getMerchantId() != null ? request.getMerchantId() : "");
        sb.append(request.getMerchantSiteId() != null ? request.getMerchantSiteId() : "");
        sb.append(request.getClientRequestId() != null ? request.getClientRequestId() : "");
        sb.append(request.getTimeStamp());
        sb.append(merchantKey);

        System.out.println("Hash: " + sb.toString());

        return getHash(sb.toString(), Constants.CHARSET_UTF8, hashAlgorithm);
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

    public static String calculateTimestamp() {
        Calendar cal = new GregorianCalendar();
        sdf.setTimeZone(cal.getTimeZone());
        return sdf.format(cal.getTime());
    }

    public static String calculateClientRequestId(String timestamp) {
        try {
            return String.valueOf(sdf.parse(timestamp)
                                     .getTime());
        } catch (ParseException e) {
            return "-1";
        }
    }
}
