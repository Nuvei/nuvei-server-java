package com.safecharge.biz;

import java.util.List;

import com.safecharge.exception.SafechargeConfigurationException;
import com.safecharge.exception.SafechargeException;
import com.safecharge.model.Addendums;
import com.safecharge.model.AmountDetails;
import com.safecharge.model.CashierUserDetails;
import com.safecharge.model.DeviceDetails;
import com.safecharge.model.DynamicDescriptor;
import com.safecharge.model.InitPaymentPaymentOption;
import com.safecharge.model.Item;
import com.safecharge.model.MerchantDetails;
import com.safecharge.model.MerchantInfo;
import com.safecharge.model.OpenOrderPaymentOption;
import com.safecharge.model.PaymentOption;
import com.safecharge.model.SubMerchant;
import com.safecharge.model.UrlDetails;
import com.safecharge.model.UserAddress;
import com.safecharge.model.UserPaymentOption;
import com.safecharge.model.Verify3dPaymentOption;
import com.safecharge.request.CardDetailsRequest;
import com.safecharge.request.SafechargeBaseRequest;
import com.safecharge.response.Authorize3dResponse;
import com.safecharge.response.CardDetailsResponse;
import com.safecharge.response.GetPaymentStatusResponse;
import com.safecharge.response.InitPaymentResponse;
import com.safecharge.response.OpenOrderResponse;
import com.safecharge.response.PaymentResponse;
import com.safecharge.response.RefundTransactionResponse;
import com.safecharge.response.SafechargeResponse;
import com.safecharge.response.SettleTransactionResponse;
import com.safecharge.response.Verify3dResponse;
import com.safecharge.response.VoidTransactionResponse;
import com.safecharge.util.Constants;

