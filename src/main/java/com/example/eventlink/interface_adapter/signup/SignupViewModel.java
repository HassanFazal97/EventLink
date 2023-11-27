package com.example.eventlink.interface_adapter.signup;

import com.example.eventlink.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class SignupViewModel extends ViewModel {
    private SignupState state = new SignupState();

    public SignupViewModel() {super("/com.example.eventlink/signup-view.fxml");}

    public SignupState getState() {return state;}

    public void setState(SignupState state) {this.state = state;}

}
