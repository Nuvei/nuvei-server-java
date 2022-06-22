package com.safecharge.model;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Holder for Checkout Page's Payment Gateway external token data.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/10/2017
 */
public class ApiExternalToken {

    private String externalToken_tokenValue;
    private String externalToken_cardBin;
    private String externalToken_cardMask;
    private String externalToken_cardLength;
    private String externalToken_cardName;
    private String externalToken_cardExpiration;
    private String externalToken_cardTypeId;
    private String externalToken_cardTypeName;
    private String externalToken_creditCompanyId;
    private String externalToken_creditCompanyName;
    private String externalToken_cardBrandId;
    private String externalToken_cardBrandName;
    private String externalToken_cardAcquirerId;
    private String externalToken_cardAcquirerName;
    private String externalToken_blockedCard;
    private String externalToken_extendedCardType;
    private String externalToken_clubName;
    private String externalToken_Indication;
    private String externalToken_tokenProvider;

    public String getExternalToken_tokenValue() {
        return externalToken_tokenValue;
    }

    public void setExternalToken_tokenValue(String externalToken_tokenValue) {
        this.externalToken_tokenValue = externalToken_tokenValue;
    }

    public String getExternalToken_cardBin() {
        return externalToken_cardBin;
    }

    public void setExternalToken_cardBin(String externalToken_cardBin) {
        this.externalToken_cardBin = externalToken_cardBin;
    }

    public String getExternalToken_cardMask() {
        return externalToken_cardMask;
    }

    public void setExternalToken_cardMask(String externalToken_cardMask) {
        this.externalToken_cardMask = externalToken_cardMask;
    }

    public String getExternalToken_cardLength() {
        return externalToken_cardLength;
    }

    public void setExternalToken_cardLength(String externalToken_cardLength) {
        this.externalToken_cardLength = externalToken_cardLength;
    }

    public String getExternalToken_cardName() {
        return externalToken_cardName;
    }

    public void setExternalToken_cardName(String externalToken_cardName) {
        this.externalToken_cardName = externalToken_cardName;
    }

    public String getExternalToken_cardExpiration() {
        return externalToken_cardExpiration;
    }

    public void setExternalToken_cardExpiration(String externalToken_cardExpiration) {
        this.externalToken_cardExpiration = externalToken_cardExpiration;
    }

    public String getExternalToken_cardTypeId() {
        return externalToken_cardTypeId;
    }

    public void setExternalToken_cardTypeId(String externalToken_cardTypeId) {
        this.externalToken_cardTypeId = externalToken_cardTypeId;
    }

    public String getExternalToken_cardTypeName() {
        return externalToken_cardTypeName;
    }

    public void setExternalToken_cardTypeName(String externalToken_cardTypeName) {
        this.externalToken_cardTypeName = externalToken_cardTypeName;
    }

    public String getExternalToken_creditCompanyId() {
        return externalToken_creditCompanyId;
    }

    public void setExternalToken_creditCompanyId(String externalToken_creditCompanyId) {
        this.externalToken_creditCompanyId = externalToken_creditCompanyId;
    }

    public String getExternalToken_creditCompanyName() {
        return externalToken_creditCompanyName;
    }

    public void setExternalToken_creditCompanyName(String externalToken_creditCompanyName) {
        this.externalToken_creditCompanyName = externalToken_creditCompanyName;
    }

    public String getExternalToken_cardBrandId() {
        return externalToken_cardBrandId;
    }

    public void setExternalToken_cardBrandId(String externalToken_cardBrandId) {
        this.externalToken_cardBrandId = externalToken_cardBrandId;
    }

    public String getExternalToken_cardBrandName() {
        return externalToken_cardBrandName;
    }

    public void setExternalToken_cardBrandName(String externalToken_cardBrandName) {
        this.externalToken_cardBrandName = externalToken_cardBrandName;
    }

