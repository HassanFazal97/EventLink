package com.example.eventlink.use_case.view_event;

public class ViewEventOutputData {
    private final String name;
    private final String start;
    private final String end;
    private final String summary;
    private final String id;

    public ViewEventOutputData(String name, String start, String end, String summary, String id) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.summary = summary;
        this.id = id;
    }

    public String getName() {return name;}
    public String getStart() {return start;}
    public String getEnd() {return end;}
    public String getSummary() {return summary;}
    public String getId() {return id;}
}
