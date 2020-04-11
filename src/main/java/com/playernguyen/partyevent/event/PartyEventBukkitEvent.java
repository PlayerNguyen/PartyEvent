package com.playernguyen.partyevent.event;

import com.playernguyen.partyevent.object.Event;
import org.bukkit.event.HandlerList;

public abstract class PartyEventBukkitEvent extends org.bukkit.event.Event {

    private static final HandlerList handlerList = new HandlerList();
    private Event event;

    public PartyEventBukkitEvent(Event event, boolean isAsync) {
        super(isAsync);
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
