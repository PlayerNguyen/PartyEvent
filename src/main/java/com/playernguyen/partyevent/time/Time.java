package com.playernguyen.partyevent.time;

import com.playernguyen.partyevent.PartyEventInstance;

import java.util.Date;

public class Time extends PartyEventInstance {

    private long time;

    public Time(long time) {
        this.time = time;
    }

    public Time(int second) {
        this.time = second * 1000;
    }

    public Time add(int second) {
        return new Time(getTime() + new Time(second).getTime());
    }

    private long getTime() {
        return time;
    }

    public long toMillis() {
        return time;
    }

    public Date toDate() {
        return new Date(getTime());
    }

    public long toSecond() {
        return this.getTime() / 1000;
    }


}
