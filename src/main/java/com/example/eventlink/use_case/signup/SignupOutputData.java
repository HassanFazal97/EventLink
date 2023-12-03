/**
 * The SignupOutputData class represents the output data produced after the execution of the signup use case.
 * It encapsulates information such as the username, creation time, and a flag indicating whether the use case failed.
 */
package com.example.eventlink.use_case.signup;

public class SignupOutputData {

    /**
     * The username associated with the signup.
     */
    private final String username;

    /**
     * The timestamp indicating the creation time of the signup.
     */
    private String creationTime;

    /**
     * A flag indicating whether the signup use case failed.
     */
    private boolean useCaseFailed;

    /**
     * Constructs a new SignupOutputData object with the provided information.
     *
     * @param username       The username associated with the signup.
     * @param creationTime   The timestamp indicating the creation time of the signup.
     * @param useCaseFailed  A flag indicating whether the signup use case failed.
     */
    public SignupOutputData(String username, String creationTime, boolean useCaseFailed) {
        this.username = username;
        this.creationTime = creationTime;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Gets the username associated with the signup.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the creation time timestamp.
     *
     * @return The timestamp indicating the creation time of the signup.
     */
    public String getCreationTime() {
        return creationTime;
    }

    /**
     * Sets the creation time timestamp.
     *
     * @param creationTime The timestamp indicating the creation time of the signup.
     */
    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
