package com.example.eventlink.interface_adapter.guest_in;
import com.example.eventlink.entity.event.Event;
import com.example.eventlink.interface_adapter.ViewModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class GuestViewModel extends ViewModel {
    private final static String viewName = "/com.example.eventlink/guest-view.fxml";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private GuestState state = new GuestState();

    public GuestViewModel() {}
    public static String getViewName() {return viewName;}

    public void setState(GuestState state){this.state = state;}
    public GuestState getState(){return this.state;}

    public void firePropertyChanged() {support.firePropertyChange("state", null, this.state);}
    public void addPropertyChangeListener(PropertyChangeListener listener) {support.addPropertyChangeListener(listener);}
}
