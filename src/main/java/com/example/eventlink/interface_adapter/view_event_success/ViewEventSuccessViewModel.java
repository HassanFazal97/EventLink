package com.example.eventlink.interface_adapter.view_event_success;

import com.example.eventlink.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ViewEventSuccessViewModel extends ViewModel {
    private static final String viewName = "/com.example.eventlink/viewevent-view.fxml";
    private ViewEventSuccessState state = new ViewEventSuccessState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public static String getViewName() {return viewName;}

    public ViewEventSuccessState getState() {return state;}
    public void setState(ViewEventSuccessState state) {this.state = state;}

    public void addPropertyChangeListener(PropertyChangeListener listener) {support.addPropertyChangeListener(listener);}
    public void firePropertyChanged() {support.firePropertyChange("state", null, this.state);}
}
