package me.sakio.cosmetic;

import lombok.Getter;
import me.sakio.cosmetic.commands.CosmeticCommand;
import me.sakio.cosmetic.commands.OpenMenuCommand;
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

public final class Cosmetic extends JavaPlugin {
    @Getter
    private static Cosmetic instance;
    @Getter
    private PlayerData playerData;

    @Override
    public void onEnable() {
        Bukkit.getServer().getConsoleSender().sendMessage("Working | sCosmetic");
        instance = this;
        this.playerData = new PlayerData();
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
                new JoinListener()
        );
    }

    private void registerCommands(Object... command) {
        CommandFramework commandFramework = new CommandFramework(this);
        Arrays.stream(command).forEach(commandFramework::registerCommands);

    }

    private void registerListeners(Listener... listeners) {
        Arrays.stream(listeners).forEach(l -> Bukkit.getServer().getPluginManager().registerEvents(l, this));
    }
}
