package com.example.eventlink.data_access;

import com.example.eventlink.entity.event.Event;
import com.example.eventlink.entity.user.*;
import com.example.eventlink.entity.user.CommonUser;
import com.example.eventlink.entity.user.UserFactory;
import com.example.eventlink.use_case.login.LoginUserDataAccessInterface;
import com.example.eventlink.use_case.signup.SignupUserDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class UserDataAccessObject implements SignupUserDataAccessInterface, LoginUserDataAccessInterface {
    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, User> accounts = new HashMap<String, User>();

    private UserFactory userFactory;

    private EventDataAccessObject eventDAO;

    public UserDataAccessObject(String filePath, UserFactory userFactory, EventDataAccessObject eventDAO) throws IOException {
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
                    List<Event> events = new ArrayList<>();
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

    @Override
    public void save(User user) {
        accounts.put(user.getUsername(), user);
        this.save();
    }

    @Override
    public User get(String username) {
        return accounts.get(username);
    }

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

    @Override
    public boolean existsByName(String username) {
        return accounts.containsKey(username);
    }

//    @Override
//    public void save(User user) {
//
//    }

//    @Override
//    public User get(String username) {
//        return null;
//    }
}
