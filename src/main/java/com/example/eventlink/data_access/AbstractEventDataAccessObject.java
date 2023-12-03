package com.example.eventlink.data_access;

import com.example.eventlink.entity.event.*;

import java.util.*;
public interface AbstractEventDataAccessObject {

    public Event get(String id);

    public boolean existsById(String id);

    public Event create(String name, String startDate, String startTime, String endDate, String endTime, String currency, String summary, Boolean isPrivate);

    public void remove(String id);
    public String modify(String id, String name, String startDate, String startTime, String endDate, String endTime, String currency, String summary, Boolean isPrivate);

}
