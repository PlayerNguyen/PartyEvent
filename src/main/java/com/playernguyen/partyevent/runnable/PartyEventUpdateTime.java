package com.playernguyen.partyevent.runnable;

public class PartyEventUpdateTime extends PartyEventRunnable {

    /**
     * Set the server real-time
     */
    public void run() {
        // Count up the time
        this.getPluginInstance().getRealtime().setTime(System.currentTimeMillis());
    }

}
