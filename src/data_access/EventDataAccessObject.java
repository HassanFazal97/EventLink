package data_access;

import entity.event.CommonEvent;
import entity.event.Event;
import entity.event.EventFactory;
import use_case.modify_events.ModifyEventDataAccessInterface;
import use_case.create_events.CreateEventDataAccessInterface;
import use_case.register_for_event.RegisterForEventDataAccessInterface;
import use_case.view_event.ViewEventDataAccessInterface;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class EventDataAccessObject implements ViewEventDataAccessInterface,
        ModifyEventDataAccessInterface, CreateEventDataAccessInterface,
        RegisterForEventDataAccessInterface {

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

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
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
                        event.getCurrency(), event.getSummary(), event.getIsPrivate(),
                        event.getID());
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
    public void save(Event event) {
        events.put(event.getID(), event);
        this.saveToFile();
    }

    @Override
    public void remove(Event event) {
        events.remove(event.getID());
        this.saveToFile();
    }

    public Event modify(String id, String name, String start, String end, String currency, String summary, Boolean isPrivate) {
        Client client = ClientBuilder.newClient();
        Entity payload = Entity.json("{  \"event\": {    \"name\": {      \"html\": \"&#60;p&#62;Some text&#60;/p&#62;\"    },    \"description\": {      \"html\": \"&#60;p&#62;Some text&#60;/p&#62;\"    },    \"start\": {      \"timezone\": \"UTC\",      \"utc\": \"2018-05-12T02:00:00Z\"    },    \"end\": {      \"timezone\": \"UTC\",      \"utc\": \"2018-05-12T02:00:00Z\"    },    \"currency\": \"USD\",    \"online_event\": false,    \"organizer_id\": \"\",    \"listed\": false,    \"shareable\": false,    \"invite_only\": false,    \"show_remaining\": true,    \"password\": \"12345\",    \"capacity\": 100,    \"is_reserved_seating\": true,    \"is_series\": true,    \"show_pick_a_seat\": true,    \"show_seatmap_thumbnail\": true,    \"show_colors_in_seatmap_thumbnail\": true  }}");
        Response response = client.target("https://www.eventbriteapi.com/v3/events/" + id + "/")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("Authorization", "Bearer PERSONAL_OAUTH_TOKEN")
                .post(payload);

        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + response.readEntity(String.class));

        this.remove(events.get(id));
        Event event = eventFactory.create(id, name, start, end, currency, summary, isPrivate);
        this.save(event);
        return event;
    }

}
