/**
 * The SignupInputData class represents the input data required for signup use case.
 * It stores information such as username, password, repeat password, first name,
 * last name, and a list of tags associated with the user.
 */

package com.example.eventlink.use_case.signup;

import java.util.List;

public class SignupInputData {

    /**
     * The username chosen by the user for signup.
     */
    private final String username;

    /**
     * The password chosen by the user for signup.
     */
    private final String password;

    /**
     * The repeated password for confirmation during signup.
     */
    private final String repeatPassword;

    /**
     * The first name of the user signing up.
     */
    private final String firstName;

    /**
     * The last name of the user signing up.
     */
    private final String lastName;

    /**
     * A list of tags associated with the user for categorization.
     */
    private final List<String> tags;

    /**
     * Constructs a new SignupInputData object with the provided information.
     *
     * @param username       The chosen username for signup.
     * @param password       The chosen password for signup.
     * @param repeatPassword The repeated password for confirmation.
     * @param firstName      The first name of the user.
     * @param lastName       The last name of the user.
     * @param tags           A list of tags associated with the user.
     */
    public SignupInputData(String username, String password, String repeatPassword,
                           String firstName, String lastName, List<String> tags) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tags = tags;
    }

    /**
     * Gets the username.
     *
     * @return The username chosen for signup.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password.
     *
     * @return The password chosen for signup.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the repeated password for confirmation.
     *
     * @return The repeated password.
     */
    public String getRepeatPassword() {
        return repeatPassword;
    }

    /**
     * Gets the first name of the user.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of the user.
     *
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the list of tags associated with the user.
     *
     * @return A list of tags.
     */
    public List<String> getTags() {
        return tags;
    }
}
