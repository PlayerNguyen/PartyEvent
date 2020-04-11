package com.playernguyen.partyevent.event;

import com.playernguyen.partyevent.object.Event;

public class EventChangedStateEvent extends PartyEventBukkitEvent {

    public EventChangedStateEvent(Event event) {
        super(event, true);
    }

}
