package com.safecharge.model;

public class AmountDetails {

    private String totalHandling;
    private String totalShipping;
    private String totalTax;
    private String totalDiscount;
    
    public String getTotalHandling() {
        return totalHandling;
    }
    public void setTotalHandling(String totalHandling) {
        this.totalHandling = totalHandling;
    }
    public String getTotalShipping() {
        return totalShipping;
    }
    public void setTotalShipping(String totalShipping) {
        this.totalShipping = totalShipping;
    }
    public String getTotalTax() {
        return totalTax;
    }
    public void setTotalTax(String totalTax) {
        this.totalTax = totalTax;
    }
    public String getTotalDiscount() {
        return totalDiscount;
    }
    public void setTotalDiscount(String totalDiscount) {
        this.totalDiscount = totalDiscount;
    }
    @Override
    public String toString() {
        
        StringBuilder sBuilder = new StringBuilder("AmountDetails [totalHandling=");
        sBuilder.append(totalHandling);
        sBuilder.append(", totalShipping=");
        sBuilder.append(totalShipping);
        sBuilder.append(", totalTax=");
        sBuilder.append(totalTax);
        sBuilder.append(", totalDiscount=");
        sBuilder.append(totalDiscount);
        sBuilder.append("]");
        return sBuilder.toString();
    }
}
