package com.lasalle.automation.vueling.web.model;

public class FlightDTO {
    private String origin;
    private String destination;
    private String outbound;
    private String returnDate;
    private String passengers;


    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOutbound() {
        return outbound;
    }

    public void setOutbound(String outbound) {
        this.outbound = outbound;
    }

    public String getreturnDate() {
        return returnDate;
    }

    public void setreturnDate(String areturnDate) {
        returnDate = areturnDate;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }
}
