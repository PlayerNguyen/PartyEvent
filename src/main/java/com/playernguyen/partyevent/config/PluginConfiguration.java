package com.playernguyen.partyevent.config;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.IOException;
import java.io.InputStreamReader;

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
}
