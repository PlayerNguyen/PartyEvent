package com.playernguyen.partyevent.runnable;

import com.playernguyen.partyevent.PartyEvent;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class PartyEventRunnable extends BukkitRunnable {

    public PartyEvent getPluginInstance() {
        return PartyEvent.getInstance();
    }

}
