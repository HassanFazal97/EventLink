package com.example.eventlink.data_access;

import com.example.eventlink.entity.event.*;
import com.example.eventlink.entity.user.User;
import com.example.eventlink.use_case.view_event.ViewEventDataAccessInterface;
import com.example.eventlink.entity.event.Event;
import com.example.eventlink.use_case.modify_events.ModifyEventDataAccessInterface;
import com.example.eventlink.use_case.create_events.CreateEventDataAccessInterface;
import com.example.eventlink.use_case.register_for_event.RegisterForEventDataAccessInterface;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EventDataAccessObject implements ViewEventDataAccessInterface,
        ModifyEventDataAccessInterface, CreateEventDataAccessInterface,
        RegisterForEventDataAccessInterface {

    //TODO: Change interfaces to allow for proper ID generation
    private final File dataFile;
    private final Map<String, Integer> headers = new LinkedHashMap<String, Integer>();
    private final Map<String, Event> events = new HashMap<String, Event>();
    private EventFactory eventFactory;

    public EventDataAccessObject(String filePath, EventFactory eventFactory) throws IOException {
        dataFile = new File(filePath);
        this.eventFactory = eventFactory;
        headers.put("name", 0);
        headers.put("start", 1);
        headers.put("end", 2);
        headers.put("currency", 3);
        headers.put("summary", 4);
        headers.put("isPrivate", 5);
        headers.put("id", 6);

        if (dataFile.length() == 0) {
            saveToFile();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
                String header = reader.readLine();

                // TODO: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("name,start,end,currency,summary,isPrivate,id");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String name = String.valueOf(col[0]);
                    String start = String.valueOf(col[1]);
                    String end = String.valueOf(col[2]);
                    String currency = String.valueOf(col[3]);
                    String summary = String.valueOf(col[4]);
                    String privacy = String.valueOf(col[5]);
                    Boolean isPrivate = privacy.equals("true");
                    String id = String.valueOf(col[6]);

                    Event event = eventFactory.create(id, name, start, end, currency, summary, isPrivate);
                    events.put(id, event);
                }
            }
        }
    }

    private void saveToFile() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(dataFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (Event event : events.values()) {
                String line = String.format("%s,%s,%s,%s,%s,%s,%s",
                        event.getName(), event.getStart(), event.getEnd(),
                        event.getCurrency(), event.getSummary(), event.getIsPrivate(), event.getID());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Event get(String id) {
        return events.get(id);
    }

    @Override
    public boolean existsById(String id) {
        return events.containsKey(id);
    }

    @Override
    //TODO: I think this and below methods need their API calls modified
    //TODO: double check CreatEventViewController and formatting time either here or there
    public Event create(String name, String startDate, String startTime, String endDate, String endTime, String currency, String summary, Boolean isPrivate) {
        String start = startDate + "T" + startTime + ":00Z";
        String end = endDate + "T" + endTime + ":00Z";

        ZonedDateTime startZonedDateTime;
        ZonedDateTime endZonedDateTime;

        try {
            startZonedDateTime = ZonedDateTime.parse(start, DateTimeFormatter.ISO_DATE_TIME);
            endZonedDateTime = ZonedDateTime.parse(end, DateTimeFormatter.ISO_DATE_TIME);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format", e);
        }

        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);

        // Validate the dates
        if (startZonedDateTime.isBefore(now) || endZonedDateTime.isBefore(now)) {
            throw new IllegalArgumentException("Start and end dates must be in the future.");
        }
        if (endZonedDateTime.isBefore(startZonedDateTime)) {
            throw new IllegalArgumentException("End date must be after start date.");
        }


        Client client = ClientBuilder.newClient();
        String payloadString = String.format("{  \"event\": {    \"name\": {      \"html\": \"<p>%s</p>\"    },    \"description\": {      \"html\": \"<p>%s</p>\"    },    \"start\": {      \"timezone\": \"UTC\",      \"utc\": \"%s\"    },    \"end\": {      \"timezone\": \"UTC\",      \"utc\": \"%s\"    },    \"currency\": \"%s\",    \"online_event\": false,    \"organizer_id\": \"\",    \"listed\": false,    \"shareable\": false,    \"invite_only\": %b,    \"show_remaining\": true,    \"password\": \"12345\",    \"capacity\": 100,    \"is_reserved_seating\": false,    \"is_series\": false,    \"show_pick_a_seat\": true,    \"show_seatmap_thumbnail\": true,    \"show_colors_in_seatmap_thumbnail\": true,    \"locale\": \"de_AT\"  }}",
                name, summary, start, end, currency, isPrivate);
        Entity payload = Entity.json(payloadString);
        Response response = client.target("https://www.eventbriteapi.com/v3/organizations/1861001665463/events/")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("Authorization", "Bearer V62FODWQELD5JCBTLNQC")
                .post(payload);

        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        String responseBody = response.readEntity(String.class);
        System.out.println("body:" + responseBody);


        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = objectMapper.readTree(responseBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        String id = rootNode.path("id").asText();
        System.out.println("Event ID: " + id);
        Event event = eventFactory.create(id, name, start, end, currency, summary, isPrivate);

        events.put(id, event);
        this.saveToFile();
        return event;
    }

    @Override
    public void remove(String id) {
        Client client = ClientBuilder.newClient();
        Response response = client.target("https://www.eventbriteapi.com/v3/events/" + id + "/")
                .request(MediaType.TEXT_PLAIN_TYPE)
                .header("Authorization", "Bearer V62FODWQELD5JCBTLNQC")
                .delete();

        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + response.readEntity(String.class));

        events.remove(id);
        this.saveToFile();
    }

    public String modify(String id, String name, String startDate, String startTime, String endDate, String endTime, String currency, String summary, Boolean isPrivate) {
        String start = startDate + "T" + startTime + ":00Z";
        String end = endDate + "T" + endTime + ":00Z";

        ZonedDateTime startZonedDateTime;
        ZonedDateTime endZonedDateTime;

        try {
            startZonedDateTime = ZonedDateTime.parse(start, DateTimeFormatter.ISO_DATE_TIME);
            endZonedDateTime = ZonedDateTime.parse(end, DateTimeFormatter.ISO_DATE_TIME);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format", e);
        }

        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);

        // Validate the dates
        if (startZonedDateTime.isBefore(now) || endZonedDateTime.isBefore(now)) {
            throw new IllegalArgumentException("Start and end dates must be in the future.");
        }
        if (endZonedDateTime.isBefore(startZonedDateTime)) {
            throw new IllegalArgumentException("End date must be after start date.");
        }

        Client client = ClientBuilder.newClient();
        String payloadString = String.format("{  \"event\": {    \"name\": {      \"html\": \"<p>%s</p>\"    },    \"description\": {      \"html\": \"<p>%s</p>\"    },    \"start\": {      \"timezone\": \"UTC\",      \"utc\": \"%s\"    },    \"end\": {      \"timezone\": \"UTC\",      \"utc\": \"%s\"    },    \"currency\": \"%s\",    \"online_event\": false,    \"organizer_id\": \"\",    \"listed\": false,    \"shareable\": false,    \"invite_only\": %b,    \"show_remaining\": true,    \"password\": \"12345\",    \"capacity\": 100,    \"is_reserved_seating\": false,    \"is_series\": false,    \"show_pick_a_seat\": true,    \"show_seatmap_thumbnail\": true,    \"show_colors_in_seatmap_thumbnail\": true,    \"locale\": \"de_AT\"  }}",
                name, summary, start, end, currency, isPrivate);
        Entity payload = Entity.json(payloadString);
        Response response = client.target("https://www.eventbriteapi.com/v3/events/" + id + "/")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("Authorization", "Bearer V62FODWQELD5JCBTLNQC")
                .post(payload);

        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + response.readEntity(String.class));

        Event event = this.get(id);
        event.setName(name);
        event.setStart(start);
        event.setEnd(end);
        event.setCurrency(currency);
        event.setSummary(summary);
        event.setIsPrivate(isPrivate);

        this.saveToFile();

        return event.getID();
    }

    @Override
    public User getUsername(String username) {
        return null;
    }

    @Override
    public void UpdateUser(User user) {

    }

    public List<Event> getAllEvents(){
        return new ArrayList<>(events.values());
    }
}