package use_case.createEvent;

import java.util.Date;

public interface CreateEventInputData {

    final String name;

    final String summary;

    final String url;

    final Date start;

    final Date end;

    final Date created;

    final boolean online;

    final boolean hide_end_date;


}
