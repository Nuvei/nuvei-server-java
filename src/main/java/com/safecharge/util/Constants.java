/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.util;

/**
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/15/2017
 */
public interface Constants {

    /**
     * All server error codes:
     */

    int ERR_CODE_NO_ERROR = 0;
    int ERR_CODE_GENERAL_SYSTEM_ERROR = 1000;
    int ERR_CODE_INVALID_CHECKSUM = 1001;
    int ERR_CODE_MERCHANT_NOT_EXIST = 1002;
    int ERR_CODE_MERCHANT_SITE_NOT_EXIST = 1003;
    int ERR_CODE_INVALID_CARD_NUMBER = 1004;
    int ERR_CODE_INVALID_EXP_MONTH = 1005;
    int ERR_CODE_INVALID_EXP_YEAR = 1006;
    int ERR_CODE_INVALID_NAME_ON_CARD = 1007;
    int ERR_CODE_EXPIRED_CARD = 1008;
    int ERR_CODE_UPO_STATUS_SUSPENDED = 1009;
    int ERR_CODE_INVALID_USER_TOKEN = 1010;
    int ERR_CODE_INVALID_USER_PAYMENT_OPTION_ID = 1011;
    int ERR_CODE_INVALID_CLIENT_REQUEST_ID = 1012;
    int ERR_CODE_INVALID_MERCHANT_ID = 1013;
    int ERR_CODE_INVALID_COUNTRY_CODE = 1014;
    int ERR_CODE_INVALID_LOCALE_CODE = 1015;
    int ERR_CODE_INVALID_PHONE_NUMBER = 1016;
    int ERR_CODE_INVALID_MERCHANT_MERCHANTSITE = 1017;
    int ERR_CODE_INVALID_CC_CARD_BIN = 1018;
    int ERR_CODE_GENERAL_VALIDATION = 1019;
    int ERR_CODE_INVALID_PAYMENT_METHOD = 1020;
    int ERR_CODE_INVALID_TIMESTAMP = 1021;
    int ERR_CODE_INVALID_MERCHANT_SITE_ID = 1022;
    int ERR_CODE_INVALID_UPO_STATUS = 1023;
    int ERR_CODE_UPO_LIMIT_EXCEEDED = 1024;
    int ERR_CODE_INVALID_CC_CARD_LAST_4_DIGITS = 1025;
    int ERR_CODE_INVALID_UNIQUE_CC = 1026;
    int ERR_CODE_INVALID_CC_ISSUER_NAME = 1027;
    int ERR_CODE_INVALID_CC_ISSUER = 1028;
    int ERR_CODE_INVALID_CC_EXP_DATE = 1029;
    int ERR_CODE_ERROR_SUSPENDING_UPO = 1030;
    int ERR_CODE_ERROR_ENABLING_UPO = 1031;
    int ERR_CODE_INVALID_START_IDX = 1032;
    int ERR_CODE_INVALID_END_IDX = 1033;
    int ERR_CODE_INVALID_CONFIGURATION = 1034;
    int ERR_CODE_NOT_FINALIZED_WD_ORDERS_EXIST = 1035;
    int ERR_CODE_OUTSTANDING_NET_DPOSIT_EXIST = 1036;
    int ERR_CODE_WD_ORDERS_AND_NET_DPOSIT_EXIST = 1037;
    int ERR_CODE_COMMUNICATION_ERROR = 1038;
    int ERR_CODE_INVALID_SBSCR_ID = 1039;
    int ERR_CODE_INVALID_AMOUNT = 1040;
    int ERR_CODE_INVALID_CURRENCY = 1041;
    int ERR_CODE_INVALID_RBL_PAYMENT_TYPE = 1042;
    int ERR_CODE_INVALID_RBL_TRX_SEQUENCE = 1043;
    int ERR_CODE_INVALID_SBSCR_STATUS = 1044;
    int ERR_CODE_INVALID_ACTIVE_TRX_ID = 1045;
    int ERR_CODE_ERROR_RISK_ONLY_CREATING_UPO = 1046;
    /**
     * The character set that the checksum calculation uses.
     */
    String CHARSET_UTF8 = "UTF-8";
    /**
     * Array of possible hexadecimal values.
     */
    char[] HEXADECIMAL = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * Response statuses Approved, Declined and Error are used by PhoneBet API and should not be changed, because they are in production use.
     */
    enum APIResponseStatus {

        SUCCESS("SUCCESS"), ERROR("ERROR"), Approved("Approved"), Declined("Declined"), Error("Error");

        private final String name;

        APIResponseStatus(final String name) {
            this.name = name;
        }

