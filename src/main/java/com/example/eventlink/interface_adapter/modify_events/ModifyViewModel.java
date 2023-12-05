/**
 * The ModifyViewModel class is responsible for managing the state and interaction with the modify events view.
 * It extends the base ViewModel class and utilizes the ModifyState for storing the modification state.
 */

package com.example.eventlink.interface_adapter.modify_events;

import com.example.eventlink.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModifyViewModel extends ViewModel {

    /**
     * The path to the FXML file associated with the modify event view.
     */
    private static final String viewName = "/com.example.eventlink/modifyevent-view.fxml";

    /**
     * The current modification state.
     */
    private ModifyState state = new ModifyState();

    /**
     * The PropertyChangeSupport for handling property change events.
     */
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Constructs a new ModifyViewModel with default values.
     */
    public ModifyViewModel(){}

    /**
     * Gets the path to the FXML file associated with the modify event view.
     *
     * @return The FXML file path.
     */
    public static String getViewName() {return viewName;}

    /**
     * Sets the modification state of the view model.
     *
     * @param state The modification state to set.
     */
    public void setState(ModifyState state) {this.state = state;}

    /**
     * Gets the current modification state.
     *
     * @return The current modification state.
     */
    public ModifyState getState() {return this.state;}

    /**
     * Adds a property change listener to the view model.
     *
     * @param listener The property change listener to add.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {support.addPropertyChangeListener(listener);}

    /**
     * Fires a property change event indicating a change in the modification state.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
}
