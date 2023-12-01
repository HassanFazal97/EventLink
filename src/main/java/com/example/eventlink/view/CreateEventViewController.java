package com.example.eventlink.view;

import com.example.eventlink.interface_adapter.Controller;
import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.ViewModel;
import com.example.eventlink.interface_adapter.create_events.CreateEventController;
import com.example.eventlink.interface_adapter.create_events.CreateEventState;
import com.example.eventlink.interface_adapter.create_events.CreateEventViewModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.interface_adapter.signup.SignupController;
import com.example.eventlink.interface_adapter.signup.SignupViewModel;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.format.DateTimeFormatter;

public class CreateEventViewController extends ViewController implements PropertyChangeListener {
    public Label welcomeMessage;
    public TextField eventNameField;
    public DatePicker startDateField;
    public TextField startTimeField;
    public DatePicker endDateField;
    public TextField endTimeField;
    public TextField summaryField;
    public Label errorLabel;

    private CreateEventController createEventController;
    private CreateEventViewModel createEventViewModel;
    private ViewManagerModel viewManagerModel;

    public CreateEventViewController() {}
    @Override
    public void setController(Controller createEventController){
        this.createEventController = (CreateEventController) createEventController;}
    @Override
    public void setViewModel(ViewModel createEventViewModel){
        this.createEventViewModel = (CreateEventViewModel) createEventViewModel;
        this.createEventViewModel.addPropertyChangeListener(this);
    }
    @Override
    public void setViewManagerModel(ViewManagerModel viewManagerModel) {this.viewManagerModel = viewManagerModel;}

    public void cancelButtonClick() {
        System.out.println("Pressed Cancel");
        this.viewManagerModel.setActiveView(LoggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void logOutButtonClick() {
        System.out.println("Pressed Logout");
        this.viewManagerModel.setActiveView(LoginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void createEventButtonClick() {
        CreateEventState currentState = createEventViewModel.getState();
        String startDate = startDateField.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String endDate = endDateField.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        currentState.setName(eventNameField.getText());
        currentState.setStartDate(startDate);
        currentState.setStartTime(startTimeField.getText());
        currentState.setEndDate(endDate);
        currentState.setEndTime(endTimeField.getText());
        currentState.setSummary(summaryField.getText());
        System.out.println("Attempting Create Event");
        createEventViewModel.setState(currentState);

        createEventController.execute(
                currentState.getName(),
                currentState.getStartDate(),
                currentState.getStartTime(),
                currentState.getEndDate(),
                currentState.getEndTime(),
                currentState.getCurrency(),
                currentState.getSummary(),
                currentState.getIsPrivate()
        );
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        CreateEventState state = (CreateEventState) evt.getNewValue();
        String error = state.getError();
        errorLabel.setText(error);
        System.out.println("Label Updated");
    }
}
