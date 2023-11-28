package com.example.eventlink.view;

import com.example.eventlink.interface_adapter.Controller;
import com.example.eventlink.interface_adapter.guest_in.GuestViewModel;
import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.ViewModel;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.interface_adapter.signup.SignupController;
import com.example.eventlink.interface_adapter.signup.SignupState;
import com.example.eventlink.interface_adapter.signup.SignupViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SignUpViewController extends ViewController implements PropertyChangeListener {
    public TextField firstNameField;
    public TextField lastNameField;
    public PasswordField repeatPasswordField;
    public PasswordField passwordField;
    public TextField usernameField;
    public Label errorLabel;

    private SignupController signupController;
    private SignupViewModel signupViewModel;
    private ViewManagerModel viewManagerModel;

    public SignUpViewController() {}

    @Override
    public void setController(Controller signupController){this.signupController = (SignupController) signupController;}
    @Override
    public void setViewModel(ViewModel signupViewModel){
        this.signupViewModel = (SignupViewModel) signupViewModel;
        this.signupViewModel.addPropertyChangeListener(this);
    }
    @Override
    public void setViewManagerModel(ViewManagerModel viewManagerModel) {this.viewManagerModel = viewManagerModel;}

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
        this.viewManagerModel.setActiveView(LoginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void continueAsGuestButtonClick(ActionEvent event) {
        System.out.println("Pressed Guest");
        this.viewManagerModel.setActiveView(GuestViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SignupState state = (SignupState) evt.getNewValue();
        String error = state.getError();
        errorLabel.setText(error);
        System.out.println("Label Updated");
    }
}
