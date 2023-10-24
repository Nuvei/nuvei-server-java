/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.response;

import com.safecharge.model.ExternalTokenInfo;
import com.safecharge.model.FraudDetails;
import com.safecharge.model.PartialApprovalDetails;

/**
 * <p>
 * This is the unified response for the Settle, Void and Refund transaction requests.
 * </p>
 * @author Nikola Dichev
 * @since 3/20/2017
 */
public abstract class SafechargeTransactionResponse extends SafechargeResponse {

    /**
     * The transaction ID of the transaction for future actions.
     */
    private String transactionId;

    /**
     * The transaction ID of the transaction in the event that an external service is used.
     */
    private String externalTransactionId;

    /**
     * The UPO ID used for the transaction.
     */
    private Long userPaymentOptionId;

    /**
     * If an error occurred on the APM side, an error code is returned in this parameter.
     */
    private Integer paymentMethodErrorCode;

    /**
     * If an error occurred on the APM side, an error reason is returned in this parameter.
     */
    private String paymentMethodErrorReason;

    /**
     * If an error occurred in the Gateway, then an error code is returned in this parameter.
     */
    private Integer gwErrorCode;

    /**
     * If an error occurred in the gateway, then an error reason is returned in this parameter.
     * (E.g. failure in checksum validation, timeout from processing engine, etc.)
     */
    private String gwErrorReason;

    /**
     * Error code if error occurred on the bank’s side.
     * When a transaction is successful, this field is 0.
     * When a transaction is not successful, the parameter is the code of the generic error.
     */
    private Integer gwExtendedErrorCode;

    /**
     * The gateway transaction status. Possible values:
     * <ul>
     * <li>APPROVED
     * <li>DECLINED
     * <li>ERROR
     * </ul>
     */
    private String transactionStatus;

    /**
     * The authorization code of the related auth transaction, to be compared to the original one.
     */
    private String authCode;

    /**
     * The 3D secure request data for the card issuer/bank.
     */
    private String paRequest;

    /**
     * The URL used by the merchant to redirect consumers to the payment method for authentication and authorization of the transaction.
     */
    private String redirectUrl;

    /**
     * The Electronic Commerce Indicator (ECI) is returned from banks and indicates whether the attempted transaction
     * passed as full 3D or failed.
     */
    private String eci;

    /**
     * If the attempt for 3D transaction failed - this parameter is returned by the banks to indicate the reason why
     * the transaction was not passed as full 3D.
     */
    private String threeDReason;

    private String threeDFlow;

    private ExternalTokenInfo externalTokenInfo;

    private PartialApprovalDetails partialApprovalDetails;

    private String cvv2Reply;
    private String avsCode;

    private String transactionType;

    private String customData;

    private FraudDetails fraudDetails;

    private String acquirerId;
    private String bin;
    private String last4Digits;
    private String ccCardNumber;
    private String ccExpMonth;
    private String ccExpYear;
    private String cardType;
    private String cardBrand;
    private String issuerCountry;

    private String methodUrl;
    private String threeDSVersion;
    private String v2supported;
    private String methodPayload;

    private String acsChallengeMandated;
    private String cReq;
    private String authenticationType;
    private String cardHolderInfoText;
    private String whiteListStatus;
    private String cavv;
    private String directoryServerId;
    private String directoryServerPublicKey;
    private String acsSignedContent;
    private String serverTransId;
    private String xid;
    private String threeDresult;
    private String acsTransID;
    private String dsTransID;

    private String threeDReasonId;
    private String challengeCancelReasonId;
    private String challengeCancelReason;
    private String isLiabilityOnIssuer;
    private String isExemptionRequestInAuthentication;
    private String challengePreferenceReason;


    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getExternalTransactionId() {
        return externalTransactionId;
    }

    public void setExternalTransactionId(String externalTransactionId) {
        this.externalTransactionId = externalTransactionId;
    }

    public Long getUserPaymentOptionId() {
        return userPaymentOptionId;
    }

