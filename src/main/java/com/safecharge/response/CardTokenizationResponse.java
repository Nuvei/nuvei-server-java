package com.safecharge.response;

import com.safecharge.model.FraudDetails;

/**
 * Copyright (C) 2007-2020 SafeCharge International Group Limited.
 * <p>
 * Response received from the SafeCharge's servers to the {@link com.safecharge.request.CardTokenizationRequest}.
 * </p>
 * @author Nikola Dichev
 * @see <a href="https://www.safecharge.com/docs/api/?java#cardtokenization">Card Tokenization documentation</a>
 * @see com.safecharge.request.CardTokenizationRequest
 * @since 2/15/2017
 */
public class CardTokenizationResponse extends SafechargeResponse {

    /**
     * The generated card's temporary token, if the request is successful.
     */
    private String ccTempToken;

    private Boolean isVerified;

    private String orderId;

    private FraudDetails fraudDetails;

    private String uniqueCC;

    private String cardType;

    private String issuerCountry;

    private Integer gwErrorCode;

    private Integer gwExtendedErrorCode;

    public String getCcTempToken() {
        return ccTempToken;
    }

    public void setCcTempToken(String ccTempToken) {
        this.ccTempToken = ccTempToken;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public FraudDetails getFraudDetails() {
        return fraudDetails;
    }

    public void setFraudDetails(FraudDetails fraudDetails) {
        this.fraudDetails = fraudDetails;
    }

    public String getUniqueCC() {
        return uniqueCC;
    }

    public void setUniqueCC(String uniqueCC) {
        this.uniqueCC = uniqueCC;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getIssuerCountry() {
        return issuerCountry;
    }

    public void setIssuerCountry(String issuerCountry) {
        this.issuerCountry = issuerCountry;
    }

    public Integer getGwErrorCode() {
        return gwErrorCode;
    }

    public void setGwErrorCode(Integer gwErrorCode) {
        this.gwErrorCode = gwErrorCode;
    }

    public Integer getGwExtendedErrorCode() {
        return gwExtendedErrorCode;
    }

    public void setGwExtendedErrorCode(Integer gwExtendedErrorCode) {
        this.gwExtendedErrorCode = gwExtendedErrorCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CardTokenizationResponse{");
        sb.append("ccTempToken='").append(ccTempToken).append('\'')
                .append(", isVerified='").append(isVerified)
                .append(", orderId='").append(orderId)
                .append(", fraudDetails='").append(fraudDetails)
                .append(", uniqueCC='").append(uniqueCC)
                .append(", cardType='").append(cardType)
                .append(", issuerCountry='").append(issuerCountry)
                .append(", gwErrorCode='").append(gwErrorCode)
                .append(", gwExtendedErrorCode='").append(gwExtendedErrorCode)
                .append(", ").append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
