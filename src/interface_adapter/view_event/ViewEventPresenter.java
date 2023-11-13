package interface_adapter.view_event;

import use_case.view_event.ViewEventOutputBoundary;
import use_case.view_event.ViewEventOutputData;

public class ViewEventPresenter implements ViewEventOutputBoundary {
    @Override
    public void prepareSuccessView(ViewEventOutputData viewEventOutputData) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
