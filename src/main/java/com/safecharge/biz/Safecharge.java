package com.safecharge.biz;

import com.safecharge.exception.SafechargeConfigurationException;
import com.safecharge.model.*;
import com.safecharge.response.GetSessionTokenResponse;
import com.safecharge.response.SafechargeResponse;
import com.safecharge.util.APIConstants;
import com.safecharge.util.Constants;

import java.util.List;

/**
 * Copyright (C) 2007-2019 SafeCharge International Group Limited.
 * <p>
 * This class is a wrapper for the most used endpoints in Safecharge's REST API. It makes it easier to execute openOrder,
 * initPayment and createPayment requests. First you have to invoke initialize method and then choose the corresponding request
 * method.
 * </p>
 *
 * @author <a mailto:vasiln@safecharge.com>Vassil Nikov</a>
 */
public class Safecharge {

    private final ServiceFactory serviceFactory;
    private MerchantInfo merchantInfo;
    private String sessionToken;

    public Safecharge() {
        this.serviceFactory = new ServiceFactory();
    }

    /**
     * <p>
     * This method should always be invoked before any other method from this class. It takes care of setting up MerchantInfo
     * object and getting the mandatory sessionToken.
     * </p>
     *
     * @param merchantId  The id corresponding to the merchant's GwId in Safecharge's system
     * @param siteId      The Merchant site id in Safecharge's system
     * @param merchantKey The merchant key in Safecharge's system
     * @param environment Points to the environment's URL to which to make the corresponding request. Currently can be either integration or production
     * @param algorithm   Hashing algorithm. Can be MD5 or SHA-256
     */
    public void initialize(String merchantId, String siteId, String merchantKey, APIConstants.Environment environment, Constants.HashAlgorithm algorithm) {
        merchantInfo = createMerchantInfo(merchantId, siteId, merchantKey, environment, algorithm);
        sessionToken = getSessionToken();
    }

    private MerchantInfo createMerchantInfo(String merchantId, String siteId, String merchantKey, APIConstants.Environment environment, Constants.HashAlgorithm algorithm) {
        return new MerchantInfo(merchantKey, merchantId, siteId, environment.getUrl(), algorithm);
    }

    private String getSessionToken() {
        PaymentService service = serviceFactory.getPaymentService();
        GetSessionTokenResponse response = service.getSessionTokenresponse(merchantInfo);
        if (Constants.APIResponseStatus.ERROR.equals(response.getStatus())) {
            throw new SafechargeConfigurationException(response.getReason());
        }
        return response.getSessionToken();
    }

    /**
     * <p>
     *     This method should be used to create request for payment endpoint in Safecharge's REST API.
     * </p>
     * @param userTokenId
     * @param clientUniqueId
     * @param clientRequestId
     * @param paymentOption
     * @param isRebilling
     * @param currency
     * @param amount
     * @param amountDetails
     * @param items
     * @param deviceDetails
     * @param userDetails
     * @param shippingAddress
     * @param billingAddress
     * @param dynamicDescriptor
     * @param merchantDetails
     * @param addendums
     * @param urlDetails
     * @param customSiteName
     * @param productId
     * @param customData
     * @param relatedTransactionId
     * @param transactionType
     * @param autoPayment3D
     * @param sourceApplication
     * @param isMoto
     * @param internalRequestId
     * @return Passes through the response from Safecharge's REST API.
     * @throws SafechargeConfigurationException If the {@link Safecharge#initialize(String, String, String, APIConstants.Environment, Constants.HashAlgorithm)}
     * method is not invoked beforehand this exception will be thrown
     */
    public SafechargeResponse createPayment(String userTokenId, String clientUniqueId, String clientRequestId, PaymentOption paymentOption, Integer isRebilling,
                                            String currency, String amount, AmountDetails amountDetails, List<Item> items, DeviceDetails deviceDetails,
                                            CashierUserDetails userDetails, UserAddress shippingAddress, UserAddress billingAddress, DynamicDescriptor dynamicDescriptor,
                                            MerchantDetails merchantDetails, Addendums addendums, UrlDetails urlDetails, String customSiteName, String productId,
                                            String customData, String relatedTransactionId, Constants.TransactionType transactionType, Boolean autoPayment3D, String sourceApplication,
                                            String isMoto, String internalRequestId) {
        ensureMerchantInfoAndSessionTokenNotNull();

        PaymentService service = serviceFactory.getPaymentService();
        SafechargeResponse response = service.getPaymentResponse(merchantInfo, sessionToken, userTokenId, clientUniqueId, clientRequestId, paymentOption,
                isRebilling, currency, amount, amountDetails, items, deviceDetails, userDetails, shippingAddress, billingAddress,
                dynamicDescriptor, merchantDetails, addendums, urlDetails, customSiteName, productId, customData, relatedTransactionId,
                transactionType, autoPayment3D, sourceApplication, isMoto, internalRequestId);

        return response;
    }

