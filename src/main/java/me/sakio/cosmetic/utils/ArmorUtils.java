package me.sakio.cosmetic.utils;

import me.sakio.cosmetic.Cosmetic;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Project: Cosmetic
 * Date: 28/05/2021 @ 23:24
 * Class: ArmorUtils
 */
public class ArmorUtils {
    public static void getArmor(Player player, Color color, String nameColor) {
        ItemStack helmet = new ItemMaker(Material.LEATHER_HELMET).
                setColor(color).
                setTitle(Cosmetic.getInstance().getConfig().getString("ARMORS." + nameColor + ".NAME")).
                setLore(Cosmetic.getInstance().getConfig().getString("ARMORS." + nameColor + ".LORE")).build();
        ItemStack chestplate = new ItemMaker(Material.LEATHER_CHESTPLATE).
                setColor(color).
                setTitle(Cosmetic.getInstance().getConfig().getString("ARMORS." + nameColor + ".NAME")).
                setLore(Cosmetic.getInstance().getConfig().getString("ARMORS." + nameColor + ".LORE")).build();
        ItemStack leggings = new ItemMaker(Material.LEATHER_LEGGINGS).
                setColor(color).
                setTitle(Cosmetic.getInstance().getConfig().getString("ARMORS." + nameColor + ".NAME")).
                setLore(Cosmetic.getInstance().getConfig().getString("ARMORS." + nameColor + ".LORE")).build();
        ItemStack boots = new ItemMaker(Material.LEATHER_BOOTS).
                setColor(color).
                setTitle(Cosmetic.getInstance().getConfig().getString("ARMORS." + nameColor + ".NAME")).
                setLore(Cosmetic.getInstance().getConfig().getString("ARMORS." + nameColor + ".LORE")).build();
        player.getInventory().setHelmet(helmet);
        player.getInventory().setChestplate(chestplate);
        player.getInventory().setLeggings(leggings);
        player.getInventory().setBoots(boots);
        /**
         * here you create armors item to remove excess of code
         */
    }
}
