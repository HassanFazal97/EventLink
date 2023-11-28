package com.example.eventlink.interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

//TODO Implement firePropertyChanged() and addPropertyChangeListener
public class ViewManagerModel {
    private String activeViewName;

    public String getActiveView() {
        return activeViewName;
    }

    public void setActiveView(String activeView) {
        this.activeViewName = activeView;
    }

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {

    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
