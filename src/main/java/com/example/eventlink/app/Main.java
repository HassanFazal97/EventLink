package com.example.eventlink.app;

import com.example.eventlink.app.use_case_factories.*;
import com.example.eventlink.data_access.EventDataAccessObject;
import com.example.eventlink.data_access.UserDataAccessObject;
import com.example.eventlink.entity.event.CommonEventFactory;
import com.example.eventlink.entity.user.CommonUserFactory;
import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.create_events.CreateEventController;
import com.example.eventlink.interface_adapter.create_events.CreateEventViewModel;
import com.example.eventlink.interface_adapter.guest_in.GuestState;
import com.example.eventlink.interface_adapter.guest_in.GuestViewModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInState;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.interface_adapter.login.LoginController;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.interface_adapter.modify_events.ModifyController;
import com.example.eventlink.interface_adapter.modify_events.ModifyViewModel;
import com.example.eventlink.interface_adapter.register_for_event.RegisterForEventController;
import com.example.eventlink.interface_adapter.signup.SignupController;
import com.example.eventlink.interface_adapter.signup.SignupViewModel;
import com.example.eventlink.interface_adapter.view_event.ViewEventController;
import com.example.eventlink.interface_adapter.view_event.ViewEventViewModel;
import com.example.eventlink.interface_adapter.view_event_success.ViewEventSuccessViewModel;
import com.example.eventlink.view.ViewManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    //The viewManagerModel helps keep track of the current view.
    ViewManagerModel viewManagerModel = new ViewManagerModel();
    //Although it says there are no usages of viewManager, it is incorrect.
    ViewManager viewManager = new ViewManager(viewManagerModel);

    //Each of the viewModel's store data for the relevant viewControllers
    CreateEventViewModel createEventViewModel = new CreateEventViewModel();
    GuestViewModel guestViewModel = new GuestViewModel();
    LoginViewModel loginViewModel = new LoginViewModel();
    LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
    ModifyViewModel modifyViewModel = new ModifyViewModel();
    SignupViewModel signupViewModel = new SignupViewModel();
    ViewEventViewModel viewEventViewModel = new ViewEventViewModel();
    ViewEventSuccessViewModel viewEventSuccessViewModel = new ViewEventSuccessViewModel();

    //Each dataAccessObject manages access to our entities
    EventDataAccessObject eventDataAccessObject;
    {
        try {
            eventDataAccessObject = new EventDataAccessObject("src/eventDatabase.csv",
                    new CommonEventFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    UserDataAccessObject userDataAccessObject;
    {
        try {
            userDataAccessObject = new UserDataAccessObject("src/userDatabase.csv",
                    new CommonUserFactory(), eventDataAccessObject);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Each of the Controllers manage interactions between UI and backend
    CreateEventController createEventController = CreateEventUseCaseFactory.create(viewManagerModel,
            createEventViewModel, loggedInViewModel, guestViewModel, eventDataAccessObject);
    LoginController loginController = LoginUseCaseFactory.create(viewManagerModel, loginViewModel,
            loggedInViewModel, createEventViewModel, modifyViewModel, viewEventSuccessViewModel, userDataAccessObject);
    ModifyController modifyController = ModifyEventUseCaseFactory.create(viewManagerModel,
            modifyViewModel, loggedInViewModel, guestViewModel, eventDataAccessObject);
    RegisterForEventController registerForEventController = RegisterForEventUseCaseFactory.create(viewEventSuccessViewModel,
            userDataAccessObject,eventDataAccessObject);
    SignupController signupController = SignupUseCaseFactory.create(viewManagerModel,
            signupViewModel, loginViewModel, userDataAccessObject);
    ViewEventController viewEventController = ViewEventUseCaseFactory.create(viewManagerModel,
            viewEventSuccessViewModel, eventDataAccessObject);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        var scene = new Scene(new Pane());
        ViewManager.setScene(scene);
        //Sending the complete list of events to guestViewModel and loggedInViewModel
        GuestState guestState = guestViewModel.getState();
        guestState.setEvents(eventDataAccessObject.getAllEvents());
        guestViewModel.setState(guestState);
        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setEvents(eventDataAccessObject.getAllEvents());
        loggedInViewModel.setState(loggedInState);

        //Inject CreateEvent
        ViewManager.addViewModel("/com.example.eventlink/createevent-view.fxml", createEventViewModel);
        ViewManager.addController("/com.example.eventlink/createevent-view.fxml", createEventController);
        //Inject Guest
        ViewManager.addViewModel("/com.example.eventlink/guest-view.fxml", guestViewModel);
        //Inject LoggedIn
        ViewManager.addViewModel("/com.example.eventlink/loggedin-view.fxml", loggedInViewModel);
        //Inject Login
        ViewManager.addViewModel("/com.example.eventlink/login-view.fxml", loginViewModel);
        ViewManager.addController("/com.example.eventlink/login-view.fxml", loginController);
        //Inject Modify
        ViewManager.addViewModel("/com.example.eventlink/modifyevent-view.fxml", modifyViewModel);
        ViewManager.addController("/com.example.eventlink/modifyevent-view.fxml", modifyController);
        //Inject Signup
        ViewManager.addViewModel("/com.example.eventlink/signup-view.fxml", signupViewModel);
        ViewManager.addController("/com.example.eventlink/signup-view.fxml", signupController);
        //Inject ViewEvent
        ViewManager.addController("viewEventController", viewEventController);
        ViewManager.addViewModel("viewEventViewModel", viewEventViewModel);
        //Inject ViewEventSuccess
        ViewManager.addViewModel("/com.example.eventlink/viewevent-view.fxml", viewEventSuccessViewModel);
        ViewManager.addController("/com.example.eventlink/viewevent-view.fxml", registerForEventController);
        //Set First View
        viewManagerModel.setActiveView(LoginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

        //Limits our Window to 1280x720
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
