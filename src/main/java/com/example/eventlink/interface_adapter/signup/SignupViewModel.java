package com.example.eventlink.interface_adapter.signup;

import com.example.eventlink.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class SignupViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Sign Up View";
    public static final String FIRSTNAME_LABEL = "Enter first name:";
    public static final String LASTNAME_LABEL = "Enter last name:";
    public static final String USERNAME_LABEL = "Enter username:";
    public static final String PASSWORD_LABEL = "Enter password:";
    public static final String REPEAT_PASSWORD_LABEL = "Enter password again:";
    public static final String TAGS_LABEL = "Choose Tags:";
    public static final String SIGNUP_BUTTON_LABEL = "Sign-up";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    private SignupState state = new SignupState();

    //TODO Implement firePropertyChanged() and addPropertyChangeListener

    public SignupViewModel() {
        super("Sign-up");
    }

    public void setState(SignupState state) {
        this.state = state;
    }

    public SignupState getState() {
        return state;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    @Override
    public void firePropertyChanged() {

    }
}
