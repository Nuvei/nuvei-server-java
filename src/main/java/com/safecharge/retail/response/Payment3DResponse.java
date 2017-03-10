package com.safecharge.retail.response;

import com.safecharge.retail.model.ExternalToken;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/10/2017
 */
public class Payment3DResponse extends BasePaymentsResponse implements PaymentsResponse {

    /**
     * Returned from banks and indicate if the transaction passed as full 3D, attempted to do so and failed etc.
     */
    private String eci;

    /**
     * Returned from the banks and indicate the reason if the transaction was not passed as full 3D but attempted to do so and failed etc. 
     */
    private String threeDReason;

    /**
     * This block contain external token parameters arriving from a 3rd party payment provider which is not SafeCharge (such as CreditGuard ect.)
     * <p>
     * token_tokenValue
     * token_cardBin
     * token_cardMask
     * token_cardLength
     * token_cardName
     * token_cardExpiration
     * token_cardTypeId
     * token_cardTypeName
     * token_creditCompanyId
     * token_creditCompanyName
     * token_cardBrandId
     * token_cardBrandName
     * token_cardAcquirerId
     * token_cardAcquirerName
     * token_blockedCard
     * token_extendedCardType
     * token_clubName
     * token_lifeStyle"
     */
    private ExternalToken externalToken;

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

    public ExternalToken getExternalToken() {
        return externalToken;
    }

    public void setExternalToken(ExternalToken externalToken) {
        this.externalToken = externalToken;
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
          .append(externalToken);
        sb.append(", ")
          .append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
