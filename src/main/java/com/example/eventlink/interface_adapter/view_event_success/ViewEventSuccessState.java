package com.example.eventlink.interface_adapter.view_event_success;

public class ViewEventSuccessState {
    private String userName = "";
    private String eventName = "";
    private String eventStartDate = "";
    private String eventStartTime = "";
    private String eventEndDate = "";
    private String eventEndTime = "";
    private String summary = "";

    public String getUserName() {return userName;}
    public void setUserName(String userName){this.userName = userName;}

    public String getEventName() {return eventName;}
    public void setEventName(String eventName) {this.eventName = eventName;}

    public String getEventStartDate() {return eventStartDate;}
    public void setEventStartDate(String eventStartDate) {this.eventStartDate = eventStartDate;}

    public String getEventStartTime() {return eventStartTime;}
    public void setEventStartTime(String eventStartTime) {this.eventStartTime = eventStartTime;}

    public String getEventEndDate() {return eventEndDate;}
    public void setEventEndDate(String eventEndDate) {this.eventEndDate = eventEndDate;}

    public String getEventEndTime() {return eventEndTime;}
    public void setEventEndTime(String eventEndTime) {this.eventEndTime = eventEndTime;}

    public String getSummary() {return summary;}
    public void setSummary(String summary) {this.summary = summary;}
}
