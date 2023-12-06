/**
 * The ModifyOutputBoundary interface defines methods for preparing views in response to the
 * success or failure of the modify events use case.
 */

package com.example.eventlink.use_case.modify_events;

public interface ModifyOutputBoundary {

    /**
     * Prepares the view for a successful event modification.
     *
     * @param event The output data containing details of the modified event.
     */
    void prepareSuccessView(ModifyOutputData event);

    /**
     * Prepares the view for a failed event modification attempt.
     *
     * @param error A string indicating the reason for the modification failure.
     */
    void prepareFailView(String error);

}
