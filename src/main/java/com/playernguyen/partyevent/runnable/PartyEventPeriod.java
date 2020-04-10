package com.playernguyen.partyevent.runnable;

import com.playernguyen.partyevent.object.Event;
import com.playernguyen.partyevent.time.Realtime;

public class PartyEventPeriod extends PartyEventRunnable {

    private Event event;

    public PartyEventPeriod(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public void run() {

    }

    public Realtime getRealTime() {
        return getPluginInstance().getRealtime();
    }

}
