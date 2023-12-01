package com.example.eventlink.interface_adapter.create_events;

import javafx.scene.control.TextField;

/**
 * The CreateEventState class represents the state of an event
 * that a user is creating in the EventLink application.
 * It encapsulates information such as event details, and any errors that
 * may occur during the registration process for an event.
 * <p>
 * This class provides getter and setter methods for each attribute,
 * allowing external classes to interact with and modify the state.
 * </p>
 *
 * @version 1.0
 */

public class CreateEventState {
    private String userName = "";
    private String name = "";
    private String startDate = "";
    private String startTime= "";
    private String endDate = "";
    private String endTime = "";
    private final String CURRENCY = "CAD";
    private String summary = "";
    private Boolean isPrivate = false;
    private String error = "";

    public CreateEventState(CreateEventState copy){
        this.userName = copy.userName;
        this.name = copy.name;
        this.startDate = copy.startDate;
        this.startTime = copy.startTime;
        this.endDate = copy.endDate;
        this.endTime = copy.endTime;
        this.summary = copy.summary;
        this.isPrivate = copy.isPrivate;
        this.error = copy.error;
    }

    public CreateEventState(){}

    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getStartDate() {return startDate;}
    public void setStartDate(String startDate) {this.startDate = startDate;}

    public String getStartTime() {return startTime;}
    public void setStartTime(String startTime) {this.startTime = startTime;}

    public String getEndDate() {return endDate;}
    public void setEndDate(String end) {this.endDate = end;}

    public String getEndTime() {return endTime;}
    public void setEndTime(String endTime) {this.endTime = endTime;}

    public String getCurrency() {return CURRENCY;}

    public String getSummary() {return summary;}
    public void setSummary(String summary) {this.summary = summary;}

    public Boolean getIsPrivate() {return isPrivate;}
    public void setIsPrivate(Boolean isPrivate) {this.isPrivate = isPrivate;}

    public String getError() {return error;}
    public void setError(String error){this.error = error;}

}
