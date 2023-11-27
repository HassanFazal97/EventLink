package com.example.eventlink.use_case.create_events;

public interface CreateEventDataAccessInterface {
    //TODO: I think this and below methods need their API calls modified
    String save(String name, String start, String end, String currency, String summary, Boolean isPrivate);
}
