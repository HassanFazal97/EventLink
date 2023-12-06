package com.example.eventlink.use_case.create_events;

import com.example.eventlink.entity.event.Event;
import com.example.eventlink.entity.event.EventFactory;
import java.util.List;
import java.util.Objects;

/**
 * Interactor for creating events, implementing the input boundary specified by CreateEventInputBoundary.
 * This class handles the logic for creating events and interacting with the data access object,
 * the output boundary, and the event factory.
 */
public class CreateEventInteractor implements CreateEventInputBoundary {
    final CreateEventDataAccessInterface eventDataAccessObject;
    final CreateEventOutputBoundary createEventPresenter;
    final EventFactory eventFactory;

    /**
     * Constructs a new CreateEventInteractor with the specified data access, output boundary, and event factory.
     *
     * @param createEventDataAccessInterface the data access interface for event creation
     * @param createEventOutputBoundary      the output boundary for presenting the creation results
     * @param eventFactory                   the factory for creating event entities
     */
    public CreateEventInteractor(CreateEventDataAccessInterface createEventDataAccessInterface,
                                 CreateEventOutputBoundary createEventOutputBoundary,
                                 EventFactory eventFactory) {
        this.eventDataAccessObject = createEventDataAccessInterface;
        this.createEventPresenter = createEventOutputBoundary;
        this.eventFactory = eventFactory;
    }

    /**
     * Executes the event creation process using the provided input data.
     * Creates an event, retrieves all events, and then prepares the view for either success or failure.
     *
     * @param createEventInputData the input data for creating an event
     */
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
            createEventPresenter.prepareSuccessView(createEventOutputData);
        } catch (Exception e) {
            createEventPresenter.prepareFailView(e.getMessage());
        }
    }
}
