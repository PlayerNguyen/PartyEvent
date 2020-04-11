package com.playernguyen.partyevent.config;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class PluginConfiguration extends AbstractSettingConfig {

    private static final String FILE_NAME = "config.yml";

    public PluginConfiguration() {
        super(FILE_NAME);

    }

    public void afterLoad() {
        // Check resource file
        if (getResourceFile() == null) {
            throw new NullPointerException("Not found resources file: " + getName());
        }
        // If the file not exist
        if (!getFile().exists()) {
            // Set the stream to the file
            this.setConfiguration(YamlConfiguration.loadConfiguration(new InputStreamReader(getResourceFile())));
            //  Try to save
            try {
                save();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        // If exist the file, set the file
        this.setConfiguration(YamlConfiguration.loadConfiguration(getFile()));
    }

    /**
     * Get the configured event id
     * @return The id list of {@link com.playernguyen.partyevent.object.Event}
     */
    public Set<String> getConfiguredEventID() {
        ConfigurationSection section = getConfiguration().getConfigurationSection("");
        if (section == null) {
            throw new NullPointerException("The section was null");
        }
        return section.getKeys(false);
    }

    public boolean isValid(String eventId) {
        if (!getConfiguredEventID().contains(eventId)) {
            throw new NullPointerException(String.format("Event %s hasn't configured ", eventId));
        }
        for (ConfigKey configKey : ConfigKey.values()) {
            Object object = getConfiguration().get(buildPath(eventId, configKey));
            if (!configKey.isNullable() && object == null) {
                return false;
            }
        }
        return true;
    }

    private String buildPath(String id, ConfigKey configKey) {
        StringBuilder builder = new StringBuilder();
        builder.append(id).append(".").append(configKey.getPath());
        return builder.toString();
    }
}
