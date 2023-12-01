package com.example.eventlink.use_case.create_events;


import com.example.eventlink.entity.event.Event;
import com.example.eventlink.entity.event.EventFactory;

public class CreateEventInteractor implements CreateEventInputBoundary{
    final CreateEventDataAccessInterface eventDataAccessObject;
    final CreateEventOutputBoundary creatEventPresenter;
    final EventFactory eventFactory;

    public CreateEventInteractor(CreateEventDataAccessInterface createEventDataAccessInterface, CreateEventOutputBoundary createEventOutputBoundary, EventFactory eventFactory ){
        this.eventDataAccessObject = createEventDataAccessInterface;
        this.creatEventPresenter = createEventOutputBoundary;
        this.eventFactory = eventFactory;
    }

    //TODO: The 0 is just a placeholder ID, it is there solely so I can run the program.
    @Override
    public void execute(CreateEventInputData createEventInputData) {
        Event event = eventDataAccessObject.create(
                createEventInputData.getName(),
                createEventInputData.getStartDate(),
                createEventInputData.getStartTime(),
                createEventInputData.getEndDate(),
                createEventInputData.getEndTime(),
                createEventInputData.getCurrency(),
                createEventInputData.getSummary(),
                createEventInputData.getIsPrivate());
        if (event == null) {
            creatEventPresenter.prepareFailView("Event failed to create, please try again");
        } else {
            CreateEventOutputData createEventOutputData = new CreateEventOutputData(event.getName());
            creatEventPresenter.prepareSuccessView(createEventOutputData);
        }
    }
}
