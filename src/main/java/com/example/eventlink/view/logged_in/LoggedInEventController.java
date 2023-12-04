package com.example.eventlink.view.logged_in;

import com.example.eventlink.interface_adapter.Controller;
import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.ViewModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.interface_adapter.view_event.ViewEventController;
import com.example.eventlink.interface_adapter.view_event.ViewEventState;
import com.example.eventlink.interface_adapter.view_event.ViewEventViewModel;
import com.example.eventlink.view.ViewController;
import com.example.eventlink.view.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class LoggedInEventController extends ViewController {
    @FXML
    public Label eventID;
    public Label eventName;
    public Text eventSummary;
    public Label eventStart;
    public Label eventEnd;
    private ViewEventController viewEventController;
    private ViewEventViewModel viewEventViewModel;
    private ViewManagerModel viewManagerModel;

    public void setController(Controller viewEventController) {
        this.viewEventController = (ViewEventController) viewEventController;}

    public void setViewModel(ViewModel viewEventViewModel) {
        this.viewEventViewModel = (ViewEventViewModel) viewEventViewModel;}

    public void setViewManagerModel(ViewManagerModel viewManagerModel) {this.viewManagerModel = viewManagerModel;}
    public LoggedInEventController() {
        setViewManagerModel(ViewManager.getviewManagerModel());
        setController(ViewManager.getController("viewEventController"));
        setViewModel(ViewManager.getViewModel("viewEventViewModel"));
    }

    public void setEventID(String id) {eventID.setText(id);}
    public void setEventName(String name) {eventName.setText(name);}
    public void setEventSummary(String summary) {eventSummary.setText(summary);}
    public void setEventStart(String start) {eventStart.setText(start);}
    public void setEventEnd(String end) {eventEnd.setText(end);}

    public void viewClick() {
        ViewEventState state= viewEventViewModel.getState();
        state.setEventID(this.eventID.getText());
        viewEventViewModel.setState(state);

        System.out.println("Pressed View Event");
        viewEventController.execute(state.getEventID());

        //this.viewManagerModel.setActiveView(ViewEventViewModel.getViewName());
        //this.viewManagerModel.firePropertyChanged();
    }
}
