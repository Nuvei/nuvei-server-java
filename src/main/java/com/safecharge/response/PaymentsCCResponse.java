package com.safecharge.response;

import com.safecharge.model.PartialApprovalDetails;

public class PaymentsCCResponse extends PaymentsResponse {

    protected PartialApprovalDetails partialApprovalDetails;

    protected String CVV2Reply;
    protected String AVSCode;

    protected String transactionType;
    private String externalTokenProvider;

    private String customData;

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

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getExternalTokenProvider() {
        return externalTokenProvider;
    }

    public void setExternalTokenProvider(String externalTokenProvider) {
        this.externalTokenProvider = externalTokenProvider;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentsCCResponse{");
        sb.append("partialApprovalDetails=").append(partialApprovalDetails);
        sb.append(", CVV2Reply='").append(CVV2Reply).append('\'');
        sb.append(", AVSCode='").append(AVSCode).append('\'');
        sb.append(", transactionType='").append(transactionType).append('\'');
        sb.append(", externalTokenProvider='").append(externalTokenProvider).append('\'');
        sb.append(", orderId='").append(orderId).append('\'');
        sb.append(", transactionStatus='").append(transactionStatus).append('\'');
        sb.append(", paymentMethodErrorCode='").append(paymentMethodErrorCode).append('\'');
        sb.append(", paymentMethodErrorReason='").append(paymentMethodErrorReason).append('\'');
        sb.append(", gwErrorCode=").append(gwErrorCode);
        sb.append(", gwErrorReason='").append(gwErrorReason).append('\'');
        sb.append(", gwExtendedErrorCode=").append(gwExtendedErrorCode);
        sb.append(", userPaymentOptionId='").append(userPaymentOptionId).append('\'');
        sb.append(", externalTransactionId='").append(externalTransactionId).append('\'');
        sb.append(", transactionId='").append(transactionId).append('\'');
        sb.append(", authCode='").append(authCode).append('\'');
        sb.append(", userTokenId='").append(userTokenId).append('\'');
        sb.append(", externalToken=").append(externalToken);
        sb.append(", customData=").append(customData);
        sb.append('}');
        return sb.toString();
    }
}