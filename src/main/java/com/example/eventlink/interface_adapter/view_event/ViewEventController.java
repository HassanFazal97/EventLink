package com.example.eventlink.interface_adapter.view_event;

import com.example.eventlink.interface_adapter.Controller;
import com.example.eventlink.use_case.view_event.ViewEventInputBoundary;
import com.example.eventlink.use_case.view_event.ViewEventInputData;

public class ViewEventController extends Controller {
    final ViewEventInputBoundary viewEventInteractor;

    public ViewEventController(ViewEventInputBoundary viewEventInteractor) {
        this.viewEventInteractor = viewEventInteractor;
    }

    public void execute(String eventId) {
        ViewEventInputData viewEventInputData = new ViewEventInputData(eventId);
        viewEventInteractor.execute(viewEventInputData);
    }
}
