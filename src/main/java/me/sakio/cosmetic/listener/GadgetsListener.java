package me.sakio.cosmetic.listener;

import me.sakio.cosmetic.Cosmetic;
import me.sakio.cosmetic.manager.PlayerData;
import me.sakio.cosmetic.manager.objects.Gadgets;
import me.sakio.cosmetic.utils.ItemMaker;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by DevSakio
 * Project: Cosmetic
 * Date: 16/01/2021 @ 22:01
 * Class: GadgetsListener
 */
public class GadgetsListener implements Listener {
    @EventHandler
    public void onJoinItem(PlayerJoinEvent event){
        Player player = event.getPlayer();
        PlayerData playerData = Cosmetic.getInstance().getPlayerData();
        if (playerData.getGadgets(player).equals(Gadgets.DEFAULT.getName())){
            return;
        }
        if (playerData.getGadgets(player).equals(Gadgets.PEARLS.getName())){
            player.getInventory().setItem(Cosmetic.getInstance().getConfig().getInt("GADGETS.SLOTS"), new ItemMaker(Material.ENDER_PEARL).setAmount(64).build());
        }
        if (playerData.getGadgets(player).equals(Gadgets.SNOW_PEARLS.getName())){
            player.getInventory().setItem(Cosmetic.getInstance().getConfig().getInt("GADGETS.SLOTS"), new ItemMaker(Material.SNOW_BALL).setAmount(64).build());
        }

        if (playerData.getGadgets(player).equals(Gadgets.LITGTH_STRIKE.getName())){
            player.getInventory().setItem(Cosmetic.getInstance().getConfig().getInt("GADGETS.SLOTS"), new ItemMaker(Material.BLAZE_ROD).setAmount(1).build());
        }

    }
    @EventHandler
    public void onEventItem(PlayerInteractEvent event) {
        if (event.getItem() == null) return;
        if (event.getAction() == Action.LEFT_CLICK_AIR) return;
        if (event.getAction() == Action.LEFT_CLICK_BLOCK) return;

        Action action = event.getAction();

        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() == null) {
                return;
            }
            if (event.getItem().getType() == Material.ENDER_PEARL) {
                if (event.getPlayer().getVehicle() != null) {
                    event.getPlayer().getVehicle().remove();
                    event.getPlayer().eject();
                }
                event.getPlayer().spigot().setCollidesWithEntities(false);
                event.getPlayer().setVelocity(event.getPlayer().getLocation().getDirection().normalize().setY(1.2f));
                event.getPlayer().setVelocity(event.getPlayer().getLocation().getDirection().normalize().multiply(2.6f));
                event.getPlayer().updateInventory();
                event.getPlayer().setItemInHand(event.getPlayer().getItemInHand());
                event.getPlayer().updateInventory();
                event.setCancelled(false);
            }
        }
        if (event.getItem().getType() == Material.SNOW_BALL) {
            if (event.getPlayer().getVehicle() != null) {
                event.getPlayer().getVehicle().remove();
                event.getPlayer().eject();
            }
            event.getPlayer().spigot().setCollidesWithEntities(false);
            event.getPlayer().setVelocity(event.getPlayer().getLocation().getDirection().normalize().setY(1.2f));
            event.getPlayer().setVelocity(event.getPlayer().getLocation().getDirection().normalize().multiply(2.6f));
            event.getPlayer().updateInventory();
            event.getPlayer().setItemInHand(event.getPlayer().getItemInHand());
            event.getPlayer().updateInventory();
            event.setCancelled(false);
        }
        if (event.getItem().getType() == Material.BLAZE_ROD){
            event.getPlayer().getWorld().spigot().strikeLightning(event.getPlayer().getLocation(), false);
        }
    }
}
