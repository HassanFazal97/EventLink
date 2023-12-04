package com.example.eventlink.interface_adapter.modify_events;

public class ModifyState {
    private String userName = "";
    private String name = "";
    private String startDate = "";
    private String startTime = "";
    private String endDate = "";
    private String endTime = "";
    private String currency = "";
    private String summary = "";
    private Boolean isPrivate = false;
    private String id = "";
    private String error = "";

    public ModifyState() {}

    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getStartDate() {return startDate;}
    public void setStartDate(String startDate) {this.startDate = startDate;}

    public String getStartTime() {return startTime;}
    public void setStartTime(String startTime) {this.startTime = startTime;}

    public String getEndTime() {return endTime;}
    public void setEndTime(String endTime) {this.endTime = endTime;}

    public String getEndDate() {return endDate;}
    public void setEndDate(String endDate) {this.endDate = endDate;}

    public String getCurrency() {return currency;}
    public void setCurrency(String currency) {this.currency = currency;}

    public String getSummary() {return summary;}
    public void setSummary(String summary) {this.summary = summary;}

    public Boolean getIsPrivate() {return isPrivate;}
    public void setIsPrivate(Boolean isPrivate) {this.isPrivate = isPrivate;}

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getError(){return error;}
    public void setError(String error) {this.error = error;}
}
