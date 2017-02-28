package com.safecharge.retail.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/14/2017
 */
public class Item {

    @NotNull(message = "name may not be null!") @Size(min = 1,
                                                      max = 255) private String name;

    @NotNull(message = "name may not be null!") @Size(min = 1,
                                                      max = 10) private String price;

    @NotNull(message = "name may not be null!") @Size(min = 1,
                                                      max = 10) private String quantity;

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
