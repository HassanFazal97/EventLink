package com.example.eventlink.interface_adapter.create_events;

import com.example.eventlink.data_access.EventDataAccessObject;
import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.guest_in.GuestState;
import com.example.eventlink.interface_adapter.guest_in.GuestViewModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInState;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.use_case.create_events.CreateEventOutputBoundary;
import com.example.eventlink.use_case.create_events.CreateEventOutputData;

/**
 * Presenter for handling the presentation logic of the event creation process.
 * Implements the CreateEventOutputBoundary interface to manage how the results
 * of the event creation process are displayed to the user.
 */
public class CreateEventPresenter implements CreateEventOutputBoundary {

    private final CreateEventViewModel createEventViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private final ViewManagerModel viewManagerModel;
    private final GuestViewModel guestViewModel;

    /**
     * Constructs a CreateEventPresenter with the necessary view models and view manager.
     *
     * @param viewManagerModel       The model responsible for managing different views.
     * @param createEventViewModel   The view model for event creation.
     * @param loggedInViewModel      The view model for the logged-in state.
     * @param guestViewModel         The view model for the guest state.
     */
    public CreateEventPresenter(ViewManagerModel viewManagerModel, CreateEventViewModel createEventViewModel,
                                LoggedInViewModel loggedInViewModel, GuestViewModel guestViewModel) {
        this.createEventViewModel = createEventViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
        this.guestViewModel = guestViewModel;
    }

    /**
     * Prepares and displays the success view after an event is successfully created.
     * Updates the relevant view models with success information and switches the active view.
     *
     * @param outputData The data containing details about the successfully created event.
     */
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

    /**
     * Prepares and displays the failure view in case of an error during event creation.
     * Sets an error message in the create event state and updates the view model.
     *
     * @param error The error message describing the failure.
     */
    @Override
    public void prepareFailView(String error) {
        //On Fail, prepare an error message to be displayed on GUI.
        CreateEventState createEventState = createEventViewModel.getState();
        createEventState.setError(error);
        createEventViewModel.firePropertyChanged();
        System.out.println(error);
    }
}
