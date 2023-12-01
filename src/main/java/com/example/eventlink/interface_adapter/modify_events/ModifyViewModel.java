package com.example.eventlink.interface_adapter.modify_events;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModifyViewModel {
    private static final String viewName = "/com.example.eventlink/modifyevent-view.fxml";
    private ModifyState state = new ModifyState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public ModifyViewModel(){}
    public static String getViewName() {return viewName;}
    public void setState(ModifyState state) {this.state = state;}
    public void firePropertyChanged() {support.firePropertyChange("state", null, this.state);}
    public void addPropertyChangeListener(PropertyChangeListener listener) {support.addPropertyChangeListener(listener);}
    public ModifyState getState() {return this.state;}

}
