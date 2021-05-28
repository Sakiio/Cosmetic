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
        if (playerData.getTrails(player).equals(Trails.DEFAULT.getName())){
            return;
        }
        if(playerData.getTrails(player).equals(Trails.FIRE.getName())){
            player.getWorld().spigot().playEffect(
                    player.getLocation(),
                    Effect.FLAME,
                    26, 0, 0.2F, 1, 1, 1, 2, 1);
        }
        if (playerData.getTrails(player).equals(Trails.NOTE.getName())){
            player.getWorld().spigot().playEffect(
                    player.getLocation(),
                    Effect.NOTE,
                    26, 0, 0.2F, 1, 1, 1, 2, 1);
        }
        if (playerData.getTrails(player).equals(Trails.FIREWORKS_SPARK.getName())){
            player.getWorld().spigot().playEffect(
                    player.getLocation(),
                    Effect.FIREWORKS_SPARK, 26, 0,0.2F,1,1,1,2,1
            );
        }
        if (playerData.getTrails(player).equals(Trails.HEART.getName())){
            player.getWorld().spigot().playEffect(
                    player.getLocation(),
                    Effect.HEART, 26, 0,0.2F,1,1,1,2,1
            );
        }
        if (playerData.getTrails(player).equals(Trails.CRITIC.getName())){
            player.getWorld().spigot().playEffect(
                    player.getLocation(),
                    Effect.CRIT, 26, 0,0.2F,1,1,1,2,1
            );
        }
        if (playerData.getTrails(player).equals(Trails.SMOKE.getName())){
            player.getWorld().spigot().playEffect(
                    player.getLocation(),
                    Effect.SMOKE, 26, 0,0.2F,1,1,1,2,1
            );
        }
    }
}
