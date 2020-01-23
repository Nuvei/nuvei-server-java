package com.safecharge.biz;

import com.safecharge.model.*;
import com.safecharge.request.*;
import com.safecharge.response.GetSessionTokenResponse;
import com.safecharge.response.SafechargeResponse;
import com.safecharge.util.Constants;

import java.util.List;

public class PaymentService {

    private SafechargeRequestExecutor requestExecutor = SafechargeRequestExecutor.getInstance();

    public GetSessionTokenResponse getSessionTokenresponse(MerchantInfo merchantInfo) {
        SafechargeRequest safechargeRequest = (SafechargeRequest) GetSessionTokenRequest.builder()
                .addMerchantInfo(merchantInfo)
                .build();

        return (GetSessionTokenResponse) requestExecutor.executeRequest(safechargeRequest);
    }

    public SafechargeResponse getPaymentResponse(MerchantInfo merchantInfo, String sessionToken, String userTokenId, String clientUniqueId,
                                                 String clientRequestId, PaymentOption paymentOption, Integer isRebilling, String currency,
                                                 String amount, AmountDetails amountDetails, List<Item> items, DeviceDetails deviceDetails,
                                                 CashierUserDetails userDetails, UserAddress shippingAddress, UserAddress billingAddress,
                                                 DynamicDescriptor dynamicDescriptor, MerchantDetails merchantDetails, Addendums addendums,
                                                 UrlDetails urlDetails, String customSiteName, String productId, String customData,
                                                 String relatedTransactionId, Constants.TransactionType transactionType, Boolean autoPayment3D, String sourceApplication,
                                                 String isMoto) {
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
                .build();

        return requestExecutor.executeRequest(request);
    }

    public SafechargeResponse getInitPaymentResponse(String sessionToken, String userTokenId, String clientUniqueId, String clientRequestId, String currency,
                                                     String amount, DeviceDetails deviceDetails, InitPaymentPaymentOption paymentOption, UrlDetails urlDetails,
                                                     String customData, UserAddress billingAddress, String sourceApplication,
                                                     MerchantBaseInfo merchantInfo) {
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
                .build();

        return requestExecutor.executeRequest(request);
    }

    public SafechargeResponse getOpenOrderResponse(MerchantInfo merchantInfo, String sessionToken, String clientRequestId, String customSiteName,
                                                   String productId, OpenOrderPaymentOption paymentOption, Constants.TransactionType transactionType,
                                                   String currency, String amount, List<Item> items, DeviceDetails deviceDetails, CashierUserDetails userDetails,
                                                   UserAddress shippingAddress, UserAddress billingAddress, DynamicDescriptor dynamicDescriptor, MerchantDetails merchantDetails,
                                                   UrlDetails urlDetails, String userTokenId, String clientUniqueId, UserPaymentOption userPaymentOption,
                                                   String paymentMethod, AmountDetails amountDetails, Addendums addendums, String customData, Boolean autoPayment3D,
                                                   String sourceApplication, String isMoto) {
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
                .addIsMoto(isMoto)
                .build();

        return requestExecutor.executeRequest(request);
    }
}
