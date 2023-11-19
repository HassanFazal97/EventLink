package com.example.eventlink.interface_adapter.view_event;

import com.example.eventlink.use_case.view_event.ViewEventOutputBoundary;
import com.example.eventlink.use_case.view_event.ViewEventOutputData;

public class ViewEventPresenter implements ViewEventOutputBoundary {
    @Override
    public void prepareSuccessView(ViewEventOutputData viewEventOutputData) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
