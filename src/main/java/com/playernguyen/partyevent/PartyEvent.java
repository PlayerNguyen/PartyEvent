package com.playernguyen.partyevent;

import com.playernguyen.partyevent.config.PluginConfiguration;
import com.playernguyen.partyevent.object.EventManager;
import com.playernguyen.partyevent.runnable.PartyEventUpdateTime;
import com.playernguyen.partyevent.time.Realtime;
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
        validConfig();
        setupRealtime();
    }

    /**
     * Valid the config is alright
     */
    private void validConfig() {
        for (String id : getPluginConfiguration().getConfiguredEventID()) {
            if (!getPluginConfiguration().isValid(id)) {
                throw new IllegalStateException( String.format("Config not valid, empty data as id %s", id) );
            }
        }
    }

    /**
     * Register realtime counter
     */
    private void setupRealtime() {
        this.realtime = new Realtime(System.currentTimeMillis());
        // Run async task every tick
        PartyEventUpdateTime tick = new PartyEventUpdateTime();
        tick.runTaskTimer(this, 1, 1);
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
