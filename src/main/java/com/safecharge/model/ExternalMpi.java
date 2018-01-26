package com.safecharge.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ExternalMpi {

    @Size(max = 1)
    @NotNull
    private String isExternalMpi;

    @Size(max = 2)
    @NotNull
    String eci;

    @Size(max = 50)
    @NotNull
    String cavv;

    @Size(max = 5)
    String xid;

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

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder("ApiExternalMpiDTO [isExternalMpi=");
        builder.append(isExternalMpi);
        builder.append(", eci=");
        builder.append(eci);
        builder.append(", cavv=");
        builder.append(cavv);
        builder.append(", xid=");
        builder.append(xid);

        return builder.toString();
    }
}