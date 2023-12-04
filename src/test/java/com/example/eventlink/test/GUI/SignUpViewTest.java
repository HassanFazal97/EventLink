package com.example.eventlink.test.GUI;

import com.example.eventlink.app.use_case_factories.*;
import com.example.eventlink.data_access.EventDataAccessObject;
import com.example.eventlink.data_access.TestDataAccessObject;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * This is a set of tests for the Signup page.
 * It checks to make sure that the 3 buttons work, and that they display the right values.
 * TextFields and PasswordFields are not tested as their functionality is governed by javafx, not client code.
 * <p>
 * The Class works by initializing a reduced version of the program, loading the Signup page, and running various tests.
 */
public class SignUpViewTest extends ApplicationTest {
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
    TestDataAccessObject userDataAccessObject;
    {userDataAccessObject = new TestDataAccessObject(new CommonEventFactory(),new CommonUserFactory());}

    //Each of the Controllers manage interactions between UI and backend
    LoginController loginController = LoginUseCaseFactory.create(viewManagerModel, loginViewModel,
            loggedInViewModel, createEventViewModel, modifyViewModel, viewEventSuccessViewModel, userDataAccessObject);
    SignupController signupController = SignupUseCaseFactory.create(viewManagerModel,
            signupViewModel, loginViewModel, userDataAccessObject);


    //Needed so that tests can work properly
    Scene scene;

    //Will be called with {@code @Before} semantics, i.e. before each test method.
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(new Pane());
        ViewManager.setScene(scene);
        //Sending the complete list of events to guestViewModel and loggedInViewModel
        GuestState guestState = guestViewModel.getState();
        guestState.setEvents(eventDataAccessObject.getAllEvents());
        guestViewModel.setState(guestState);
        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setEvents(eventDataAccessObject.getAllEvents());
        loggedInViewModel.setState(loggedInState);

        //Inject Guest
        ViewManager.addViewModel("/com.example.eventlink/guest-view.fxml", guestViewModel);
        //Inject LoggedIn
        ViewManager.addViewModel("/com.example.eventlink/loggedin-view.fxml", loggedInViewModel);
        //Inject Login
        ViewManager.addViewModel("/com.example.eventlink/login-view.fxml", loginViewModel);
        ViewManager.addController("/com.example.eventlink/login-view.fxml", loginController);
        //Inject Signup
        ViewManager.addViewModel("/com.example.eventlink/signup-view.fxml", signupViewModel);
        ViewManager.addController("/com.example.eventlink/signup-view.fxml", signupController);

        //Set Signup View
        viewManagerModel.setActiveView(SignupViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

        //Limits our Window to 1280x720
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void LoginButtonFail() {
        Button button = (Button) scene.lookup("#loginButton");
        Assertions.assertThat(button).hasText("Log In!");

        clickOn(button);
        assertEquals("ViewModel is incorrect" ,viewManagerModel.getActiveViewName(),
                "/com.example.eventlink/login-view.fxml");
    }

    @Test
    public void SignUpButtonFailButton() {
        Button button = (Button) scene.lookup("#signupButton");
        Assertions.assertThat(button).hasText("Sign Up");

        clickOn(button);
        assertEquals("ViewModel is incorrect" ,viewManagerModel.getActiveViewName(),
                "/com.example.eventlink/signup-view.fxml");
    }

    @Test
    public void SignUpButtonSuccessButton() {
        Button button = (Button) scene.lookup("#signupButton");

        TextField firstNameField = (TextField) scene.lookup("#firstNameField");
        TextField lastNameField = (TextField) scene.lookup("#lastNameField");
        TextField usernameField = (TextField) scene.lookup("#usernameField");
        PasswordField passwordField = (PasswordField) scene.lookup("#passwordField");
        PasswordField repeatPasswordField = (PasswordField) scene.lookup("#repeatPasswordField");

        firstNameField.setText("test");
        lastNameField.setText("ing");
        usernameField.setText("testing");
        passwordField.setText("please");
        repeatPasswordField.setText("please");

        clickOn(button);
        assertEquals("ViewModel is incorrect" ,viewManagerModel.getActiveViewName(),
                "/com.example.eventlink/login-view.fxml");

        TextField loginUsernameField = (TextField) scene.lookup("#usernameField");
        assertEquals("Username is incorrect or missing","testing", loginUsernameField.getText());
    }

    @Test
    public void GuestButton() {
        Button button = (Button) scene.lookup("#guestButton");
        Assertions.assertThat(button).hasText("Continue as Guest");

        clickOn(button);
        assertEquals("ViewModel is incorrect" ,viewManagerModel.getActiveViewName(),
                "/com.example.eventlink/guest-view.fxml");
    }
}