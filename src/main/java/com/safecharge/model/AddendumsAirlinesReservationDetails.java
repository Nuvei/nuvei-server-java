package com.safecharge.model;

import java.util.List;

import javax.validation.Valid;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Local payment info specific for some clients. Part of {@link Addendums}.
 *
 * @author <a mailto:bozhidarsh@safecharge.com>Bozhidar Shumanov</a>
 * @see Addendums
 * @since 8/8/2018
 */
public class AddendumsAirlinesReservationDetails {

    private String addendumSent;
    private String pnrCode;
    private String bookingSystemUniqueId;
    private String computerizedReservationSystem;
    private String ticketNumber;
    private String documentType;
    private String flightDateUTC;
    private String issueDate;
    private String travelAgencyCode;
    private String travelAgencyName;
    private String travelAgencyInvoiceNumber;
    private String travelAgencyPlanName;
    private String restrictedTicketIndicator;
    private String issuingCarrierCode;
    private String isCardholderTraveling;
    private String passengersCount;
    private String infantsCount;
    private String payerPassportId;
    private String totalFare;
    private String totalTaxes;
    private String totalFee;
    private String boardingFee;
    private String ticketIssueAddress;

    @Valid
    private List<AddendumsAirlinesPassengerDetails> passengerDetails;

    @Valid
    private List<AddendumsAirlinesFlightLegDetails> flightLegDetails;

    public String getAddendumSent() {
        return addendumSent;
    }

    public String getPnrCode() {
        return pnrCode;
    }

    public String getBookingSystemUniqueId() {
        return bookingSystemUniqueId;
    }

    public String getComputerizedReservationSystem() {
        return computerizedReservationSystem;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getFlightDateUTC() {
        return flightDateUTC;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getTravelAgencyCode() {
        return travelAgencyCode;
    }

    public String getTravelAgencyName() {
        return travelAgencyName;
    }

    public String getTravelAgencyInvoiceNumber() {
        return travelAgencyInvoiceNumber;
    }

    public String getTravelAgencyPlanName() {
        return travelAgencyPlanName;
    }

    public String getRestrictedTicketIndicator() {
        return restrictedTicketIndicator;
    }

    public String getIssuingCarrierCode() {
        return issuingCarrierCode;
    }

    public String getIsCardholderTraveling() {
        return isCardholderTraveling;
    }

    public String getPassengersCount() {
        return passengersCount;
    }

    public String getInfantsCount() {
        return infantsCount;
    }

    public String getPayerPassportId() {
        return payerPassportId;
    }

    public String getTotalFare() {
        return totalFare;
    }

    public String getTotalTaxes() {
        return totalTaxes;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public String getBoardingFee() {
        return boardingFee;
    }

    public String getTicketIssueAddress() {
        return ticketIssueAddress;
    }

    public List<AddendumsAirlinesPassengerDetails> getPassengerDetails() {
        return passengerDetails;
    }

    public List<AddendumsAirlinesFlightLegDetails> getFlightLegDetails() {
        return flightLegDetails;
    }

    public void setAddendumSent(String addendumSent) {
        this.addendumSent = addendumSent;
    }

    public void setPnrCode(String pnrCode) {
        this.pnrCode = pnrCode;
    }

    public void setBookingSystemUniqueId(String bookingSystemUniqueId) {
        this.bookingSystemUniqueId = bookingSystemUniqueId;
    }

    public void setComputerizedReservationSystem(String computerizedReservationSystem) {
        this.computerizedReservationSystem = computerizedReservationSystem;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public void setFlightDateUTC(String flightDateUTC) {
        this.flightDateUTC = flightDateUTC;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public void setTravelAgencyCode(String travelAgencyCode) {
        this.travelAgencyCode = travelAgencyCode;
    }

    public void setTravelAgencyName(String travelAgencyName) {
        this.travelAgencyName = travelAgencyName;
    }

    public void setTravelAgencyInvoiceNumber(String travelAgencyInvoiceNumber) {
        this.travelAgencyInvoiceNumber = travelAgencyInvoiceNumber;
    }

    public void setTravelAgencyPlanName(String travelAgencyPlanName) {
        this.travelAgencyPlanName = travelAgencyPlanName;
    }

    public void setRestrictedTicketIndicator(String restrictedTicketIndicator) {
        this.restrictedTicketIndicator = restrictedTicketIndicator;
    }

    public void setIssuingCarrierCode(String issuingCarrierCode) {
        this.issuingCarrierCode = issuingCarrierCode;
    }

    public void setIsCardholderTraveling(String isCardholderTraveling) {
        this.isCardholderTraveling = isCardholderTraveling;
    }

    public void setPassengersCount(String passengersCount) {
        this.passengersCount = passengersCount;
    }

    public void setInfantsCount(String infantsCount) {
        this.infantsCount = infantsCount;
    }

    public void setPayerPassportId(String payerPassportId) {
        this.payerPassportId = payerPassportId;
    }

    public void setTotalFare(String totalFare) {
        this.totalFare = totalFare;
    }

    public void setTotalTaxes(String totalTaxes) {
        this.totalTaxes = totalTaxes;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public void setBoardingFee(String boardingFee) {
        this.boardingFee = boardingFee;
    }

    public void setTicketIssueAddress(String ticketIssueAddress) {
        this.ticketIssueAddress = ticketIssueAddress;
    }

    public void setPassengerDetails(List<AddendumsAirlinesPassengerDetails> passengerDetails) {
        this.passengerDetails = passengerDetails;
    }

    public void setFlightLegDetails(List<AddendumsAirlinesFlightLegDetails> flightLegDetails) {
        this.flightLegDetails = flightLegDetails;
    }
}