package com.example.eventlink.use_case.create_events;

public class CreateEventOutputData {
    private final String eventName;

    public CreateEventOutputData(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName(){return eventName;}
}
