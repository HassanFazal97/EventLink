package com.example.eventlink.view;

import com.example.eventlink.interface_adapter.Controller;
import com.example.eventlink.interface_adapter.ViewModel;
import com.example.eventlink.interface_adapter.signup.SignupController;
import com.example.eventlink.interface_adapter.signup.SignupState;
import com.example.eventlink.interface_adapter.signup.SignupViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.beans.PropertyChangeEvent;

public class SignUpViewController extends ViewController{
    @FXML
    public TextField firstNameField;
    @FXML
    public TextField lastNameField;
    @FXML
    public PasswordField repeatPasswordField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField usernameField;

    private SignupController signupController;
    private SignupViewModel signupViewModel;

    public SignUpViewController() {}

    @Override
    public void setController(Controller signupController){this.signupController = (SignupController) signupController;}
    @Override
    public void setViewModel(ViewModel signupViewModel){this.signupViewModel = (SignupViewModel) signupViewModel;}

    public void signUpButtonClick(ActionEvent event) {
        SignupState currentState = signupViewModel.getState();
        currentState.setFirstName(firstNameField.getText());
        currentState.setLastName(lastNameField.getText());
        currentState.setUsername(usernameField.getText());
        currentState.setPassword(passwordField.getText());
        currentState.setRepeatPassword(repeatPasswordField.getText());
        System.out.println("Attempting Sign Up");
        signupViewModel.setState(currentState);

        signupController.execute(
                currentState.getUsername(),
                currentState.getPassword(),
                currentState.getRepeatPassword(),
                currentState.getFirstName(),
                currentState.getLastName(),
                currentState.getTags()
        );
    }

    public void loginButtonClick(ActionEvent event) {
        System.out.println("Pressed Login");
        //TODO: TEMPORARY
        ViewManager.switchTo("/com.example.eventlink/login-view.fxml");
    }

    public void continueAsGuestButtonClick(ActionEvent event) {
        System.out.println("Pressed Guest");
        //TODO: TEMPORARY
        ViewManager.switchTo("/com.example.eventlink/event-view.fxml");
    }

}
