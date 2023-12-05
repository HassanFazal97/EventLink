/**
 * The ModifyPresenter class is responsible for preparing views in response to the success
 * or failure of the modify events use case. It implements the ModifyOutputBoundary interface.
 */

package com.example.eventlink.interface_adapter.modify_events;

import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.guest_in.GuestState;
import com.example.eventlink.interface_adapter.guest_in.GuestViewModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInState;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.use_case.modify_events.ModifyOutputBoundary;
import com.example.eventlink.use_case.modify_events.ModifyOutputData;

public class ModifyPresenter implements ModifyOutputBoundary {

    /**
     * The ModifyViewModel for handling modify events views.
     */
    private final ModifyViewModel modifyViewModel;

    /**
     * The LoggedInViewModel for handling views when the user is logged in.
     */
    private final LoggedInViewModel loggedInViewModel;

    /**
     * The GuestViewModel for handling views when the user is a guest.
     */
    private final GuestViewModel guestViewModel;

    /**
     * The ViewManagerModel for managing the active view in the application.
     */
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructs a new ModifyPresenter with the specified dependencies.
     *
     * @param modifyViewModel    The ModifyViewModel for handling modify events views.
     * @param loggedInViewModel  The LoggedInViewModel for handling views when the user is logged in.
     * @param guestViewModel     The GuestViewModel for handling views when the user is a guest.
     * @param viewManagerModel   The ViewManagerModel for managing the active view in the application.
     */
    public ModifyPresenter(ModifyViewModel modifyViewModel, LoggedInViewModel loggedInViewModel,
                           GuestViewModel guestViewModel, ViewManagerModel viewManagerModel) {
        this.modifyViewModel = modifyViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.guestViewModel = guestViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view for a successful modification of events.
     *
     * @param outputData The output data containing details of the modified event.
     */
    @Override
    public void prepareSuccessView(ModifyOutputData outputData) {
        String SUCCESS_MESSAGE = "Successfully modified event: ";

        //On Success, update loggedInEvent view with a success message and switch to it.
        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setEvents(outputData.getEvents());
        loggedInState.setMessage(SUCCESS_MESSAGE + outputData.getEventName());
        this.loggedInViewModel.setState(loggedInState);

        GuestState guestState = guestViewModel.getState();
        guestState.setEvents(outputData.getEvents());
        this.guestViewModel.setState(guestState);

        // Switch to the logged-in view and notify view changes
        this.viewManagerModel.setActiveView(LoggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the view for a failed modification attempt.
     *
     * @param error A string indicating the reason for the modification failure to be displayed on GUI.
     */
    @Override
    public void prepareFailView(String error) {
        //On Fail, prepare an error message to be displayed on GUI.
        ModifyState modifyState = modifyViewModel.getState();
        modifyState.setError(error);
        modifyViewModel.setState(modifyState);
        modifyViewModel.firePropertyChanged();
    }
}
