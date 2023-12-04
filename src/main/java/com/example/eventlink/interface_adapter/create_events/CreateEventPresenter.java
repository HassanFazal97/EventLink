package com.example.eventlink.interface_adapter.create_events;

import com.example.eventlink.data_access.EventDataAccessObject;
import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.guest_in.GuestState;
import com.example.eventlink.interface_adapter.guest_in.GuestViewModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInState;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.use_case.create_events.CreateEventOutputBoundary;
import com.example.eventlink.use_case.create_events.CreateEventOutputData;

public class CreateEventPresenter implements CreateEventOutputBoundary {

    private final CreateEventViewModel createEventViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private final ViewManagerModel viewManagerModel;
    private final GuestViewModel guestViewModel;

    public CreateEventPresenter(ViewManagerModel viewManagerModel, CreateEventViewModel createEventViewModel, LoggedInViewModel loggedInViewModel, GuestViewModel guestViewModel){
        this.createEventViewModel = createEventViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
        this.guestViewModel = guestViewModel;
    }

    @Override
    public void prepareSuccessView(CreateEventOutputData outputData) {
        String SUCCESS_MESSAGE = "Successfully created event: ";
        //On Success, update loggedInEvent view with a success message and switch to it.
        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setEvents(outputData.getEvents());
        loggedInState.setMessage(SUCCESS_MESSAGE + outputData.getEventName());
        this.loggedInViewModel.setState(loggedInState);

        GuestState guestState = guestViewModel.getState();
        guestState.setEvents(outputData.getEvents());
        this.guestViewModel.setState(guestState);

        this.viewManagerModel.setActiveView(LoggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        //On Fail, prepare an error message to be displayed on GUI.
        CreateEventState createEventState = createEventViewModel.getState();
        createEventState.setError(error);
        createEventViewModel.firePropertyChanged();
        System.out.println(error);
    }
}
