package interface_adapter.create_events;

import interface_adapter.ViewManagerModel;
import use_case.create_events.CreateEventOutputBoundary;
import use_case.create_events.CreateEventOutputData;

public class CreateEventPresenter implements CreateEventOutputBoundary {

    private final CreateEventViewModel createEventViewModel;
    private final ViewManagerModel viewManagerModel;

    public CreateEventPresenter(ViewManagerModel viewManagerModel, CreateEventViewModel createEventViewModel){
        this.createEventViewModel = createEventViewModel;
        this.viewManagerModel = viewManagerModel;

    }

    @Override
    public void prepareSuccessView(CreateEventOutputData event) {


    }
    @Override
    public void prepareFailView(String error) {
        CreateEventState createEventState = createEventViewModel.getState();
        createEventState.setNameError(error);
        createEventViewModel.firePropertyChanged();

    }
}
