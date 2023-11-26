package com.example.eventlink.interface_adapter.login;

public class LoginState {
    private String username = "";
    private String password = "";
    private String error = "";

    public LoginState(LoginState copy) {
        username = copy.username;
        password = copy.password;
        error = copy.error;
    }

    public LoginState() {}

    public String getUsername() {return username;}
    public String getPassword() {return password;}
    public String getError() {return error;}

    public void setUsername(String username) {this.username = username;}
    public void setPassword(String password) {this.password = password;}
    public void setError(String error) {this.error = error;}
}
