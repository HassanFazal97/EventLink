package data_access;

import entity.event.Event;
import entity.event.EventFactory;
import use_case.modify_events.ModifyEventDataAccessInterface;
import use_case.create_events.CreateEventDataAccessInterface;
import use_case.register_for_event.RegisterForEventDataAccessInterface;
import use_case.view_event.ViewEventDataAccessInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EventDataAccessObject implements ViewEventDataAccessInterface,
        ModifyEventDataAccessInterface, CreateEventDataAccessInterface,
        RegisterForEventDataAccessInterface {

    private final File dataFile;
    private final Map<String, Integer> headers = new HashMap<String, Integer>();
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

        if (dataFile.length() == 0) {
            saveToFile();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("name,start,end,currency,summary,isPrivate");

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

                    Event event = eventFactory.create(name, start, end, currency, summary, isPrivate);
                    events.put(event.getID(), event);
                }
            }
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
    }

    @Override
    public void remove(Event event) {
        events.remove(event.getID());
    }
}
