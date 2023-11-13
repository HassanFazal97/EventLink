package use_case.create_events;

public interface CreateEventOutputBoundary {

    void prepareSuccessView(CreateEventOutputData event);
    void prepareFailView(String error);
}
