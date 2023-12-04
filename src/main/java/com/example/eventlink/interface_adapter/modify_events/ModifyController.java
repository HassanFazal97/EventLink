package com.example.eventlink.interface_adapter.modify_events;

import com.example.eventlink.interface_adapter.Controller;
import com.example.eventlink.use_case.modify_events.ModifyInputBoundary;
import com.example.eventlink.use_case.modify_events.ModifyInputData;

public class ModifyController extends Controller {
    final ModifyInputBoundary modifyInteractor;

    public ModifyController(ModifyInputBoundary modifyInteractor) {
        this.modifyInteractor = modifyInteractor;
    }

    public void execute(String eventName, String startDate, String startTime, String endDate,
                        String endTime, String currency, String summary, Boolean isPrivate, String id) {
        ModifyInputData modifyInputData = new ModifyInputData(id, eventName, startDate,
                startTime, endDate, endTime, currency, summary, isPrivate);
        modifyInteractor.execute(modifyInputData);
    }
}
