package com.example.eventlink.app;

import com.example.eventlink.data_access.EventDataAccessObject;
import com.example.eventlink.data_access.UserDataAccessObject;
import com.example.eventlink.entity.event.CommonEventFactory;
import com.example.eventlink.entity.user.CommonUserFactory;
import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.create_events.CreateEventViewModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.interface_adapter.login.LoginController;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.interface_adapter.modify_events.ModifyViewModel;
import com.example.eventlink.interface_adapter.register_for_event.RegisterForEventViewModel;
import com.example.eventlink.interface_adapter.signup.SignupController;
import com.example.eventlink.interface_adapter.signup.SignupViewModel;
import com.example.eventlink.view.LoginViewController;
import com.example.eventlink.view.ViewManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    //TODO: Temporary, fix this, esp the file paths.
    //The viewManagerModel helps keep track of the current view.
    ViewManagerModel viewManagerModel = new ViewManagerModel();
    ViewManager viewManager = new ViewManager(viewManagerModel);

    //Each of the viewModel's store data for the relevant viewControllers
    CreateEventViewModel createEventViewModel = new CreateEventViewModel();
    LoginViewModel loginViewModel = new LoginViewModel();
    LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
    ModifyViewModel modifyViewModel = new ModifyViewModel();
    RegisterForEventViewModel registerForEventViewModel = new RegisterForEventViewModel();
    SignupViewModel signupViewModel = new SignupViewModel();

    //Each dataAccessObject manages access to our entities
    EventDataAccessObject eventDataAccessObject;
    {
        try {
            eventDataAccessObject = new EventDataAccessObject("temp",
                    new CommonEventFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    UserDataAccessObject userDataAccessObject;
    {
        try {
            userDataAccessObject = new UserDataAccessObject("temp2",
                    new CommonUserFactory(), eventDataAccessObject);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Each of the Controllers manage interactions between UI and backend
    LoginController loginController = LoginUseCaseFactory.create(viewManagerModel,
            loginViewModel, loggedInViewModel, userDataAccessObject);
    SignupController signupController = SignupUseCaseFactory.create(viewManagerModel,
            signupViewModel, userDataAccessObject);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        var scene = new Scene(new Pane());
        ViewManager.setScene(scene);

        //Inject Login
        ViewManager.addViewModel("/com.example.eventlink/login-view.fxml", loginViewModel);
        ViewManager.addController("/com.example.eventlink/login-view.fxml", loginController);
        //Inject Signup
        ViewManager.addViewModel("/com.example.eventlink/signup-view.fxml", signupViewModel);
        ViewManager.addController("/com.example.eventlink/signup-view.fxml", signupController);
        //Set First View
        viewManagerModel.setActiveView(LoginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

        //Limits our Window to 1280x720
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
