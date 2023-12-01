package com.example.eventlink.interface_adapter.guest_in;

import com.example.eventlink.entity.event.Event;

import java.util.List;

public class GuestState {
    private List<Event> events;

    public List<Event> getEvents() {return this.events;}
    public void setEvents(List<Event> events) {this.events = events;}
}
