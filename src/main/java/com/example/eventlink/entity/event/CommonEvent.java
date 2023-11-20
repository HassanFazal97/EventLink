package com.example.eventlink.entity.event;

public class CommonEvent implements Event{

    private final String id;
    private String name;
    private String start;
    private String end;
    private String currency;
    private String summary;
    private Boolean isPrivate;


    CommonEvent(String id, String name, String start, String end, String currency, String summary, Boolean isPrivate){
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.currency = currency;
        this.summary = summary;
        this.isPrivate = isPrivate;

    }
    @Override
    public String getID() {
        return id;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public String getStart(){
        return start;
    }
    @Override
    public String getEnd(){
        return end;
    }
    @Override
    public String getCurrency(){
        return currency;
    }
    @Override
    public String getSummary(){
        return summary;
    }
    @Override
    public Boolean getIsPrivate(){
        return  isPrivate;
    }

    public void setName(String name) { this.name = name; }
    public void setStart(String start) { this.start = start; }
    public void setEnd(String end) { this.end = end; }
    public void setCurrency(String currency) {this.currency = currency; }
    public void setSummary(String summary) { this.summary = summary; }
    public void setIsPrivate(Boolean isPrivate) { this.isPrivate = isPrivate; }
}
