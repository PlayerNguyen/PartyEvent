package com.playernguyen.partyevent.object;

import com.playernguyen.partyevent.PartyEventInstance;

import java.util.HashMap;

public class EventManager extends PartyEventInstance {

    private HashMap<String, IEvent> eventLists;

    public EventManager() {
        this.eventLists = new HashMap<String, IEvent>();
    }

    public HashMap<String, IEvent> getEventLists() {
        return eventLists;
    }

    public void add(String id, Event event) {
        if (search(id) != null) {
            throw new IllegalStateException("The id " + id + " has contained in EventManager. Please re-check.");
        }
        eventLists.put(id, event);
    }

    public IEvent search(String id) {
        return eventLists.get(id);
    }
}
