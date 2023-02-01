/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import javax.validation.constraints.Size;

public class Verify3dThreeD {

    private String paResponse;

    @Size(max = 1)
    private String mpiChallengePreference;

    @Size(max = 3)
    private String externalRiskScore;

    public String getPaResponse() {
        return paResponse;
    }

    public void setPaResponse(String paResponse) {
        this.paResponse = paResponse;
    }

    public String getMpiChallengePreference() {
        return mpiChallengePreference;
    }

    public void setMpiChallengePreference(String mpiChallengePreference) {
        this.mpiChallengePreference = mpiChallengePreference;
    }

    public String getExternalRiskScore() {
        return externalRiskScore;
    }

    public void setExternalRiskScore(String externalRiskScore) {
        this.externalRiskScore = externalRiskScore;
    }
}
