package com.example.eventlink.use_case.modify_events;

public class ModifyInputData {

    private final String name;
    private final String start;
    private final String end;
    private final String currency;
    private final String summary;
    private final Boolean isPrivate;

    public ModifyInputData(String name, String start, String end, String currency, String summary, Boolean isPrivate){
        this.name = name;
        this.start = start;
        this.end = end;
        this.currency = currency;
        this.summary = summary;
        this.isPrivate = isPrivate;
    }

    public String getName() {
        return name;
    }
    public String getStart() {
        return start;
    }
    public String getEnd() {
        return end;
    }
    public String getCurrency(){
        return currency;
    }
    public String getSummary(){
        return summary;
    }
    public Boolean getIsPrivate(){ return isPrivate; }

}