        /**
         * WARNING! Case insensitive!
         */
        public static APIResponseStatus getStatus(String status) {
            status = status.toUpperCase();

            if ("SUCCESS".equals(status)) {
                return SUCCESS;
            } else if ("ERROR".equals(status)) {
                return ERROR;
            } else if ("APPROVED".equals(status)) {
                return Approved;
            } else if ("DECLINED".equals(status)) {
                return Declined;
            } else {
                throw new IllegalArgumentException("Unknown status \"" + status + "\".");
            }
        }

        @Override
        public String toString() {
            return name;
        }
    }

    /**
     * This is the hash algorithm which is used to calculate the checksum. It's configured in the server per merchant site.
     */
    enum HashAlgorithm {
        MD5("MD5"), SHA256("SHA-256");

        private final String algorithm;

        HashAlgorithm(String algorithm) {
            this.algorithm = algorithm;
        }

        public String getAlgorithm() {
            return this.algorithm;
        }
    }

    /**
     * All possible Credit/Debit card transaction types.
     */
    enum TransactionType {
        Sale, Auth, Auth3D, Credit, Void, Sale3D, Settle, Refund, RiskOnly, PreAuth
    }

    /**
     * All types of order types.
     */
    enum OrderType {
        OPEN_ORDER, UPDATE_ORDER, AUTH_3D, PAYMENT_CC, PAYMENT_APM
    }

    /**
     * All API workflow types.
     */
    enum APIType {
        PAYMENT, WITHDRAW
    }

    /**
     * All server error types.
     */
    enum ErrorType {
        NO_ERROR, GENERIC_ERROR,
        INVALID_CHECKSUM,
        INVALID_TIMESTAMP,
        GENERAL_VALIDATION,
        COMMUNICATION_ERROR,
        ERR_CODE_INVALID_MERCHANT_SITE_ID,
        ERR_CODE_INVALID_ORDER_ID,
        ERR_CODE_NO_ORDER_ASSOCIATED_WITH_TOKEN,
        ERR_CODE_INVALID_ORDER_STATE,
        ERR_CODE_INVALID_AMOUNT,
        ERR_CODE_INVALID_CURRENCY,
        ERR_CODE_INVALID_TRX_TYPE,
        ERR_CODE_USED_SESSION_TOKEN,
        SESSION_EXPIRED,
        INVALID_TOKEN,
        INVALID_REQUEST,
        ERR_CODE_INVALID_USER_TOKEN,
        ERR_CODE_INVALID_CARD_DATA,
        ERR_CODE_MISSING_PAYMENT_DATA,
        ERR_CODE_AMBIGUOUS_PAYMENT_DATA,
        ERR_CODE_INVALID_UPO_DATA,
        ERR_CODE_USER_MANAGEMENT_OFF,
        ERR_CODE_INVALID_CARD_ISSUER,
        ERR_CODE_INVALID_CARD_TOKEN,
        ERR_CODE_INVALID_CARD_HOLDER_NAME,
        ERR_CODE_INVALID_CARD_CVV,
        ERR_CODE_INVALID_CARD_EXPIRE_DATE,
        ERR_CODE_INVALID_TOTAL_AMOUNT_VS_ITEM_AMOUNT,
        ERR_CODE_UPO_IS_NOT_ENABLED,
        ERR_CODE_UPO_STATUS_IS_NOT_ALLOWED,
        ERR_CODE_PM_IS_NOT_ENABLED,
        ERR_CODE_UPO_COUNT_LIMIT_REACHED,
        ERR_CODE_SINGLE_UPO_VALIDATION,
        ERR_CODE_NOT_SUPPORTED_CURRENCY,
        ERR_CODE_INVALID_MERCHANT_ID,
        ERR_CODE_UNEQUAL_AUTH3D_AND_PAY3D_AMOUNTS,
        ERR_CODE_INVALID_PA_RESPONSE,
        ERR_CODE_INVALID_ORDER_CURRENCY,
        ERR_CODE_INVALID_COUNTRY,
        ERR_CODE_INVALID_LANGUAGE_CODE,
        ERR_CODE_UPO_EXPIRED,
        ERR_CODE_REBILL_OFF,
        ERR_CODE_PM_NOT_SUPPORTED,
        ERROR_ACCESS_FORBIDDEN,
        ERROR_IP_ADDRESS_BLOCKED,
        MS_MANAGED3D_NOT_ENABLED,
        ERR_CODE_INVALID_USER_DETAILS_DATE_OF_BIRTH,
        ERR_CODE_INVALID_KYC_USER_DET_DATE_OF_BIRTH,
        ERR_CODE_INVALID_PARTIAL_APPROVAL_VAL,
        ERR_CODE_INVALID_CONVERT_NON_ENROLLED_VAL,
        ERR_CODE_FORBIDEN_CARD_DATA_BLOCK,
        ERR_CODE_INVALID_REQUEST_XSS_CONTENT,
        ERR_CODE_INVALID_CLIENT_REQUEST_ID,
        ERR_CODE_CLIENT_REQUEST_ID_USED,
        ERR_CODE_MERCHANT_NOT_OWN_TRX,
        ERR_CODE_TRX_NOT_SUPPORT_OPERATION,
        ERR_CODE_INVALID_WEBMSG_TXT,
        ERR_CODE_INVALID_WEBMSG_LOCALE,
        ERR_CODE_INVALID_RES_RANGE,
        ERR_CODE_UNKOWN_STATUS,
        ERR_CODE_INVALID_ACC_INFO_FIELD,
        ERR_CODE_MISSING_ACC_INFO_FIELD,
        ERR_CODE_PM_REGISTERED,
        ERR_CODE_INVALID_STATE,
        ERR_CODE_NO_SUCH_PROD_DESC,
        ERR_CODE_INVALID_SUBS_PLAN_ID,
        ERR_CODE_FORBIDEN_TCTOKEN,
        ERR_USR_DET_MANDATORY_FIELDS,
        ERR_CODE_INVALID_EMAIL,
        ERR_CODE_INVALID_LOCALE_CODE,
        ERR_CODE_INVALID_RELATED_TRX_ID,
        ERR_CODE_INVALID_METHOD_CODE,
        ERR_CODE_INVALID_CASINO,
        EXTERNAL_ERROR,
        ERR_CODE_REGISTRATION_FAILED,
        ERR_CODE_INVALID_COUNTRY_STATE,
        ERR_CODE_INVALID_VERIFICATION_STATUS,
        ERR_CODE_INVALID_VERIFICATION_METHOD,
        ERR_CODE_PM_ACCOUNT_DETAILS_NOT_FOUND,
        ERR_CODE_INVALID_DYNAMIC_3D_MODE,
        ERR_CODE_INVALID_IS_DYNAMIC_3D,
        ERR_CODE_INVALID_KYC_IDENTIFICATION_TYPE,
        ERR_CODE_MERCHANT_NOT_VERIFIED,
        ERR_CODE_MERCHANTSITE_DISABLED,
        ERR_CODE_INVALID_NUMBER_OF_ITEMS,
        ERR_UPO_PM_IS_NOT_AS_USED_PM,
        ERR_REBILLING_3D_NOT_OFF,
        ERR_REBILLING_3D_BLOCK_NOT_NEEDED,
        ERR_EXTERNAL_MPI_3D_NOT_OFF,
        ERR_INVALID_PM_TYPE,
        ERR_KYC_DOCUMENT_UPLOAD_DISABLED,
        ERR_CODE_INVALID_COUNTRY_IP_PROVIDED,
        ERR_CODE_ORIGIN_URL_INVALID,
        ERR_CODE_TRANSACTION_ALREADY_AUTOSETTLED,
        ERR_CODE_INVALID_RELATED_TRANSACTION_ID,
        ERR_CODE_NO_KYC_SERVICE_PROVIDER_FOR_COUNTRY,
        ERR_CODE_INVALID_ETP_TOKEN,
        ERR_CODE_FROZEN_UPO_VALIDATION,
        ERR_CODE_CHANNEL_HANDLING_AMBIGUOUS_DATA,
        ERR_CODE_NO_PAYMENT_IN_CURRENT_SESSION,
        ERR_CODE_CURRENCY_CONVERSION_NOT_SUPPORTED,
        ERR_CODE_INVALID_CRES,
        ERR_CODE_CHALLENGE_NOT_COMPLETED,
        ERR_CODE_NOT_AUTHENTICATED
    }

