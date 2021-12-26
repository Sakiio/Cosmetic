package me.sakio.cosmetic.manager.menu;

import me.sakio.cosmetic.PluginMain;
import me.sakio.cosmetic.manager.PlayerData;
import me.sakio.cosmetic.manager.models.Trails;
import me.sakio.cosmetic.utils.Color;
import me.sakio.cosmetic.utils.InventoryUtils;
import me.sakio.cosmetic.utils.ItemMaker;
import me.sakio.cosmetic.utils.menu.type.ChestMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by DevSakio
 * Project: Cosmetic
 * Date: 01/01/2021 @ 15:24
 * Class: TrailsMenu
 */
public class TrailsMenu extends ChestMenu<PluginMain> {
    private final PlayerData playerData = PluginMain.getInstance().getPlayerData();

    public TrailsMenu() {
        super("Trails Menu", 9*6);
        this.update();
    }

    public void update(){
        this.inventory.setItem(11, new ItemMaker(Material.BLAZE_POWDER).setTitle("&3Fire Trails").build());
        this.inventory.setItem(12, new ItemMaker(Material.RECORD_3).setTitle("&3Note Trails").build());
        this.inventory.setItem(13, new ItemMaker(Material.FIREWORK).setTitle("&3FireWork Trails").build());
        this.inventory.setItem(14, new ItemMaker(Material.GHAST_TEAR).setTitle("&3Heart Trails").build());
        this.inventory.setItem(15, new ItemMaker(Material.DIAMOND_SWORD).setTitle("&3Critic Trails").build());
        this.inventory.setItem(20, new ItemMaker(Material.SNOW).setTitle("&3Smoke Trails").build());
        this.inventory.setItem(40, new ItemMaker(Material.REDSTONE).setTitle("&4Remove Trails").build());
        InventoryUtils.getFill(inventory);
    }

    @Override
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory clickedInventory = event.getClickedInventory();
        Inventory topInventory = event.getView().getTopInventory();

        if (!topInventory.equals(this.inventory)) return;

        if (topInventory.equals(clickedInventory)) {
            event.setCancelled(true);

            ItemStack item = event.getCurrentItem();
            if (item == null || item.getType() == Material.AIR) return;

            Player player = (Player) event.getWhoClicked();

            switch (event.getRawSlot()) {
                case 11:
                    playerData.setTrails(player, Trails.FIRE);
                    break;
                case 12:
                    playerData.setTrails(player, Trails.NOTE);
                    break;
                case 13:
                    playerData.setTrails(player, Trails.FIREWORKS_SPARK);
                    break;
                case 14:
                    playerData.setTrails(player, Trails.HEART);
                    break;
                case 15:
                    playerData.setTrails(player, Trails.CRITIC);
                    break;
                case 20:
                    playerData.setTrails(player, Trails.SMOKE);
                    break;
                case 40 :
                    if (playerData.getTrails(player).length() == 0) {
                        player.sendMessage(Color.translate("&cYou don't have any trails to remove!"));
                        return;
                    }
                    if (playerData.getTrails(player).length() > 0) {
                        playerData.setTrails(player , Trails.DEFAULT);
                        player.sendMessage(Color.translate("&cAll trails remove"));
                    }
                    break;
            }
        }
    }
}
