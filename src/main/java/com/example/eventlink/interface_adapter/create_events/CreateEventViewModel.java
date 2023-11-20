package com.example.eventlink.interface_adapter.create_events;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreateEventViewModel {

    public static final String TITLE_LABEL = "Create an Event";
    public static final String EVENTNAME_LABEL = "Choose Event Name";
    public static final String START_LABEL = "Start Date";
    public static final String END_LABEL = "End Date";
    public static final String CURRENCY_LABEL = "Currency";
    public static final String SUMMARY_LABEL = "Summary";
    public static final String IS_PRIVATE_LABEL = "Is Private";
    public static final String CREATE_EVENT_BUTTON_LABEL = "Create Event";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    private CreateEventState state = new CreateEventState();
    public CreateEventViewModel(){}
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