    /**
     * Order mappings names used in the checksum calculations. For more info check {@link ChecksumUtils}
     */
    enum ChecksumOrderMapping {
        API_GENERIC_CHECKSUM_MAPPING, USER_DETAILS, SETTLE_GW_TRANSACTION, REFUND_GW_TRANSACTION, VOID_GW_TRANSACTION, ADD_CASHIER_APM, ADD_CASHIER_CC_CARD, URL_DETAILS_CHECKSUM_MAPPING, CANCEL_CASHIER_SUBSCRIPTION, GET_CASHIER_SUBSCRIPTIONS, GET_CASHIER_SUBSCRIPTION_PLANS, GET_CASHIER_USER_INFO, MODIFY_CASHIER_USER, ADD_CASHIER_USER, ADD_CASHIER_CC_CARD_DATA, EDIT_CASHIER_CC_CARD, EDIT_CASHIER_APM, DELETE_UPO, SUSPEND_UPO, ENABLE_UPO
    }

    enum VerifiedPaymentMethod {
        VERIFIED("VERIFIED"), NOT_VERIFIED("NOT VERIFIED");

        private final String isVerified;

        VerifiedPaymentMethod(String isVerified) {
            this.isVerified = isVerified;
        }

        public String isVerified() {
            return this.isVerified;
        }
    }

    enum EditUpoBuilderType {
        APM, CCARD, DELETE, SUSPEND, ENABLE
    }
}
