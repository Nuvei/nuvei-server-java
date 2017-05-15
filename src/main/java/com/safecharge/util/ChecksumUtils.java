package com.safecharge.util;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/21/2017
 */
public class ChecksumUtils {

    private static final Log logger = LogFactory.getLog(RequestUtils.class);
    private static final Map<String, List<String>> requestChecksumOrder = new HashMap<String, List<String>>();

    static {
        requestChecksumOrder.put(Constants.ChecksumOrderMapping.USER_DETAILS.name(),
                Arrays.asList(new String[] { "firstName", "lastName", "address", "phone", "zip", "city", "countryCode", "state", "email" }));

        requestChecksumOrder.put(Constants.ChecksumOrderMapping.SETTLE_GW_TRANSACTION.name(),
                Arrays.asList("merchantId", "merchantSiteId", "clientRequestId", "clientUniqueId", "amount", "currency", "relatedTransactionId", "authCode",
                        "descriptorMerchantName", "descriptorMerchantPhone", "comment", "urlDetails", "timeStamp"));

        requestChecksumOrder.put(Constants.ChecksumOrderMapping.REFUND_GW_TRANSACTION.name(),
                Arrays.asList("merchantId", "merchantSiteId", "clientRequestId", "clientUniqueId", "amount", "currency", "relatedTransactionId", "authCode",
                        "comment", "urlDetails", "timeStamp"));

        requestChecksumOrder.put(Constants.ChecksumOrderMapping.VOID_GW_TRANSACTION.name(),
                Arrays.asList("merchantId", "merchantSiteId", "clientRequestId", "clientUniqueId", "amount", "currency", "relatedTransactionId", "authCode",
                        "comment", "urlDetails", "timeStamp"));

        requestChecksumOrder.put(Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING.name(),
                Arrays.asList("merchantId", "merchantSiteId", "clientRequestId", "amount", "currency", "timeStamp"));

        requestChecksumOrder.put(Constants.ChecksumOrderMapping.ADD_CASHIER_APM.name(), Arrays.asList(
                new String[] { "merchantId", "merchantSiteId", "userTokenId", "clientRequestId", "paymentMethodName", "apmData", "billingAddress",
                        "timeStamp" }));

        requestChecksumOrder.put(Constants.ChecksumOrderMapping.ADD_CASHIER_CC_CARD.name(), Arrays.asList(
                new String[] { "merchantId", "merchantSiteId", "userTokenId", "clientRequestId", "ccCardNumber", "ccExpMonth", "ccExpYear",
                        "ccNameOnCard", "billingAddress", "timeStamp" }));
    }

    public static String calculateChecksum(Object apiRequest, String key, String encoding, Constants.HashAlgorithm hashAlgorithm) {

        ValidChecksum annotation = apiRequest.getClass()
                                             .getAnnotation(ValidChecksum.class);
        if (annotation == null) {
            return null;
        }

        Constants.ChecksumOrderMapping mappingName = annotation.orderMappingName();
        List<String> paramsOrder = requestChecksumOrder.get(mappingName.name());

        StringBuilder sb = new StringBuilder();

        for (String parameterName : paramsOrder) {
            Object fieldValue = getObject(apiRequest, parameterName);
            if (fieldValue != null) {
                ValidChecksum innerObjectAnnotation = fieldValue.getClass()
                                                                .getAnnotation(ValidChecksum.class);

                if (innerObjectAnnotation != null) {
                    sb.append(appendInnerObjectParams(fieldValue, innerObjectAnnotation));

                } else if (fieldValue instanceof List) {
                    sb.append(appendInnerObjectListValues(((List) fieldValue)));

                } else if (fieldValue instanceof Map) {
                    sb.append(appendInnerObjectListValues(((Map<Object, Object>) fieldValue)));

                } else {
                    sb.append(fieldValue);
                }
            }
        }

        sb.append(key);
        return getHash(sb.toString(), encoding, hashAlgorithm);
    }

    private static String appendInnerObjectListValues(List fieldValues) {

        StringBuilder sb = new StringBuilder();

        for (Object object : fieldValues) {
            List<String> paramsOrder = null;

            ValidChecksum annotation = object.getClass()
                                             .getAnnotation(ValidChecksum.class);
            if (annotation != null) {
                paramsOrder = requestChecksumOrder.get(annotation.orderMappingName()
                                                                 .name());
            }

            if (paramsOrder != null && !paramsOrder.isEmpty()) {

                for (String parameterName : paramsOrder) {
                    Object value = getObject(object, parameterName);

                    if (value instanceof Map) {
                        sb.append(appendInnerObjectListValues((Map<Object, Object>) value));

                    } else if (value != null) {
                        sb.append(value);
                    }
                }

            } else {
                sb.append(object.toString());
            }
        }
        return sb.toString();
    }

    private static String appendInnerObjectListValues(Map<Object, Object> data) {

        StringBuilder str = new StringBuilder();

        for (Object key : data.keySet()) {
            Object value = data.get(key);

            if (value instanceof List) {
                str.append(appendInnerObjectListValues(((List) value)));

            } else if (value instanceof Map) {
                str.append(appendInnerObjectListValues((Map) value));

            } else if (value != null) {
                str.append(value);
            }
        }
        return str.toString();
    }

    private static String appendInnerObjectParams(Object fieldValue, ValidChecksum innerObjectAnnotation) {

        Constants.ChecksumOrderMapping innerMappingName = innerObjectAnnotation.orderMappingName();
        List<String> innerObjectParamsOrder = requestChecksumOrder.get(innerMappingName.name());

        StringBuilder sb = new StringBuilder();
        for (String parameterName : innerObjectParamsOrder) {
            Object innerFieldValue = getObject(fieldValue, parameterName);
            if (innerFieldValue != null) {
                sb.append(innerFieldValue);
            }
        }

        return sb.toString();
    }

    private static Object getObject(Object object, String fieldName) {
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                return field.get(object);
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return null;
    }

    private static String getHash(String text, String charset, Constants.HashAlgorithm algorithm) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm.getAlgorithm());

        } catch (NoSuchAlgorithmException nsae) {
            logger.error("Implementation of " + algorithm + " not found. " + nsae);
            return null;
        }

        CharsetEncoder encoder = Charset.forName(charset)
                                        .newEncoder();

        ByteBuffer encoded;
        try {
            encoded = encoder.encode(CharBuffer.wrap(text));
        } catch (CharacterCodingException e) {
            logger.error("Cannot encode text into bytes using charset " + charset + ": " + e.getMessage());
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
