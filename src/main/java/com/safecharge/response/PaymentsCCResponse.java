package com.safecharge.response;

import com.safecharge.model.PartialApprovalDetails;

public class PaymentsCCResponse extends PaymentsResponse {

    protected PartialApprovalDetails partialApprovalDetails;

    public PartialApprovalDetails getPartialApprovalDetails() {
        return partialApprovalDetails;
    }

    public void setPartialApprovalDetails(PartialApprovalDetails partialApprovalDetails) {
        this.partialApprovalDetails = partialApprovalDetails;
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("PaymentsCCResponse [");
        sBuilder.append(super.toString());
        sBuilder.append(", partialApprovalDetails=");
        sBuilder.append(partialApprovalDetails);
        sBuilder.append("]");
        return sBuilder.toString();
    }
}
