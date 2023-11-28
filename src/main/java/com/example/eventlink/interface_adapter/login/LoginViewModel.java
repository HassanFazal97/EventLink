package com.example.eventlink.interface_adapter.login;

import com.example.eventlink.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class LoginViewModel extends ViewModel {
    private LoginState state = new LoginState();

    //TODO Implement firePropertyChanged() and addPropertyChangeListener

    public LoginViewModel() {
        super("Log-in");
    }

    public LoginState getState() {
        return state;
    }
    public void setState(LoginState state) {this.state = state;}

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    @Override
    public void firePropertyChanged() {

    }
}
