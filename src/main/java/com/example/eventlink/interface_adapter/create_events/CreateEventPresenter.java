package com.example.eventlink.interface_adapter.create_events;

import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInState;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.use_case.create_events.CreateEventOutputBoundary;
import com.example.eventlink.use_case.create_events.CreateEventOutputData;

public class CreateEventPresenter implements CreateEventOutputBoundary {

    private final CreateEventViewModel createEventViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private final ViewManagerModel viewManagerModel;

    public CreateEventPresenter(ViewManagerModel viewManagerModel, CreateEventViewModel createEventViewModel, LoggedInViewModel loggedInViewModel){
        this.createEventViewModel = createEventViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(CreateEventOutputData event) {
        String SUCCESS_MESSAGE = "Successfully created event: ";

        //On Success, update loggedInEvent view with a success message and switch to it.

        this.viewManagerModel.setActiveView(LoggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setMessage(SUCCESS_MESSAGE + event.getEventName());
        this.loggedInViewModel.setState(loggedInState);
        this.loggedInViewModel.firePropertyChanged();
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
