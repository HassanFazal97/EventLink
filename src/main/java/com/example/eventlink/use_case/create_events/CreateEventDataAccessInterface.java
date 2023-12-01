package com.example.eventlink.use_case.create_events;

import com.example.eventlink.entity.event.Event;

public interface CreateEventDataAccessInterface {
    //TODO: I think this and below methods need their API calls modified
    Event create(String name, String startDate, String startTime, String endDate, String endTime, String currency, String summary, Boolean isPrivate);
}
