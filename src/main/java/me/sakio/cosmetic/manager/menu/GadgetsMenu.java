package me.sakio.cosmetic.manager.menu;

import me.sakio.cosmetic.PluginMain;
import me.sakio.cosmetic.manager.PlayerData;
import me.sakio.cosmetic.manager.database.PlayerDataMongo;
import me.sakio.cosmetic.manager.models.Gadgets;
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
 * Date: 05/01/2021 @ 23:43
 * Class: GadgetsMenu
 */
public class GadgetsMenu extends ChestMenu<PluginMain> {

    private final PlayerData playerData = PluginMain.getInstance().getPlayerData();

    public GadgetsMenu() {
        super("Gadgets Menu", 9*6);
        this.update();
    }

    public void update(){
        this.inventory.setItem(11, new ItemMaker(Material.ENDER_PEARL).setTitle("&3Pearls").build());
        this.inventory.setItem(12, new ItemMaker(Material.SNOW_BALL).setTitle("&3SnowBall").build());
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
            PlayerDataMongo playerDataMongo = new PlayerDataMongo(player.getUniqueId(), player.getName());

            switch (event.getRawSlot()) {
                case 11:
                    playerData.setGadgets(player, Gadgets.PEARLS);
                    break;
                case 12:
                    playerData.setGadgets(player, Gadgets.SNOW_PEARLS);
                    break;
                case 40 :
                    if (playerData.getTrails(player).length() == 0) {
                        player.sendMessage(me.sakio.cosmetic.utils.Color.translate("&cYou dont have any gadgets to remove!"));
                        break;
                    }
                    if (playerData.getGadgets(player).length() > 0) {
                        playerData.setGadgets(player , Gadgets.DEFAULT);
                        player.sendMessage(me.sakio.cosmetic.utils.Color.translate("&cAll gadgets remove"));
                        break;
                    }
            }
        }
    }
}
