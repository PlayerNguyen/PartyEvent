package com.playernguyen.partyevent.runnable;

import com.playernguyen.partyevent.PartyEvent;
import org.bukkit.scheduler.BukkitRunnable;

abstract class PartyEventRunnable extends BukkitRunnable {

    PartyEvent getPluginInstance() {
        return PartyEvent.getInstance();
    }

}
