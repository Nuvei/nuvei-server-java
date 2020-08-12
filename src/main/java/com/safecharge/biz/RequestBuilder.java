package com.safecharge.biz;

import java.util.List;

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
import com.safecharge.request.Authorize3dRequest;
import com.safecharge.request.CardDetailsRequest;
import com.safecharge.request.GetPaymentStatusRequest;
import com.safecharge.request.GetSessionTokenRequest;
import com.safecharge.request.InitPaymentRequest;
import com.safecharge.request.OpenOrderRequest;
import com.safecharge.request.PaymentRequest;
import com.safecharge.request.RefundTransactionRequest;
import com.safecharge.request.SafechargeBaseRequest;
import com.safecharge.request.SettleTransactionRequest;
import com.safecharge.request.Verify3dRequest;
import com.safecharge.request.VoidTransactionRequest;
import com.safecharge.util.Constants;

/**
 * Copyright (C) 2007-2020 SafeCharge International Group Limited.
 */
public class RequestBuilder {

    public SafechargeBaseRequest getSessionTokenRequest(MerchantInfo merchantInfo) {
        return GetSessionTokenRequest.builder()
                .addMerchantInfo(merchantInfo)
                .build();
    }

    public SafechargeBaseRequest getPaymentRequest(MerchantInfo merchantInfo, String sessionToken, String userTokenId, String clientUniqueId,
                                                   String clientRequestId, PaymentOption paymentOption, Integer isRebilling, String currency,
                                                   String amount, AmountDetails amountDetails, List<Item> items, DeviceDetails deviceDetails,
                                                   CashierUserDetails userDetails, UserAddress shippingAddress, UserAddress billingAddress,
                                                   DynamicDescriptor dynamicDescriptor, MerchantDetails merchantDetails, Addendums addendums,
                                                   UrlDetails urlDetails, String customSiteName, String productId, String customData,
                                                   String relatedTransactionId, Constants.TransactionType transactionType, Boolean autoPayment3D,
                                                   String isMoto, SubMerchant subMerchant) {
        return PaymentRequest.builder()
                .addSessionToken(sessionToken)
                .addIsRebilling(isRebilling)
                .addPaymentOption(paymentOption)
                .addAddendums(addendums)
                .addAmountDetails(amountDetails)
                .addBillingDetails(billingAddress)
                .addDeviceDetails(deviceDetails)
                .addDynamicDescriptor(dynamicDescriptor)
                .addItems(items)
                .addMerchantDetails(merchantDetails)
                .addShippingDetails(shippingAddress)
                .addMerchantInfo(merchantInfo)
                .addURLDetails(urlDetails)
                .addUserDetails(userDetails)
                .addAmount(amount)
                .addClientRequestId(clientRequestId)
                .addClientUniqueId(clientUniqueId)
                .addCurrency(currency)
                .addUserTokenId(userTokenId)
                .addCustomSiteName(customSiteName)
                .addProductId(productId)
                .addCustomData(customData)
                .addRelatedTransactionId(relatedTransactionId)
                .addTransactionType(transactionType)
                .addAutoPayment3D(autoPayment3D)
                .addIsMoto(isMoto)
                .addSubMerchant(subMerchant)
                .build();
    }

    public SafechargeBaseRequest getInitPaymentRequest(String sessionToken, String userTokenId, String clientUniqueId, String clientRequestId, String currency,
                                                       String amount, DeviceDetails deviceDetails, InitPaymentPaymentOption paymentOption, UrlDetails urlDetails,
                                                       String customData, UserAddress billingAddress,
                                                       MerchantInfo merchantInfo) {
        return InitPaymentRequest.builder()
                .addSessionToken(sessionToken)
                .addUserTokenId(userTokenId)
                .addClientRequestId(clientRequestId)
                .addClientUniqueId(clientUniqueId)
                .addCurrency(currency)
                .addAmount(amount)
                .addDeviceDetails(deviceDetails)
                .addInitPaymentPaymentOption(paymentOption)
                .addUrlDetails(urlDetails)
                .addCustomData(customData)
                .addBillingAddress(billingAddress)
                .addMerchantInfo(merchantInfo)
                .build();
    }

