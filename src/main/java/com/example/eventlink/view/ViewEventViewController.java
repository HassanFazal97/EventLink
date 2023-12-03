package com.example.eventlink.view;


import com.example.eventlink.interface_adapter.Controller;
import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.ViewModel;
import com.example.eventlink.interface_adapter.create_events.CreateEventViewModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.interface_adapter.modify_events.ModifyState;
import com.example.eventlink.interface_adapter.modify_events.ModifyViewModel;
import com.example.eventlink.interface_adapter.register_for_event.RegisterForEventController;
import com.example.eventlink.interface_adapter.view_event_success.ViewEventSuccessState;
import com.example.eventlink.interface_adapter.view_event_success.ViewEventSuccessViewModel;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ViewEventViewController extends ViewController implements PropertyChangeListener {
    public Label welcomeMessage;
    public TextField existingEventName;
    public TextField existingStartDay;
    public TextField existingStartTime;
    public TextField existingEndDay;
    public TextField existingEndTime;
    public TextArea existingSummary;
    public Label message;

    private ViewManagerModel viewManagerModel;
    private ViewEventSuccessViewModel viewEventSuccessViewModel;
    private ModifyViewModel modifyViewModel;
    private RegisterForEventController registerForEventController;

    public ViewEventViewController() {
        setModifyViewModel((ModifyViewModel) ViewManager.getViewModel("/com.example.eventlink/modifyevent-view.fxml"));
    }

    public void setViewModel(ViewModel viewEventViewModel) {
        this.viewEventSuccessViewModel = (ViewEventSuccessViewModel) viewEventViewModel;
        this.viewEventSuccessViewModel.addPropertyChangeListener(this);
    }
    public void setController(Controller registerForEventController) {
        this.registerForEventController = (RegisterForEventController) registerForEventController;}

    public void setViewManagerModel(ViewManagerModel viewManagerModel) {this.viewManagerModel = viewManagerModel;}
    public void setModifyViewModel(ModifyViewModel modifyViewModel) {this.modifyViewModel = modifyViewModel;}

    public void createEventButtonClick() {
        System.out.println("Pressed Create Event");
        this.viewManagerModel.setActiveView(CreateEventViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void logOutButtonClick() {
        System.out.println("Pressed Logout");
        this.viewManagerModel.setActiveView(LoginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void goBackButtonClick() {
        System.out.println("Pressed Go Back");
        this.viewManagerModel.setActiveView(LoggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void modifyButtonClick() {
        ViewEventSuccessState viewEventSuccessState = viewEventSuccessViewModel.getState();
        ModifyState modifyState = modifyViewModel.getState();
        modifyState.setName(viewEventSuccessState.getEventName());
        modifyState.setStartDate(viewEventSuccessState.getEventStartDate());
        modifyState.setStartTime(viewEventSuccessState.getEventStartTime());
        modifyState.setEndDate(viewEventSuccessState.getEventEndDate());
        modifyState.setEndTime(viewEventSuccessState.getEventEndTime());
        modifyState.setSummary(viewEventSuccessState.getSummary());
        modifyState.setId(viewEventSuccessState.getId());

        System.out.println("Pressed Modify Event");
        this.viewManagerModel.setActiveView(ModifyViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void registerButtonClick() {
        ViewEventSuccessState state = viewEventSuccessViewModel.getState();
        registerForEventController.execute(
                state.getId(),
                "",
                "",
                state.getUsername(),
                ""
        );
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ViewEventSuccessState state = (ViewEventSuccessState) evt.getNewValue();
        String welcomeMessage = "Welcome " + state.getUserName();
        this.welcomeMessage.setText(welcomeMessage);
        this.existingEventName.setText(state.getEventName());
        this.existingStartDay.setText(state.getEventStartDate());
        this.existingStartTime.setText(state.getEventStartTime());
        this.existingEndDay.setText(state.getEventEndDate());
        this.existingEndTime.setText(state.getEventEndTime());
        this.existingSummary.setText(state.getSummary());
        this.message.setText(state.getMessage());
        System.out.println("Label Updated");
    }
}
