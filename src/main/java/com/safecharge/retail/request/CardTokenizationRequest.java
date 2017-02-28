package com.safecharge.retail.request;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.safecharge.retail.model.CardData;
import com.safecharge.retail.model.UserAddress;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 2/15/2017
 */
public class CardTokenizationRequest extends BaseSafechargeRequest {

    @Valid private CardData cardData;

    @Valid private UserAddress billingAddress;

    @Size(max = 255,
          message = "userTokenId size must be up to 255 characters long!") private String userTokenId;

    private String ipAddress;

    public CardData getCardData() {
        return cardData;
    }

    public void setCardData(CardData cardData) {
        this.cardData = cardData;
    }

    public UserAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(UserAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("CardTokenizationRequest{");
        sb.append("cardData=")
          .append(cardData);
        sb.append(", billingAddress=")
          .append(billingAddress);
        sb.append(", userTokenId='")
          .append(userTokenId)
          .append('\'');
        sb.append(", ipAddress='")
          .append(ipAddress)
          .append('\'');
        sb.append(", ");
        sb.append(sb.append(super.toString()));
        sb.append('}');
        return sb.toString();
    }
}
