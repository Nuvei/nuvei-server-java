/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import javax.validation.constraints.Size;

public class Account {

    @Size(max = 2, message = "age must be up to 2 characters long!")
    private String age;

    @Size(max = 8, message = "lastChangeDate must be up to 8 characters long!")
    private String lastChangeDate;

    @Size(max = 2, message = "lastChangeInd must be up to 2 characters long!")
    private String lastChangeInd;

    @Size(max = 8, message = "registrationDate must be up to 8 characters long!")
    private String registrationDate;

    @Size(max = 8, message = "passwordChangeDate must be up to 8 characters long!")
    private String passwordChangeDate;

    @Size(max = 2, message = "resetInd must be up to 2 characters long!")
    private String resetInd;

    @Size(max = 4, message = "purchasesCount6M must be up to 4 characters long!")
    private String purchasesCount6M;

    @Size(max = 3, message = "addCardAttepmts24H must be up to 3 characters long!")
    private String addCardAttepmts24H;

    @Size(max = 3, message = "transactionsCount24H must be up to 3 characters long!")
    private String transactionsCount24H;

    @Size(max = 3, message = "transactionsCount1Y must be up to 3 characters long!")
    private String transactionsCount1Y;

    @Size(max = 8, message = "cardSavedDate must be up to 8 characters long!")
    private String cardSavedDate;

    @Size(max = 2, message = "cardSavedInd must be up to 2 characters long!")
    private String cardSavedInd;

    @Size(max = 8, message = "addressFirstUseDate must be up to 8 characters long!")
    private String addressFirstUseDate;

    @Size(max = 2, message = "addressFirstUseInd must be up to 2 characters long!")
    private String addressFirstUseInd;

    @Size(max = 2, message = "nameInd must be up to 2 characters long!")
    private String nameInd;

    @Size(max = 2, message = "suspiciousActivityInd must be up to 2 characters long!")
    private String suspiciousActivityInd;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(String lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getLastChangeInd() {
        return lastChangeInd;
    }

    public void setLastChangeInd(String lastChangeInd) {
        this.lastChangeInd = lastChangeInd;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getPasswordChangeDate() {
        return passwordChangeDate;
    }

    public void setPasswordChangeDate(String passwordChangeDate) {
        this.passwordChangeDate = passwordChangeDate;
    }

    public String getResetInd() {
        return resetInd;
    }

    public void setResetInd(String resetInd) {
        this.resetInd = resetInd;
    }

    public String getPurchasesCount6M() {
        return purchasesCount6M;
    }

    public void setPurchasesCount6M(String purchasesCount6M) {
        this.purchasesCount6M = purchasesCount6M;
    }

    public String getAddCardAttepmts24H() {
        return addCardAttepmts24H;
    }

    public void setAddCardAttepmts24H(String addCardAttepmts24H) {
        this.addCardAttepmts24H = addCardAttepmts24H;
    }

    public String getTransactionsCount24H() {
        return transactionsCount24H;
    }

    public void setTransactionsCount24H(String transactionsCount24H) {
        this.transactionsCount24H = transactionsCount24H;
    }

    public String getTransactionsCount1Y() {
        return transactionsCount1Y;
    }

    public void setTransactionsCount1Y(String transactionsCount1Y) {
        this.transactionsCount1Y = transactionsCount1Y;
    }

    public String getCardSavedDate() {
        return cardSavedDate;
    }

    public void setCardSavedDate(String cardSavedDate) {
        this.cardSavedDate = cardSavedDate;
    }

    public String getCardSavedInd() {
        return cardSavedInd;
    }

    public void setCardSavedInd(String cardSavedInd) {
        this.cardSavedInd = cardSavedInd;
    }

    public String getAddressFirstUseDate() {
        return addressFirstUseDate;
    }

    public void setAddressFirstUseDate(String addressFirstUseDate) {
        this.addressFirstUseDate = addressFirstUseDate;
    }

    public String getAddressFirstUseInd() {
        return addressFirstUseInd;
    }

    public void setAddressFirstUseInd(String addressFirstUseInd) {
        this.addressFirstUseInd = addressFirstUseInd;
    }

    public String getNameInd() {
        return nameInd;
    }

    public void setNameInd(String nameInd) {
        this.nameInd = nameInd;
    }

    public String getSuspiciousActivityInd() {
        return suspiciousActivityInd;
    }

    public void setSuspiciousActivityInd(String suspiciousActivityInd) {
        this.suspiciousActivityInd = suspiciousActivityInd;
    }
}
