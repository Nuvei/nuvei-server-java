

/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import javax.validation.constraints.NotNull;

public class CurrencyConversion {

    @NotNull
    private String originalAmount;

    @NotNull
    private String originalCurrency;

    private String type;

    public String getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(String originalAmount) {
        this.originalAmount = originalAmount;
    }

    public String getOriginalCurrency() {
        return originalCurrency;
    }

    public void setOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
