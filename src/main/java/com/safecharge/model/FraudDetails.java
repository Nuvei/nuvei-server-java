/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

public class FraudDetails {

    private String finalDecision;
    private String recommendations;
    private FraudDetailsSystem system;

    public String getFinalDecision() {
        return finalDecision;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public FraudDetailsSystem getSystem() {
        return system;
    }

    public void setFinalDecision(String finalDecision) {
        this.finalDecision = finalDecision;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public void setSystem(FraudDetailsSystem system) {
        this.system = system;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("FraudDetails [finalDecision=");
        builder.append(finalDecision);
        builder.append(", recommendations=");
        builder.append(recommendations);
        builder.append(", system=");
        builder.append(system);
        builder.append("]");
        return builder.toString();
    }
}