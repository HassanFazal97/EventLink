package com.example.eventlink.use_case.modify_events;

public class ModifyInputData {

    private final String id;
    private final String name;
    private final String startDate;
    private final String startTime;
    private final String endDate;
    private final String endTime;
    private final String currency;
    private final String summary;
    private final Boolean isPrivate;

    public ModifyInputData(String id, String name, String startDate,String startTime, String endDate,
                           String endTime, String currency, String summary, Boolean isPrivate){
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.currency = currency;
        this.summary = summary;
        this.isPrivate = isPrivate;
    }

    public String getId() { return id; }
    public String getName() {
        return name;
    }
    public String getStartDate() {
        return startDate;
    }
    public String getStartTime(){return startTime;}
    public String getEndDate() {return endDate;}
    public String getEndTime(){return endTime;}
    public String getCurrency(){
        return currency;
    }
    public String getSummary(){
        return summary;
    }
    public Boolean getIsPrivate(){ return isPrivate; }

}
