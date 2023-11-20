package com.example.eventlink.use_case.view_event;

public interface ViewEventOutputBoundary {
    void prepareSuccessView(ViewEventOutputData viewEventOutputData);

    void prepareFailView(String error);
}
