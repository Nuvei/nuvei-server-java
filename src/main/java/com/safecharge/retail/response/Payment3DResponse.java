package com.safecharge.retail.response;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/10/2017
 */
public class Payment3DResponse extends PaymentsResponse {

    /**
     * Returned from banks and indicate if the transaction passed as full 3D, attempted to do so and failed etc.
     */
    private String eci;

    /**
     * Returned from the banks and indicate the reason if the transaction was not passed as full 3D but attempted to do so and failed etc. 
     */
    private String threeDReason;

    public String getEci() {
        return eci;
    }

    public void setEci(String eci) {
        this.eci = eci;
    }

    public String getThreeDReason() {
        return threeDReason;
    }

    public void setThreeDReason(String threeDReason) {
        this.threeDReason = threeDReason;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Payment3DResponse{");
        sb.append("eci='")
          .append(eci)
          .append('\'');
        sb.append(", threeDReason='")
          .append(threeDReason)
          .append('\'');
        sb.append(", externalToken=")
          .append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
