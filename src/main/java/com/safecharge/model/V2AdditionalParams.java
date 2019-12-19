package com.safecharge.model;

import javax.validation.constraints.Size;

public class V2AdditionalParams {

    @Size(max = 254, message = "deliveryEmail must be up to 254 characters long!")
    private String deliveryEmail;

    @Size(max = 2, message = "deliveryTimeFrame must be up to 2 characters long!")
    private String deliveryTimeFrame;

    @Size(max = 15, message = "giftCardAmount must be up to 15 characters long!")
    private String giftCardAmount;

    @Size(max = 2, message = "giftCardCount must be up to 2 characters long!")
    private String giftCardCount;

    @Size(max = 8, message = "preOrderDate must be up to 8 characters long!")
    private String preOrderDate;

    @Size(max = 2, message = "preOrderPurchaseInd must be up to 2 characters long!")
    private String preOrderPurchaseInd;

    @Size(max = 2, message = "reorderItemsInd must be up to 2 characters long!")
    private String reorderItemsInd;

    @Size(max = 2, message = "shipIndicator must be up to 2 characters long!")
    private String shipIndicator;

    @Size(max = 8, message = "rebillExpiry must be up to 8 characters long!")
    private String rebillExpiry;

    @Size(max = 4, message = "rebillFrequency must be up to 4 characters long!")
    private String rebillFrequency;

    @Size(max = 2, message = "challengeWindowSize must be up to 2 characters long!")
    private String challengeWindowSize;

    @Size(max = 2, message = "challengePreference must be up to 2 characters long!")
    private String challengePreference;

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

    public String getGiftCardCount() {
        return giftCardCount;
    }

    public void setGiftCardCount(String giftCardCount) {
        this.giftCardCount = giftCardCount;
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

    public String getShipIndicator() {
        return shipIndicator;
    }

    public void setShipIndicator(String shipIndicator) {
        this.shipIndicator = shipIndicator;
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

    public String getChallengeWindowSize() {
        return challengeWindowSize;
    }

    public void setChallengeWindowSize(String challengeWindowSize) {
        this.challengeWindowSize = challengeWindowSize;
    }

    public String getChallengePreference() {
        return challengePreference;
    }

    public void setChallengePreference(String challengePreference) {
        this.challengePreference = challengePreference;
    }

    public Boolean getExceptionPayment3DAuth() {
        return exceptionPayment3DAuth;
    }

    public void setExceptionPayment3DAuth(Boolean exceptionPayment3DAuth) {
        this.exceptionPayment3DAuth = exceptionPayment3DAuth;
    }
}
