package com.safecharge.model;

import javax.validation.constraints.Size;

public class SubMerchant {

    @Size(max = 15)
    private String id;

    @Size(max = 2)
    private String countryCode;

    @Size(max = 20)
    private String city;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "SubMerchant{" +
                "id='" + id + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