    private void ensureMerchantInfoAndSessionTokenNotNull() {
        if (merchantInfo == null || sessionToken == null) {
            throw new SafechargeConfigurationException("Missing mandatory info for execution of payments! Please run initialization method before creating payments.");
        }
    }

    /**
     * <p>
     *     This method should be used to create request for initPayment endpoint in Safecharge's REST API.
     * </p>
     * @param userTokenId
     * @param clientUniqueId
     * @param clientRequestId
     * @param currency
     * @param amount
     * @param deviceDetails
     * @param paymentOption
     * @param urlDetails
     * @param customData
     * @param billingAddress
     * @param sourceApplication
     * @param internalRequestId
     * @return Passes through the response from Safecharge's REST API.
     * @throws SafechargeConfigurationException If the {@link Safecharge#initialize(String, String, String, APIConstants.Environment, Constants.HashAlgorithm)}
     * method is not invoked beforehand this exception will be thrown
     */
    public SafechargeResponse createInitPayment(String userTokenId, String clientUniqueId, String clientRequestId, String currency, String amount,
                                                DeviceDetails deviceDetails, InitPaymentPaymentOption paymentOption, UrlDetails urlDetails, String customData,
                                                UserAddress billingAddress, String sourceApplication, String internalRequestId) {
        ensureMerchantInfoAndSessionTokenNotNull();
        MerchantBaseInfo merchant = new MerchantBaseInfo(merchantInfo.getMerchantKey(), merchantInfo.getServerHost(), merchantInfo.getHashAlgorithm());

        PaymentService service = serviceFactory.getPaymentService();
        SafechargeResponse response = service.getInitPaymentResponse(sessionToken, userTokenId, clientUniqueId, clientRequestId, currency,
                amount, deviceDetails, paymentOption, urlDetails, customData, billingAddress, sourceApplication, merchant, internalRequestId);

        return response;
    }

    /**
     * <p>
     *     This method should be used to create request for openOrder endpoint in Safecharge's REST API.
     * </p>
     * @param userTokenId
     * @param clientRequestId
     * @param clientUniqueId
     * @param customSiteName
     * @param productId
     * @param paymentOption
     * @param transactionType
     * @param currency
     * @param amount
     * @param items
     * @param deviceDetails
     * @param userDetails
     * @param shippingAddress
     * @param billingAddress
     * @param dynamicDescriptor
     * @param merchantDetails
     * @param urlDetails
     * @param userPaymentOption
     * @param paymentMethod
     * @param amountDetails
     * @param addendums
     * @param customData
     * @param autoPayment3D
     * @param sourceApplication
     * @param isMoto
     * @param internalRequestId
     * @return Passes through the response from Safecharge's REST API.
     * @throws SafechargeConfigurationException If the {@link Safecharge#initialize(String, String, String, APIConstants.Environment, Constants.HashAlgorithm)}
     * method is not invoked beforehand this exception will be thrown
     */
    public SafechargeResponse createOpenOrder(String userTokenId, String clientRequestId, String clientUniqueId, String customSiteName, String productId,
                                              OpenOrderPaymentOption paymentOption, Constants.TransactionType transactionType, String currency, String amount,
                                              List<Item> items, DeviceDetails deviceDetails, CashierUserDetails userDetails, UserAddress shippingAddress,
                                              UserAddress billingAddress, DynamicDescriptor dynamicDescriptor, MerchantDetails merchantDetails,
                                              UrlDetails urlDetails, UserPaymentOption userPaymentOption, String paymentMethod, AmountDetails amountDetails,
                                              Addendums addendums, String customData, Boolean autoPayment3D, String sourceApplication, String isMoto,
                                              String internalRequestId) {
        ensureMerchantInfoAndSessionTokenNotNull();

        PaymentService service = serviceFactory.getPaymentService();
        SafechargeResponse response = service.getOpenOrderResponse(merchantInfo, sessionToken, clientRequestId, customSiteName, productId,
                paymentOption, transactionType, currency, amount, items, deviceDetails, userDetails, shippingAddress, billingAddress,
                dynamicDescriptor, merchantDetails, urlDetails, userTokenId, clientUniqueId, userPaymentOption, paymentMethod,
                amountDetails, addendums, customData, autoPayment3D, sourceApplication, isMoto, internalRequestId);

        return response;
    }

    /**
     * <p>
     *     This method should be used to create request for getPaymentStatus endpoint in Safecharge's REST API.
     * </p>
     *
     * @param clientRequestId
     * @param internalRequestId
     * @return Passes through the response from Safecharge's REST API.
     * @throws SafechargeConfigurationException If the {@link Safecharge#initialize(String, String, String, APIConstants.Environment, Constants.HashAlgorithm)}
     * method is not invoked beforehand this exception will be thrown
     */
    public SafechargeResponse createPaymentStatus(String clientRequestId, String internalRequestId) {
        ensureMerchantInfoAndSessionTokenNotNull();

        PaymentService service = serviceFactory.getPaymentService();
        SafechargeResponse response = service.getPaymentStatusResponse(sessionToken, clientRequestId, merchantInfo, internalRequestId);

        return response;
    }

