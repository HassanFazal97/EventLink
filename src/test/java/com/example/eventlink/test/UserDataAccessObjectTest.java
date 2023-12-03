package com.example.eventlink.test;

import com.example.eventlink.data_access.AbstractUserDataAccessObject;
import com.example.eventlink.data_access.EventDataAccessObject;
import com.example.eventlink.data_access.TestDataAccessObject;
import com.example.eventlink.data_access.UserDataAccessObject;
import com.example.eventlink.entity.event.CommonEventFactory;
import com.example.eventlink.entity.user.CommonUserFactory;
import com.example.eventlink.entity.user.User;

import java.io.IOException;

import com.example.eventlink.entity.user.UserFactory;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserDataAccessObjectTest {

    private AbstractUserDataAccessObject userDataAccessObject;
    private UserFactory userFactory = new CommonUserFactory();
    private TestDataAccessObject eventDataAccessObject = new TestDataAccessObject(new CommonEventFactory(), userFactory);
    private User user;

    @Test
    public void testUserGetters() throws IOException {
        userDataAccessObject = new UserDataAccessObject("src/testUsers.csv", userFactory, eventDataAccessObject);
        User initUser = userFactory.create("user", "1", "user1", "12345", new ArrayList<>(), new ArrayList<>());
        userDataAccessObject.save(initUser);
        user = userDataAccessObject.getUser(initUser.getUsername());
        assertEquals("First name should match", "user", user.getFirstName());
        assertEquals("Last name should match", "1", user.getLastName());
        assertEquals("Username should match", "user1", user.getUsername());
        assertEquals("Password should match", "12345", user.getPassword());
        assertEquals("Events list should match", new ArrayList<>(), user.getEvents());
        assertEquals("Tags list should match", new ArrayList<>(), user.getTags());
    }

    @Test
    public void testMemoryMatchesFile() throws IOException {
        userDataAccessObject = new UserDataAccessObject("src/testUsers.csv", userFactory, eventDataAccessObject);
        user = userFactory.create("user", "1", "user1", "12345", new ArrayList<>(), new ArrayList<>());
        userDataAccessObject.save(user);
        try (BufferedReader reader = new BufferedReader(new FileReader("src/testUsers.csv"))) {
            String header = reader.readLine();
            assertEquals("Header is missing", "firstName,lastName,username,password,events,tag", header);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] info = line.split(",");
                String username = info[2];
                user = userDataAccessObject.getUser(username);
                assertEquals("First name should match", user.getFirstName(), info[0]);
                assertEquals("Last name should match", user.getLastName(), info[1]);
                assertEquals("Username should match", user.getUsername(), info[2]);
                assertEquals("Password should match", user.getPassword(), info[3]);
                assertEquals("Events list should match", String.valueOf(user.getEvents()), String.valueOf(info[4]));
                assertEquals("Tags list should match", String.valueOf(user.getTags()), String.valueOf(info[5]));
            }
        }
    }

    @Test
    public void testExistsByIdPass() throws IOException {
        userDataAccessObject = new UserDataAccessObject("src/testUsers.csv", userFactory, eventDataAccessObject);
        user = userFactory.create("user", "1", "user1", "12345", new ArrayList<>(), new ArrayList<>());
        userDataAccessObject.save(user);
        assertTrue("User could not be found", userDataAccessObject.existsByName(user.getUsername()));
    }

    @Test
    public void testExistsByIdFail() throws IOException {
        userDataAccessObject = new UserDataAccessObject("src/testUsers.csv", userFactory, eventDataAccessObject);
        assertFalse("Nonexistent user was found", userDataAccessObject.existsByName(""));
    }

}
