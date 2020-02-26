package com.safecharge.request.builder;

import com.safecharge.model.Item;
import com.safecharge.model.UrlDetails;
import com.safecharge.model.UserAddress;
import com.safecharge.request.GetPaymentPageRequest;
import com.safecharge.util.ChecksumUtils;
import com.safecharge.util.Constants;
import com.safecharge.util.UrlUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class SafechargePPBuilder<T extends SafechargePPBuilder<T>> extends SafechargeBuilder<T> {

    private String currency;
    private String amount;
    private List<Item> items = new ArrayList<>();
    private UrlDetails urlDetails;
    private String userTokenId;
    private String clientUniqueId;
    private String paymentMethod;
    private String paymentMethodMode;
    private UserAddress billingAddress;

    /**
     * Adds amount to the request.
     *
     * @param amount amount value as {@link String} E.g. "10", "10.11", "10.1101"
     * @return this object
     */
    public T addAmount(String amount) {
        this.amount = amount;
        return (T) this;
    }

    /**
     * Adds currency to the request.
     *
     * @param currency the three character ISO currency code
     * @return this object
     */
    public T addCurrency(String currency) {
        this.currency = currency;
        return (T) this;
    }

    /**
     * Adds item to the request. The item is added to a {@link List} of items and is not replaced.
     *
     * @param item the {@link Item} to add to the request
     * @return this object
     */
    public T addItem(Item item) {

        items.add(item);
        return (T) this;
    }

    /**
     * Adds item to the request. The item is added to a {@link List} of items and is not replaced.
     *
     * @param name     the name of the item to add
     * @param price    the price of the item to add
     * @param quantity the quantity of the item to add
     * @return this object
     */
    public T addItem(String name, String price, String quantity) {

        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        item.setQuantity(quantity);

        return addItem(item);
    }

    /**
     * Adds URLs to redirect to in case of success/failure and URL to send notification(DMN) to.
     *
     * @param urlDetails {@link UrlDetails} object to add to the request
     * @return this object
     */
    public T addURLDetails(UrlDetails urlDetails) {

        this.urlDetails = urlDetails;
        return (T) this;
    }

    /**
     * Adds URLs to redirect to in case of success/failure and URL to send notification(DMN) to.
     *
     * @param failureUrl      URL to redirect to in case of failed transaction
     * @param pendingUrl      URL to redirect to in case of pending transaction
     * @param successUrl      URL to redirect to in case of successful transaction
     * @param notificationUrl URL to send notification(DMN) to
     * @return this object
     */
    public T addURLDetails(String failureUrl, String pendingUrl, String successUrl, String notificationUrl) {

        UrlDetails urlDetails = UrlUtils.createUrlDetails(failureUrl, pendingUrl, successUrl, notificationUrl);
        return addURLDetails(urlDetails);
    }

    /**
     * Adds user's token id to the request.
     *
     * @param userTokenId the user's token id to add to the request
     * @return this object
     */
    public T addUserTokenId(String userTokenId) {

        this.userTokenId = userTokenId;
        return (T) this;
    }

    /**
     * Adds client's unique id to the request.
     *
     * @param clientUniqueId the client's unique id to add to the request
     * @return this object
     */
    public T addClientUniqueId(String clientUniqueId) {

        this.clientUniqueId = clientUniqueId;
        return (T) this;
    }

    public T addPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return (T) this;
    }

    public T addPaymentMethodMode(String paymentMethodMode) {
        this.paymentMethodMode = paymentMethodMode;
        return (T) this;
    }

    /**
     * Adds billing info to the request.
     *
     * @param userAddress {@link UserAddress} object to add to the request as billing details
     * @return this object
     */
    public T addBillingDetails(UserAddress userAddress) {

        this.billingAddress = userAddress;
        return (T) this;
    }

    /**
     * Adds the order details data, collected by this builder.
     *
     * @param getPaymentPageRequest an already created request of type T
     * @param <S>                   type parameter
     * @return this object
     */
    protected <S extends GetPaymentPageRequest> S build(S getPaymentPageRequest) {

        super.build(getPaymentPageRequest);

        getPaymentPageRequest.setCurrency(currency);
        getPaymentPageRequest.setAmount(amount);
        for (Item item : items) {
            getPaymentPageRequest.addItem(item);
        }
        getPaymentPageRequest.setUrlDetails(urlDetails);
        getPaymentPageRequest.setUserTokenId(userTokenId);
        getPaymentPageRequest.setClientUniqueId(clientUniqueId);
        getPaymentPageRequest.setPaymentMethod(paymentMethod);
        getPaymentPageRequest.setPaymentMethodMode(paymentMethodMode);
        getPaymentPageRequest.setBillingAddress(billingAddress);

        getPaymentPageRequest.setChecksum(
                ChecksumUtils.calculateChecksum(getPaymentPageRequest, merchantInfo != null ? merchantInfo.getMerchantKey() : "",
                        Constants.CHARSET_UTF8, merchantInfo != null ? merchantInfo.getHashAlgorithm() : null));

        return getPaymentPageRequest;
    }
}
