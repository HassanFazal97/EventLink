package com.example.eventlink.interface_adapter.register_for_event;

import com.example.eventlink.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel class for handling the registration for an event.
 */
public class RegisterForEventViewModel extends ViewModel {

    // The path to the FXML view file
    private static final String viewName = "/com.example.eventlink/viewevent-view.fxml";
    private RegisterForEventState state = new RegisterForEventState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Default constructor for RegisterForEventViewModel.
     */
    public RegisterForEventViewModel() {
    }

    /**
     * Gets the path to the FXML view file.
     *
     * @return The view name.
     */
    public static String getViewName() {
        return viewName;
    }

    /**
     * Gets the current state of the registration for an event.
     *
     * @return The current state.
     */
    public RegisterForEventState getState() {
        return state;
    }

    /**
     * Sets the state of the registration for an event.
     *
     * @param state The new state.
     */
    public void setState(RegisterForEventState state) {
        this.state = state;
    }

    /**
     * Fires a property change event to notify listeners about a change in the state.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a property change listener to the support.
     *
     * @param listener The listener to be added.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }


}