    public String getExternalToken_cardAcquirerId() {
        return externalToken_cardAcquirerId;
    }

    public void setExternalToken_cardAcquirerId(String externalToken_cardAcquirerId) {
        this.externalToken_cardAcquirerId = externalToken_cardAcquirerId;
    }

    public String getExternalToken_cardAcquirerName() {
        return externalToken_cardAcquirerName;
    }

    public void setExternalToken_cardAcquirerName(String externalToken_cardAcquirerName) {
        this.externalToken_cardAcquirerName = externalToken_cardAcquirerName;
    }

    public String getExternalToken_blockedCard() {
        return externalToken_blockedCard;
    }

    public void setExternalToken_blockedCard(String externalToken_blockedCard) {
        this.externalToken_blockedCard = externalToken_blockedCard;
    }

    public String getExternalToken_extendedCardType() {
        return externalToken_extendedCardType;
    }

    public void setExternalToken_extendedCardType(String externalToken_extendedCardType) {
        this.externalToken_extendedCardType = externalToken_extendedCardType;
    }

    public String getExternalToken_clubName() {
        return externalToken_clubName;
    }

    public void setExternalToken_clubName(String externalToken_clubName) {
        this.externalToken_clubName = externalToken_clubName;
    }

    public String getExternalToken_Indication() {
        return externalToken_Indication;
    }

    public void setExternalToken_Indication(String externalToken_Indication) {
        this.externalToken_Indication = externalToken_Indication;
    }

    public String getExternalToken_tokenProvider() {
        return externalToken_tokenProvider;
    }

    public void setExternalToken_tokenProvider(String externalToken_tokenProvider) {
        this.externalToken_tokenProvider = externalToken_tokenProvider;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExternalToken{");
        sb.append("externalToken_tokenValue='")
                .append(externalToken_tokenValue)
                .append('\'');
        sb.append(", externalToken_cardBin='")
                .append(externalToken_cardBin)
                .append('\'');
        sb.append(", externalToken_cardMask='")
                .append(externalToken_cardMask)
                .append('\'');
        sb.append(", externalToken_cardLength='")
                .append(externalToken_cardLength)
                .append('\'');
        sb.append(", externalToken_cardName='")
                .append(externalToken_cardName)
                .append('\'');
        sb.append(", externalToken_cardExpiration='")
                .append(externalToken_cardExpiration)
                .append('\'');
        sb.append(", externalToken_cardTypeId='")
                .append(externalToken_cardTypeId)
                .append('\'');
        sb.append(", externalToken_cardTypeName='")
                .append(externalToken_cardTypeName)
                .append('\'');
        sb.append(", externalToken_creditCompanyId='")
                .append(externalToken_creditCompanyId)
                .append('\'');
        sb.append(", externalToken_creditCompanyName='")
                .append(externalToken_creditCompanyName)
                .append('\'');
        sb.append(", externalToken_cardBrandId='")
                .append(externalToken_cardBrandId)
                .append('\'');
        sb.append(", externalToken_cardBrandName='")
                .append(externalToken_cardBrandName)
                .append('\'');
        sb.append(", externalToken_cardAcquirerId='")
                .append(externalToken_cardAcquirerId)
                .append('\'');
        sb.append(", externalToken_cardAcquirerName='")
                .append(externalToken_cardAcquirerName)
                .append('\'');
        sb.append(", externalToken_blockedCard='")
                .append(externalToken_blockedCard)
                .append('\'');
        sb.append(", externalToken_extendedCardType='")
                .append(externalToken_extendedCardType)
                .append('\'');
        sb.append(", externalToken_clubName='")
                .append(externalToken_clubName)
                .append('\'');
        sb.append(", externalToken_Indication='")
                .append(externalToken_Indication)
                .append('\'');
        sb.append(", externalToken_tokenProvider='")
                .append(externalToken_tokenProvider)
                .append('\'');
        sb.append('}');
        return sb.toString();
    }
}
