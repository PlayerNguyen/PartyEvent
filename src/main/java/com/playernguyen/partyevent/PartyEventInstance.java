package com.playernguyen.partyevent;

import com.playernguyen.partyevent.time.Time;

public abstract class PartyEventInstance {

    /**
     * Get the plugin
     * @return {@link PartyEvent} class
     */
    protected PartyEvent getPlugin() {
        return PartyEvent.getInstance();
    }

    /**
     * Get the server time (not from client)
     * @return Long get millisecond time now
     */
    protected Time getNow() {
        return getPlugin().getRealtime().toTimeObject();
    }

    /**
     * It's get now, but return the long of millis
     * @return Long of millisecond of current server time
     */
    protected long getNowAsMillisecond() {
        return getPlugin().getRealtime().asMillis();
    }

}
