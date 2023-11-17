package interface_adapter.register_for_event;

import interface_adapter.ViewManagerModel;
import interface_adapter.create_events.CreateEventViewModel;
import use_case.register_for_event.RegisterForEventOutputBoundary;
import use_case.register_for_event.RegisterForEventOutputData;
import view.ViewManager;

public class RegisterForEventPresenter implements RegisterForEventOutputBoundary {

    private final RegisterForEventViewModel registerForEventViewModelViewModel;
    private final ViewManagerModel viewManagerModel;


    public RegisterForEventPresenter(ViewManagerModel viewManagerModel,
                                     RegisterForEventViewModel registerForEventViewModel) {
        this.registerForEventViewModelViewModel = registerForEventViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(RegisterForEventOutputData register) {
    }

    @Override
    public void prepareFailView(String error) {
    }
}
