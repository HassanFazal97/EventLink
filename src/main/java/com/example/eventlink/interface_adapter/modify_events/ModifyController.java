package com.example.eventlink.interface_adapter.modify_events;

import com.example.eventlink.interface_adapter.Controller;
import com.example.eventlink.use_case.modify_events.ModifyInputBoundary;
import com.example.eventlink.use_case.modify_events.ModifyInputData;

public class ModifyController extends Controller {

    final ModifyInputBoundary eventModifyUseCaseInteractor;

    public ModifyController(ModifyInputBoundary eventModifyUseCaseInteractor) {
        this.eventModifyUseCaseInteractor = eventModifyUseCaseInteractor;
    }

    public void execute(String id, String name, String startDate, String startTime, String endDate,
                        String endTime, String currency, String summary, boolean isPrivate) {
        ModifyInputData modifyInputData = new ModifyInputData(id, name, startDate, startTime,
                endDate, endTime, currency, summary, isPrivate);
        eventModifyUseCaseInteractor.execute(modifyInputData);
    }

}
