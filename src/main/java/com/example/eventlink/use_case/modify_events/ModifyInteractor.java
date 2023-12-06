/**
 * The ModifyInteractor class implements the business logic for modifying events.
 * It serves as the intermediary between the ModifyInputBoundary and ModifyOutputBoundary,
 * interacting with the ModifyEventDataAccessInterface to perform modifications on events.
 */

package com.example.eventlink.use_case.modify_events;

import com.example.eventlink.entity.event.Event;
import com.example.eventlink.entity.event.EventFactory;

import java.util.List;

public class ModifyInteractor implements ModifyInputBoundary {

    /**
     * The data access object for modifying events.
     */
    final ModifyEventDataAccessInterface eventDataAccessObject;

    /**
     * The presenter for handling the output of the modification process.
     */
    final ModifyOutputBoundary modifyPresenter;

    /**
     * Constructs a new ModifyInteractor with the specified dependencies.
     *
     * @param eventDataAccessObject The data access object for modifying events.
     * @param modifyPresenter       The presenter for handling the output of the modification process.
     */
    public ModifyInteractor(ModifyEventDataAccessInterface eventDataAccessObject, ModifyOutputBoundary modifyPresenter) {
        this.eventDataAccessObject = eventDataAccessObject;
        this.modifyPresenter = modifyPresenter;
    }

    /**
     * Executes the modification of events based on the provided input data.
     *
     * @param modifyInputData The input data containing details for the modification operation.
     */
    @Override
    public void execute(ModifyInputData modifyInputData) {
        // Check if the event with the given ID exists
        if (eventDataAccessObject.get(modifyInputData.getId()) == null) {
            modifyPresenter.prepareFailView("Event not found.");
            return;
        }
        try {
            // Perform the modification operation
            String eventID = eventDataAccessObject.modify(
                    modifyInputData.getId(),
                    modifyInputData.getName(),
                    modifyInputData.getStartDate(),
                    modifyInputData.getStartTime(),
                    modifyInputData.getEndDate(),
                    modifyInputData.getEndTime(),
                    modifyInputData.getCurrency(),
                    modifyInputData.getSummary(),
                    modifyInputData.getIsPrivate());

            // Retrieve the list of all events and the modified event
            List<Event> events = eventDataAccessObject.getAllEvents();
            Event event = eventDataAccessObject.get(eventID);
            String eventName = event.getName();

            // Prepare output data for successful modification
            ModifyOutputData modifyOutputData = new ModifyOutputData(eventName, events);
            modifyPresenter.prepareSuccessView(modifyOutputData);

        } catch (Exception e) {
            // Handle any exceptions and prepare output data for failure
            modifyPresenter.prepareFailView(e.getMessage());
        }
    }
}
