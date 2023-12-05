package com.example.eventlink.interface_adapter.create_events;

import com.example.eventlink.interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel for the event creation view in the EventLink application.
 * Manages the state of the event creation view and provides methods
 * to update and observe changes in the view state.
 */
public class CreateEventViewModel extends ViewModel {
    private final static String viewName = "/com.example.eventlink/createevent-view.fxml";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private CreateEventState state = new CreateEventState();

    /**
     * Constructs a new CreateEventViewModel.
     */
    public CreateEventViewModel(){}

    /**
     * Returns the name of the view associated with this ViewModel.
     *
     * @return the view name
     */
    public static String getViewName() { return viewName; }

    /**
     * Sets the state of the event creation view.
     *
     * @param state the new state of the view
     */
    public void setState(CreateEventState state){ this.state = state; }

    /**
     * Returns the current state of the event creation view.
     *
     * @return the current state
     */
    public CreateEventState getState(){ return state; }

    /**
     * Notifies all registered listeners about a change in the view state.
     */
    public void firePropertyChanged() { support.firePropertyChange("state", null, this.state); }

    /**
     * Adds a property change listener to this ViewModel.
     * The listener is notified of state changes.
     *
     * @param listener the PropertyChangeListener to add
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
