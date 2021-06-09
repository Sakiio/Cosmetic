package me.sakio.cosmetic.listener;

import me.sakio.cosmetic.Cosmetic;
import me.sakio.cosmetic.manager.database.PlayerDataMongo;
import me.sakio.cosmetic.manager.objects.Gadgets;
import me.sakio.cosmetic.manager.objects.Trails;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;


/**
 * Project: Cosmetic
 * Date: 09/06/2021 @ 10:43
 * Class: LoadPLayerDataListener
 */
public class LoadPLayerDataListener implements Listener {
    @EventHandler
    public void onPreLoginLoad(PlayerPreLoginEvent event) {
        if (Cosmetic.getInstance().getConfig().getBoolean("MONGO.STATUS")){
            new PlayerDataMongo(event.getUniqueId(), event.getName());
        }
    }

    @EventHandler
    public void onPlayerLoadData(PlayerJoinEvent event) {
        if (Cosmetic.getInstance().getConfig().getBoolean("MONGO.STATUS")){
            PlayerDataMongo playerDataMongo = PlayerDataMongo.getPlayer(event.getPlayer());
            if (playerDataMongo.getTrails() == null) playerDataMongo.setTrails(Trails.DEFAULT);
            if (playerDataMongo.getGadgets() == null) playerDataMongo.setGadgets(Gadgets.DEFAULT);
            event.setJoinMessage(null);
        }
    }
    @EventHandler
    public void onPlayerQuitSaveData(PlayerQuitEvent event){
        Bukkit.getScheduler().runTaskAsynchronously(Cosmetic.getInstance(), () -> PlayerDataMongo.getPlayer(event.getPlayer()).save());
    }
}
