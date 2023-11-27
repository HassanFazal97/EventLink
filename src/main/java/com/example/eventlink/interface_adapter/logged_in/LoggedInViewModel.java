package com.example.eventlink.interface_adapter.logged_in;

import com.example.eventlink.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoggedInViewModel extends ViewModel {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private LoggedInState state = new LoggedInState();

    public LoggedInViewModel() {super("/com.example.eventlink/event-view.fxml");}

    public void setState(LoggedInState state){this.state = state;}
    public LoggedInState getState(){return this.state;}


    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