    public SafechargeBaseRequest getOpenOrderRequest(MerchantInfo merchantInfo, String sessionToken, String clientRequestId, String customSiteName,
                                                     String productId, OpenOrderPaymentOption paymentOption, Constants.TransactionType transactionType,
                                                     String currency, String amount, List<Item> items, DeviceDetails deviceDetails, CashierUserDetails userDetails,
                                                     UserAddress shippingAddress, UserAddress billingAddress, DynamicDescriptor dynamicDescriptor, MerchantDetails merchantDetails,
                                                     UrlDetails urlDetails, String userTokenId, String clientUniqueId, UserPaymentOption userPaymentOption,
                                                     String paymentMethod, AmountDetails amountDetails, Addendums addendums, String customData, Boolean autoPayment3D,
                                                     String isMoto, String authenticationOnlyType, SubMerchant subMerchant, Integer isRebilling, String rebillingType, String preventOverride) {
        return OpenOrderRequest.builder()
                .addMerchantInfo(merchantInfo)
                .addSessionToken(sessionToken)
                .addClientRequestId(clientRequestId)
                .addClientUniqueId(clientUniqueId)
                .addCustomSiteName(customSiteName)
                .addProductId(productId)
                .addOpenOrderPaymentOption(paymentOption)
                .addTransactionType(transactionType)
                .addAddendums(addendums)
                .addAmountDetails(amountDetails)
                .addAmount(amount)
                .addBillingDetails(billingAddress)
                .addDeviceDetails(deviceDetails)
                .addDynamicDescriptor(dynamicDescriptor)
                .addItems(items)
                .addMerchantDetails(merchantDetails)
                .addShippingDetails(shippingAddress)
                .addURLDetails(urlDetails)
                .addCurrency(currency)
                .addUserDetails(userDetails)
                .addUserTokenId(userTokenId)
                .addPaymentMethod(paymentMethod)
                .addUserPaymentOption(userPaymentOption)
                .addCustomData(customData)
                .addAutoPayment3D(autoPayment3D)
                .addIsMoto(isMoto)
                .addAuthenticationOnlyType(authenticationOnlyType)
                .addSubMerchant(subMerchant)
                .addIsRebilling(isRebilling)
                .addRebillingType(rebillingType)
                .addPreventOverride(preventOverride)
                .build();
    }

    public SafechargeBaseRequest getPaymentStatusRequest(String sessionToken, MerchantInfo merchantInfo) {
        return GetPaymentStatusRequest.builder()
                .addSessionToken(sessionToken)
                .addMerchantInfo(merchantInfo)
                .build();
    }

    public SafechargeBaseRequest getVoidTransactionRequest(String sessionToken, String clientRequestId, MerchantInfo merchantInfo,
                                                           String relatedTransactionId, String amount, String currency, String authCode,
                                                           String clientUniqueId, UrlDetails urlDetails, String customSiteName,
                                                           String productId, String customData, String comment, SubMerchant subMerchant) {
        return VoidTransactionRequest.builder()
                .addMerchantInfo(merchantInfo)
                .addSessionToken(sessionToken)
                .addRelatedTransactionId(relatedTransactionId)
                .addAmount(amount)
                .addCurrency(currency)
                .addComment(comment)
                .addClientUniqueId(clientUniqueId)
                .addURLDetails(urlDetails)
                .addCustomSiteName(customSiteName)
                .addProductId(productId)
                .addCustomData(customData)
                .addClientRequestId(clientRequestId)
                .addAuthCode(authCode)
                .addSubMerchant(subMerchant)
                .build();
    }

    public SafechargeBaseRequest getSettleTransactionRequest(String sessionToken, MerchantInfo merchantInfo, String clientUniqueId,
                                                             String clientRequestId, Addendums addendums, String descriptorMerchantName,
                                                             String descriptorMerchantPhone,
                                                             UrlDetails urlDetails, String amount, String authCode, String customData,
                                                             String comment, String currency, String customSiteName, String productId,
                                                             String relatedTransactionId, SubMerchant subMerchant) {
        return SettleTransactionRequest.builder()
                .addMerchantInfo(merchantInfo)
                .addClientUniqueId(clientUniqueId)
                .addClientRequestId(clientRequestId)
                .addSessionToken(sessionToken)
                .addAddendums(addendums)
                .addDescriptorMerchantName(descriptorMerchantName)
                .addDescriptorMerchantPhone(descriptorMerchantPhone)
                .addURLDetails(urlDetails)
                .addAmount(amount)
                .addAuthCode(authCode)
                .addComment(comment)
                .addCurrency(currency)
                .addCustomData(customData)
                .addCustomSiteName(customSiteName)
                .addProductId(productId)
                .addRelatedTransactionId(relatedTransactionId)
                .addSubMerchant(subMerchant)
                .build();
    }

