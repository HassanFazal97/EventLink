package com.example.eventlink.interface_adapter.login;

public class LoginViewModel {
    private LoginState state = new LoginState();

    public LoginViewModel() {}
    public LoginState getState() {
        return state;
    }
    public void setState(LoginState state) {this.state = state;}
}
