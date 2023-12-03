/**
 * The SignupUserDataAccessInterface interface defines the outline for data access operations
 * related to users for the signup process.
 */
package com.example.eventlink.use_case.signup;
import com.example.eventlink.entity.user.User;

public interface SignupUserDataAccessInterface {

    /**
     * Checks if a user with the given username already exists.
     *
     * @param username The username to check for existence.
     * @return True if a user with the given username exists, false otherwise.
     */
    boolean existsByName(String username);

    /**
     * Saves a user entity to the database.
     *
     * @param user The user entity to be saved.
     */
    void save(User user);
}
