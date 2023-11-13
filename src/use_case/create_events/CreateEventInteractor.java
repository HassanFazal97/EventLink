package use_case.create_events;


import entity.event.Event;
import entity.event.EventFactory;

public class CreateEventInteractor implements CreateEventInputBoundary{
    final CreateEventDataAccessInterface eventDataAccessObject;
    final CreateEventOutputBoundary creatEventPresenter;
    final EventFactory eventFactory;

    public CreateEventInteractor(CreateEventDataAccessInterface createEventDataAccessInterface, CreateEventOutputBoundary createEventOutputBoundary, EventFactory eventFactory ){
        this.eventDataAccessObject = createEventDataAccessInterface;
        this.creatEventPresenter = createEventOutputBoundary;
        this.eventFactory =eventFactory;
    }
    @Override
    public void execute(CreateEventInputData createEventInputData) {
        Event event = eventFactory.create(createEventInputData.getName(), createEventInputData.getStart(),createEventInputData.getEnd(),createEventInputData.getCurrency(),createEventInputData.getSummary(),createEventInputData.getIsPrivate());

    }
}
