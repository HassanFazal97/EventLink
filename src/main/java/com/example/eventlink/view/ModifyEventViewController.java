package com.example.eventlink.view;

import com.example.eventlink.interface_adapter.Controller;
import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.ViewModel;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.interface_adapter.modify_events.ModifyController;
import com.example.eventlink.interface_adapter.modify_events.ModifyState;
import com.example.eventlink.interface_adapter.modify_events.ModifyViewModel;
import com.example.eventlink.interface_adapter.view_event_success.ViewEventSuccessViewModel;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ModifyEventViewController extends ViewController implements PropertyChangeListener {
    public Label welcomeMessage;
    public TextField existingEventName;
    public TextField existingStartTime;
    public TextField existingEndTime;
    public TextArea existingSummary;
    public TextField existingStartDay;
    public TextField existingEndDay;
    public TextField eventNameField;
    public DatePicker startDateField;
    public TextField startTimeField;
    public DatePicker endDateField;
    public TextField endTimeField;
    public TextArea summaryField;
    public Label errorLabel;
    private ViewManagerModel viewManagerModel;
    private ModifyViewModel modifyViewModel;
    private ModifyController modifyController;

    public void setViewModel(ViewModel modifyViewModel) {
        this.modifyViewModel = (ModifyViewModel) modifyViewModel;
        this.modifyViewModel.addPropertyChangeListener(this);
    }
    public void setController(Controller modifyController) {
        this.modifyController = (ModifyController) modifyController;
    }
    public void setViewManagerModel(ViewManagerModel viewManagerModel) {this.viewManagerModel = viewManagerModel;}

    public void logOutButtonClick() {
        System.out.println("Pressed Logout");
        this.viewManagerModel.setActiveView(LoginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
    public void cancelButtonClick() {
        System.out.println("Pressed Cancel");
        this.viewManagerModel.setActiveView(ViewEventSuccessViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
    public void modifyEventButtonClick() {
        ModifyState currentstate = modifyViewModel.getState();
        String startDate = startDateField.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String endDate = endDateField.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        currentstate.setName(eventNameField.getText());
        currentstate.setStartDate(startDate);
        currentstate.setStartTime(startTimeField.getText());
        currentstate.setEndDate(endDate);
        currentstate.setEndTime(endTimeField.getText());
        currentstate.setSummary(summaryField.getText());

        modifyViewModel.setState(currentstate);

        modifyController.execute(
                currentstate.getName(),
                currentstate.getStartDate(),
                currentstate.getStartTime(),
                currentstate.getEndDate(),
                currentstate.getEndTime(),
                "CAD",
                currentstate.getSummary(),
                Boolean.FALSE,
                currentstate.getId()
        );
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ModifyState state = (ModifyState) evt.getNewValue();
        String welcomeMessage = "Welcome " + state.getUserName();
        String message = state.getError();
        this.welcomeMessage.setText(welcomeMessage);

        this.existingEventName.setText(state.getName());
        this.eventNameField.setText(state.getName());

        this.existingStartDay.setText(state.getStartDate());
        this.startDateField.setValue(LocalDate.parse(state.getStartDate()));

        this.existingStartTime.setText(state.getStartTime());
        this.startTimeField.setText(state.getStartTime());

        this.existingEndDay.setText(state.getEndDate());
        this.endDateField.setValue(LocalDate.parse(state.getEndDate()));

        this.existingEndTime.setText(state.getEndTime());
        this.endTimeField.setText(state.getEndTime());

        this.existingSummary.setText(state.getSummary());
        this.summaryField.setText(state.getSummary());
        this.errorLabel.setText(message);
        System.out.println("Label's Updated");
    }
}
