package me.sakio.cosmetic.listener;

import me.sakio.cosmetic.Cosmetic;
import me.sakio.cosmetic.manager.PlayerData;
import me.sakio.cosmetic.manager.objects.Gadgets;
import me.sakio.cosmetic.manager.objects.Trails;
import me.sakio.cosmetic.manager.menu.CosmeticMainMenu;
import me.sakio.cosmetic.utils.DataFile;
import me.sakio.cosmetic.utils.ItemMaker;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;

/**
 * Created by DevSakio
 * Project: Cosmetic
 * Date: 04/01/2021 @ 17:44
 * Class: JoinListener
 */
public class PlayerListener implements Listener {
    @EventHandler
    public void JoinEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();
        PlayerData playerData = Cosmetic.getInstance().getPlayerData();
        DataFile.getConfig().save();
        if (Cosmetic.getInstance().getConfig().getBoolean("ITEM.STATUS")){
            player.getInventory().setItem(Cosmetic.getInstance().getConfig().getInt("ITEM.SLOTS"), new ItemMaker(Material.ENDER_CHEST).
                    setTitle(Cosmetic.getInstance().getConfig().getString("ITEM.NAME")).
                    setLore(Cosmetic.getInstance().getConfig().getString("ITEM.LORE")).build());
        }
        if (!player.hasPlayedBefore()){
            playerData.createData(player);
            playerData.setTrails(player, Trails.DEFAULT);
            playerData.setGadgets(player, Gadgets.DEFAULT);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        DataFile.getConfig().save();
    }

    @EventHandler
    public void onEnderChestClick(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Action action = event.getAction();
        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem().getType() == Material.ENDER_CHEST) {
                new CosmeticMainMenu().open(player);
            }
        }
    }
}
