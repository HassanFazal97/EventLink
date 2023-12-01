package com.example.eventlink.use_case.login;

public class LoginOutputData {
    private final String firstName;
    private final String lastName;

    public LoginOutputData(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName() {return firstName + " " + lastName;}
}
