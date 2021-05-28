package me.sakio.cosmetic;

import lombok.Getter;
import me.sakio.cosmetic.commands.CosmeticCommand;
import me.sakio.cosmetic.commands.OpenMenuCommand;
import me.sakio.cosmetic.listener.GadgetsListener;
import me.sakio.cosmetic.listener.JoinListener;
import me.sakio.cosmetic.listener.TrailsListener;
import me.sakio.cosmetic.manager.PlayerData;
import me.sakio.cosmetic.utils.commands.CommandFramework;
import me.sakio.cosmetic.utils.menu.MenuListener;
import me.sakio.cosmetic.utils.task.RainbowTask;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

@Getter
public class Cosmetic extends JavaPlugin {
    private static Cosmetic instance;

    @Override
    public void onEnable() {
        Bukkit.getServer().getConsoleSender().sendMessage("Working | sCosmetic");
        instance = this;
        reloadConfig();
        saveDefaultConfig();
        this.registerCommands();
        this.registerListeners();
        Bukkit.getScheduler().runTaskTimer(this, new RainbowTask(), 20, 0);
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
                new JoinListener(),
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
        return instance;
    }
    public PlayerData getPlayerData(){
        return new PlayerData();
    }
}
