package me.sakio.cosmetic.utils;

import java.io.File;

import me.sakio.cosmetic.PluginMain;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;


public class DataFile extends YamlConfiguration {
	
    private static DataFile config;
    private final Plugin plugin;
    private final File configFile;
    
    public static DataFile getConfig() {
        if (DataFile.config == null) {
            DataFile.config = new DataFile();
        }
        return DataFile.config;
    }
    
    private Plugin main() {
        return PluginMain.getInstance();
    }
    
    public DataFile() {
        this.plugin = this.main();
        this.configFile = new File(this.plugin.getDataFolder(), "player-data.yml");
        this.saveDefault();
        this.reload();
    }
    
    public void reload() {
        try {
            super.load(this.configFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void save() {
        try {
            super.save(this.configFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void saveDefault() {
        this.plugin.saveResource("player-data.yml", false);
    }

    public void saveAll() {
        this.save();
        this.reload();
    }
}
