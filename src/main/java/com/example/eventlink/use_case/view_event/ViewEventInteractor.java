package com.example.eventlink.use_case.view_event;

import com.example.eventlink.entity.event.Event;

public class ViewEventInteractor implements ViewEventInputBoundary{
    final ViewEventOutputBoundary viewEventPresenter;
    final ViewEventDataAccessInterface eventDataAccessObject;

    public ViewEventInteractor (ViewEventOutputBoundary viewEventPresenter,
                                ViewEventDataAccessInterface eventDataAccessObject){
        this.viewEventPresenter = viewEventPresenter;
        this.eventDataAccessObject = eventDataAccessObject;
    }
    @Override
    public void execute(ViewEventInputData viewEventInputData) {
        String id = viewEventInputData.getId();
        try {
            Event event = eventDataAccessObject.get(id);
            ViewEventOutputData viewEventOutputData = new ViewEventOutputData(event.getName(), event.getStart(),
                                                                                event.getEnd(), event.getSummary());
            viewEventPresenter.prepareSuccessView(viewEventOutputData);
        }
        catch (Exception e) {
            viewEventPresenter.prepareFailView("Event with id:" + id + " does not exist");
        }
    }
}
