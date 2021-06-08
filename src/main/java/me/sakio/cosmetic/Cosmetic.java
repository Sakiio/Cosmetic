package me.sakio.cosmetic;

import lombok.Getter;
import me.sakio.cosmetic.commands.CosmeticCommand;
import me.sakio.cosmetic.commands.OpenMenuCommand;
import me.sakio.cosmetic.listener.GadgetsListener;
import me.sakio.cosmetic.listener.PlayerListener;
import me.sakio.cosmetic.listener.TrailsListener;
import me.sakio.cosmetic.manager.PlayerData;
import me.sakio.cosmetic.manager.database.MongoConnection;
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
    private MongoConnection mongoConnection;

    @Override
    public void onEnable() {
        Bukkit.getServer().getConsoleSender().sendMessage("Working | sCosmetic");
        instance = this;
        reloadConfig();
        saveDefaultConfig();
        this.registerCommands();
        this.registerListeners();
        Bukkit.getScheduler().runTaskAsynchronously(this, new RainbowTask());
        if (getInstance().getConfig().getBoolean("MONGO.STATUS")) {
            try {
                this.mongoConnection = new MongoConnection();
                System.out.println("[MONGODB] Database Connected");
            } catch (Exception exception) {
                exception.printStackTrace();
                super.getLogger().severe("Could not connect to the MongoDB Database");
                super.getServer().getPluginManager().disablePlugin(this);
            }
        }
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
