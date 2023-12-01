package com.example.eventlink.interface_adapter;

import com.example.eventlink.interface_adapter.login.LoginState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class ViewModel {
    private final static String viewName = "";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ViewModel() {}
    public static String getViewName() {return viewName;}
    public void firePropertyChanged() {}
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
