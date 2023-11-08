package interface_adapter.create_events;

import use_case.create_events.CreateEventInputBoundary;
import use_case.create_events.CreateEventInputData;

public class CreateEventController {

    final CreateEventInputBoundary createEventUseCaseInteractor;
    public CreateEventController(CreateEventInputBoundary createEventUseCaseInteractor){
        this.createEventUseCaseInteractor = createEventUseCaseInteractor;
    }

    public void execute(String name, String start, String end, String currency, String summary, Boolean isPrivate){
        CreateEventInputData createEventInputData = new CreateEventInputData(name, start, end, currency, summary, isPrivate);
        createEventUseCaseInteractor.execute(createEventInputData);
    }
}
