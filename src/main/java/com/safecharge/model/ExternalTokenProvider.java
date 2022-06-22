package com.safecharge.model;

import javax.validation.constraints.Size;

public class ExternalTokenProvider extends ExternalToken {

    @Size(max = 45)
    private String cardType;

    @Size(max = 255)
    private String externalTokenData;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getExternalTokenData() {
        return externalTokenData;
    }

    public void setExternalTokenData(String externalTokenData) {
        this.externalTokenData = externalTokenData;
    }
}