package com.example.eventlink.use_case.view_event;

import com.example.eventlink.entity.event.Event;

public interface ViewEventDataAccessInterface {
    Event get(String id);
}
