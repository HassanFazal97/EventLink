package com.example.eventlink.test;


import com.example.eventlink.test.GUI.LoginViewTest;
import com.example.eventlink.test.GUI.SignUpViewTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginViewTest.class,
        SignUpViewTest.class,
        CreateEventTest.class,
        EventDataAccessObjectTest.class,
        ModifyEventTest.class,
        UserDataAccessObjectTest.class,
        RegisterTest.class
})
public class RunAllTests {}
