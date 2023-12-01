package com.example.eventlink.app.use_case_factories;

import com.example.eventlink.entity.event.CommonEventFactory;
import com.example.eventlink.entity.event.EventFactory;
import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.create_events.CreateEventController;
import com.example.eventlink.interface_adapter.create_events.CreateEventPresenter;
import com.example.eventlink.interface_adapter.create_events.CreateEventViewModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.use_case.create_events.CreateEventDataAccessInterface;
import com.example.eventlink.use_case.create_events.CreateEventInputBoundary;
import com.example.eventlink.use_case.create_events.CreateEventInteractor;
import com.example.eventlink.use_case.create_events.CreateEventOutputBoundary;

public class CreateEventUseCaseFactory {
    private CreateEventUseCaseFactory() {}

    public static CreateEventController create(
            ViewManagerModel viewManagerModel,
            CreateEventViewModel createEventViewModel,
            LoggedInViewModel loggedInViewModel,
            CreateEventDataAccessInterface eventDataAccessObject) {

        EventFactory eventFactory = new CommonEventFactory();

        CreateEventOutputBoundary createEventOutputBoundary = new CreateEventPresenter(viewManagerModel,
                createEventViewModel, loggedInViewModel);

        CreateEventInputBoundary createEventInteractor = new CreateEventInteractor(eventDataAccessObject,
                createEventOutputBoundary, eventFactory);

        System.out.println("createEventController Created!");
        return new CreateEventController(createEventInteractor);
    }
}
