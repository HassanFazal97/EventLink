package data_access;

import entity.event.Event;
import entity.event.EventFactory;
import use_case.modify_events.ModifyEventDataAccessInterface;
import use_case.create_events.CreateEventDataAccessInterface;
import use_case.register_for_event.RegisterForEventDataAccessInterface;
import use_case.view_event.ViewEventDataAccessInterface;

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
}
