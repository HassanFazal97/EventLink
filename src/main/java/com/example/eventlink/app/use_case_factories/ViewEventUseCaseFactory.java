package com.example.eventlink.app.use_case_factories;

import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.view_event.ViewEventController;
import com.example.eventlink.interface_adapter.view_event.ViewEventPresenter;
import com.example.eventlink.interface_adapter.view_event_success.ViewEventSuccessViewModel;
import com.example.eventlink.use_case.view_event.ViewEventDataAccessInterface;
import com.example.eventlink.use_case.view_event.ViewEventInputBoundary;
import com.example.eventlink.use_case.view_event.ViewEventInteractor;
import com.example.eventlink.use_case.view_event.ViewEventOutputBoundary;

public class ViewEventUseCaseFactory {
    private ViewEventUseCaseFactory() {}

    public static ViewEventController create(
            ViewManagerModel viewManagerModel,
            ViewEventSuccessViewModel viewEventSuccessViewModel,
            ViewEventDataAccessInterface eventDataAccessObject) {

        ViewEventOutputBoundary viewEventPresenter = new ViewEventPresenter(
                viewManagerModel, viewEventSuccessViewModel);

        ViewEventInputBoundary viewEventInteractor = new ViewEventInteractor(
                viewEventPresenter, eventDataAccessObject);

        System.out.println("ViewEventController Created!");
        return new ViewEventController(viewEventInteractor);
    }
}
