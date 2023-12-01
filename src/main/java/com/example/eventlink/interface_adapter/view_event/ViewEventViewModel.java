package com.example.eventlink.interface_adapter.view_event;

import com.example.eventlink.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ViewEventViewModel extends ViewModel {
    private static final String viewName = "/com.example.eventlink/viewevent-view.fxml";
    private ViewEventState state = new ViewEventState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public static String getViewName() {return viewName;}

    public ViewEventState getState() {return state;}
    public void setState(ViewEventState state) {this.state = state;}

    public void addPropertyChangeListener(PropertyChangeListener listener) {support.addPropertyChangeListener(listener);}
    public void firePropertyChanged() {support.firePropertyChange("state", null, this.state);}
}
