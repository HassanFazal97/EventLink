package com.example.eventlink.test;


import com.example.eventlink.test.GUI.GuestViewTest;
import com.example.eventlink.test.GUI.LoginViewTest;
import com.example.eventlink.test.GUI.SignUpViewTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        GuestViewTest.class,
        LoginViewTest.class,
        SignUpViewTest.class,
        CreateEventTest.class,
        EventDataAccessObjectTest.class,
        ModifyEventTest.class,
        SignupTest.class
})
public class RunAllTests {}
