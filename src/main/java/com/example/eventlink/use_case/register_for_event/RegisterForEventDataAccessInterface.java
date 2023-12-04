package com.example.eventlink.use_case.register_for_event;

import com.example.eventlink.entity.user.User;

/**
 * The  RegisterForEventDataAccessInterface interface defines methods for accessing and updating user data.
 * Implementing classes provides functionality to retrieve user information by username and update user details.
 */

public interface RegisterForEventDataAccessInterface {
    /**
     * Retrieves user information based on the provided username.
     *
     * @param username The username of the user whose information is to be retrieved.
     * @return The User object containing information about the user.
     */
    User getUser(String username);

    /**
     * Updates the user information with the provided {@code User} object.
     *
     * @param user The User object containing updated information to be stored.
     */
    void updateUser(String username, User user);
}
