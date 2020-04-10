package com.playernguyen.partyevent;

import com.playernguyen.partyevent.config.PluginConfiguration;
import com.playernguyen.partyevent.object.EventManager;
import com.playernguyen.partyevent.runnable.PartyEventUpdateTime;
import com.playernguyen.partyevent.time.Realtime;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class PartyEvent extends JavaPlugin {

    /**
     * Instance Object
     */
    private static PartyEvent instance;

    /**
     * Settings
     */
    private PluginConfiguration pluginConfiguration;

    /**
     * Managers
     */
    private EventManager eventManager;

    /**
     * Realtime counter
     */
    private Realtime realtime;

    /**
     * Plugin enable
     */
    public void onEnable() {
        setupInstance();
        setupManager();
        setupConfig();
        setupRealtime();
    }

    /**
     * Register realtime counter
     */
    private void setupRealtime() {
        this.realtime = new Realtime(System.currentTimeMillis());
        // Run async task every tick
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, new PartyEventUpdateTime(), 1L, 1L);
    }

    /**
     * Register managers
     */
    private void setupManager() {
        this.eventManager = new EventManager();
    }

    /**
     * Setup all config
     */
    private void setupConfig () {
        this.pluginConfiguration = new PluginConfiguration();
    }

    /**
     * Setup instance
     */
    private void setupInstance () {
        instance = this;
    }

    /**
     * Get instance
     * @return the plugin object
     */
    public static PartyEvent getInstance() {
        return instance;
    }

    /**
     * Get plugin configuration. (config.yml)
     * @return PluginConfig class
     */
    public PluginConfiguration getPluginConfiguration() {
        return pluginConfiguration;
    }

    /**
     * Event manager contain all managers. <br>
     * The manager object contained id of each Event
     * @return EventManager object
     */
    public EventManager getEventManager() {
        return eventManager;
    }

    /**
     * Get realtime object
     * @return Realtime Object
     */
    public Realtime getRealtime() {
        return realtime;
    }
}
