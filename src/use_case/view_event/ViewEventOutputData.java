package use_case.view_event;

public class ViewEventOutputData {
    private final String name;
    private final String start;
    private final String end;
    private final String summary;

    public ViewEventOutputData(String name, String start, String end, String summary) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.summary = summary;
    }

    public String getName() {return name;}
    public String getStart() {return start;}
    public String getEnd() {return end;}
    public String getSummary() {return summary;}
}