    /**
     * <p>
     *     This method should be used to create request for voidTransaction endpoint in Safecharge's REST API.
     * </p>
     *
     * @param clientRequestId
     * @param relatedTransactionId
     * @param amount
     * @param currency
     * @param authCode
     * @param clientUniqueId
     * @param urlDetails
     * @param customSiteName
     * @param productId
     * @param customData
     * @param sourceApplication
     * @param comment
     * @param internalRequestId
     * @return Passes through the response from Safecharge's REST API.
     * @throws SafechargeConfigurationException If the {@link Safecharge#initialize(String, String, String, APIConstants.Environment, Constants.HashAlgorithm)}
     *  method is not invoked beforehand this exception will be thrown
     */
    public SafechargeResponse createVoidTransaction(String clientRequestId, String relatedTransactionId, String amount, String currency,
                                                    String authCode, String clientUniqueId, UrlDetails urlDetails, String customSiteName,
                                                    String productId, String customData, String sourceApplication, String comment,
                                                    String internalRequestId) {
        ensureMerchantInfoAndSessionTokenNotNull();

        PaymentService service = serviceFactory.getPaymentService();
        SafechargeResponse response = service.getVoidTransactionResponse(sessionToken, clientRequestId, merchantInfo, relatedTransactionId,
                amount, currency, authCode, clientUniqueId, urlDetails, customSiteName, productId, customData, sourceApplication,
                comment, internalRequestId);

        return response;
    }

    /**
     * <p>
     *     This method should be used to create request for settleTransaction endpoint in Safecharge's REST API.
     * </p>
     * @param clientUniqueId
     * @param clientRequestId
     * @param addendums
     * @param descriptorMerchantName
     * @param descriptorMerchantPhone
     * @param dynamicDescriptor
     * @param urlDetails
     * @param amount
     * @param authCode
     * @param customData
     * @param comment
     * @param currency
     * @param customSiteName
     * @param productId
     * @param relatedTransactionid
     * @param sourceApplication
     * @param internalRequestId
     * @return Passes through the response from Safecharge's REST API.
     * @throws SafechargeConfigurationException If the {@link Safecharge#initialize(String, String, String, APIConstants.Environment, Constants.HashAlgorithm)}
     * method is not invoked beforehand this exception will be thrown
     */
    public SafechargeResponse createSettleTransaction(String clientUniqueId, String clientRequestId, Addendums addendums,
                                                      String descriptorMerchantName, String descriptorMerchantPhone, DynamicDescriptor dynamicDescriptor,
                                                      UrlDetails urlDetails, String amount, String authCode, String customData,
                                                      String comment, String currency, String customSiteName, String productId,
                                                      String relatedTransactionid, String sourceApplication, String internalRequestId) {
        ensureMerchantInfoAndSessionTokenNotNull();

        PaymentService service = serviceFactory.getPaymentService();
        SafechargeResponse response = service.getSettleTransactionResponse(sessionToken, merchantInfo, clientUniqueId, clientRequestId, addendums,
                descriptorMerchantName, descriptorMerchantPhone, dynamicDescriptor, urlDetails, amount, authCode, customData, comment, currency,
                customSiteName, productId, relatedTransactionid, sourceApplication, internalRequestId);

        return response;
    }

    /**
     * <p>
     *     This method should be used to create request for refundTransaction endpoint in Safecharge's REST API.
     * </p>
     * @param clientUniqueId
     * @param clientRequestId
     * @param urlDetails
     * @param amount
     * @param authCode
     * @param comment
     * @param currency
     * @param customData
     * @param customSiteName
     * @param productId
     * @param relatedTransactionId
     * @param sourceApplication
     * @param internalRequestId
     * @return Passes through the response from Safecharge's REST API.
     * @throws SafechargeConfigurationException If the {@link Safecharge#initialize(String, String, String, APIConstants.Environment, Constants.HashAlgorithm)}
     * method is not invoked beforehand this exception will be thrown
     */
    public SafechargeResponse createRefundTransaction(String clientUniqueId, String clientRequestId, UrlDetails urlDetails,
                                                      String amount, String authCode, String comment, String currency, String customData,
                                                      String customSiteName, String productId, String relatedTransactionId,
                                                      String sourceApplication, String internalRequestId) {
        ensureMerchantInfoAndSessionTokenNotNull();

        PaymentService service = serviceFactory.getPaymentService();
        SafechargeResponse response = service.getRefundTransactionResponse(sessionToken, merchantInfo, clientUniqueId, clientRequestId,
                urlDetails, amount, authCode, comment, currency, customData, customSiteName, productId, relatedTransactionId,
                sourceApplication, internalRequestId);

        return response;
    }
}
