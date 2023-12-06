package com.example.eventlink.use_case.create_events;

import com.example.eventlink.entity.event.Event;
import java.util.List;

/**
 * Class representing the output data for an event creation process.
 * This includes the name of the newly created event and a list of all events.
 */
public class CreateEventOutputData {
    private final String eventName;
    private final List<Event> events;

    /**
     * Constructs a new CreateEventOutputData with the specified event name and list of events.
     *
     * @param eventName the name of the newly created event
     * @param events    the list of all events
     */
    public CreateEventOutputData(String eventName, List<Event> events) {
        this.eventName = eventName;
        this.events = events;
    }

    /**
     * Returns the name of the newly created event.
     *
     * @return the event name
     */
    public String getEventName() { return eventName; }

    /**
     * Returns the list of all events.
     *
     * @return the list of events
     */
    public List<Event> getEvents() { return events; }
}
