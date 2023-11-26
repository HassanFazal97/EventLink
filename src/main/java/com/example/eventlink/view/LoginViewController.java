package com.example.eventlink.view;

import com.example.eventlink.interface_adapter.login.LoginController;

import com.example.eventlink.interface_adapter.login.LoginViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginViewController {
    @FXML
    Button continueAsGuestButton;
    @FXML
    private Label welcomeText;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    private LoginViewModel loginViewModel;
    private LoginController loginController;
    public LoginViewController(){
    }

    public void setLoginViewModel(LoginViewModel loginViewModel) {
        this.loginViewModel = loginViewModel;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
    @FXML
    protected void loginButtonClick(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        System.out.println(username);
        System.out.println(password);
    }

    @FXML
    protected void continueAsGuestButtonClick(ActionEvent event) throws IOException {
        System.out.println("Pressed Guest");
        ViewManager.switchTo("/com.example.eventlink/test.fxml");
    }
}

