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
import com.safecharge.request.GetPaymentStatusRequest;
import com.safecharge.request.GetSessionTokenRequest;
import com.safecharge.request.InitPaymentRequest;
import com.safecharge.request.OpenOrderRequest;
import com.safecharge.request.PaymentRequest;
import com.safecharge.request.RefundTransactionRequest;
import com.safecharge.request.SafechargeBaseRequest;
import com.safecharge.request.SafechargeRequest;
import com.safecharge.request.SettleTransactionRequest;
import com.safecharge.request.Verify3dRequest;
import com.safecharge.request.VoidTransactionRequest;
import com.safecharge.response.GetPaymentStatusResponse;
import com.safecharge.response.GetSessionTokenResponse;
import com.safecharge.response.InitPaymentResponse;
import com.safecharge.response.OpenOrderResponse;
import com.safecharge.response.PaymentResponse;
import com.safecharge.response.RefundTransactionResponse;
import com.safecharge.response.SettleTransactionResponse;
import com.safecharge.response.Verify3dResponse;
import com.safecharge.response.VoidTransactionResponse;
import com.safecharge.util.Constants;

public class PaymentService {

    private SafechargeRequestExecutor requestExecutor = SafechargeRequestExecutor.getInstance();

    public GetSessionTokenResponse getSessionTokenresponse(MerchantInfo merchantInfo) {
        SafechargeRequest safechargeRequest = (SafechargeRequest) GetSessionTokenRequest.builder()
                .addMerchantInfo(merchantInfo)
                .build();

        return (GetSessionTokenResponse) requestExecutor.executeRequest(safechargeRequest);
    }

    public PaymentResponse getPaymentResponse(MerchantInfo merchantInfo, String sessionToken, String userTokenId, String clientUniqueId,
                                              String clientRequestId, PaymentOption paymentOption, Integer isRebilling, String currency,
                                              String amount, AmountDetails amountDetails, List<Item> items, DeviceDetails deviceDetails,
                                              CashierUserDetails userDetails, UserAddress shippingAddress, UserAddress billingAddress,
                                              DynamicDescriptor dynamicDescriptor, MerchantDetails merchantDetails, Addendums addendums,
                                              UrlDetails urlDetails, String customSiteName, String productId, String customData,
                                              String relatedTransactionId, Constants.TransactionType transactionType, Boolean autoPayment3D, String sourceApplication,
                                              String isMoto, String internalRequestId) {
        SafechargeRequest request = PaymentRequest.builder()
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
                .addSourceApplication(sourceApplication)
                .addIsMoto(isMoto)
                .addInternalRequestId(internalRequestId)
                .build();

        return (PaymentResponse) requestExecutor.executeRequest(request);
    }

    public InitPaymentResponse getInitPaymentResponse(String sessionToken, String userTokenId, String clientUniqueId, String clientRequestId, String currency,
                                                      String amount, DeviceDetails deviceDetails, InitPaymentPaymentOption paymentOption, UrlDetails urlDetails,
                                                      String customData, UserAddress billingAddress, String sourceApplication,
                                                      MerchantInfo merchantInfo, String internalRequestId) {
        SafechargeBaseRequest request = InitPaymentRequest.builder()
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
                .addSourceApplication(sourceApplication)
                .addMerchantInfo(merchantInfo)
                .addInternalRequestId(internalRequestId)
                .build();

        return (InitPaymentResponse) requestExecutor.executeRequest(request);
    }

    public OpenOrderResponse getOpenOrderResponse(MerchantInfo merchantInfo, String sessionToken, String clientRequestId, String customSiteName,
                                                  String productId, OpenOrderPaymentOption paymentOption, Constants.TransactionType transactionType,
                                                  String currency, String amount, List<Item> items, DeviceDetails deviceDetails, CashierUserDetails userDetails,
                                                  UserAddress shippingAddress, UserAddress billingAddress, DynamicDescriptor dynamicDescriptor, MerchantDetails merchantDetails,
                                                  UrlDetails urlDetails, String userTokenId, String clientUniqueId, UserPaymentOption userPaymentOption,
                                                  String paymentMethod, AmountDetails amountDetails, Addendums addendums, String customData, Boolean autoPayment3D,
                                                  String sourceApplication, String isMoto, String internalRequestId) {
        SafechargeBaseRequest request = OpenOrderRequest.builder()
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
                .addSourceApplication(sourceApplication)
                .addInternalRequestId(internalRequestId)
                .addIsMoto(isMoto)
                .build();

        return (OpenOrderResponse) requestExecutor.executeRequest(request);
    }

    public GetPaymentStatusResponse getPaymentStatusResponse(String sessionToken, String clientRequestId, MerchantInfo merchantInfo,
                                                             String internalRequestId) {
        GetPaymentStatusRequest request = GetPaymentStatusRequest.builder()
                .addSessionToken(sessionToken)
                .addMerchantInfo(merchantInfo)
                .addClientRequestId(clientRequestId)
                .addInternalRequestId(internalRequestId)
                .build();

        return (GetPaymentStatusResponse) requestExecutor.executeRequest(request);
    }

