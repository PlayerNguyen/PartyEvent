package com.playernguyen.partyevent.time;

public class Realtime {

    private long time;

    public Realtime(long time) {
        this.time = time;
    }

    public long asMillis() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Time toTimeObject() {
        return new Time(time);
    }

}
