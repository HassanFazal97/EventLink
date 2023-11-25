package com.example.eventlink.entity.event;

public interface EventFactory {
    Event create(String id, String name, String start, String end, String currency, String summary, Boolean isPrivate);
}
