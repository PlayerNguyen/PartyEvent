package com.playernguyen.partyevent.timeline;

import com.playernguyen.partyevent.time.Time;

public class Timeline implements ITimeline {

    private Time startPoint;
    private Time occurPoint;
    private Time endPoint;

    public Timeline(Time startPoint) {
        this.startPoint = startPoint;
    }

    public Time getStartPoint() {
        return startPoint;
    }

    public Time getOccurPoint() {
        return occurPoint;
    }

    public Time getEndPoint() {
        return endPoint;
    }
}
