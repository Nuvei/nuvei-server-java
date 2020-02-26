package com.safecharge.request;

import com.safecharge.model.Item;
import com.safecharge.model.UrlDetails;
import com.safecharge.model.UserAddress;
import com.safecharge.request.builder.SafechargePPBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class GetPaymentPageRequest extends SafechargeRequest {
    /**
     * ID of the user in merchant system.
     */
    @Size(max = 45, message = "userTokenId size must be up to 45 characters long!")
    private String userTokenId;
    /**
     * ID of the transaction in merchant system.
     */
    @Size(max = 45, message = "clientUniqueId size must be up to 45 characters long!")
    private String clientUniqueId;

    /**
     * The three character ISO currency code.
     */
    @NotNull(message = "currency parameter is mandatory!")
    private String currency;

    /**
     * The transaction amount.
     */
    @NotNull(message = "amount parameter is mandatory!")
    private String amount;

    /**
     * List of items that will be purchased.
     */
    @Valid
    @NotNull
    @Size(min = 1, message = "Request must have at least one item!")
    private List<Item> items = new ArrayList<>();

    /**
     * Although DMN response can be configured per merchant site, it will allow to dynamically return the DMN to the provided address per request.
     */
    private UrlDetails urlDetails;

    /**
     * The type of payment method selected by the customer (pre-selected):
     * credit card: cc_card
     * debit card: dc_card
     * APMs: SafeCharge’s unique name of the payment method (for example apmgw_Neteller).
     */
    private String paymentMethod;

    /**
     * This parameter filters out any payment method that is not the payment method sent in paymentMethod parameter.
     * Possible values: filter or no value at all.
     */
    private String paymentMethodMode;

    /**
     * Billing address related to a user payment option. Since order can contain only one payment option billing address is part of the order parameters.
     */
    @Valid
    private UserAddress billingAddress;

    /**
     * Adds an item that will be purchased.
     * <p>
     * At least one item must be added for a successful order.
     *
     * @param item the {@link Item} object to add to the list of items that the order contains.
     */
    public void addItem(Item item) {
        this.items.add(item);
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    public String getClientUniqueId() {
        return clientUniqueId;
    }

    public void setClientUniqueId(String clientUniqueId) {
        this.clientUniqueId = clientUniqueId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public UrlDetails getUrlDetails() {
        return urlDetails;
    }

    public void setUrlDetails(UrlDetails urlDetails) {
        this.urlDetails = urlDetails;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethodMode() {
        return paymentMethodMode;
    }

    public void setPaymentMethodMode(String paymentMethodMode) {
        this.paymentMethodMode = paymentMethodMode;
    }

    public UserAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(UserAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public static GetPaymentPageRequest.Builder builder() {
        return new GetPaymentPageRequest.Builder();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetPaymentPageRequest{");
        sb.append("userTokenId='")
                .append(userTokenId)
                .append('\'');
        sb.append(", clientUniqueId='")
                .append(clientUniqueId)
                .append('\'');
        sb.append(", currency='")
                .append(currency)
                .append('\'');
        sb.append(", amount='")
                .append(amount)
                .append('\'');
        sb.append(", items='")
                .append(items)
                .append('\'');
        sb.append(", urlDetails='")
                .append(urlDetails)
                .append('\'');
        sb.append(", paymentMethod='")
                .append(paymentMethod)
                .append('\'');
        sb.append(", paymentMethodMode='")
                .append(paymentMethodMode)
                .append('\'');
        sb.append(", billingAddress='")
                .append(billingAddress)
                .append('\'');
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargePPBuilder<Builder> {

        /**
         * Builds the request.
         *
         * @return {@link SafechargeRequest} object build from the params set by this builder
         */
        @Override
        public SafechargeBaseRequest build() {
            GetPaymentPageRequest getPaymentPageRequest = new GetPaymentPageRequest();
            return ValidationUtils.validate(super.build(getPaymentPageRequest));
        }
    }
}
