package com.playernguyen.partyevent.timeline;

import com.playernguyen.partyevent.PartyEventInstance;
import com.playernguyen.partyevent.time.Time;

public class Timeline extends PartyEventInstance implements ITimeline {

    private Time startPoint;
    private Time occurPoint;
    private Time endPoint;

    public Timeline(Time startPoint, int prepareTime, int occurTime) {
        this.startPoint = startPoint;
        this.occurPoint = startPoint.add(prepareTime);
        this.endPoint = startPoint.add(prepareTime).add(occurTime);
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

    /**
     * Check whether the timeline is in past or not
     * @return Is past or not
     */
    public boolean isPast() {
        return getNowAsMillisecond() > getStartPoint().toMillis()
                && getNowAsMillisecond() > getEndPoint().toMillis();
    }



}
