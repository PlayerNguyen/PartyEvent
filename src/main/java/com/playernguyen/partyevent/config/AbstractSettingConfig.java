package com.playernguyen.partyevent.config;

import com.playernguyen.partyevent.PartyEventInstance;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public abstract class AbstractSettingConfig extends PartyEventInstance implements IConfig {

    private String name;
    private File file;
    private FileConfiguration configuration;

    AbstractSettingConfig(String name) {
        this.name = name;
        this.file = new File(getPlugin().getDataFolder(), name);
        this.load();
        this.afterLoad();
    }

    /**
     * Load the file, can be use to reload
     */
    public void load() {
        this.configuration = YamlConfiguration.loadConfiguration(file);
    }

    public String getName() {
        return name;
    }

    public File getFile() {
        return file;
    }

    public FileConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(FileConfiguration configuration) {
        this.configuration = configuration;
    }

    public void save() throws IOException {
        this.getConfiguration().save(getFile());
    }

    public InputStream getResourceFile() {
        return getPlugin().getResource(getName());
    }
}
