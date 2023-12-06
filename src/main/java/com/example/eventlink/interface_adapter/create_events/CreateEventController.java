package com.example.eventlink.interface_adapter.create_events;

import com.example.eventlink.interface_adapter.Controller;
import com.example.eventlink.use_case.create_events.CreateEventInputBoundary;
import com.example.eventlink.use_case.create_events.CreateEventInputData;

/**
 * Controller for handling event creation requests.
 * This class receives input from the user interface, creates a CreateEventInputData object,
 * and passes it to the CreateEventInputBoundary (use case interactor) for processing.
 */
public class CreateEventController extends Controller {

    final CreateEventInputBoundary createEventUseCaseInteractor;

    /**
     * Constructs a new CreateEventController with the specified event creation use case interactor.
     *
     * @param createEventUseCaseInteractor the use case interactor responsible for event creation logic
     */
    public CreateEventController(CreateEventInputBoundary createEventUseCaseInteractor){
        this.createEventUseCaseInteractor = createEventUseCaseInteractor;
    }

    /**
     * Initiates the event creation process by constructing the CreateEventInputData
     * and passing it to the use case interactor.
     *
     * @param name       the name of the event
     * @param startDate  the start date of the event
     * @param startTime  the start time of the event
     * @param endDate    the end date of the event
     * @param endTime    the end time of the event
     * @param currency   the currency used for the event
     * @param summary    a brief summary of the event
     * @param isPrivate  the privacy status of the event (true for private, false for public)
     */
    public void execute(String name, String startDate, String startTime, String endDate,
                        String endTime, String currency, String summary, Boolean isPrivate){
        CreateEventInputData createEventInputData = new CreateEventInputData(name,
                startDate, startTime, endDate, endTime, currency, summary, isPrivate);
        createEventUseCaseInteractor.execute(createEventInputData);
    }
}
