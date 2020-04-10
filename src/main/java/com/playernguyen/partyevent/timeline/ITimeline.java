package com.playernguyen.partyevent.timeline;

import com.playernguyen.partyevent.time.Time;

public interface ITimeline {

    Time getStartPoint();

    Time getOccurPoint();

    Time getEndPoint();

}
