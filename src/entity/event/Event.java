package entity.event;

public interface Event {
    String getID();
    String getName();
    String getStart();
    String getEnd();
    String getCurrency();
    String getSummary();
    Boolean getIsPrivate();
}