    public SafechargeBaseRequest getRefundTransactionRequest(String sessionToken, MerchantInfo merchantInfo, String clientUniqueId,
                                                             String clientRequestId, UrlDetails urlDetails, String amount, String authCode,
                                                             String comment, String currency, String customData, String customSiteName,
                                                             String productId, String relatedTransactionId, SubMerchant subMerchant) {
        return RefundTransactionRequest.builder()
                .addSessionToken(sessionToken)
                .addMerchantInfo(merchantInfo)
                .addClientUniqueId(clientUniqueId)
                .addClientRequestId(clientRequestId)
                .addURLDetails(urlDetails)
                .addAmount(amount)
                .addAuthCode(authCode)
                .addComment(comment)
                .addCurrency(currency)
                .addCustomData(customData)
                .addCustomSiteName(customSiteName)
                .addProductId(productId)
                .addRelatedTransactionId(relatedTransactionId)
                .addSubMerchant(subMerchant)
                .build();
    }

    public SafechargeBaseRequest getVerify3dResquest(String sessionToken, MerchantInfo merchantInfo, String clientUniqueId, String clientRequestId,
                                                     String amount, String currency, UserAddress billingAddress, String customData,
                                                     String customSiteName, MerchantDetails merchantDetails, String relatedTransactionId,
                                                     SubMerchant subMerchant, String userId, String userTokenId, Verify3dPaymentOption paymentOption) {
        return Verify3dRequest.builder()
                .addSessionToken(sessionToken)
                .addMerchantInfo(merchantInfo)
                .addClientUniqueId(clientUniqueId)
                .addClientRequestId(clientRequestId)
                .addAmount(amount)
                .addCurrency(currency)
                .addBillingAddress(billingAddress)
                .addCustomData(customData)
                .addCustomSiteName(customSiteName)
                .addMerchantDetails(merchantDetails)
                .addRelatedTransactionId(relatedTransactionId)
                .addSubMerchant(subMerchant)
                .addUserId(userId)
                .addUserTokenId(userTokenId)
                .addPaymentOption(paymentOption)
                .build();
    }

    public SafechargeBaseRequest getAuthorize3dRequest(MerchantInfo merchantInfo, String sessionToken, String userTokenId, String clientUniqueId,
                                                       String clientRequestId, PaymentOption paymentOption, Integer isRebilling, String currency,
                                                       String amount, AmountDetails amountDetails, List<Item> items, DeviceDetails deviceDetails,
                                                       CashierUserDetails userDetails, UserAddress shippingAddress, UserAddress billingAddress,
                                                       DynamicDescriptor dynamicDescriptor, MerchantDetails merchantDetails, Addendums addendums,
                                                       UrlDetails urlDetails, String customSiteName, String productId, String customData,
                                                       String relatedTransactionId, Constants.TransactionType transactionType, Boolean autoPayment3D,
                                                       SubMerchant subMerchant) {
        return Authorize3dRequest.builder()
                .addSessionToken(sessionToken)
                .addIsRebilling(isRebilling)
                .addPaymentOption(paymentOption)
                .addAddendums(addendums)
                .addAmountDetails(amountDetails)
                .addBillingDetails(billingAddress)
                .addDeviceDetails(deviceDetails)
                .addDynamicDescriptor(dynamicDescriptor)
                .addItems(items)
                .addMerchantDetails(merchantDetails)
                .addShippingDetails(shippingAddress)
                .addMerchantInfo(merchantInfo)
                .addURLDetails(urlDetails)
                .addUserDetails(userDetails)
                .addAmount(amount)
                .addClientRequestId(clientRequestId)
                .addClientUniqueId(clientUniqueId)
                .addCurrency(currency)
                .addUserTokenId(userTokenId)
                .addCustomSiteName(customSiteName)
                .addProductId(productId)
                .addCustomData(customData)
                .addRelatedTransactionId(relatedTransactionId)
                .addTransactionType(transactionType)
                .addAutoPayment3D(autoPayment3D)
                .addSubMerchant(subMerchant)
                .build();
    }

    public CardDetailsRequest getCardDetailsRequest(String sessionToken, MerchantInfo merchantInfo, String clientUniqueId,
                                                    String clientRequestId, String cardNumber) {
        return CardDetailsRequest.builder()
                .addSessionToken(sessionToken)
                .addMerchantInfo(merchantInfo)
                .addClientUniqueId(clientUniqueId)
                .addClientRequestId(clientRequestId)
                .addCardNumber(cardNumber)
                .build();
    }
}
