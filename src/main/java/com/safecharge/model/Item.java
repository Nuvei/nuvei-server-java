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
}
