package com.example.eventlink.interface_adapter.signup;

import com.example.eventlink.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class SignupViewModel extends ViewModel {
    private static final String viewName = "/com.example.eventlink/signup-view.fxml";
    private SignupState state = new SignupState();

    public SignupViewModel() {}
    public static String getViewName() {return viewName;}

    public SignupState getState() {return state;}

    public void setState(SignupState state) {this.state = state;}

}
