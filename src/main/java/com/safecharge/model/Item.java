/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <p>
 * Holder for Checkout Page's Merchant's item info.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/14/2017
 */
public class Item {

    @NotNull(message = "name may not be null!")
    @Size(min = 1, max = 255, message = "name size must be up to 255 characters long!")
    private String name;

    @NotNull(message = "price may not be null!")
    @Size(min = 1, max = 10, message = "price size must be up to 10 characters long!")
    private String price;

    @NotNull(message = "quantity may not be null!")
    @Size(min = 1, max = 10, message = "quantity size must be up to 10 characters long!")
    private String quantity;


    @Size(max=50, message = "type size must be up to 50 characters long!")
    private String type;

    @Size(max=10, message = "discount size must be up to 10 characters long!")
    private String discount;

    @Size(max=10, message = "shipping size must be up to 10 characters long!")
    private String shipping;

    @Size(max=10, message = "shippingTax size must be up to 10 characters long!")
    private String shippingTax;

    @Size(max=10, message = "tax size must be up to 10 characters long!")
    private String tax;

    private String groupId;

    private String imageUrl;

    private String productUrl;

    private String taxRate;

    private String discountRate;

    private String shippingTaxRate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public String getShippingTax() {
        return shippingTax;
    }

    public void setShippingTax(String shippingTax) {
        this.shippingTax = shippingTax;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }


    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public String getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate;
    }

    public String getShippingTaxRate() {
        return shippingTaxRate;
    }

    public void setShippingTaxRate(String shippingTaxRate) {
        this.shippingTaxRate = shippingTaxRate;
    }
}
