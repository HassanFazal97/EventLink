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
        this.eventFactory =eventFactory;
    }

    //TODO: The 0 is just a placeholder ID, it is there solely so I can run the program.
    @Override
    public void execute(CreateEventInputData createEventInputData) {
        Event event = eventFactory.create("0", createEventInputData.getName(), createEventInputData.getStart(),createEventInputData.getEnd(),createEventInputData.getCurrency(),createEventInputData.getSummary(),createEventInputData.getIsPrivate());

    }
}
