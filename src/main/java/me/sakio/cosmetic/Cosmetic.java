package me.sakio.cosmetic;

import lombok.Getter;
import me.sakio.cosmetic.commands.CosmeticCommand;
import me.sakio.cosmetic.commands.OpenMenuCommand;
import me.sakio.cosmetic.listener.GadgetsListener;
import me.sakio.cosmetic.listener.PlayerListener;
import me.sakio.cosmetic.listener.TrailsListener;
import me.sakio.cosmetic.manager.PlayerData;
import me.sakio.cosmetic.utils.commands.CommandFramework;
import me.sakio.cosmetic.utils.menu.MenuListener;
import me.sakio.cosmetic.utils.task.RainbowTask;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class Cosmetic extends JavaPlugin {

    @Override
    public void onEnable() {
        reloadConfig();
        saveDefaultConfig();

        this.registerCommands();
        this.registerListeners();

        Bukkit.getScheduler().runTaskAsynchronously(this, new RainbowTask());
    }

    @Override
    public void onDisable() {}

    public void registerCommands() {
        this.registerCommands(
                new CosmeticCommand(),
                new OpenMenuCommand()
        );
        this.registerListeners(
                new MenuListener(),
                new TrailsListener(),
                new PlayerListener(),
                new GadgetsListener()
        );
    }

    private void registerCommands(Object... command) {
        CommandFramework commandFramework = new CommandFramework(this);
        Arrays.stream(command).forEach(commandFramework::registerCommands);

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
