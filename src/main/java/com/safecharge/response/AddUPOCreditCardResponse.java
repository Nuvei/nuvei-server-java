/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.response;

import com.safecharge.model.UserDetails;

/**
 * <p>
 * Response received from the SafeCharge's servers to the {@link com.safecharge.request.AddUPOCreditCardRequest}.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see com.safecharge.request.AddUPOCreditCardRequest
 * @since 3/22/2017
 */
public class AddUPOCreditCardResponse extends SafechargeResponse {

    /**
     * The id of the created User Payment Option(UPO), if the request is successful.
     */
    private Long userPaymentOptionId;

    /**
     * Credit card token(hashed value of the credit card number)
     */
    private String ccToken;
    /**
     * The brand of the credit card, i.e. Visa, MasterCard, etc.
     */
    private String brand;
    /**
     * A unique identifying code for the credit card.
     */
    private String uniqueCC;
    /**
     * The credit card’s bin number.
     */
    private String bin;
    /**
     * The last four digits of the credit card number.
     */
    private String last4Digits;
    /**
     * Value describing if the card used is a credit card or debit card.
     */
    private String cardType;

    private String externalTokenProvider;

    private UserDetails billingAddress;

    public Long getUserPaymentOptionId() {
        return userPaymentOptionId;
    }

    public void setUserPaymentOptionId(Long userPaymentOptionId) {
        this.userPaymentOptionId = userPaymentOptionId;
    }

    public String getCcToken() {
        return ccToken;
    }

    public void setCcToken(String ccToken) {
        this.ccToken = ccToken;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getUniqueCC() {
        return uniqueCC;
    }

    public void setUniqueCC(String uniqueCC) {
        this.uniqueCC = uniqueCC;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getLast4Digits() {
        return last4Digits;
    }

    public void setLast4Digits(String last4Digits) {
        this.last4Digits = last4Digits;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getExternalTokenProvider() {
        return externalTokenProvider;
    }

    public void setExternalTokenProvider(String externalTokenProvider) {
        this.externalTokenProvider = externalTokenProvider;
    }

    public UserDetails getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(UserDetails billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AddUPOCreditCardResponse{");
        sb.append("userPaymentOptionId=")
                .append(userPaymentOptionId);
        sb.append(", ccToken='")
                .append(ccToken)
                .append('\'');
        sb.append(", brand='")
                .append(brand)
                .append('\'');
        sb.append(", uniqueCC='")
                .append(uniqueCC)
                .append('\'');
        sb.append(", bin='")
                .append(bin)
                .append('\'');
        sb.append(", last4Digits='")
                .append(last4Digits)
                .append('\'');
        sb.append(", cardType='")
                .append(cardType)
                .append('\'');
        sb.append(", externalTokenProvider='")
                .append(externalTokenProvider)
                .append('\'');
        sb.append(", billingAddress='")
                .append(billingAddress)
                .append('\'');
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
