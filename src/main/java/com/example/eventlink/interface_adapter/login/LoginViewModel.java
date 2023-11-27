package com.example.eventlink.interface_adapter.login;

import com.example.eventlink.interface_adapter.ViewModel;

public class LoginViewModel extends ViewModel {
    private LoginState state = new LoginState();

    public LoginViewModel() {}

    public LoginState getState() {
        return state;
    }
    public void setState(LoginState state) {this.state = state;}
}
