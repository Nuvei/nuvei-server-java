/*
 * Copyright (c) 2007-2020 SafeCharge International Group Limited.
 */

package com.safecharge.model;

public class ExternalTokenInfo {

    private String token;
    private String tokenProvider;
    private String cardBin;
    private String cardMask;
    private String cardLength;
    private String cardName;
    private String cardExpiration;
    private String cardTypeId;
    private String cardTypeName;
    private String creditCompanyId;
    private String creditCompanyName;
    private String cardBrandId;
    private String cardBrandName;
    private String cardAcquirerId;
    private String cardAcquirerName;
    private String blockedCard;
    private String extendedCardType;
    private String clubName;
    private String lifeStyle;
    private String indication;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenProvider() {
        return tokenProvider;
    }

    public void setTokenProvider(String tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    public String getCardBin() {
        return cardBin;
    }

    public void setCardBin(String cardBin) {
        this.cardBin = cardBin;
    }

    public String getCardMask() {
        return cardMask;
    }

    public void setCardMask(String cardMask) {
        this.cardMask = cardMask;
    }

    public String getCardLength() {
        return cardLength;
    }

    public void setCardLength(String cardLength) {
        this.cardLength = cardLength;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardExpiration() {
        return cardExpiration;
    }

    public void setCardExpiration(String cardExpiration) {
        this.cardExpiration = cardExpiration;
    }

    public String getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(String cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public String getCardTypeName() {
        return cardTypeName;
    }

    public void setCardTypeName(String cardTypeName) {
        this.cardTypeName = cardTypeName;
    }

    public String getCreditCompanyId() {
        return creditCompanyId;
    }

    public void setCreditCompanyId(String creditCompanyId) {
        this.creditCompanyId = creditCompanyId;
    }

    public String getCreditCompanyName() {
        return creditCompanyName;
    }

    public void setCreditCompanyName(String creditCompanyName) {
        this.creditCompanyName = creditCompanyName;
    }

    public String getCardBrandId() {
        return cardBrandId;
    }

    public void setCardBrandId(String cardBrandId) {
        this.cardBrandId = cardBrandId;
    }

    public String getCardBrandName() {
        return cardBrandName;
    }

    public void setCardBrandName(String cardBrandName) {
        this.cardBrandName = cardBrandName;
    }

    public String getCardAcquirerId() {
        return cardAcquirerId;
    }

    public void setCardAcquirerId(String cardAcquirerId) {
        this.cardAcquirerId = cardAcquirerId;
    }

    public String getCardAcquirerName() {
        return cardAcquirerName;
    }

    public void setCardAcquirerName(String cardAcquirerName) {
        this.cardAcquirerName = cardAcquirerName;
    }

    public String getBlockedCard() {
        return blockedCard;
    }

    public void setBlockedCard(String blockedCard) {
        this.blockedCard = blockedCard;
    }

    public String getExtendedCardType() {
        return extendedCardType;
    }

    public void setExtendedCardType(String extendedCardType) {
        this.extendedCardType = extendedCardType;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getLifeStyle() {
        return lifeStyle;
    }

    public void setLifeStyle(String lifeStyle) {
        this.lifeStyle = lifeStyle;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    @Override
    public String toString() {
        return "ExternalTokenInfo{" +
                "token='" + token + '\'' +
                ", tokenProvider='" + tokenProvider + '\'' +
                ", cardBin='" + cardBin + '\'' +
                ", cardMask='" + cardMask + '\'' +
                ", cardLength='" + cardLength + '\'' +
                ", cardName='" + cardName + '\'' +
                ", cardExpiration='" + cardExpiration + '\'' +
                ", cardTypeId='" + cardTypeId + '\'' +
                ", cardTypeName='" + cardTypeName + '\'' +
                ", creditCompanyId='" + creditCompanyId + '\'' +
                ", creditCompanyName='" + creditCompanyName + '\'' +
                ", cardBrandId='" + cardBrandId + '\'' +
                ", cardBrandName='" + cardBrandName + '\'' +
                ", cardAcquirerId='" + cardAcquirerId + '\'' +
                ", cardAcquirerName='" + cardAcquirerName + '\'' +
                ", blockedCard='" + blockedCard + '\'' +
                ", extendedCardType='" + extendedCardType + '\'' +
                ", clubName='" + clubName + '\'' +
                ", lifeStyle='" + lifeStyle + '\'' +
                ", indication='" + indication + '\'' +
                '}';
    }
}
