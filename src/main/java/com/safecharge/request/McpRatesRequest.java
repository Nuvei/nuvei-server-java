

/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.request;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.safecharge.request.builder.SafechargeBuilder;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.API_GENERIC_CHECKSUM_MAPPING)
public class McpRatesRequest extends SafechargeRequest {

    @Size(max = 45)
    private String clientUniqueId;

    @NotNull
    @Size(min = 3, max = 3, message = "Invalid currency iso. Provided currency ISO must be exactly 3 characters long!")
    private String fromCurrency;

    private List<String> toCurrency;

    private List<String> paymentMethods;

    public String getClientUniqueId() {
        return clientUniqueId;
    }

    public void setClientUniqueId(String clientUniqueId) {
        this.clientUniqueId = clientUniqueId;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public List<String> getToCurrency() {
        if (toCurrency == null) {
            toCurrency = new ArrayList<>();
        }

        return toCurrency;
    }

    public void setToCurrency(List<String> toCurrency) {
        this.toCurrency = toCurrency;
    }

    public List<String> getPaymentMethods() {
        if (paymentMethods == null) {
            paymentMethods = new ArrayList<>();
        }

        return paymentMethods;
    }

    public void setPaymentMethods(List<String> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    @Override
    public String toString() {
        return "GetMcpRatesRequest{" +
                "clientUniqueId='" + clientUniqueId + '\'' +
                ", fromCurrency='" + fromCurrency + '\'' +
                ", toCurrency=" + toCurrency +
                ", paymentMethods=" + paymentMethods +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends SafechargeBuilder<Builder> {

        private String clientUniqueId;
        private String fromCurrency;
        private List<String> toCurrency = new ArrayList<>();
        private List<String> paymentMethods = new ArrayList<>();

        public Builder addClientUniqueId(String clientUniqueId) {
            this.clientUniqueId = clientUniqueId;
            return this;
        }

        public Builder addFromCurrency(String fromCurrency) {
            this.fromCurrency = fromCurrency;
            return this;
        }

        public Builder addToCurrency(List<String> toCurrency) {
            if (toCurrency != null) {
                this.toCurrency.addAll(toCurrency);
            }
            return this;
        }

        public Builder addPaymentMethods(List<String> paymentMethods) {
            if (paymentMethods != null) {
                this.paymentMethods.addAll(paymentMethods);
            }
            return this;
        }

        @Override
        public McpRatesRequest build() throws ConstraintViolationException {
            McpRatesRequest request = new McpRatesRequest();
            request.setClientUniqueId(clientUniqueId);
            request.setFromCurrency(fromCurrency);
            request.setToCurrency(toCurrency);
            request.setPaymentMethods(paymentMethods);

            return ValidationUtils.validate(super.build(request));
        }
    }
}
