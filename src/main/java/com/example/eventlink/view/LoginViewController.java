package com.example.eventlink.view;

import com.example.eventlink.interface_adapter.login.LoginController;
import com.example.eventlink.interface_adapter.login.LoginState;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginViewController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;

    private final LoginController loginController;
    private final LoginViewModel loginViewModel;

    //TODO: Resolve this error if necessary
    public LoginViewController(LoginController loginController, LoginViewModel loginViewModel){
        this.loginController = loginController;
        this.loginViewModel = loginViewModel;
        System.out.println("LVC initiated");
    }

    //TODO: I have no idea why this fixes my problems, please verify.
    public LoginViewController() {
        this.loginController = null;
        this.loginViewModel = null;
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
    }
}

