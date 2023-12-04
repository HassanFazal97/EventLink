package com.example.eventlink.use_case.login;

public class LoginOutputData {
    private final String firstName;
    private final String lastName;
    private final String username;

    public LoginOutputData(String firstName, String lastName, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    public String getName() {return firstName + " " + lastName;}

    public String getUsername() {return username;}
}
