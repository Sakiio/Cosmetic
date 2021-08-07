package me.sakio.cosmetic.utils;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

/**
 * Created by DevSakio
 * Project: Cosmetic
 * Date: 16/01/2021 @ 22:03
 * Class: InventoryUtils
 */
public class InventoryUtils {
    public static void getFill(Inventory inv) {
        for (int i = 0; i < inv.getSize(); i++) {
            if (inv.getItem(i) == null || inv.getItem(i).getType().equals(Material.AIR)) {
                inv.setItem(i, new ItemMaker(Material.STAINED_GLASS_PANE).setTitle("").build());
            }
        }
    }
}
