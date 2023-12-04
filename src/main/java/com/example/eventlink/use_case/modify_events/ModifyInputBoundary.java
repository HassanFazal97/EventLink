/**
 * This interface defines the boundary for the input of the modify events use case.
 * It declares a single method to execute the modification operation based on the provided input data.
 */

package com.example.eventlink.use_case.modify_events;

public interface ModifyInputBoundary {

    /**
     * Executes the modify events use case based on the provided input data.
     *
     * @param modifyInputData The input data containing details for the modification operation.
     */
    void execute(ModifyInputData modifyInputData);

}
