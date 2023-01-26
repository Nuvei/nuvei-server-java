package com.safecharge.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ExternalMpi {

    @Size(min = 1, max = 1, message = "value is invalid. The allowed values are: (0, {max}).")
    @NotNull
    private String isExternalMpi;

    @Size(min = 1, max = 2, message = "value is invalid.")
    @NotNull
    String eci;

    @Size(min = 1, max = 50, message = "value is invalid. The length of the value should be between {min} and {max} symbols.")
    @NotNull
    String cavv;

    @Size(max = 50, message = "value is invalid. The length of the value should be maximum {max} symbols.")
    String xid;

    @Size(max = 36, message = "value is invalid. The length of the value should be maximum {max} symbols.")
    private String dsTransID;

    @Size(max = 25)
    private String challengePreference;

    @Size(max = 25)
    private String exemptionRequestReason;

    @Size(max = 45)
    private String externalTokenProvider;

    public String getIsExternalMpi() {
        return isExternalMpi;
    }

    public String getEci() {
        return eci;
    }

    public String getCavv() {
        return cavv;
    }

    public String getXid() {
        return xid;
    }

    public void setIsExternalMpi(String isExternalMpi) {
        this.isExternalMpi = isExternalMpi;
    }

    public void setEci(String eci) {
        this.eci = eci;
    }

    public void setCavv(String cavv) {
        this.cavv = cavv;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getDsTransID() {
        return dsTransID;
    }

    public void setDsTransID(String dsTransID) {
        this.dsTransID = dsTransID;
    }

    public String getChallengePreference() {
        return challengePreference;
    }

    public void setChallengePreference(String challengePreference) {
        this.challengePreference = challengePreference;
    }

    public String getExemptionRequestReason() {
        return exemptionRequestReason;
    }

    public void setExemptionRequestReason(String exemptionRequestReason) {
        this.exemptionRequestReason = exemptionRequestReason;
    }

    public String getExternalTokenProvider() {
        return externalTokenProvider;
    }

    public void setExternalTokenProvider(String externalTokenProvider) {
        this.externalTokenProvider = externalTokenProvider;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder("ApiExternalMpiDTO [isExternalMpi=");
        builder.append(isExternalMpi)
                .append(", eci=").append(eci)
                .append(", cavv=").append(cavv)
                .append(", xid=").append(xid)
                .append(", exemptionRequestReason=").append(exemptionRequestReason)
                .append(", externalTokenProvider=").append(externalTokenProvider)
                .append(", challengePreference=").append(challengePreference)
                .append(", dsTransId=").append(dsTransID);

        return builder.toString();
    }
}