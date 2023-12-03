package com.example.eventlink.use_case.register_for_event;

import com.example.eventlink.entity.event.Event;

/**
 * The RegisterForEventOutputData class represents the output data for the
 * RegisterForEvent use case, providing information about the registration results.
 * It encapsulates the event that the user registered for and a flag indicating whether the use case failed.
 */
public class RegisterForEventOutputData {
    private final Event registeredEvent;
    private final boolean useCaseFailed;


    /**
     * Constructs a RegisterForEventOutputData object for a successful registration.
     *
     * @param registeredEvent The event that was successfully registered.
     * @param useCaseFailed  A flag indicating whether the RegisterForEvent use case failed.
     */
    public RegisterForEventOutputData(Event registeredEvent, boolean useCaseFailed) {
        this.registeredEvent = registeredEvent;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Gets the registered event when the registration is successful.
     *
     * @return The event that was successfully registered, or null if the registration failed.
     */
    public Event getRegisteredEvent() {
        return registeredEvent;
    }
}
