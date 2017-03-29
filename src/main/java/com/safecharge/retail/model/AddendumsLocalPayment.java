package com.safecharge.retail.model;

import javax.validation.constraints.Size;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/29/2017
 */
public class AddendumsLocalPayment {

    @Size(max = 255) private String nationalId;

    @Size(max = 255) private String debitType;

    @Size(max = 255) private String firstInstallment;

    @Size(max = 255) private String periodicalInstallment;

    @Size(max = 255) private String numberOfInstallments;

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getDebitType() {
        return debitType;
    }

    public void setDebitType(String debitType) {
        this.debitType = debitType;
    }

    public String getFirstInstallment() {
        return firstInstallment;
    }

    public void setFirstInstallment(String firstInstallment) {
        this.firstInstallment = firstInstallment;
    }

    public String getPeriodicalInstallment() {
        return periodicalInstallment;
    }

    public void setPeriodicalInstallment(String periodicalInstallment) {
        this.periodicalInstallment = periodicalInstallment;
    }

    public String getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(String numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }
}
