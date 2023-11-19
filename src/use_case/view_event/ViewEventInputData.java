package use_case.view_event;

public class ViewEventInputData {
    final private String event_id;

    public ViewEventInputData(String event_id) {this.event_id = event_id;}

    String getId() {return event_id;}
}
