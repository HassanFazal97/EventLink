package com.example.eventlink.use_case.create_events;


import com.example.eventlink.entity.event.Event;
import com.example.eventlink.entity.event.EventFactory;

import java.util.Objects;

public class CreateEventInteractor implements CreateEventInputBoundary{
    final CreateEventDataAccessInterface eventDataAccessObject;
    final CreateEventOutputBoundary creatEventPresenter;
    final EventFactory eventFactory;

    public CreateEventInteractor(CreateEventDataAccessInterface createEventDataAccessInterface, CreateEventOutputBoundary createEventOutputBoundary, EventFactory eventFactory ){
        this.eventDataAccessObject = createEventDataAccessInterface;
        this.creatEventPresenter = createEventOutputBoundary;
        this.eventFactory = eventFactory;
    }

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
        if (Objects.equals(event.getID(), "")) {
            //TODO: FIX THIS IT IS NOT CORRECT IT SHOULD FAIL TO CREATE AN EVENT
            creatEventPresenter.prepareFailView("Event failed to create, please try again");
        } else {
            CreateEventOutputData createEventOutputData = new CreateEventOutputData(event.getName());
            creatEventPresenter.prepareSuccessView(createEventOutputData);
        }
    }
}
