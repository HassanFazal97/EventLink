/**
 * The ModifyOutputData class represents the output data for the modify events use case.
 * It encapsulates information about the modified event name and the list of all events.
 */

package com.example.eventlink.use_case.modify_events;

import com.example.eventlink.entity.event.Event;

import java.util.List;

public class ModifyOutputData {

    /**
     * The name of the modified event.
     */
    private final String eventName;

    /**
     * The list of all events.
     */
    private final List<Event> events;

    /**
     * Constructs a new ModifyOutputData object with the provided details.
     *
     * @param eventName The name of the modified event.
     * @param events    The list of all events.
     */
    public ModifyOutputData(String eventName, List<Event> events) {
        this.eventName = eventName;
        this.events = events;
    }

    /**
     * Gets the name of the modified event.
     *
     * @return The name of the modified event.
     */
    public String getEventName(){return eventName;}

    /**
     * Gets the list of all events, possibly including the modified event.
     *
     * @return The list of all events.
     */
    public List<Event> getEvents() {return events;}

}
