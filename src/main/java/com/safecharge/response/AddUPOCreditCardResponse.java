package com.safecharge.response;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/22/2017
 */
public class AddUPOCreditCardResponse extends SafechargeResponse {

    private Long userPaymentOptionId;
    private String ccToken;
    private String brand;
    private String uniqueCC;
    private String bin;
    private String last4Digits;
    private String cardType;

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
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
