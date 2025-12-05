/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.model;

public class InitPaymentCard extends CardData {

    private ExternalTokenProvider externalToken;

    private InitPaymentThreeD threeD;

    private String acquirerId;

    public String getAcquirerId() {
        return acquirerId;
    }

    public void setAcquirerId(String acquirerId) {
        this.acquirerId = acquirerId;
    }

    public ExternalTokenProvider getExternalToken() {
        return externalToken;
    }

    public void setExternalToken(ExternalTokenProvider externalToken) {
        this.externalToken = externalToken;
    }

    public InitPaymentThreeD getThreeD() {
        return threeD;
    }

    public void setThreeD(InitPaymentThreeD threeD) {
        this.threeD = threeD;
    }
}
