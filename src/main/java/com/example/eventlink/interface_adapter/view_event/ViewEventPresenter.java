package com.example.eventlink.interface_adapter.view_event;

import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.ViewModel;
import com.example.eventlink.interface_adapter.view_event_success.ViewEventSuccessState;
import com.example.eventlink.interface_adapter.view_event_success.ViewEventSuccessViewModel;
import com.example.eventlink.use_case.view_event.ViewEventOutputBoundary;
import com.example.eventlink.use_case.view_event.ViewEventOutputData;

public class ViewEventPresenter implements ViewEventOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final ViewEventSuccessViewModel viewEventSuccessViewModel;

    public ViewEventPresenter(ViewManagerModel viewManagerModel, ViewEventSuccessViewModel viewEventSuccessViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.viewEventSuccessViewModel = viewEventSuccessViewModel;
    }

    @Override
    public void prepareSuccessView(ViewEventOutputData viewEventOutputData) {
        //On Success, switch to ViewEvent view.
        ViewEventSuccessState viewEventSuccessState = viewEventSuccessViewModel.getState();
        viewEventSuccessState.setEventName(viewEventOutputData.getName());
        viewEventSuccessState.setEventStartDate(viewEventOutputData.getStart().substring(0,10));
        viewEventSuccessState.setEventStartTime(viewEventOutputData.getStart().substring(11));
        viewEventSuccessState.setEventEndDate(viewEventOutputData.getEnd().substring(0,10));
        viewEventSuccessState.setEventEndTime(viewEventOutputData.getEnd().substring(11));
        viewEventSuccessState.setSummary(viewEventOutputData.getSummary());
        viewEventSuccessState.setId(viewEventOutputData.getId());
        viewEventSuccessState.setMessage("");
        this.viewEventSuccessViewModel.setState(viewEventSuccessState);

        this.viewManagerModel.setActiveView(ViewEventSuccessViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {

    }
}
