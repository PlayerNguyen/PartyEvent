package com.playernguyen.partyevent.object;

import org.bukkit.configuration.MemorySection;

public interface IEvent {

    String getId();

    String getName();

    int getPrepare();

    int getDuration();

    MemorySection getHandleBlock();

    EventState getState();

}
