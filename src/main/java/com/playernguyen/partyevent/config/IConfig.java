package com.playernguyen.partyevent.config;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface IConfig {

    String getName();

    File getFile();

    FileConfiguration getConfiguration();

    void setConfiguration(FileConfiguration fileConfiguration);

    void save() throws IOException;

    InputStream getResourceFile();

    void load();

    void afterLoad();

}
