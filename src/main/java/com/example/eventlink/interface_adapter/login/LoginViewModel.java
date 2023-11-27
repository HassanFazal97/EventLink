package com.example.eventlink.interface_adapter.login;

import com.example.eventlink.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginViewModel extends ViewModel {
    private static final String viewName = "/com.example.eventlink/login-view.fxml";
    private LoginState state = new LoginState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public LoginViewModel() {}
    public static String getViewName(){return viewName;}

    public void setState(LoginState state) {this.state = state;}


    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);}

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public LoginState getState() {return state;}
}
