package com.example.eventlink.use_case.modify_events;

public interface ModifyOutputBoundary {

    void prepareSuccessView(ModifyOutputData event);

    void prepareFailView(String error);

}