    public void setUserPaymentOptionId(Long userPaymentOptionId) {
        this.userPaymentOptionId = userPaymentOptionId;
    }

    public Integer getPaymentMethodErrorCode() {
        return paymentMethodErrorCode;
    }

    public void setPaymentMethodErrorCode(Integer paymentMethodErrorCode) {
        this.paymentMethodErrorCode = paymentMethodErrorCode;
    }

    public String getPaymentMethodErrorReason() {
        return paymentMethodErrorReason;
    }

    public void setPaymentMethodErrorReason(String paymentMethodErrorReason) {
        this.paymentMethodErrorReason = paymentMethodErrorReason;
    }

    public Integer getGwErrorCode() {
        return gwErrorCode;
    }

    public void setGwErrorCode(Integer gwErrorCode) {
        this.gwErrorCode = gwErrorCode;
    }

    public String getGwErrorReason() {
        return gwErrorReason;
    }

    public void setGwErrorReason(String gwErrorReason) {
        this.gwErrorReason = gwErrorReason;
    }

    public Integer getGwExtendedErrorCode() {
        return gwExtendedErrorCode;
    }

    public void setGwExtendedErrorCode(Integer gwExtendedErrorCode) {
        this.gwExtendedErrorCode = gwExtendedErrorCode;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getPaRequest() {
        return paRequest;
    }

    public void setPaRequest(String paRequest) {
        this.paRequest = paRequest;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

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

    public String getThreeDFlow() {
        return threeDFlow;
    }

    public void setThreeDFlow(String threeDFlow) {
        this.threeDFlow = threeDFlow;
    }

    public ExternalTokenInfo getExternalTokenInfo() {
        return externalTokenInfo;
    }

    public void setExternalTokenInfo(ExternalTokenInfo externalTokenInfo) {
        this.externalTokenInfo = externalTokenInfo;
    }

    public PartialApprovalDetails getPartialApprovalDetails() {
        return partialApprovalDetails;
    }

    public void setPartialApprovalDetails(PartialApprovalDetails partialApprovalDetails) {
        this.partialApprovalDetails = partialApprovalDetails;
    }

    public String getCvv2Reply() {
        return cvv2Reply;
    }

    public void setCvv2Reply(String cvv2Reply) {
        this.cvv2Reply = cvv2Reply;
    }

    public String getAvsCode() {
        return avsCode;
    }

    public void setAvsCode(String avsCode) {
        this.avsCode = avsCode;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }

    public FraudDetails getFraudDetails() {
        return fraudDetails;
    }

    public void setFraudDetails(FraudDetails fraudDetails) {
        this.fraudDetails = fraudDetails;
    }

    public String getAcquirerId() {
        return acquirerId;
    }

    public void setAcquirerId(String acquirerId) {
        this.acquirerId = acquirerId;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getLast4Digits() {
        return last4Digits;
    }

    public void setLast4Digits(String last4Digits) {
        this.last4Digits = last4Digits;
    }

    public String getCcCardNumber() {
        return ccCardNumber;
    }

    public void setCcCardNumber(String ccCardNumber) {
        this.ccCardNumber = ccCardNumber;
    }

    public String getCcExpMonth() {
        return ccExpMonth;
    }

    public void setCcExpMonth(String ccExpMonth) {
        this.ccExpMonth = ccExpMonth;
    }

    public String getCcExpYear() {
        return ccExpYear;
    }

    public void setCcExpYear(String ccExpYear) {
        this.ccExpYear = ccExpYear;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

    public String getIssuerCountry() {
        return issuerCountry;
    }

    public void setIssuerCountry(String issuerCountry) {
        this.issuerCountry = issuerCountry;
    }

    public String getMethodUrl() {
        return methodUrl;
    }

    public void setMethodUrl(String methodUrl) {
        this.methodUrl = methodUrl;
    }

    public String getThreeDSVersion() {
        return threeDSVersion;
    }

    public void setThreeDSVersion(String threeDSVersion) {
        this.threeDSVersion = threeDSVersion;
    }

    public String getV2supported() {
        return v2supported;
    }

    public void setV2supported(String v2supported) {
        this.v2supported = v2supported;
    }

    public String getMethodPayload() {
        return methodPayload;
    }

    public void setMethodPayload(String methodPayload) {
        this.methodPayload = methodPayload;
    }

    public String getAcsChallengeMandated() {
        return acsChallengeMandated;
    }

    public void setAcsChallengeMandated(String acsChallengeMandated) {
        this.acsChallengeMandated = acsChallengeMandated;
    }

    public String getcReq() {
        return cReq;
    }

    public void setcReq(String cReq) {
        this.cReq = cReq;
    }

    public String getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(String authenticationType) {
        this.authenticationType = authenticationType;
    }

    public String getCardHolderInfoText() {
        return cardHolderInfoText;
    }

    public void setCardHolderInfoText(String cardHolderInfoText) {
        this.cardHolderInfoText = cardHolderInfoText;
    }

    public String getWhiteListStatus() {
        return whiteListStatus;
    }

    public void setWhiteListStatus(String whiteListStatus) {
        this.whiteListStatus = whiteListStatus;
    }

    public String getCavv() {
        return cavv;
    }

    public void setCavv(String cavv) {
        this.cavv = cavv;
    }

    public String getDirectoryServerId() {
        return directoryServerId;
    }

    public void setDirectoryServerId(String directoryServerId) {
        this.directoryServerId = directoryServerId;
    }

    public String getDirectoryServerPublicKey() {
        return directoryServerPublicKey;
    }

    public void setDirectoryServerPublicKey(String directoryServerPublicKey) {
        this.directoryServerPublicKey = directoryServerPublicKey;
    }

    public String getAcsSignedContent() {
        return acsSignedContent;
    }

    public void setAcsSignedContent(String acsSignedContent) {
        this.acsSignedContent = acsSignedContent;
    }

    public String getServerTransId() {
        return serverTransId;
    }

    public void setServerTransId(String serverTransId) {
        this.serverTransId = serverTransId;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getThreeDresult() {
        return threeDresult;
    }

    public void setThreeDresult(String threeDresult) {
        this.threeDresult = threeDresult;
    }

    public String getAcsTransID() {
        return acsTransID;
    }

    public void setAcsTransID(String acsTransID) {
        this.acsTransID = acsTransID;
    }

    public String getDsTransID() {
        return dsTransID;
    }

    public void setDsTransID(String dsTransID) {
        this.dsTransID = dsTransID;
    }

    public String getThreeDReasonId() {
        return threeDReasonId;
    }

    public void setThreeDReasonId(String threeDReasonId) {
        this.threeDReasonId = threeDReasonId;
    }

    public String getChallengeCancelReasonId() {
        return challengeCancelReasonId;
    }

    public void setChallengeCancelReasonId(String challengeCancelReasonId) {
        this.challengeCancelReasonId = challengeCancelReasonId;
    }

    public String getChallengeCancelReason() {
        return challengeCancelReason;
    }

    public void setChallengeCancelReason(String challengeCancelReason) {
        this.challengeCancelReason = challengeCancelReason;
    }

    public String getIsLiabilityOnIssuer() {
        return isLiabilityOnIssuer;
    }

    public void setIsLiabilityOnIssuer(String isLiabilityOnIssuer) {
        this.isLiabilityOnIssuer = isLiabilityOnIssuer;
    }

    public String getIsExemptionRequestInAuthentication() {
        return isExemptionRequestInAuthentication;
    }

    public void setIsExemptionRequestInAuthentication(String isExemptionRequestInAuthentication) {
        this.isExemptionRequestInAuthentication = isExemptionRequestInAuthentication;
    }

    public String getChallengePreferenceReason() {
        return challengePreferenceReason;
    }

    public void setChallengePreferenceReason(String challengePreferenceReason) {
        this.challengePreferenceReason = challengePreferenceReason;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("transactionId='").append(transactionId).append('\'');
        sb.append(", externalTransactionId='").append(externalTransactionId).append('\'');
        sb.append(", userPaymentOptionId=").append(userPaymentOptionId);
        sb.append(", paymentMethodErrorCode=").append(paymentMethodErrorCode);
        sb.append(", paymentMethodErrorReason='").append(paymentMethodErrorReason).append('\'');
        sb.append(", gwErrorCode=").append(gwErrorCode);
        sb.append(", gwErrorReason='").append(gwErrorReason).append('\'');
        sb.append(", gwExtendedErrorCode=").append(gwExtendedErrorCode);
        sb.append(", transactionStatus='").append(transactionStatus).append('\'');
        sb.append(", authCode='").append(authCode).append('\'');
        sb.append(", paRequest='").append(paRequest).append('\'');
        sb.append(", redirectUrl='").append(redirectUrl).append('\'');
        sb.append(", eci='").append(eci).append('\'');
        sb.append(", threeDReason='").append(threeDReason).append('\'');
        sb.append(", threeDFlow='").append(threeDFlow).append('\'');
        sb.append(", externalTokenInfo='").append(externalTokenInfo).append('\'');
        sb.append(", partialApprovalDetails='").append(partialApprovalDetails).append('\'');
        sb.append(", cvv2Replay='").append(cvv2Reply).append('\'');
        sb.append(", avsCode='").append(avsCode).append('\'');
        sb.append(", transactionType='").append(transactionType).append('\'');
        sb.append(", customData='").append(customData).append('\'');
        sb.append(", fraudDetails='").append(fraudDetails).append('\'');
        sb.append(", acquirerId='").append(acquirerId).append('\'');
        sb.append(", bin='").append(bin).append('\'');
        sb.append(", last4Digits='").append(last4Digits).append('\'');
        sb.append(", ccCardNumber='").append(ccCardNumber).append('\'');
        sb.append(", ccExpMonth='").append(ccExpMonth).append('\'');
        sb.append(", cardType='").append(cardType).append('\'');
        sb.append(", cardBrand='").append(cardBrand).append('\'');
        sb.append(", issuerCountry='").append(issuerCountry).append('\'');
        sb.append(", methodUrl='").append(methodUrl).append('\'');
        sb.append(", threeDSVersion='").append(threeDSVersion).append('\'');
        sb.append(", v2supported='").append(v2supported).append('\'');
        sb.append(", methodPayload='").append(methodPayload).append('\'');
        sb.append(", acsChallengeMandated='").append(acsChallengeMandated).append('\'');
        sb.append(", cReq='").append(cReq).append('\'');
        sb.append(", authenticationType='").append(authenticationType).append('\'');
        sb.append(", cardHolderInfoText='").append(cardHolderInfoText).append('\'');
        sb.append(", whiteListStatus='").append(whiteListStatus).append('\'');
        sb.append(", cavv='").append(cavv).append('\'');
        sb.append(", directoryServerId='").append(directoryServerId).append('\'');
        sb.append(", directoryServerPublicKey='").append(directoryServerPublicKey).append('\'');
        sb.append(", acsSignedContent='").append(acsSignedContent).append('\'');
        sb.append(", serverTransId='").append(serverTransId).append('\'');
        sb.append(", xid='").append(xid).append('\'');
        sb.append(", threeDresult='").append(threeDresult).append('\'');
        sb.append(", dsTransID='").append(dsTransID).append('\'');
        sb.append(", threeDReasonId='").append(threeDReasonId).append('\'');
        sb.append(", challengeCancelReasonId='").append(challengeCancelReasonId).append('\'');
        sb.append(", challengeCancelReason='").append(challengeCancelReason).append('\'');
        sb.append(", isLiabilityOnIssuer='").append(isLiabilityOnIssuer).append('\'');
        sb.append(", isExemptionRequestInAuthentication='").append(isExemptionRequestInAuthentication).append('\'');
        sb.append(", challengePreferenceReason='").append(challengePreferenceReason).append('\'');
        sb.append(", ").append(super.toString());

        return sb.toString();
    }
}
