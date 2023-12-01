package com.example.eventlink.interface_adapter.create_events;

import com.example.eventlink.interface_adapter.Controller;
import com.example.eventlink.use_case.create_events.CreateEventInputBoundary;
import com.example.eventlink.use_case.create_events.CreateEventInputData;

public class CreateEventController extends Controller {

    final CreateEventInputBoundary createEventUseCaseInteractor;
    public CreateEventController(CreateEventInputBoundary createEventUseCaseInteractor){
        this.createEventUseCaseInteractor = createEventUseCaseInteractor;
    }

    public void execute(String name, String startDate, String startTime, String endDate,
                        String endTime, String currency, String summary, Boolean isPrivate){
        CreateEventInputData createEventInputData = new CreateEventInputData(name,
                startDate, startTime, endDate, endTime, currency, summary, isPrivate);
        createEventUseCaseInteractor.execute(createEventInputData);
    }
}
