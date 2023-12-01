package com.example.eventlink.interface_adapter.create_events;

import com.example.eventlink.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreateEventViewModel extends ViewModel {
    private final static String viewName = "/com.example.eventlink/createevent-view.fxml";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private CreateEventState state = new CreateEventState();

    public CreateEventViewModel(){}
    public static String getViewName() {return viewName;}
    public void setState(CreateEventState state){this.state = state;}
    public CreateEventState getState(){return state;}

    public void firePropertyChanged() {support.firePropertyChange("state", null, this.state);}
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);}
}
