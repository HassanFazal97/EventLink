package com.example.eventlink.use_case.register_for_event;

/**
 * The RegisterForEventInputBoundary interface defines the input boundary for the Register for Event use case.
 * Classes implementing this interface should provide the means to execute the use case by processing the input data.
 */
public interface RegisterForEventInputBoundary {
    /**
     * Executes the Register for Event use case/process with the provided register for event input data.
     *
     * @param registerForEventInputData The input data containing the necessary information needed for
     *                                  event registration.
     */
    void execute(RegisterForEventInputData registerForEventInputData);
}