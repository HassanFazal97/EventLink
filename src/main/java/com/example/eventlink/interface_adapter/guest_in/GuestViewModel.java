package com.example.eventlink.interface_adapter.guest_in;

import com.example.eventlink.interface_adapter.logged_in.LoggedInState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GuestViewModel {
    private final static String viewName = "/com.example.eventlink/event-view.fxml";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public GuestViewModel() {}
    public static String getViewName() {return viewName;}
}
