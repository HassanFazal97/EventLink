package com.example.eventlink.view;

import com.example.eventlink.interface_adapter.Controller;
import com.example.eventlink.interface_adapter.ViewModel;
import com.example.eventlink.interface_adapter.login.LoginController;
import com.example.eventlink.interface_adapter.login.LoginState;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoginViewController extends ViewController implements PropertyChangeListener{
    public Label errorLabel;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    private LoginController loginController;
    private LoginViewModel loginViewModel;

    public LoginViewController() {}

    @Override
    public void setController(Controller loginController){
        this.loginController = (LoginController) loginController;
    }
    @Override
    public void setViewModel(ViewModel loginViewModel){
        this.loginViewModel = (LoginViewModel) loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);
    }

    public void logInButtonClick() {
        LoginState currentState = loginViewModel.getState();
        currentState.setUsername(usernameField.getText());
        currentState.setPassword(passwordField.getText());
        System.out.println("Attempting Log In");
        loginViewModel.setState(currentState);

        loginController.execute(
                currentState.getUsername(),
                currentState.getPassword()
        );
    }

    public void continueAsGuestButtonClick() {
        System.out.println("Pressed Guest");
        //TODO: TEMPORARY
        ViewManager.switchTo("/com.example.eventlink/event-view.fxml");
    }

    public void signupButtonClick(ActionEvent event) {
        System.out.println("Pressed Sign Up");
        //TODO: TEMPORARY
        ViewManager.switchTo("/com.example.eventlink/signup-view.fxml");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoginState state = (LoginState) evt.getNewValue();
        String error = state.getError();
        errorLabel.setText(error);
        System.out.println("Label Updated");
    }
}

