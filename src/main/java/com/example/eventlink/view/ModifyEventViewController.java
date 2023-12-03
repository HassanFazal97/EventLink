package com.example.eventlink.view;

import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.ViewModel;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.interface_adapter.modify_events.ModifyController;
import com.example.eventlink.interface_adapter.modify_events.ModifyState;
import com.example.eventlink.interface_adapter.modify_events.ModifyViewModel;
import com.example.eventlink.interface_adapter.view_event_success.ViewEventSuccessViewModel;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ModifyEventViewController extends ViewController implements PropertyChangeListener {
    public Label welcomeMessage;
    public TextField existingEventName;
    public TextField existingStartTime;
    public TextField existingEndTime;
    public TextField existingSummary;
    public TextField existingStartDay;
    public TextField existingEndDay;
    public TextField eventNameField;
    public DatePicker startDateField;
    public TextField startTimeField;
    public DatePicker endDateField;
    public TextField endTimeField;
    public TextField summaryField;
    private ViewManagerModel viewManagerModel;
    private ModifyViewModel modifyViewModel;
    private ModifyController modifyController;

    public void setViewModel(ViewModel modifyViewModel) {
        this.modifyViewModel = (ModifyViewModel) modifyViewModel;
        this.modifyViewModel.addPropertyChangeListener(this);
    }
    public void setViewManagerModel(ViewManagerModel viewManagerModel) {this.viewManagerModel = viewManagerModel;}

    public void logOutButtonClick(ActionEvent event) {
        System.out.println("Pressed Logout");
        this.viewManagerModel.setActiveView(LoginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
    public void cancelButtonClick(ActionEvent event) {
        System.out.println("Pressed Cancel");
        this.viewManagerModel.setActiveView(ViewEventSuccessViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
    public void modifyEventButtonClick(ActionEvent event) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ModifyState state = (ModifyState) evt.getNewValue();
        String welcomeMessage = "Welcome " + state.getUserName();
        String message = state.getError();
        this.welcomeMessage.setText(welcomeMessage);
        //.setText(message);
        System.out.println("Label's Updated");
    }
}
