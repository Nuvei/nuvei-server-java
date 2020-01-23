package com.safecharge.model;

import javax.validation.constraints.Size;

public class OpenOrderThreeDV2AdditionalParams {

    @Size(max = 254, message = "deliveryEmail size must be up to 254 characters long!")
    private String deliveryEmail;

    @Size(max = 2, message = "deliveryTimeFrame size must be up to 2 characters long!")
    private String deliveryTimeFrame;

    @Size(max = 15, message = "giftCardAmount size must be up to 15 characters long!")
    private String giftCardAmount;

    @Size(min=3, max = 3, message = "giftCardCurrency size must be 3 characters long!")
    private String giftCardCurrency;

    @Size(max = 8, message = "preOrderDate size must be up to 8 characters long!")
    private String preOrderDate;

    @Size(max = 2, message = "preOrderPurchaseInd size must be up to 2 characters long!")
    private String preOrderPurchaseInd;
    private String reorderItemsInd;
    private String rebillExpiry;
    private String rebillFrequency;
    private Boolean exceptionPayment3DAuth;

    public String getDeliveryEmail() {
        return deliveryEmail;
    }

    public void setDeliveryEmail(String deliveryEmail) {
        this.deliveryEmail = deliveryEmail;
    }

    public String getDeliveryTimeFrame() {
        return deliveryTimeFrame;
    }

    public void setDeliveryTimeFrame(String deliveryTimeFrame) {
        this.deliveryTimeFrame = deliveryTimeFrame;
    }

    public String getGiftCardAmount() {
        return giftCardAmount;
    }

    public void setGiftCardAmount(String giftCardAmount) {
        this.giftCardAmount = giftCardAmount;
    }

    public String getGiftCardCurrency() {
        return giftCardCurrency;
    }

    public void setGiftCardCurrency(String giftCardCurrency) {
        this.giftCardCurrency = giftCardCurrency;
    }

    public String getPreOrderDate() {
        return preOrderDate;
    }

    public void setPreOrderDate(String preOrderDate) {
        this.preOrderDate = preOrderDate;
    }

    public String getPreOrderPurchaseInd() {
        return preOrderPurchaseInd;
    }

    public void setPreOrderPurchaseInd(String preOrderPurchaseInd) {
        this.preOrderPurchaseInd = preOrderPurchaseInd;
    }

    public String getReorderItemsInd() {
        return reorderItemsInd;
    }

    public void setReorderItemsInd(String reorderItemsInd) {
        this.reorderItemsInd = reorderItemsInd;
    }

    public String getRebillExpiry() {
        return rebillExpiry;
    }

    public void setRebillExpiry(String rebillExpiry) {
        this.rebillExpiry = rebillExpiry;
    }

    public String getRebillFrequency() {
        return rebillFrequency;
    }

    public void setRebillFrequency(String rebillFrequency) {
        this.rebillFrequency = rebillFrequency;
    }

    public Boolean getExceptionPayment3DAuth() {
        return exceptionPayment3DAuth;
    }

    public void setExceptionPayment3DAuth(Boolean exceptionPayment3DAuth) {
        this.exceptionPayment3DAuth = exceptionPayment3DAuth;
    }
}
