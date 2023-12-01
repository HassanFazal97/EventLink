package com.example.eventlink.interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ViewManagerModel {
    private String activeViewName;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    //Allows activeViewName to be changed.
    public void setActiveView(String activeViewName) {this.activeViewName = activeViewName;}
    //This calls ViewManager to tell it to update.
    public void firePropertyChanged() {
        support.firePropertyChange("view", null, this.activeViewName);
    }
    //This allows ViewManagerModel to be called in order to update.
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

}
