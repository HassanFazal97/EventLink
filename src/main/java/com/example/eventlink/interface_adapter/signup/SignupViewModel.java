/**
 * The SignupViewModel class represents the view model for managing the
 * state and data related to the signup view.
 */
package com.example.eventlink.interface_adapter.signup;

import com.example.eventlink.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SignupViewModel extends ViewModel {

    /**
     * The path to the FXML file associated with the signup view.
     */
    private static final String viewName = "/com.example.eventlink/signup-view.fxml";

    /**
     * The state representing the current state of the signup view.
     */
    private SignupState state = new SignupState();

    /**
     * The PropertyChangeSupport object for handling property change events.
     */
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Constructs a new SignupViewModel.
     */
    public SignupViewModel() {}

    /**
     * Gets the path to the FXML file associated with the signup view.
     *
     * @return The FXML file path.
     */
    public static String getViewName() {return viewName;}

    /**
     * Gets the current state of the signup view.
     *
     * @return The current state.
     */
    public SignupState getState() {return state;}

    /**
     * Sets the state of the signup view.
     *
     * @param state The new state.
     */
    public void setState(SignupState state) {this.state = state;}

    /**
     * Adds a PropertyChangeListener to listen for property change events.
     *
     * @param listener The listener to be added.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {support.addPropertyChangeListener(listener);}

    /**
     * Notifies registered listeners about a property change event.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
}
