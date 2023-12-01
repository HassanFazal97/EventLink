package com.example.eventlink.interface_adapter.signup;

import java.util.List;

public class SignupState {
    private String username = "";
    private String password = "";
    private String repeatPassword = "";
    private String firstName = "";
    private String lastName = "";
    private List<String> tags = null;

    private String error = "";

    public SignupState(SignupState copy) {
        username = copy.username;
        password = copy.password;
        repeatPassword = copy.repeatPassword;
        firstName = copy.firstName;
        lastName = copy.lastName;
        tags = copy.tags;
    }
    public SignupState() {}

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getRepeatPassword() {return repeatPassword;}
    public void setRepeatPassword(String repeatPassword) {this.repeatPassword = repeatPassword;}

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public List<String> getTags() {return tags;}
    public void setTags(List<String> tags) {this.tags = tags;}

    public String getError() {return error;}
    public void setError(String error) {this.error = error;}
    @Override
    public String toString() {
        return "SignupState{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", repeatPassword='" + repeatPassword + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", tags='" + tags + '\'' +
                '}';
    }
}
