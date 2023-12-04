/**
 * The RegisterForEventOutputData class represents the output data for the
 * RegisterForEvent use case, providing information about the registration results.
 * It encapsulates the event that the user registered for and a flag indicating whether the use case failed.
 */

package com.example.eventlink.use_case.register_for_event;

public class RegisterForEventOutputData {
    private final String eventName;

    /**
     * Constructs a RegisterForEventOutputData object for a successful registration.
     *
     * @param registeredEvent The event that was successfully registered.
     */
    public RegisterForEventOutputData(String registeredEvent) {this.eventName = registeredEvent;}

    /**
     * Gets the registered event when the registration is successful.
     *
     * @return The event that was successfully registered, or null if the registration failed.
     */
    public String getRegisteredEvent() {return eventName;}
}
