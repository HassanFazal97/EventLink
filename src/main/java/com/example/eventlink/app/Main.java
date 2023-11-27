package com.example.eventlink.app;

import com.example.eventlink.data_access.EventDataAccessObject;
import com.example.eventlink.data_access.UserDataAccessObject;
import com.example.eventlink.entity.event.CommonEventFactory;
import com.example.eventlink.entity.user.CommonUserFactory;
import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
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
    //Each of the viewModel's store data for the relevant viewControllers
    LoginViewModel loginViewModel = new LoginViewModel();
    LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
    //DAO's
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
            userDataAccessObject = new UserDataAccessObject("temp",
                    new CommonUserFactory(), eventDataAccessObject);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    LoginViewController loginViewController = LoginUseCaseFactory.create(viewManagerModel,
            loginViewModel, loggedInViewModel, userDataAccessObject);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        var scene = new Scene(new Pane());

        ViewManager.setScene(scene);
        ViewManager.switchTo("/com.example.eventlink/login-view.fxml");

        //Limits our Window to 720p
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
