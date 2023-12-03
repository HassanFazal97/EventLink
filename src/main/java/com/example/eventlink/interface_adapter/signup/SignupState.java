/**
 * The SignupState class represents the state of the signup view, including user input data and error messages.
 */
package com.example.eventlink.interface_adapter.signup;

import java.util.List;

public class SignupState {
    /**
     * The username entered by the user.
     */
    private String username = "";

    /**
     * The password entered by the user.
     */
    private String password = "";

    /**
     * The repeated password entered by the user for confirmation.
     */
    private String repeatPassword = "";

    /**
     * The first name entered by the user.
     */
    private String firstName = "";

    /**
     * The last name entered by the user.
     */
    private String lastName = "";

    /**
     * The list of tags associated with the user.
     */
    private List<String> tags = null;

    /**
     * The error message to be displayed in case of a signup failure.
     */
    private String error = "";

    /**
     * Constructs a new SignupState by copying the data from another instance.
     *
     * @param copy The SignupState instance to copy data from.
     */
    public SignupState(SignupState copy) {
        username = copy.username;
        password = copy.password;
        repeatPassword = copy.repeatPassword;
        firstName = copy.firstName;
        lastName = copy.lastName;
        tags = copy.tags;
    }

    /**
     * Constructs a new empty SignupState.
     */
    public SignupState() {}

    /**
     * Gets the username from the SignupState.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username in the SignupState.
     *
     * @param username The new username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password from the SignupState.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password in the SignupState.
     *
     * @param password The new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the repeated password from the SignupState.
     *
     * @return The repeated password.
     */
    public String getRepeatPassword() {
        return repeatPassword;
    }

    /**
     * Sets the repeated password in the SignupState.
     *
     * @param repeatPassword The new repeated password.
     */
    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    /**
     * Gets the first name from the SignupState.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name in the SignupState.
     *
     * @param firstName The new first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name from the SignupState.
     *
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name in the SignupState.
     *
     * @param lastName The new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the list of tags from the SignupState.
     *
     * @return The list of tags.
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * Sets the list of tags in the SignupState.
     *
     * @param tags The new list of tags.
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * Gets the error message from the SignupState.
     *
     * @return The error message.
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the error message in the SignupState.
     *
     * @param error The new error message.
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Returns a string representation of the SignupState.
     *
     * @return A string representation.
     */
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