/**
 * Copyright (C) 2007-2020 SafeCharge International Group Limited.
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
    private SafechargeRequestExecutor requestExecutor;
    private MerchantInfo merchantInfo;
    private String sessionToken;

    public Safecharge() {
        this.serviceFactory = new ServiceFactory();
        this.requestExecutor = SafechargeRequestExecutor.getInstance();
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
     * @param serverHost  Points to the environment's URL to which to make the corresponding request. Currently can be either integration or production
     * @param algorithm   Hashing algorithm. Can be MD5 or SHA-256
     * @throws SafechargeConfigurationException if getting a session token isn't successful.
     * @throws SafechargeException              if there are request related problems.
     */
    public void initialize(String merchantId, String siteId, String merchantKey, String serverHost, Constants.HashAlgorithm algorithm) throws SafechargeException {
        merchantInfo = createMerchantInfo(merchantId, siteId, merchantKey, serverHost, algorithm);
        sessionToken = getSessionToken();
    }

    private MerchantInfo createMerchantInfo(String merchantId, String siteId, String merchantKey, String serverHost, Constants.HashAlgorithm algorithm) {
        return new MerchantInfo(merchantKey, merchantId, siteId, serverHost, algorithm);
    }

    private String getSessionToken() throws SafechargeException {
        RequestBuilder requestBuilder = serviceFactory.getRequestBuilder();
        SafechargeBaseRequest request = requestBuilder.getSessionTokenRequest(merchantInfo);
        SafechargeResponse response = requestExecutor.execute(request);
        if (Constants.APIResponseStatus.ERROR.equals(response.getStatus())) {
            throw new SafechargeConfigurationException(response.getReason());
        }

        return response.getSessionToken();
    }

    /**
     * <p>
     * This method should be used to create request for payment endpoint in Safecharge's REST API. The payment method is your endpoint for performing payment of any kind.
     * </p>
     *
     * @param userTokenId          This field uniquely identifies your consumer/user in your system.
     *                             Required if you wish to use the paymentOptionId field for future charging of this user without re-collecting the payment details
     * @param clientUniqueId       This ID identifies the transaction in your system. Optionally, you can pass this value
     *                             to us and we will store it with the transaction record created in our system for your future reference.
     * @param clientRequestId      The ID of the API request in the merchant’s system. This value must be unique, and though
     *                             not mandatory it is recommended that it is sent.
     * @param paymentOption        This class represents the details on the payment method.
     * @param isRebilling          When performing recurring/rebilling, use this field to indicate the recurring step.
     * @param currency             The three-character ISO currency code.
     * @param amount               The transaction amount. This amount must be identical to the amount listed in the dynamic3D.
     * @param amountDetails        Details for the amount. Note that the items and amountDetails prices should be summed up in
     *                             the amount parameter and sent separately.
     * @param items                An array describing the items in the purchase. The items price should be summed up to the amount parameter sent separately.
     * @param deviceDetails        The device details.
     * @param userDetails          The user details.
     * @param shippingAddress      Shipping address.
     * @param billingAddress       The billing address related to a user payment option.
     * @param dynamicDescriptor    The dynamicDescriptor is used to provide additional information for merchant name and phone.
     * @param merchantDetails      Merchant details
     * @param addendums            This block contains industry specific addendums. The addendum fields that appear are based on the specific addendum type.
     * @param urlDetails           Although DMN responses can be configured per merchant site, it allows dynamically returning the
     *                             DMN to the provided address per request.
     * @param customSiteName       The merchant’s site name. This is useful for merchants operating many websites that are distinguished only by name.
     * @param productId            A free text field used to identify the product/service sold. If this parameter is not
     *                             sent or is sent with an empty value, then it contains the concatenation of all item names up until the parameter maximum length.
     * @param customData           This parameter can be used to pass any type of information.
     *                             If sent in request, then is passed on to the payments gateway, is visible in SafeCharge’s
     *                             back-office tool transaction reporting and is returned in response.
     * @param relatedTransactionId Mandatory in some flows like 3DSecure v2.
     * @param transactionType      The type of transaction: Sale or Auth.
     * @param autoPayment3D        Autopayment3D flag.
     * @param isMoto               Set this field to “1” to mark the transaction as MOTO (mail order/telephone order).
     * @param subMerchant          Contains information about the SubMerchant.
     * @return Passes through the response from Safecharge's REST API.
     * @throws SafechargeConfigurationException If the {@link Safecharge#initialize(String, String, String, String, Constants.HashAlgorithm)}
     *                                          method is not invoked beforehand SafechargeConfigurationException exception will be thrown.
     * @throws SafechargeException              if there are request related problems.
     */
    public PaymentResponse payment(String userTokenId, String clientUniqueId, String clientRequestId, PaymentOption paymentOption, Integer isRebilling,
                                   String currency, String amount, AmountDetails amountDetails, List<Item> items, DeviceDetails deviceDetails,
                                   CashierUserDetails userDetails, UserAddress shippingAddress, UserAddress billingAddress, DynamicDescriptor dynamicDescriptor,
                                   MerchantDetails merchantDetails, Addendums addendums, UrlDetails urlDetails, String customSiteName, String productId,
                                   String customData, String relatedTransactionId, Constants.TransactionType transactionType, Boolean autoPayment3D,
                                   String isMoto, SubMerchant subMerchant) throws SafechargeException {
        ensureMerchantInfoAndSessionTokenNotNull();

        RequestBuilder requestBuilder = serviceFactory.getRequestBuilder();
        SafechargeBaseRequest request = requestBuilder.getPaymentRequest(merchantInfo, sessionToken, userTokenId, clientUniqueId, clientRequestId, paymentOption,
                isRebilling, currency, amount, amountDetails, items, deviceDetails, userDetails, shippingAddress, billingAddress,
                dynamicDescriptor, merchantDetails, addendums, urlDetails, customSiteName, productId, customData, relatedTransactionId,
                transactionType, autoPayment3D, isMoto, subMerchant);

        return (PaymentResponse) requestExecutor.execute(request);
    }

    private void ensureMerchantInfoAndSessionTokenNotNull() {
        if (merchantInfo == null || sessionToken == null) {
            throw new SafechargeConfigurationException("Missing mandatory info for execution of payments! Please run initialization method before creating payments.");
        }
    }

    /**
     * <p>
     * This method should be used to create request for initPayment endpoint in Safecharge's REST API. This method initiates the payment process for transactions.
     * </p>
     *
     * @param userTokenId     This field uniquely identifies your consumer/user in your system.
     *                        Required if you wish to use the paymentOptionId field for future charging of this user without re-collecting the payment details
     * @param clientUniqueId  This ID identifies the transaction in your system. Optionally, you can pass this value to
     *                        us and we will store it with the transaction record created in our system for your future reference.
     * @param clientRequestId The ID of the API request in merchant system.
     * @param currency        The ISO currency code.
     * @param amount          The transaction amount.
     * @param deviceDetails   The device details.
     * @param paymentOption   Card payment information inside the card sub-class
     * @param urlDetails      Although DMN responses can be configured per merchant site, it allows dynamically returning the
     *                        DMN to the provided address per request.
     * @param customData      General data about the customer provided by the merchant.
     * @param billingAddress  The billing address.
     * @return Passes through the response from Safecharge's REST API.
     * @throws SafechargeConfigurationException If the {@link Safecharge#initialize(String, String, String, String, Constants.HashAlgorithm)}
     *                                          method is not invoked beforehand SafechargeConfigurationException exception will be thrown.
     * @throws SafechargeException              if there are request related problems.
     */
    public InitPaymentResponse initPayment(String userTokenId, String clientUniqueId, String clientRequestId, String currency, String amount,
                                           DeviceDetails deviceDetails, InitPaymentPaymentOption paymentOption, UrlDetails urlDetails, String customData,
                                           UserAddress billingAddress) throws SafechargeException {
        ensureMerchantInfoAndSessionTokenNotNull();

        RequestBuilder requestBuilder = serviceFactory.getRequestBuilder();
        SafechargeBaseRequest request = requestBuilder.getInitPaymentRequest(sessionToken, userTokenId, clientUniqueId, clientRequestId, currency,
                amount, deviceDetails, paymentOption, urlDetails, customData, billingAddress, merchantInfo);

        return (InitPaymentResponse) requestExecutor.execute(request);
    }

    /**
     * <p>
     * This method should be used to create request for openOrder endpoint in Safecharge's REST API.
     * </p>
     *
     * @param userTokenId            This field uniquely identifies your consumer/user in your system.
     *                               Required if you wish to use the paymentOptionId field for future charging of this user without re-collecting the payment details
     * @param clientRequestId        ID of the API request in the merchant’s system.
     * @param clientUniqueId         ID of the transaction in the merchant’s system. This value must be unique.
     *                               This must be sent to perform future actions, such as reconciliation, identifying the transaction in the event of any issues, etc.
     * @param customSiteName         The merchant’s site name. This is useful for merchants operating many websites that are distinguished only by name.
     * @param productId              A free text field used to identify the product/service sold. If this parameter is not
     *                               sent or is sent with an empty value, then it contains the concatenation of all item names up until the parameter maximum length.
     * @param paymentOption
     * @param transactionType        The type of transaction
     * @param currency               The three-character ISO currency code.
     * @param amount                 The transaction amount.
     * @param items                  An array describing the items in the purchase. The items price should be summed up to the amount parameter sent separately.
     * @param deviceDetails          The device details.
     * @param userDetails            The user details.
     * @param shippingAddress        The shipping address.
     * @param billingAddress         The billing address.
     * @param dynamicDescriptor      The dynamicDescriptor is used to provide additional information for merchant name and phone.
     * @param merchantDetails        This allows the merchant to send information with the request to be saved in the API level and returned in response.
     * @param urlDetails             Although DMN responses can be configured per merchant site, it allows dynamically returning the
     *                               DMN to the provided address per request.
     * @param userPaymentOption
     * @param paymentMethod
     * @param amountDetails          The amount details.
     * @param addendums              This block contains industry specific addendums. The addendum fields that appear are based on the specific addendum type.
     * @param customData             This parameter can be used to pass any type of information.
     *                               If sent in request, then is passed on to the payments gateway, is visible in SafeCharge’s
     *                               back-office tool transaction reporting and is returned in response.
     * @param autoPayment3D          Autopayment3D flag.
     * @param isMoto                 When performing recurring/rebilling, use this field to indicate the recurring step
     * @param authenticationOnlyType
     * @param subMerchant            Contains information about the SubMerchant.
     * @param isRebilling            When performing recurring/rebilling, use this field to indicate the recurring step.
     * @param rebillingType
     * @param preventOverride
     * @return Passes through the response from Safecharge's REST API.
     * @throws SafechargeConfigurationException If the {@link Safecharge#initialize(String, String, String, String, Constants.HashAlgorithm)}
     *                                          method is not invoked beforehand SafechargeConfigurationException exception will be thrown.
     * @throws SafechargeException              if there are request related problems.
     */
    public OpenOrderResponse openOrder(String userTokenId, String clientRequestId, String clientUniqueId, String customSiteName, String productId,
                                       OpenOrderPaymentOption paymentOption, Constants.TransactionType transactionType, String currency, String amount,
                                       List<Item> items, DeviceDetails deviceDetails, CashierUserDetails userDetails, UserAddress shippingAddress,
                                       UserAddress billingAddress, DynamicDescriptor dynamicDescriptor, MerchantDetails merchantDetails,
                                       UrlDetails urlDetails, UserPaymentOption userPaymentOption, String paymentMethod, AmountDetails amountDetails,
                                       Addendums addendums, String customData, Boolean autoPayment3D, String isMoto, String authenticationOnlyType,
                                       SubMerchant subMerchant, Integer isRebilling, String rebillingType, String preventOverride) throws SafechargeException {
        ensureMerchantInfoAndSessionTokenNotNull();

        RequestBuilder requestBuilder = serviceFactory.getRequestBuilder();
        SafechargeBaseRequest request = requestBuilder.getOpenOrderRequest(merchantInfo, sessionToken, clientRequestId, customSiteName, productId,
                paymentOption, transactionType, currency, amount, items, deviceDetails, userDetails, shippingAddress, billingAddress,
                dynamicDescriptor, merchantDetails, urlDetails, userTokenId, clientUniqueId, userPaymentOption, paymentMethod,
                amountDetails, addendums, customData, autoPayment3D, isMoto, authenticationOnlyType, subMerchant, isRebilling, rebillingType, preventOverride);

        return (OpenOrderResponse) requestExecutor.execute(request);
    }

    /**
     * <p>
     * This method should be used to create request for getPaymentStatus endpoint in Safecharge's REST API. This method retrieves
     * the status of a payment recently performed. It receives the session ID and queries if a payment was performed.
     * </p>
     *
     * @return Passes through the response from Safecharge's REST API.
     * @throws SafechargeConfigurationException If the {@link Safecharge#initialize(String, String, String, String, Constants.HashAlgorithm)}
     *                                          method is not invoked beforehand SafechargeConfigurationException exception will be thrown.
     * @throws SafechargeException              if there are request related problems.
     */
    public GetPaymentStatusResponse getPaymentStatus() throws SafechargeException {
        ensureMerchantInfoAndSessionTokenNotNull();

        RequestBuilder requestBuilder = serviceFactory.getRequestBuilder();
        SafechargeBaseRequest request = requestBuilder.getPaymentStatusRequest(sessionToken, merchantInfo);

        return (GetPaymentStatusResponse) requestExecutor.execute(request);
    }

    /**
     * <p>
     * This method should be used to create request for voidTransaction endpoint in Safecharge's REST API.
     * </p>
     *
     * @param clientRequestId      ID of the API request in merchant system. This value must be unique.
     *                             This must be sent to perform future actions, such as reconciliation, identifying the transaction in the event of any issues, etc.
     * @param relatedTransactionId The ID of the original auth transaction.
     * @param amount               The transaction amount.
     * @param currency             The three-letter ISO currency code.
     * @param authCode             The authorisation code of the related settle transaction, to be compared to the original one.
     * @param clientUniqueId       The ID of the transaction in the merchant’s system. This value must be unique.
     *                             This must be sent to perform future actions, such as reconciliation, identifying the transaction in the event of any issues, etc.
     * @param urlDetails           Although DMN responses can be configured per merchant site, it allows dynamically returning the
     *                             DMN to the provided address per request.
     * @param customSiteName       The merchant’s site name. This is useful for merchants operating many websites that are distinguished only by name.
     * @param productId            A free text field used to identify the product/service sold. If this parameter is not
     *                             sent or is sent with an empty value, then it contains the concatenation of all item names up until the parameter maximum length.
     * @param customData           This parameter can be used to pass any type of information.
     *                             If sent in request, then is passed on to the payments gateway, is visible in SafeCharge’s
     *                             back-office tool transaction reporting and is returned in response.
     * @param comment              Enables the addition of a free text comment to the request.
     * @param subMerchant Contains information about the SubMerchant.
     * @return Passes through the response from Safecharge's REST API.
     * @throws SafechargeConfigurationException If the {@link Safecharge#initialize(String, String, String, String, Constants.HashAlgorithm)}
     *                                          method is not invoked beforehand SafechargeConfigurationException exception will be thrown.
     * @throws SafechargeException              if there are request related problems.
     */
    public VoidTransactionResponse voidTransaction(String clientRequestId, String relatedTransactionId, String amount, String currency,
                                                   String authCode, String clientUniqueId, UrlDetails urlDetails, String customSiteName,
                                                   String productId, String customData, String comment, SubMerchant subMerchant) throws SafechargeException {
        ensureMerchantInfoAndSessionTokenNotNull();

        RequestBuilder requestBuilder = serviceFactory.getRequestBuilder();
        SafechargeBaseRequest request = requestBuilder.getVoidTransactionRequest(sessionToken, clientRequestId, merchantInfo, relatedTransactionId,
                amount, currency, authCode, clientUniqueId, urlDetails, customSiteName, productId, customData, comment, subMerchant);

        return (VoidTransactionResponse) requestExecutor.execute(request);
    }

    /**
     * <p>
     * This method should be used to create request for settleTransaction endpoint in Safecharge's REST API. The settleTransaction
     * method is used for settling an authorisation transaction that was previously performed, with a two-phase Auth-Settle process, for either a full or partial settlements
     * </p>
     *
     * @param clientUniqueId          The ID of the transaction in the merchant’s system. This value must be unique.
     *                                This must be sent to perform future actions, such as reconciliation, identifying the transaction in the event of any issues, etc.
     * @param clientRequestId         ID of the API request in the merchant’s system. This value must be unique.
     *                                This must be sent to perform future actions, such as reconciliation, identifying the transaction in the event of any issues, etc.
     * @param addendums               This block contains industry specific addendums. The addendum fields that appear are based on the specific addendum type.
     * @param descriptorMerchantName  Allows the merchant to define a dynamic descriptor, which appears in the payment statement.
     * @param descriptorMerchantPhone Allows the merchant to define a dynamic descriptor, which appears in the payment statement.
     * @param urlDetails              Although DMN responses can be configured per merchant site, it allows dynamically returning the
     *                                DMN to the provided address per request.
     * @param amount                  The transaction amount.
     * @param authCode                The authorisation code of the original transaction to be refunded.
     * @param customData              This parameter can be used to pass any type of information.
     *                                If sent in request, then is passed on to the payments gateway, is visible in SafeCharge’s
     *                                back-office tool transaction reporting and is returned in response.
     * @param comment                 Enables the addition of a free text comment to the request.
     * @param currency                The three-letter ISO currency code.
     * @param customSiteName          The merchant’s site name. This is useful for merchants operating many websites that are distinguished only by name.
     * @param productId               A free text field used to identify the product/service sold. If this parameter is not
     *                                sent or is sent with an empty value, then it contains the concatenation of all item names up until the parameter maximum length.
     * @param relatedTransactionId    The ID of the original transaction to be settled.
     * @param subMerchant Contains information about the SubMerchant.
     * @return Passes through the response from Safecharge's REST API.
     * @throws SafechargeConfigurationException If the {@link Safecharge#initialize(String, String, String, String, Constants.HashAlgorithm)}
     *                                          method is not invoked beforehand SafechargeConfigurationException exception will be thrown.
     * @throws SafechargeException              if there are request related problems.
     */
    public SettleTransactionResponse settleTransaction(String clientUniqueId, String clientRequestId, Addendums addendums,
                                                       String descriptorMerchantName, String descriptorMerchantPhone,
                                                       UrlDetails urlDetails, String amount, String authCode, String customData,
                                                       String comment, String currency, String customSiteName, String productId,
                                                       String relatedTransactionId, SubMerchant subMerchant) throws SafechargeException {
        ensureMerchantInfoAndSessionTokenNotNull();

        RequestBuilder requestBuilder = serviceFactory.getRequestBuilder();
        SafechargeBaseRequest request = requestBuilder.getSettleTransactionRequest(sessionToken, merchantInfo, clientUniqueId, clientRequestId, addendums,
                descriptorMerchantName, descriptorMerchantPhone, urlDetails, amount, authCode, customData, comment, currency,
                customSiteName, productId, relatedTransactionId, subMerchant);

        return (SettleTransactionResponse) requestExecutor.execute(request);
    }

    /**
     * <p>
     * This method should be used to create request for refundTransaction endpoint in Safecharge's REST API.
     * </p>
     *
     * @param clientUniqueId       The ID of the transaction in the merchant’s system. This value must be unique.
     *                             This must be sent to perform future actions, such as reconciliation, identifying the transaction in the event of any issues, etc.
     * @param clientRequestId      ID of the API request in merchant system. This value must be unique.
     *                             This must be sent to perform future actions, such as reconciliation, identifying the transaction in the event of any issues, etc.
     * @param urlDetails           Although DMN responses can be configured per merchant site, it allows dynamically returning the
     *                             DMN to the provided address per request.
     * @param amount               The transaction amount.
     * @param authCode             The authorisation code of the related settle transaction, to be compared to the original one.
     * @param comment              Enables the addition of a free text comment to the request.
     * @param currency             The three-letter ISO currency code.
     * @param customData           This parameter can be used to pass any type of information.
     *                             If sent in request, then is passed on to the payments gateway, is visible in SafeCharge’s
     *                             back-office tool transaction reporting and is returned in response.
     * @param customSiteName       The merchant’s site name. This is useful for merchants operating many websites that are distinguished only by name.
     * @param productId            A free text field used to identify the product/service sold.
     *                             If this parameter is not sent or is sent with empty value, then it contains the concatenation
     *                             of all item names up until parameter maximum length.
     * @param relatedTransactionId The ID of the settle transaction.
     * @param subMerchant          Contains information about the SubMerchant.
     * @return Passes through the response from Safecharge's REST API.
     * @throws SafechargeConfigurationException If the {@link Safecharge#initialize(String, String, String, String, Constants.HashAlgorithm)}
     *                                          method is not invoked beforehand SafechargeConfigurationException exception will be thrown.
     * @throws SafechargeException              if there are request related problems.
     */
    public RefundTransactionResponse refundTransaction(String clientUniqueId, String clientRequestId, UrlDetails urlDetails,
                                                       String amount, String authCode, String comment, String currency, String customData,
                                                       String customSiteName, String productId, String relatedTransactionId, SubMerchant subMerchant) throws SafechargeException {
        ensureMerchantInfoAndSessionTokenNotNull();

        RequestBuilder requestBuilder = serviceFactory.getRequestBuilder();
        SafechargeBaseRequest request = requestBuilder.getRefundTransactionRequest(sessionToken, merchantInfo, clientUniqueId, clientRequestId,
                urlDetails, amount, authCode, comment, currency, customData, customSiteName, productId, relatedTransactionId, subMerchant);

        return (RefundTransactionResponse) requestExecutor.execute(request);
    }

    /**
     * <p>
     * Call this method if you need to use the SafeCharge MPI service to perform a 3D Secure only request. This method is called after the /authorize3d method in case of the Challenge.
     * </p>
     *
     * @param clientUniqueId       This ID identifies the transaction in your system. Optionally, you can pass this value to us
     *                             and we will store it with the transaction record created in our system for your future reference.
     * @param clientRequestId
     * @param amount               The transaction amount.
     * @param currency             The three-letter ISO currency code.
     * @param billingAddress       The billing address related to a user payment option. Since an order can contain only
     *                             one payment option, the billing address is part of the order parameters.
     * @param customData           This parameter can be used to pass any type of information.
     *                             If sent in request, then is passed on to the payments gateway, is visible in SafeCharge’s back-office
     *                             tool transaction reporting and is returned in response.
     * @param customSiteName       The merchant’s site name. This is useful for merchants operating many websites that are distinguished only by name.
     * @param merchantDetails
     * @param relatedTransactionId The transaction ID of the of the call to {@link Safecharge#authorize3d(String, String,
     *                             String, PaymentOption, Integer, String, String, AmountDetails, List, DeviceDetails, CashierUserDetails, UserAddress,
     *                             UserAddress, DynamicDescriptor, MerchantDetails, Addendums, UrlDetails, String, String, String, String,
     *                             Constants.TransactionType, Boolean, SubMerchant)}.
     * @param subMerchant          Contains information about the SubMerchant.
     * @param userId
     * @param userTokenId          This field uniquely identifies your consumer/user in your system.
     *                             Required if you wish to use the paymentOptionId field for future charging of this user without re-collecting the payment details
     * @param paymentOption        This class represents the details about the payment method.
     *                             Can have either card, alternativePaymentMethod, or userPaymentOptionId.
     * @return Passes through the response from Safecharge's REST API.
     * @throws SafechargeConfigurationException If the {@link Safecharge#initialize(String, String, String, String, Constants.HashAlgorithm)}
     *                                          method is not invoked beforehand SafechargeConfigurationException exception will be thrown.
     * @throws SafechargeException              if there are request related problems.
     */
    public Verify3dResponse verify3d(String clientUniqueId, String clientRequestId, String amount, String currency, UserAddress billingAddress,
                                     String customData, String customSiteName, MerchantDetails merchantDetails, String relatedTransactionId,
                                     SubMerchant subMerchant, String userId, String userTokenId, Verify3dPaymentOption paymentOption) throws SafechargeException {
        ensureMerchantInfoAndSessionTokenNotNull();

        RequestBuilder requestBuilder = serviceFactory.getRequestBuilder();
        SafechargeBaseRequest request = requestBuilder.getVerify3dResquest(sessionToken, merchantInfo, clientUniqueId, clientRequestId, amount,
                currency, billingAddress, customData, customSiteName, merchantDetails, relatedTransactionId, subMerchant, userId,
                userTokenId, paymentOption);

        return (Verify3dResponse) requestExecutor.execute(request);
    }

    /**
     * <p>
     * Call this method if you need to use the SafeCharge MPI service to perform a 3D Secure only request. This method is
     * called after the /initPayment method and returns the information regarding whether the merchant has to perform a
     * Challenge or if they receive a frictionless response.
     * </p>
     *
     * @param userTokenId          This field uniquely identifies your consumer/user in your system.
     *                             Required if you wish to use the paymentOptionId field for future charging of this user without re-collecting the payment details
     * @param clientUniqueId       This ID identifies the transaction in your system. Optionally, you can pass this value
     *                             to us and we will store it with the transaction record created in our system for your future reference.
     * @param clientRequestId      Use this advanced field to prevent idempotency. Use it to uniquely identify the request
     *                             you are submitting. If our system receives two calls with the same clientRequestId, it refuses the second call as it will assume idempotency.
     * @param paymentOption        This class represents the details about the payment method. Can have either card,
     *                             alternativePaymentMethod, or userPaymentOptionId.
     * @param isRebilling          When performing recurring/rebilling, use this field to indicate the recurring step.
     * @param currency             The three-character ISO currency code.
     * @param amount               The transaction amount.
     *                             This amount must be identical to the amount listed in the dynamic3D.
     * @param amountDetails        Details for the amount. Note that the items and amountDetails prices should be summed up in
     *                             the amount parameter and sent separately.
     * @param items                An array describing the items in the purchase. The items price should be summed up to the amount parameter sent separately.
     * @param deviceDetails        The device details.
     * @param userDetails          The user details.
     * @param shippingAddress      The shipping details.
     * @param billingAddress       The billing details.
     * @param dynamicDescriptor    The dynamicDescriptor is used to provide additional information for merchant name and phone.
     * @param merchantDetails      The merchant details.
     * @param addendums            This block contains industry specific addendums. The addendum fields that appear are based on the specific addendum type.
     * @param urlDetails           Although DMN responses can be configured per merchant site, it allows dynamically returning the
     *                             DMN to the provided address per request.
     * @param customSiteName       The merchant’s site name. This is useful for merchants operating many websites that are
     *                             distinguished only by name.
     * @param productId            A free text field used to identify the product/service sold. If this parameter is not
     *                             sent or is sent with an empty value, then it contains the concatenation of all item names up until the parameter maximum length.
     * @param customData           This parameter can be used to pass any type of information.
     *                             If sent in request, then is passed on to the payments gateway, is visible in SafeCharge’s
     *                             back-office tool transaction reporting and is returned in response.
     * @param relatedTransactionId Sets the transactionId returned from the preceding initPayment call.
     * @param transactionType      The type of transaction
     * @param autoPayment3D        Autopayment3D flag.
     * @param subMerchant          Contains information about the SubMerchant.
     * @return Passes through the response from Safecharge's REST API.
     * @throws SafechargeConfigurationException If the {@link Safecharge#initialize(String, String, String, String, Constants.HashAlgorithm)}
     *                                          method is not invoked beforehand SafechargeConfigurationException exception will be thrown.
     * @throws SafechargeException              if there are request related problems.
     */
    public Authorize3dResponse authorize3d(String userTokenId, String clientUniqueId, String clientRequestId, PaymentOption paymentOption,
                                           Integer isRebilling, String currency, String amount, AmountDetails amountDetails,
                                           List<Item> items, DeviceDetails deviceDetails, CashierUserDetails userDetails,
                                           UserAddress shippingAddress, UserAddress billingAddress, DynamicDescriptor dynamicDescriptor,
                                           MerchantDetails merchantDetails, Addendums addendums, UrlDetails urlDetails,
                                           String customSiteName, String productId, String customData, String relatedTransactionId,
                                           Constants.TransactionType transactionType, Boolean autoPayment3D, SubMerchant subMerchant) throws SafechargeException {
        ensureMerchantInfoAndSessionTokenNotNull();

        RequestBuilder requestBuilder = serviceFactory.getRequestBuilder();
        SafechargeBaseRequest request = requestBuilder.getAuthorize3dRequest(merchantInfo, sessionToken, userTokenId, clientUniqueId,
                clientRequestId, paymentOption, isRebilling, currency, amount, amountDetails, items, deviceDetails, userDetails,
                shippingAddress, billingAddress, dynamicDescriptor, merchantDetails, addendums, urlDetails, customSiteName,
                productId, customData, relatedTransactionId, transactionType, autoPayment3D, subMerchant);

        return (Authorize3dResponse) requestExecutor.execute(request);
    }

    /**
     * @param clientUniqueId  This ID identifies the transaction in your system. Optionally, you can pass this value to us
     *                        and we will store it with the transaction record created in our system for your future reference.
     * @param clientRequestId The ID of the API request in the merchant’s system. This value must be unique.
     * @param cardNumber      This field can accept both cardNumber and card BIN number.
     * @return Passes through the response from Safecharge's REST API.
     * @throws SafechargeConfigurationException If the {@link Safecharge#initialize(String, String, String, String, Constants.HashAlgorithm)}
     *                                          method is not invoked beforehand SafechargeConfigurationException exception will be thrown.
     * @throws SafechargeException              if there are request related problems.
     */
    public CardDetailsResponse getCardDetails(String clientUniqueId, String clientRequestId, String cardNumber) throws SafechargeException {
        ensureMerchantInfoAndSessionTokenNotNull();

        RequestBuilder requestBuilder = serviceFactory.getRequestBuilder();
        CardDetailsRequest request = requestBuilder.getCardDetailsRequest(sessionToken, merchantInfo, clientUniqueId, clientRequestId, cardNumber);

        return (CardDetailsResponse) requestExecutor.execute(request);
    }
}
