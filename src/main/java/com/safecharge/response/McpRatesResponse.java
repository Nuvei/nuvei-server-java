/*
 * Copyright (c) 2007-2020 SafeCharge International Group Limited.
 */

package com.safecharge.response;

import java.util.ArrayList;
import java.util.List;

import com.safecharge.model.Rate;

/**
 * <p>
 * Response received from the Safecharge's servers to the {@link com.safecharge.request.McpRatesRequest}
 * </p>
 *
 * @see com.safecharge.request.McpRatesRequest
 */
public class McpRatesResponse extends SafechargeResponse {

    private String mcpTimestamp;

    private List<Rate> rates;

    public String getMcpTimestamp() {
        return mcpTimestamp;
    }

    public void setMcpTimestamp(String mcpTimestamp) {
        this.mcpTimestamp = mcpTimestamp;
    }

    public List<Rate> getRates() {
        if (rates == null) {
            this.rates = new ArrayList<>();
        }
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
