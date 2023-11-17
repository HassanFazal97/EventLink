package use_case.register_for_event;

import use_case.create_events.CreateEventOutputData;

public interface RegisterForEventOutputBoundary {
    void prepareSuccessView(RegisterForEventOutputData register);
    void prepareFailView(String error);
}
