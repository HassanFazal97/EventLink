package com.example.eventlink.use_case.register_for_event;

public interface RegisterForEventOutputBoundary {
    void prepareSuccessView(RegisterForEventOutputData register);
    void prepareFailView(String error);
}
