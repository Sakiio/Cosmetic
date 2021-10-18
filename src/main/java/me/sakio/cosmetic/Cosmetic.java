package me.sakio.cosmetic;

import me.sakio.cosmetic.commands.OpenMenuCommand;
import me.sakio.cosmetic.listener.GadgetsListener;
import me.sakio.cosmetic.listener.PlayerListener;
import me.sakio.cosmetic.listener.TrailsListener;
import me.sakio.cosmetic.manager.PlayerData;
import me.sakio.cosmetic.utils.menu.MenuListener;
import me.sakio.cosmetic.task.RainbowTask;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class Cosmetic extends JavaPlugin {

    @Override
    public void onEnable() {
        reloadConfig();
        saveDefaultConfig();

        this.registerListeners();

        Bukkit.getScheduler().runTaskAsynchronously(this, new RainbowTask());
    }

    @Override
    public void onDisable() {}

    public void init() {
        this.registerListeners(
                new MenuListener(),
                new TrailsListener(),
                new PlayerListener(),
                new GadgetsListener()
        );

        this.getServer().getPluginCommand("menu").setExecutor(new OpenMenuCommand());
    }

    private void registerListeners(Listener... listeners) {
        Arrays.stream(listeners).forEach(l -> Bukkit.getServer().getPluginManager().registerEvents(l, this));
    }

    public static Cosmetic getInstance(){
        return Cosmetic.getPlugin(Cosmetic.class);
    }
    public PlayerData getPlayerData(){
        return new PlayerData();
    }
}
