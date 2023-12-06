package com.example.eventlink.test;

import com.example.eventlink.data_access.TestDataAccessObject;
import com.example.eventlink.entity.event.CommonEventFactory;
import com.example.eventlink.entity.user.CommonUserFactory;
import com.example.eventlink.entity.user.UserFactory;
import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.login.LoginViewModel;
import com.example.eventlink.interface_adapter.signup.SignupPresenter;
import com.example.eventlink.interface_adapter.signup.SignupViewModel;
import com.example.eventlink.use_case.signup.SignupInputData;
import com.example.eventlink.use_case.signup.SignupInteractor;
import com.example.eventlink.use_case.signup.SignupOutputBoundary;
import com.example.eventlink.use_case.signup.SignupUserDataAccessInterface;
import org.junit.Test;
import org.junit.Before;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SignupTest {

    private UserFactory userFactory;
    private SignupUserDataAccessInterface userDataAccessObject;
    private SignupOutputBoundary userPresenter;
    private SignupInteractor signupInteractor;

    @Before
    public void setup() {
        // Creating all fresh instances necessary for testing Signup
        userFactory = new CommonUserFactory();
        userDataAccessObject = new TestDataAccessObject(new CommonEventFactory(),
                userFactory);
        userPresenter = new SignupPresenter(new ViewManagerModel(),
                new SignupViewModel(), new LoginViewModel());
        signupInteractor = new SignupInteractor(userDataAccessObject, userPresenter, userFactory);
    }

    @Test
    public void execute_SuccessfulSignup() {
        //Signup Details Setup
        String username = "johndoe";
        String password = "password";
        String repPassword = "password";
        String firstName = "John";
        String lastName = "Doe";
        List<String> tags = null;

        // Act
        SignupInputData signupInputData = new SignupInputData(username, password, repPassword, firstName, lastName, tags);
        signupInteractor.execute(signupInputData);

        // Checking to see that account has been generated with correct details.
        assertTrue(userDataAccessObject.existsByName(username));

        TestDataAccessObject uDAO = (TestDataAccessObject) userDataAccessObject;

        assertEquals(firstName, uDAO.getUser(username).getFirstName());
        assertEquals(lastName, uDAO.getUser(username).getLastName());
        assertEquals(password, uDAO.getUser(username).getPassword());
    }

    @Test
    public void execute_UserAlreadyExists() {
        //Signup Details Setup
        String username = "johndoe";
        String password = "password";
        String repPassword = "password";
        String firstName = "John";
        String lastName = "Doe";
        List<String> tags = null;

        String fName2 = "Johnd";
        String lName2 = "Oe";
        String password2 = "johnnydoe";
        String repPassword2 = "johnnydoe";

        // Act
        SignupInputData signupInputData = new SignupInputData(username, password, repPassword, firstName, lastName, tags);
        signupInteractor.execute(signupInputData);

        SignupInputData signupInputData2 = new SignupInputData(username, password2, repPassword2, fName2, lName2, tags);
        signupInteractor.execute(signupInputData2);

        // Checking to see that first account has generated but the second account hasn't.
        assertTrue(userDataAccessObject.existsByName(username));

        TestDataAccessObject uDAO = (TestDataAccessObject) userDataAccessObject;

        assertEquals(firstName, uDAO.getUser(username).getFirstName());
        assertEquals(lastName, uDAO.getUser(username).getLastName());
        assertEquals(password, uDAO.getUser(username).getPassword());
    }

    @Test
    public void execute_PasswordNotMatching() {
        //Signup Details Setup
        String username = "johndoe";
        String password = "password";
        String repPassword = "passworD";
        String firstName = "John";
        String lastName = "Doe";
        List<String> tags = null;

        // Act
        SignupInputData signupInputData = new SignupInputData(username, password, repPassword, firstName, lastName, tags);
        signupInteractor.execute(signupInputData);

        // Should fail since the passwords don't match. Thus, the account should not have generated.
        assertFalse(userDataAccessObject.existsByName(username));
    }

    @Test
    public void execute_PasswordNotValid() {
        //Signup Details Setup
        String username = "johndoe";
        String password = "passw";
        String repPassword = "passw";
        String firstName = "John";
        String lastName = "Doe";
        List<String> tags = null;

        // Act
        SignupInputData signupInputData = new SignupInputData(username, password, repPassword, firstName, lastName, tags);
        signupInteractor.execute(signupInputData);

        // Should fail since the password is not valid according to the PasswordValidator.
        // It needs to be 6 or more characters longer.
        assertFalse(userDataAccessObject.existsByName(username));
    }
}