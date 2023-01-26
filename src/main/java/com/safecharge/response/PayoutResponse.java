package com.safecharge.response;

import com.safecharge.model.CardData;
import com.safecharge.model.MerchantDetails;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Response returned in result of payout method execution.
 *
 * @author <a mailto:bozhidarsh@safecharge.com>Bozhidar sHumanov</a>
 * @see <a href="https://www.safecharge.com/docs/api/?java#payout">payout</a>
 * @since 11/21/2017
 */

public class PayoutResponse extends SafechargeResponse {

    private String userTokenId;
    private String transactionStatus;
    private String paymentMethodErrorCode;
    private String paymentMethodErrorReason;
    private Integer gwErrorCode;
    private String gwErrorReason;
    private Integer gwExtendedErrorCode;
    private String userPaymentOptionId;
    private String externalTransactionId;
    private String transactionId;

    private MerchantDetails merchantDetails;
    private CardData cardData;

    private String additionalTransactionBankId;

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getPaymentMethodErrorCode() {
        return paymentMethodErrorCode;
    }

    public void setPaymentMethodErrorCode(String paymentMethodErrorCode) {
        this.paymentMethodErrorCode = paymentMethodErrorCode;
    }

    public String getPaymentMethodErrorReason() {
        return paymentMethodErrorReason;
    }

    public void setPaymentMethodErrorReason(String paymentMethodErrorReason) {
        this.paymentMethodErrorReason = paymentMethodErrorReason;
    }

    public Integer getGwErrorCode() {
        return gwErrorCode;
    }

    public void setGwErrorCode(Integer gwErrorCode) {
        this.gwErrorCode = gwErrorCode;
    }

    public String getGwErrorReason() {
        return gwErrorReason;
    }

    public void setGwErrorReason(String gwErrorReason) {
        this.gwErrorReason = gwErrorReason;
    }

    public Integer getGwExtendedErrorCode() {
        return gwExtendedErrorCode;
    }

    public void setGwExtendedErrorCode(Integer gwExtendedErrorCode) {
        this.gwExtendedErrorCode = gwExtendedErrorCode;
    }

    public String getUserPaymentOptionId() {
        return userPaymentOptionId;
    }

    public void setUserPaymentOptionId(String userPaymentOptionId) {
        this.userPaymentOptionId = userPaymentOptionId;
    }

    public String getExternalTransactionId() {
        return externalTransactionId;
    }

    public void setExternalTransactionId(String externalTransactionId) {
        this.externalTransactionId = externalTransactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public MerchantDetails getMerchantDetails() {
        return merchantDetails;
    }

    public void setMerchantDetails(MerchantDetails merchantDetails) {
        this.merchantDetails = merchantDetails;
    }

    public CardData getCardData() {
        return cardData;
    }

    public void setCardData(CardData cardData) {
        this.cardData = cardData;
    }

    public String getAdditionalTransactionBankId() {
        return additionalTransactionBankId;
    }

    public void setAdditionalTransactionBankId(String additionalTransactionBankId) {
        this.additionalTransactionBankId = additionalTransactionBankId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PayoutResponse{");
        sb.append(super.toString()).append(", ");
        sb.append("userTokenId='").append(userTokenId).append('\'');
        sb.append(", transactionStatus='").append(transactionStatus).append('\'');
        sb.append(", paymentMethodErrorCode='").append(paymentMethodErrorCode).append('\'');
        sb.append(", paymentMethodErrorReason='").append(paymentMethodErrorReason).append('\'');
        sb.append(", gwErrorCode=").append(gwErrorCode);
        sb.append(", gwErrorReason='").append(gwErrorReason).append('\'');
        sb.append(", gwExtendedErrorCode=").append(gwExtendedErrorCode);
        sb.append(", userPaymentOptionId='").append(userPaymentOptionId).append('\'');
        sb.append(", externalTransactionId='").append(externalTransactionId).append('\'');
        sb.append(", transactionId='").append(transactionId).append('\'');
        sb.append(", cardData='").append(cardData).append('\'');
        sb.append(", merchantDetails=").append(merchantDetails);
        sb.append(", additionalTransactionBankId='").append(additionalTransactionBankId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