    public VoidTransactionResponse getVoidTransactionResponse(String sessionToken, String clientRequestId, MerchantInfo merchantInfo,
                                                              String relatedTransactionId, String amount, String currency, String authCode,
                                                              String clientUniqueId, UrlDetails urlDetails, String customSiteName,
                                                              String productId, String customData, String sourceApplication, String comment,
                                                              String internalRequestId) {
        VoidTransactionRequest request = VoidTransactionRequest.builder()
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
                .addSourceApplication(sourceApplication)
                .addClientRequestId(clientRequestId)
                .addAuthCode(authCode)
                .addInternalRequestId(internalRequestId)
                .build();

        return (VoidTransactionResponse) requestExecutor.executeRequest(request);
    }

    public SettleTransactionResponse getSettleTransactionResponse(String sessionToken, MerchantInfo merchantInfo, String clientUniqueId,
                                                                  String clientRequestId, Addendums addendums, String descriptorMerchantName,
                                                                  String descriptorMerchantPhone, DynamicDescriptor dynamicDescriptor,
                                                                  UrlDetails urlDetails, String amount, String authCode, String customData,
                                                                  String comment, String currency, String customSiteName, String productId,
                                                                  String relatedTransactionId, String sourceApplication, String internalRequestId) {
        SafechargeBaseRequest request = SettleTransactionRequest.builder()
                .addMerchantInfo(merchantInfo)
                .addClientUniqueId(clientUniqueId)
                .addClientRequestId(clientRequestId)
                .addSessionToken(sessionToken)
                .addAddendums(addendums)
                .addDescriptorMerchantName(descriptorMerchantName)
                .addDescriptorMerchantPhone(descriptorMerchantPhone)
                .addDynamicDescriptor(dynamicDescriptor)
                .addURLDetails(urlDetails)
                .addAmount(amount)
                .addAuthCode(authCode)
                .addComment(comment)
                .addCurrency(currency)
                .addCustomData(customData)
                .addCustomSiteName(customSiteName)
                .addProductId(productId)
                .addRelatedTransactionId(relatedTransactionId)
                .addSourceApplication(sourceApplication)
                .addInternalRequestId(internalRequestId)
                .build();

        return (SettleTransactionResponse) requestExecutor.executeRequest(request);
    }

    public RefundTransactionResponse getRefundTransactionResponse(String sessionToken, MerchantInfo merchantInfo, String clientUniqueId,
                                                                  String clientRequestId, UrlDetails urlDetails, String amount, String authCode,
                                                                  String comment, String currency, String customData, String customSiteName,
                                                                  String productId, String relatedTransactionId, String sourceApplication,
                                                                  String internalRequestId) {
        SafechargeBaseRequest request = RefundTransactionRequest.builder()
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
                .addSourceApplication(sourceApplication)
                .addInternalRequestId(internalRequestId)
                .build();

        return (RefundTransactionResponse) requestExecutor.executeRequest(request);
    }

    public Verify3dResponse getVerify3dResponse(String sessionToken, MerchantInfo merchantInfo, String clientUniqueId, String clientRequestId,
                                                String amount, String currency, UserAddress billingAddress, String customData,
                                                String customSiteName, MerchantDetails merchantDetails, String relatedTransactionId,
                                                SubMerchant subMerchant, String userId, String userTokenId, Verify3dPaymentOption paymentOption,
                                                String sourceApplication, String internalRequestId) {
        SafechargeBaseRequest request = new Verify3dRequest.Builder()
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
                .addSourceApplication(sourceApplication)
                .addInternalRequestId(internalRequestId)
                .build();

        return (Verify3dResponse) requestExecutor.executeRequest(request);
    }

    public PaymentResponse getAuthorize3dResponse(MerchantInfo merchantInfo, String sessionToken, String userTokenId, String clientUniqueId,
                                                  String clientRequestId, PaymentOption paymentOption, Integer isRebilling, String currency,
                                                  String amount, AmountDetails amountDetails, List<Item> items, DeviceDetails deviceDetails,
                                                  CashierUserDetails userDetails, UserAddress shippingAddress, UserAddress billingAddress,
                                                  DynamicDescriptor dynamicDescriptor, MerchantDetails merchantDetails, Addendums addendums,
                                                  UrlDetails urlDetails, String customSiteName, String productId, String customData,
                                                  String relatedTransactionId, Constants.TransactionType transactionType, Boolean autoPayment3D, String sourceApplication,
                                                  String isMoto, String internalRequestId) {
        SafechargeRequest request = Authorize3dRequest.builder()
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
                .addSourceApplication(sourceApplication)
                .addIsMoto(isMoto)
                .addInternalRequestId(internalRequestId)
                .build();

        return (PaymentResponse) requestExecutor.executeRequest(request);
    }
}
