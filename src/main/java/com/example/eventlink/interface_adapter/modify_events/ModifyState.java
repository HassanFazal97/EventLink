package com.example.eventlink.interface_adapter.modify_events;

public class ModifyState {

    private String name = "";
    private String start= "";
    private String end = "";
    private String currency = "";
    private String summary = "";
    private Boolean isPrivate = false;
    private String eventError = null;

    public ModifyState(ModifyState copy){
        this.name = copy.getName();
        this.start = copy.getStart();
        this.end = copy.getEnd();
        this.currency = copy.getCurrency();
        this.summary = copy.getSummary();
        this.isPrivate = copy.getIsPrivate();
        this.eventError = copy.getEventError();
    }

    public ModifyState() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getEventError() { return eventError; }
    public void setEventError(String eventError) { this.eventError = eventError; }

}
