package com.example.eventlink.use_case.modify_events;

import com.example.eventlink.entity.event.Event;

import java.util.List;

public class ModifyOutputData {
    private final String eventName;
    private final List<Event> events;

    public ModifyOutputData(String eventName, List<Event> events) {
        this.eventName = eventName;
        this.events = events;
    }

    public String getEventName(){return eventName;}
    public List<Event> getEvents() {return events;}

}
