/**
 * The ModifyController class is responsible for handling user input and interacting with
 * the modify events use case through the ModifyInputBoundary.
 * It extends the base Controller class and provides a method to execute the modify events operation.
 */

package com.example.eventlink.interface_adapter.modify_events;

import com.example.eventlink.interface_adapter.Controller;
import com.example.eventlink.use_case.modify_events.ModifyInputBoundary;
import com.example.eventlink.use_case.modify_events.ModifyInputData;

public class ModifyController extends Controller {

    /**
     * The ModifyInputBoundary for interacting with the modify events use case.
     */
    final ModifyInputBoundary modifyInteractor;

    /**
     * Constructs a new ModifyController with the specified ModifyInputBoundary.
     *
     * @param modifyInteractor The ModifyInputBoundary for interacting with the modify events use case.
     */
    public ModifyController(ModifyInputBoundary modifyInteractor) {
        this.modifyInteractor = modifyInteractor;
    }

    /**
     * Executes the modify events operation based on the provided input parameters.
     *
     * @param eventName  The modified name of the event.
     * @param startDate  The modified start date of the event.
     * @param startTime  The modified start time of the event.
     * @param endDate    The modified end date of the event.
     * @param endTime    The modified end time of the event.
     * @param currency   The modified currency for the event.
     * @param summary    The modified summary of the event.
     * @param isPrivate  The modified privacy status of the event.
     * @param id         The ID of the event to modify.
     */
    public void execute(String eventName, String startDate, String startTime, String endDate,
                        String endTime, String currency, String summary, Boolean isPrivate, String id) {
        ModifyInputData modifyInputData = new ModifyInputData(id, eventName, startDate,
                startTime, endDate, endTime, currency, summary, isPrivate);
        modifyInteractor.execute(modifyInputData);
    }
}
