package use_case.create_events;

public class CreateEventInputData {

    private final String name;
    private final String start;
    private final String end;
    private final String currency;
    private final String summary;
    private final Boolean isPrivate;

    public CreateEventInputData(String name, String start, String end, String currency, String summary, Boolean isPrivate){
        this.name = name;
        this.start = start;
        this.end = end;
        this.currency = currency;
        this.summary = summary;
        this.isPrivate = isPrivate;
    }
    public String getName() {
        return name;
    }
    public String getStart() {
        return start;
    }
    public String getEnd() {
        return end;
    }
    public String getCurrency(){
        return currency;
    }
    public String getSummary(){
        return summary;
    }
    public Boolean getIsPrivate(){ return isPrivate; }
}
