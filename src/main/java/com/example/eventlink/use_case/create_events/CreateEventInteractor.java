package com.example.eventlink.use_case.create_events;


import com.example.eventlink.entity.event.Event;
import com.example.eventlink.entity.event.EventFactory;

import java.util.List;
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
        try {
            Event event = eventDataAccessObject.create(
                    createEventInputData.getName(),
                    createEventInputData.getStartDate(),
                    createEventInputData.getStartTime(),
                    createEventInputData.getEndDate(),
                    createEventInputData.getEndTime(),
                    createEventInputData.getCurrency(),
                    createEventInputData.getSummary(),
                    createEventInputData.getIsPrivate());
            List<Event> events = eventDataAccessObject.getAllEvents();
            CreateEventOutputData createEventOutputData = new CreateEventOutputData(event.getName(), events);
            creatEventPresenter.prepareSuccessView(createEventOutputData);
        } catch (Exception e) {
            creatEventPresenter.prepareFailView(e.getMessage());
        }
    }
}
