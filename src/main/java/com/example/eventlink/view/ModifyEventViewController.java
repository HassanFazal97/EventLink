package com.example.eventlink.view;

import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.interface_adapter.view_event.ViewEventViewModel;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ModifyEventViewController extends ViewController{
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
    public void setViewManagerModel(ViewManagerModel viewManagerModel) {this.viewManagerModel = viewManagerModel;}

    public void logOutButtonClick(ActionEvent event) {
        System.out.println("Pressed Logout");
        this.viewManagerModel.setActiveView(LoginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
    public void cancelButtonClick(ActionEvent event) {
        System.out.println("Pressed Cancel");
        this.viewManagerModel.setActiveView(ViewEventViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
    public void modifyEventButtonClick(ActionEvent event) {
    }
}
