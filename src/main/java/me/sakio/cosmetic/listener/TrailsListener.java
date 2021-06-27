package me.sakio.cosmetic.listener;

import me.sakio.cosmetic.Cosmetic;
import me.sakio.cosmetic.manager.PlayerData;
import me.sakio.cosmetic.manager.objects.Trails;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Created by DevSakio
 * Project: Cosmetic
 * Date: 01/01/2021 @ 23:58
 * Class: TrailsEvent
 */
public class TrailsListener implements Listener {
    @EventHandler
    public void moveTrails(PlayerMoveEvent e){
        Player player = e.getPlayer();
        PlayerData playerData = Cosmetic.getInstance().getPlayerData();
        Trails trail = Trails.valueOf(playerData.getTrails(player));
        if (trail == Trails.DEFAULT)
            return;

        Effect effectType = trail.getEffect();
        player.getWorld().spigot().playEffect(
                player.getLocation(),
                effectType,
                26, 0, 0.2F, 1, 1, 1, 2, 1
        );
    }
}
