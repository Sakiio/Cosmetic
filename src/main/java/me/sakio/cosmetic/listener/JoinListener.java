package me.sakio.cosmetic.listener;

import me.sakio.cosmetic.Cosmetic;
import me.sakio.cosmetic.manager.PlayerData;
import me.sakio.cosmetic.manager.provider.Gadgets;
import me.sakio.cosmetic.manager.provider.Trails;
import me.sakio.cosmetic.menu.CosmeticMainMenu;
import me.sakio.cosmetic.utils.DataFile;
import me.sakio.cosmetic.utils.ItemMaker;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;

import java.util.Arrays;

/**
 * Created by DevSakio
 * Project: Cosmetic
 * Date: 04/01/2021 @ 17:44
 * Class: JoinListener
 */
public class JoinListener implements Listener {
    @EventHandler
    public void JoinEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();
        PlayerData playerData = Cosmetic.getInstance().getPlayerData();
        if (Cosmetic.getInstance().getConfig().getBoolean("ITEM.STATUS")){
            player.getInventory().setItem(Cosmetic.getInstance().getConfig().getInt("ITEM.SLOTS"), new ItemMaker(Material.ENDER_CHEST).
                    setTitle(Cosmetic.getInstance().getConfig().getString("ITEM.NAME")).
                    setLore(Cosmetic.getInstance().getConfig().getString("ITEM.LORE")).build());
        }
        if (player.hasPlayedBefore()){
            playerData.setTrails(player, Trails.DEFAULT);
            playerData.setGadgets(player, Gadgets.DEFAULT);
        }
        DataFile.getConfig().save();
    }
    @EventHandler
    public void onClick(PlayerInteractEvent event){
        if (event.getItem() == null) return;
        if (event.getAction() == Action.LEFT_CLICK_AIR) return;
        if (event.getAction() == Action.LEFT_CLICK_BLOCK) return;

        Player player = event.getPlayer();
        Action action = event.getAction();
        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() == null) {
                return;
            }
            if (event.getItem().getType() == Material.ENDER_CHEST) {
                new CosmeticMainMenu().open(player);
            }
        }
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        DataFile.getConfig().save();
    }
}
