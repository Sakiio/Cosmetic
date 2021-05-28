package me.sakio.cosmetic.manager.menu;

import me.sakio.cosmetic.Cosmetic;
import me.sakio.cosmetic.utils.InventoryUtils;
import me.sakio.cosmetic.utils.ItemMaker;
import me.sakio.cosmetic.utils.menu.type.ChestMenu;
import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Project: Cosmetic
 * Date: 01/03/2021 @ 19:17
 * Class: PetsMenu
 */
public class PetsMenu extends ChestMenu<Cosmetic> {
    public PetsMenu() {
        super("Pets Menu", 9*6);
        this.update();
    }

    public void update(){
        this.inventory.setItem(11, new ItemMaker(Material.BLAZE_POWDER).setTitle("Test").build());
        this.inventory.setItem(40, new ItemMaker(Material.REDSTONE).setTitle("&4Remove Pets").build());
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
                    Creeper creeper = (Creeper) player.getWorld().spawnEntity(player.getLocation(), EntityType.CREEPER);
                    creeper.setTarget(player);
                    creeper.setCustomName(player.getName() + "Pets");
                    break;
                case 40:
            }
        }
    }
}
