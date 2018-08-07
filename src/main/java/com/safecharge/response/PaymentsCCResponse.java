package com.safecharge.response;

import com.safecharge.model.PartialApprovalDetails;

public class PaymentsCCResponse extends PaymentsResponse {

    protected PartialApprovalDetails partialApprovalDetails;

    protected String CVV2Reply;
    protected String AVSCode;

    public PartialApprovalDetails getPartialApprovalDetails() {
        return partialApprovalDetails;
    }

    public void setPartialApprovalDetails(PartialApprovalDetails partialApprovalDetails) {
        this.partialApprovalDetails = partialApprovalDetails;
    }

    public String getCVV2Reply() {
        return CVV2Reply;
    }

    public void setCVV2Reply(String CVV2Reply) {
        this.CVV2Reply = CVV2Reply;
    }

    public String getAVSCode() {
        return AVSCode;
    }

    public void setAVSCode(String AVSCode) {
        this.AVSCode = AVSCode;
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("PaymentsCCResponse [");
        sBuilder.append(super.toString());
        sBuilder.append(", partialApprovalDetails=");
        sBuilder.append(partialApprovalDetails);
        sBuilder.append(", CVV2Reply=");
        sBuilder.append(CVV2Reply);
        sBuilder.append(", AVSCode=");
        sBuilder.append(AVSCode);
        sBuilder.append("]");
        return sBuilder.toString();
    }
}
