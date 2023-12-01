package com.example.eventlink.interface_adapter.signup;

import com.example.eventlink.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SignupViewModel extends ViewModel {
    private static final String viewName = "/com.example.eventlink/signup-view.fxml";
    private SignupState state = new SignupState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public SignupViewModel() {}
    public static String getViewName() {return viewName;}

    public SignupState getState() {return state;}

    public void setState(SignupState state) {this.state = state;}

    public void addPropertyChangeListener(PropertyChangeListener listener) {support.addPropertyChangeListener(listener);}
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
}
