package com.safecharge.model;


import java.util.List;

public class FraudDetailsSystem {

    private String systemId;
    private String systemName;
    private String decision;
    private List<FraudRule> rules;

    public String getSystemId() {
        return systemId;
    }

    public String getSystemName() {
        return systemName;
    }

    public String getDecision() {
        return decision;
    }

    public List<FraudRule> getRules() {
        return rules;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public void setRules(List<FraudRule> rules) {
        this.rules = rules;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("FraudDetailsSystem [systemId=");
        builder.append(systemId);
        builder.append(", systemName=");
        builder.append(systemName);
        builder.append(", decision=");
        builder.append(decision);
        builder.append(", rules=");
        builder.append(rules);
        builder.append("]");
        return builder.toString();
    }
}