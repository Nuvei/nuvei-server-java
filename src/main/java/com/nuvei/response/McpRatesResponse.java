

/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.response;

import java.util.ArrayList;
import java.util.List;

import com.nuvei.model.Rate;

/**
 * <p>
 * Response received from the Nuvei's servers to the {@link com.nuvei.request.McpRatesRequest}
 * </p>
 *
 * @see com.nuvei.request.McpRatesRequest
 */
public class McpRatesResponse extends NuveiResponse {

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
