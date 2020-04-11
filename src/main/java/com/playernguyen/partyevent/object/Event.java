package com.playernguyen.partyevent.object;

import com.playernguyen.partyevent.PartyEventInstance;
import com.playernguyen.partyevent.event.EventChangedStateEvent;
import com.playernguyen.partyevent.timeline.ITimeline;
import org.bukkit.configuration.MemorySection;

import java.util.ArrayList;

public class Event extends PartyEventInstance implements IEvent {

    private String id;
    private String name;
    private int prepare;
    private int duration;
    private MemorySection handleBlock;

    private EventState state;

    private ArrayList<ITimeline> timelineList;

    public Event(String id, String name, int prepare, int duration, MemorySection handleBlock) {
        this.id = id;
        this.name = name;
        this.prepare = prepare;
        this.duration = duration;
        this.handleBlock = handleBlock;
        // Set state to not occur
        this.setState(EventState.NOT_OCCUR);
        // Apply new timeline list
        this.timelineList = new ArrayList<ITimeline>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrepare() {
        return prepare;
    }

    public int getDuration() {
        return duration;
    }

    public MemorySection getHandleBlock() {
        return handleBlock;
    }

    public EventState getState() {
        return state;
    }

    public void setState(EventState state) {
        EventChangedStateEvent changedStateEvent = new EventChangedStateEvent(this);
        if (changedStateEvent.callEvent()) {
            this.state = state;
        } else {
            throw new IllegalStateException("Cannot change state because of false returned");
        }
    }

    public ArrayList<ITimeline> getTimelineList() {
        return timelineList;
    }


}

