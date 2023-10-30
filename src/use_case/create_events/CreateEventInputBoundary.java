package use_case.create_events;

import use_case.createEvent.CreateEventInputData;

public interface CreateEventInputBoundary {
    void execute(CreateEventInputData createEventInputData);
}