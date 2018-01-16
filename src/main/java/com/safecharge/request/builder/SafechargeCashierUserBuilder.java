package com.safecharge.request.builder;

import com.safecharge.request.basic.CashierUserRequest;
import com.safecharge.util.ChecksumUtils;
import com.safecharge.util.Constants;

public abstract class SafechargeCashierUserBuilder<T extends SafechargeCashierUserBuilder<T>> extends SafechargeBuilder<T> {

    private String userTokenId;

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private String city;
    private String zip;
    private String countryCode;
    private String state;
    private String locale;
    private String dateOfBirth;
    private String county;

    public T userTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
        return (T) this;
    }

    public T firstName(String firstName) {
        this.firstName = firstName;
        return (T) this;
    }

    public T lastName(String lastName) {
        this.lastName = lastName;
        return (T) this;
    }

    public T address(String address) {
        this.address = address;
        return (T) this;
    }

    public T email(String email) {
        this.email = email;
        return (T) this;
    }

    public T phone(String phone) {
        this.phone = phone;
        return (T) this;
    }

    public T city(String city) {
        this.city = city;
        return (T) this;
    }

    public T zip(String zip) {
        this.zip = zip;
        return (T) this;
    }

    public T countryCode(String countryCode) {
        this.countryCode = countryCode;
        return (T) this;
    }

    public T state(String state) {
        this.state = state;
        return (T) this;
    }

    public T locale(String locale) {
        this.locale = locale;
        return (T) this;
    }

    public T dateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return (T) this;
    }

    public T county(String county) {
        this.county = county;
        return (T) this;
    }

    public <S extends CashierUserRequest> S build(S request) {

        super.build(request);

        request.setUserTokenId(userTokenId);
        request.setFirstName(firstName);
        request.setLastName(lastName);
        request.setAddress(address);
        request.setEmail(email);
        request.setPhone(phone);
        request.setCity(city);
        request.setZip(zip);
        request.setCountryCode(countryCode);
        request.setState(state);
        request.setLocale(locale);
        request.setDateOfBirth(dateOfBirth);
        request.setCounty(county);

        request.setChecksum(
                ChecksumUtils.calculateChecksum(request, merchantInfo != null ? merchantInfo.getMerchantKey() : "", Constants.CHARSET_UTF8,
                        merchantInfo != null ? merchantInfo.getHashAlgorithm() : null));

        return request;
    }

}
