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
        System.out.println("LVcontroller initiated");
    }

    //TODO: I have no idea why this fixes my problems, please verify.
    public LoginViewController() {
        this.loginController = null;
        this.loginViewModel = null;
    }

    @FXML
    protected void loginButtonClick(ActionEvent event) {
        LoginState currentState = loginViewModel.getState();
        currentState.setUsername(usernameField.getText());
        currentState.setPassword(passwordField.getText());
        loginViewModel.setState(currentState);

        loginController.execute(
                currentState.getUsername(),
                currentState.getPassword()
        );
    }

    @FXML
    protected void continueAsGuestButtonClick(ActionEvent event) {
        System.out.println("Pressed Guest");
        ViewManager.switchTo("/com.example.eventlink/test.fxml");
    }
}

