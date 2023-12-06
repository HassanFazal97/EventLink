package com.example.eventlink.data_access;

import com.example.eventlink.entity.event.Event;
import com.example.eventlink.entity.user.*;
import com.example.eventlink.entity.user.CommonUser;
import com.example.eventlink.entity.user.UserFactory;
import com.example.eventlink.use_case.login.LoginUserDataAccessInterface;
import com.example.eventlink.use_case.register_for_event.RegisterForEventDataAccessInterface;
import com.example.eventlink.use_case.signup.SignupUserDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
/**
 * Data access object for managing user data.
 * This class handles reading and writing user information to and from a CSV file.
 */
public class UserDataAccessObject implements AbstractUserDataAccessObject, SignupUserDataAccessInterface,
        LoginUserDataAccessInterface, RegisterForEventDataAccessInterface {
    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, User> accounts = new HashMap<String, User>();

    private UserFactory userFactory;

    private AbstractEventDataAccessObject eventDAO;
    /**
     * Constructs a new UserDataAccessObject.
     *
     * @param filePath Path to the CSV file.
     * @param userFactory Factory for creating User objects.
     * @param eventDAO Data Access Object for events.
     * @throws IOException If an I/O error occurs.
     */
    public UserDataAccessObject(String filePath, UserFactory userFactory, AbstractEventDataAccessObject eventDAO) throws IOException {
        this.userFactory = userFactory;
        this.eventDAO = eventDAO;

        csvFile = new File(filePath);
        headers.put("firstName", 0);
        headers.put("lastName", 1);
        headers.put("username", 2);
        headers.put("password", 3);
        headers.put("events", 4);
        headers.put("tag", 5);

        if (csvFile.length() == 0) {
            save();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();
                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("firstName,lastName,username,password,events,tag");

                String row;

                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    System.out.println(col);
                    String firstName = String.valueOf(col[headers.get("firstName")]);
                    String lastName = String.valueOf(col[headers.get("lastName")]);
                    String username = String.valueOf(col[headers.get("username")]);
                    String password = String.valueOf(col[headers.get("password")]);
                    String eventsData = String.valueOf(col[headers.get("events")]);
                    eventsData = eventsData.substring(1, eventsData.length()-1);
                    String[]eventsArray = eventsData.split(",");
                    List<String> events = new ArrayList<>();
                    Collections.addAll(events,eventsArray);
                    for (String eventId : col[headers.get("events")].split(",")) {
//                        convert the string eventId to an Event.
                        Event event = eventDAO.get(eventId);
//                        events.add(eventId);
                    }

                    List<String> tag = new ArrayList<>();
                    String[] tags = col[headers.get("tag")].split(",");
                    for (String tag_name : tags) {
                        tag.add(tag_name);
                    }

                    User user = userFactory.create(firstName, lastName, username, password, events, tag);
                    accounts.put(username, user);
                }
            }
        }
    }
    /**
     * Saves the given user to the accounts map and persists the data.
     *
     * @param user The user to save.
     */
    @Override
    public void save(User user) {
        accounts.put(user.getUsername(), user);
        this.save();
    }
    /**
     * Retrieves a user by their username.
     *
     * @param username The username of the user.
     * @return The User object if found, null otherwise.
     */
    @Override
    public User getUser(String username) {
        return accounts.get(username);
    }
    /**
     * Internal method to save the current state of accounts to the CSV file.
     */
    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                String line = String.format("%s,%s,%s,%s,%s,%s",
                        user.getFirstName(), user.getLastName(), user.getUsername(),
                        user.getPassword(), user.getEvents(), user.getTags());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Checks if a user exists by their username.
     *
     * @param username The username to check.
     * @return true if the user exists, false otherwise.
     */
    @Override
    public boolean existsByName(String username) {
        return accounts.containsKey(username);
    }
    /**
     * Updates the information for an existing user.
     *
     * @param username The username of the user to update.
     * @param user The new user data.
     */
    @Override
    public void updateUser(String username, User user) {
        accounts.replace(username, user);
        this.save();
    }

}
