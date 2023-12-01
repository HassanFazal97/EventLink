package com.example.eventlink.interface_adapter.create_events;

import com.example.eventlink.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreateEventViewModel extends ViewModel {
    private CreateEventState state = new CreateEventState();
    private final static String viewName = "/com.example.eventlink/createevent-view.fxml";

    public CreateEventViewModel(){}
    public static String getViewName() {return viewName;}

    public void setState(CreateEventState state){
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public CreateEventState getState(){
        return state;
    }

}
