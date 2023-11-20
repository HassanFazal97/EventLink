package com.example.eventlink.entity.event;

public class CommonEvent implements Event{

    private final String id;
    private final String name;
    private final String start;
    private final String end;
    private final String currency;
    private final String summary;
    private final Boolean isPrivate;


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
}
