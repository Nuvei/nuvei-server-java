/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

public class FraudRule {

    private String ruleId;
    private String ruleDescription;

    public FraudRule() {
        super();
    }

    public FraudRule(String ruleId, String ruleDescription) {
        super();
        this.ruleId = ruleId;
        this.ruleDescription = ruleDescription;
    }

    public String getRuleId() {
        return ruleId;
    }

    public String getRuleDescription() {
        return ruleDescription;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public void setRuleDescription(String ruleDescription) {
        this.ruleDescription = ruleDescription;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("FraudRule [ruleId=");
        builder.append(ruleId);
        builder.append(", ruleDescription=");
        builder.append(ruleDescription);
        builder.append("]");
        return builder.toString();
    }
}