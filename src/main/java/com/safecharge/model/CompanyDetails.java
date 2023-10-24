package com.safecharge.model;

import javax.validation.constraints.Size;

public class CompanyDetails {

    @Size(max = 55)
    private String taxId;

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }


}
