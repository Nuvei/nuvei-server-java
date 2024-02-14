/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import javax.validation.constraints.Size;

/**
 * <p>
 * Local payment info specific for some clients. Part of {@link Addendums}.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @see Addendums
 * @since 3/29/2017
 */
public class AddendumsLocalPayment {

    @Size(max = 255)
    private String nationalId;

    @Size(max = 255)
    private String debitType;

    @Size(max = 255)
    private String firstInstallment;

    @Size(max = 255)
    private String periodicalInstallment;

    @Size(max = 255)
    private String numberOfInstallments;

    @Size(max = 12)
    private String vatAmount;

    @Size(max = 12)
    private String nationalConsumptionTaxAmount;

    @Size(max = 12)
    private String taxAmountBase;

    @Size(max = 12)
    private String tipAmount;

    @Size(max = 3)
    private String taxCurrencyCodeBase;

    @Size(max = 12)
    private String airportChargeAmount;

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

    public String getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(String vatAmount) {
        this.vatAmount = vatAmount;
    }

    public String getNationalConsumptionTaxAmount() {
        return nationalConsumptionTaxAmount;
    }

    public void setNationalConsumptionTaxAmount(String nationalConsumptionTaxAmount) {
        this.nationalConsumptionTaxAmount = nationalConsumptionTaxAmount;
    }

    public String getTaxAmountBase() {
        return taxAmountBase;
    }

    public void setTaxAmountBase(String taxAmountBase) {
        this.taxAmountBase = taxAmountBase;
    }

    public String getTipAmount() {
        return tipAmount;
    }

    public void setTipAmount(String tipAmount) {
        this.tipAmount = tipAmount;
    }

    public String getTaxCurrencyCodeBase() {
        return taxCurrencyCodeBase;
    }

    public void setTaxCurrencyCodeBase(String taxCurrencyCodeBase) {
        this.taxCurrencyCodeBase = taxCurrencyCodeBase;
    }

    public String getAirportChargeAmount() {
        return airportChargeAmount;
    }

    public void setAirportChargeAmount(String airportChargeAmount) {
        this.airportChargeAmount = airportChargeAmount;
    }
}
