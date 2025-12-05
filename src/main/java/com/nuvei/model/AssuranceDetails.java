/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.model;

public class AssuranceDetails {

    private boolean cardHolderAuthenticated;
    private boolean accountVerified;

    public boolean isCardHolderAuthenticated() {
        return cardHolderAuthenticated;
    }

    public void setCardHolderAuthenticated(boolean cardHolderAuthenticated) {
        this.cardHolderAuthenticated = cardHolderAuthenticated;
    }

    public boolean isAccountVerified() {
        return accountVerified;
    }

    public void setAccountVerified(boolean accountVerified) {
        this.accountVerified = accountVerified;
    }
}
