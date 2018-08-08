package com.safecharge.model;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Local payment info specific for some clients. Part of {@link Addendums}.
 *
 * @author <a mailto:bozhidarsh@safecharge.com>Bozhidar Shumanov</a>
 * @see Addendums
 * @since 8/8/2018
 */
public class AddendumsAirlinesFlightLegDetails {

    private String flightLegId;

    private String airlineCode;
    private String flightNumber;
    private String departureDate;
    private String arrivalDate;
    private String departureCountry;
    private String departureCity;
    private String departureAirport;
    private String destinationCountry;
    private String destinationCity;
    private String destinationAirport;

    private String type;

    private String flightType;
    private String ticketDeliveryMethod;
    private String ticketDeliveryRecipient;
    private String fareBasisCode;
    private String serviceClass;
    private String seatClass;
    private String stopOverCode;
    private String departureTaxAmount;
    private String departureTaxCurrency;
    private String fareAmount;
    private String feeAmount;
    private String taxAmount;
    private String layoutIntegererval;

    public String getFlightLegId() {
        return flightLegId;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public String getDepartureCountry() {
        return departureCountry;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public String getType() {
        return type;
    }

    public String getFlightType() {
        return flightType;
    }

    public String getTicketDeliveryMethod() {
        return ticketDeliveryMethod;
    }

    public String getTicketDeliveryRecipient() {
        return ticketDeliveryRecipient;
    }

    public String getFareBasisCode() {
        return fareBasisCode;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public String getStopOverCode() {
        return stopOverCode;
    }

    public String getDepartureTaxAmount() {
        return departureTaxAmount;
    }

    public String getDepartureTaxCurrency() {
        return departureTaxCurrency;
    }

    public String getFareAmount() {
        return fareAmount;
    }

    public String getLayoutIntegererval() {
        return layoutIntegererval;
    }

    public void setFlightLegId(String flightLegId) {
        this.flightLegId = flightLegId;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setDepartureCountry(String departureCountry) {
        this.departureCountry = departureCountry;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public void setTicketDeliveryMethod(String ticketDeliveryMethod) {
        this.ticketDeliveryMethod = ticketDeliveryMethod;
    }

    public void setTicketDeliveryRecipient(String ticketDeliveryRecipient) {
        this.ticketDeliveryRecipient = ticketDeliveryRecipient;
    }

    public void setFareBasisCode(String fareBasisCode) {
        this.fareBasisCode = fareBasisCode;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public void setStopOverCode(String stopOverCode) {
        this.stopOverCode = stopOverCode;
    }

    public void setDepartureTaxAmount(String departureTaxAmount) {
        this.departureTaxAmount = departureTaxAmount;
    }

    public void setDepartureTaxCurrency(String departureTaxCurrency) {
        this.departureTaxCurrency = departureTaxCurrency;
    }

    public void setFareAmount(String fareAmount) {
        this.fareAmount = fareAmount;
    }

    public void setLayoutIntegererval(String layoutIntegererval) {
        this.layoutIntegererval = layoutIntegererval;
    }

    public String getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(String feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getServiceClass() {
        return serviceClass;
    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public void setServiceClass(String serviceClass) {
        this.serviceClass = serviceClass;
    }

    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getLegType() {
        return type;
    }

    public void setLegType(String legType) {
        this.type = legType;
    }
}