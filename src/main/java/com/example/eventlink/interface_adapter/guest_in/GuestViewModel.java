package com.example.eventlink.interface_adapter.guest_in;

import java.beans.PropertyChangeSupport;

public class GuestViewModel {
    private final static String viewName = "/com.example.eventlink/guest-view.fxml";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public GuestViewModel() {}
    public static String getViewName() {return viewName;}
}
