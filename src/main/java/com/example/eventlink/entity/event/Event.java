package com.example.eventlink.entity.event;

public interface Event {
    String getID();
    String getName();
    String getStart();
    String getEnd();
    String getCurrency();
    String getSummary();
    Boolean getIsPrivate();
    void setName(String name);
    void setStart(String start);
    void setEnd(String end);
    void setCurrency(String currency);
    void setSummary(String summary);
    void setIsPrivate(Boolean isPrivate);
}
